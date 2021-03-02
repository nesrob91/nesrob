/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas.tipos;

import com.elektra.cadsumutils.dao.DataSources;
import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.ektrutas.dto.Remision;
import mx.com.elektra.ektrutas.dto.Respuesta;
import mx.com.elektra.ektrutas.dto.Ruta;
import mx.com.elektra.ektrutas.dto.Transporte;
import mx.com.elektra.ektrutas.dto.Unidad;
import mx.com.elektra.ektrutas.service.GeneralService;
import mx.com.elektra.ektrutas.service.RemisionService;
import mx.com.elektra.ektrutas.service.RutaService;
import mx.com.elektra.ektrutas.service.TiendaService;
import mx.com.elektra.ektrutas.service.TransporteService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("GeneraRuta")
public class Rutas {
    @Autowired
    public TransporteService transportService;
    @Autowired
    public RemisionService remisionService;
    @Autowired
    public RutaService rutaService;
    @Autowired
    public TiendaService tiendaService;
    @Autowired
    public GeneralService generalService;
    @Autowired
    private Boolean DEBUGGER;
    @Autowired
    LogsPaqueterias logger;
    
    public Respuesta generateFolRut(int origen, int folioEnvio, List<Integer> rem, int idTransporte, int eco, int tipRuta, Integer mtvo, int sec, String sello, String checador, String estibador, boolean isExternal){
        return null;
    }
    
    public String getSysdate(){
        return null;
    }
    
    public String getDocument(Integer origen, Integer folEnv, Integer folRut){
        String base64Document="";
        ByteArrayOutputStream os = null;
        try{
            HashMap parametros = new HashMap();
            parametros.put("PI_CD_ID_value1", origen);
            parametros.put("PI_RUTA_value1", folRut);
            parametros.put("PI_ENVIO_value1", folEnv);

            InputStream JasperFileName = getClass().getClassLoader().getResourceAsStream("GENRUTAR_lyde.jasper");
            //File reportfile = new File(JasperFileName);
            //reportfile.getPath();

            os = new ByteArrayOutputStream();
            Connection conn = new DataSources().namedTemplate2010().getJdbcTemplate().getDataSource().getConnection();
            JasperPrint jp = JasperFillManager.fillReport(JasperFileName, parametros, conn);
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.close();
            
            base64Document = Base64.getEncoder().encodeToString(os.toByteArray());
        }catch(Exception e){
            if(DEBUGGER)
                System.out.println("Error : "+e.getMessage());
            try{
                logger.insertaError(1110003, 11, origen, 0, 
                    "folenv "+folEnv+" folrut "+folRut, 0, 0, "", 
                    0, 0, e.getMessage(), 
                    getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
            }catch(Exception ex){
            }
        }
        return base64Document; 
    }
    
    public Map<String,Object> validateRemisionAndTrkNbr(List<String> rems, Integer emisor){
        return null;
    }
}
