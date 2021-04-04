package mx.com.elektra.mso.cb.configuration;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import mx.grupoelektra.helpersecure.Constantes;
import mx.com.elektra.mso.cb.common.BrmsCommon;
import mx.com.elektra.mso.cb.common.CodigosResponseCommon;
import mx.com.elektra.mso.cb.common.ConstantesCommon;
import mx.com.elektra.mso.cb.common.FolioCommon;

import lombok.Data;
import mx.elektra.dependencias.HelperRest.PropertiesSistemaBRMS.PropertiesSistemaBRMS;
import mx.elektra.dependencias.HelperRest.PropertiesSistemaBRMS.Url;
import mx.elektra.dependencias.HelperRest.helperrest.CredencialesBRMS;
import mx.elektra.dependencias.contenedorresponse.config.ConfigurationResponse;
import mx.elektra.dependencias.contenedorresponse.issues.ExceptionGenerica;
import mx.elektra.dependencias.dto.TipoLog;
import mx.elektra.dependencias.enums.Nivel;
import mx.elektra.dependencias.service.EscribirLog;

@Data
@Configuration
public class ApplicationSetup {

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.version}")
    private String appVersion;

    private Map<String, String> urls;
    private Map<String, Integer> timeouts;
    private String generateKey;

    @Autowired
    EscribirLog bitacora;

    @Autowired
    ConfigurationResponse configurationResponse;

    @Autowired
    FolioCommon folioCommon;

    @Autowired
    BrmsCommon brmsCommon;

    @Autowired
    public CredencialesBRMS credencialesBRMS;

    @Autowired
    public PropertiesSistemaBRMS propertiesSistemaBRMS;

    @PostConstruct
    public void init() throws Exception {
        bitacora.setTipoLog(TipoLog.CONSOLA);
        try {
            StringBuilder application = new StringBuilder();
            application.append("****************** Configurando ");
            application.append(appName);
            application.append(" ");
            application.append(appVersion);
            application.append(" ******************");
            bitacora.escribir(getClass(), Nivel.INFORMATIVO, application.toString());
            configurationResponse.setFolio(folioCommon.getFolio());
            configurationResponse.setCodigosRespuesta(CodigosResponseCommon.CODIGO_400);
            credencialesBRMS.setCredentials(brmsCommon.getUsrSys(), brmsCommon.getPsdSys());
            /*
			 **Configuracion de reglas de sistema
             */
//			Respuesta respuesta = propertiesSistemaBRMS.getPropertiesSistemaCredito(brmsCommon.getUri(), brmsCommon.getAmbiente());
//			setURLS(respuesta.getUrls());
//			setGenerateKey(respuesta.getPublicKey());
//			setTimeouts();
//			bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "llave " + respuesta.getPublicKey());
            setGenerateKey(Constantes.PUBLIC_KEY);

        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\nFallo el Setup de la Aplicacion.");
            stringBuilder.append("\nExtra Message: " + e.getMessage());
            stringBuilder.append("============>>>>>>> Error en el Setup de la Aplicaci�n <<<<<<<============");
            bitacora.escribir(this.getClass(), Nivel.ERROR, stringBuilder.toString());
            throw new ExceptionGenerica(CodigosResponseCommon.CODIGO_500, folioCommon.getFolio(), "",
                    Arrays.asList(stringBuilder.toString()));
        }
    }

    public void reloadApplication() throws Exception {
        init();
    }

    private ApplicationSetup setURLS(List<Url> listaUrlBRMS) {
        bitacora.escribir(getClass(), Nivel.INFORMATIVO, "Las urls del BRMS son: ");
        urls = new TreeMap<>();
        listaUrlBRMS.forEach(url -> urls.put(url.getKey(), url.getValue()));
        urls.forEach((k, v) -> bitacora.escribir(getClass(), Nivel.INFORMATIVO, k.concat(": " + v)));
        return this;
    }

    private ApplicationSetup setTimeouts() {
        bitacora.escribir(getClass(), Nivel.INFORMATIVO, "Los Timeouts son: ");
        timeouts = new TreeMap<>();

        timeouts.put(ConstantesCommon.TIMEOUT_BRMS, 20000);
        timeouts.put(ConstantesCommon.TIMEOUT_MSO, 20000);
        timeouts.put(ConstantesCommon.TIMEOUT_API, 250000);

        timeouts.forEach((k, v) -> bitacora.escribir(getClass(), Nivel.INFORMATIVO, k.concat(": " + v)));
        return this;
    }

    public void momentIp(Map<String, String> urls) {
        urls.forEach((k, v) -> {
            urls.put(k, v);
        });
    }

    public String getActiveProfileSettings() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ambiente: ".concat("prop.getAmbiente()"));
        stringBuilder.append("\nUrlAmbiente: ".concat("prop.getUrl()"));
        stringBuilder.append("\nUrls: ".concat(this.urls.toString()));
        return stringBuilder.toString();
    }
}
