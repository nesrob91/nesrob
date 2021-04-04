package mx.com.elektra.msd.qb.configuration;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import mx.com.elektra.msd.qb.common.CodigosResponseCommon;
import mx.com.elektra.msd.qb.common.FolioCommon;

import lombok.Data;
import mx.elektra.dependencias.contenedorresponse.config.ConfigurationResponse;
import mx.elektra.dependencias.contenedorresponse.issues.ExceptionGenerica;
import mx.elektra.dependencias.enums.Nivel;
import mx.elektra.dependencias.service.EscribirLog;

@Data
@Configuration
public class ApplicationSetup {

    @Autowired
    EscribirLog bitacora;

    @Autowired
    private FolioCommon folioCommon;

    @Autowired
    ConfigurationResponse configurationResponse;

    @Value("${info.app.name}")
    private String appName;

    @Value("${info.app.version}")
    private String appVersion;

    @PostConstruct
    public void init() throws Exception {
        try {
            StringBuilder application = new StringBuilder();
            application.append("****************** Configurando ");
            application.append(appName);
            application.append(" ");
            application.append(appVersion);
            application.append(" ******************");
            bitacora.escribir(getClass(), Nivel.INFORMATIVO, application.toString());
            configurationResponse.setCodigosRespuesta(CodigosResponseCommon.CODIGO_400);
            configurationResponse.setFolio(folioCommon.getFolio());
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("============>>>>>>> Error en el Setup de la Aplicaci�n <<<<<<<============");
            stringBuilder.append("\nFallo el Setup de la Aplicacion.");
            stringBuilder.append("\nExtra Message: " + e.getMessage());
            bitacora.escribir(this.getClass(), Nivel.ERROR, stringBuilder.toString());
            throw new ExceptionGenerica(CodigosResponseCommon.CODIGO_500, folioCommon.getFolio(), "", Arrays.asList(stringBuilder.toString()));
        }
    }

    public void reloadApplication() throws Exception {
        init();
    }

}
