/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.api.route.beans.Remision;
import mx.com.api.route.beans.Response;
import mx.com.api.route.beans.Transporte;
import mx.com.api.route.beans.Unidad;
import mx.com.api.route.beans.Usuario;
import mx.com.api.route.service.GeneralService;
import mx.com.api.route.service.RemisionService;
import mx.com.api.route.service.RutaService;
import mx.com.api.route.service.TiendaService;
import mx.com.api.route.service.TransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Base64;
import java.util.HashMap;
import mx.com.api.route.beans.ResponseRuta;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 *
 * @author nroblerol
 */
@Component("lyde")
public class LydeImpl implements RutaIfc{
    
    @Autowired
    private TransporteService transportServiceLyde;
    @Autowired
    private RemisionService remisionService;
    @Autowired
    private RutaService rutaServiceLyde;
    @Autowired
    private TiendaService tiendaService;
    @Autowired
    private GeneralService generalService;
    @Autowired
    private NamedParameterJdbcTemplate sccpConnection;
    
    @Override
    public ResponseRuta generateFolRut(int origen, int folioLyde, List<Integer> rem, int idTransporte, int eco, int tipRuta, Integer mtvo, int sec, String sello, String checador, String estibador, boolean isExternal){
        ResponseRuta resp = new ResponseRuta();
        Usuario user = generalService.getInfoUsuario(1002);//2250
        if(user!=null){
            if(!user.getUSUARIO().equals("ERROR")){
                List<Remision> rems=remisionService.getInfoRemision(origen, 0, rem);
                if(rems==null){
                    resp.setError(true);
                    resp.setCode("GRTGR0001");
                    resp.setMensaje("No se puedo obtener informacion de las remisiones");
                }else{
                    if(rems.size()<rem.size()){
                        resp.setError(true);
                        resp.setCode("GRTGR0002");
                        resp.setMensaje("No se encontro informacion de una o mas Remisiones");
                    }else{
                        for(Remision r : rems){
                            if(r.getStsreg()!= 1 || r.getStsreg()!= 4){
                                resp.setError(true);
                                resp.setCode("GRTGR0002");
                                resp.setMensaje("Remision Confirmada o con NE");
                            }
                        }
                        if(resp.getError())
                            return resp;
                        List<Integer> tiendas=new ArrayList<>();
                        rems.forEach((re)->{
                            tiendas.add(re.getRecept());
                        });
                        Map<String,Object> result=new HashMap<>();
                        /*Integer isDist=tiendaService.isDistItk(tiendas);
                        if(isDist!=null){
                            if(isDist>0){

                            }else{

                            }
                        }else{
                            result.put("Error", true);
                            result.put("Code", "GRTVI0001");
                            result.put("Message","No se pudo comprobar destinos ITK");
                        }*/
                        List<Transporte> trans = transportServiceLyde.getTransportes(origen, idTransporte, 0);
                        if(trans==null){
                            resp.setError(true);
                            resp.setCode("GRTGT0001");
                            resp.setMensaje("No se pudo validar Transporte");
                        }else{
                            if(trans.isEmpty() && !isExternal){
                                resp.setError(true);
                                resp.setCode("GRTGT0002");
                                resp.setMensaje("No se encontro Transporte");
                            }else{
                                Unidad uni=new Unidad();
                                uni.setEco(0);
                                uni.setIdTransporte(isExternal?idTransporte:trans.get(0).getIdTransporte());
                                uni.setPlaca("");
                                uni.setMts(99);
                                uni.setTipo("");
                                uni.setDisp("");
                                uni.setChofer("XX");
                                uni.setAlamcen(origen);
                                /*List<Unidad> unids = transportService.getUnidades( origen,  eco,  "");
                                if(unids==null){
                                    resp.setError(true);
                                    resp.setCode("GRTGU0001");
                                    resp.setMensaje("No se puedo validar Unidad");
                                }else{
                                    if(unids.isEmpty() && !isExternal){
                                        resp.setError(true);
                                        resp.setCode("GRTGU0002");
                                        resp.setMensaje("No se encontro Unidad");
                                    }else{
                                        boolean isDisp=false;
                                        if(isExternal){
                                            isDisp=true;
                                        }else{
                                        //for(Unidad u : unids){
                                            int tiempoEco=transportService.getTiempoEco(origen);
                                            String disp=transportService.getTransporteDisponibilidad(origen, trans.get(0).getIdTransporte(), unids.get(0).getEco(), unids.get(0).getPlaca(), tiempoEco);
                                            if(!isDisp)
                                                isDisp=disp.equals("");
                                            unids.get(0).setDisp(disp);
                                        //}
                                        }
                                        if(isDisp){*/
                                            Map<String, Object> resultTrans=new HashMap<>();
                                            if(isExternal)
                                                resultTrans.put("Error",false);
                                            else
                                                resultTrans=transportServiceLyde.capturaTransporte(origen, rems, idTransporte, 1, folioLyde, "XX", checador, estibador);
                                            if((Boolean) resultTrans.get("Error")){
                                                resp.setError(true);
                                                resp.setCode((String)resultTrans.get("Code"));
                                                resp.setMensaje((String)resultTrans.get("Message"));
                                            }else{
                                                Map<String,Object> resultRuta=rutaServiceLyde.registraRuta( origen,  rems,  isExternal?new Transporte():trans.get(0),  isExternal?new Unidad():uni,  0,  folioLyde,  checador,  estibador);
                                                if((Boolean)resultRuta.get("Error")){
                                                    resp.setError(true);
                                                    resp.setCode((String)resultRuta.get("Code"));
                                                    resp.setMensaje((String)resultRuta.get("Message"));
                                                    if(resultRuta.containsKey("Folios")){
                                                        resp.setError(false);
                                                        resp.setCode("GRTOK");
                                                        resp.setFolEnvio(0);
                                                        resp.setRuta((ArrayList)resultRuta.get("Folios"));
                                                        resp.setMensaje((String)resultRuta.get("Message"));
                                                    }
                                                }else{
                                                    folioLyde = (Integer)resultRuta.get("v_fol_env");
                                                    if(!rutaServiceLyde.updateFolRut(6, origen, folioLyde)){
                                                        resp.setError(true);
                                                        resp.setCode("GRTGF0001");
                                                        resp.setMensaje("No se recupero folio");
                                                        return resp;
                                                    }
                                                    List<Map<String,Object>> inserts=new ArrayList<>();
                                                    double mtsModif=0;
                                                    Map<String, List<Remision>> groupByRecept=new HashMap<>();
                                                    for(Remision r : rems){
                                                        if(groupByRecept.containsKey(r.getRecept()+""))
                                                            groupByRecept.get(r.getRecept()+"").add(r);
                                                        else{
                                                            List<Remision> group=new ArrayList<>();
                                                            group.add(r);
                                                            groupByRecept.put(""+r.getRecept(),group);
                                                        }
                                                    }
                                                    List<String> rutas=new ArrayList<>();
                                                    Integer lastFolrut=0;
                                                    for(Map.Entry<String, List<Remision>> entry:groupByRecept.entrySet()){
                                                        if(isExternal){
                                                            lastFolrut=rutaServiceLyde.getFolRut(5, rems.get(0).getEmisor());
                                                            if(lastFolrut==null){
                                                                resp.setError(true);
                                                                resp.setCode("GRTGF0002");
                                                                resp.setMensaje("No se recupero folio");
                                                                return resp;
                                                            }
                                                            if(!rutaServiceLyde.updateFolRut(5, origen, lastFolrut)){
                                                                resp.setError(true);
                                                                resp.setCode("GRTUF0001");
                                                                resp.setMensaje("No se recupero folio");
                                                                return resp;
                                                            }
                                                            try{
                                                                Transporte t=new Transporte();
                                                                t.setIdTransporte(idTransporte);
                                                                Unidad u=new Unidad();
                                                                u.setEco(0);
                                                                u.setMts(0);
                                                                u.setChofer("");
                                                                rutas.add(lastFolrut+"");
                                                                rutaServiceLyde.insertsRutas(rems, t, u, 0, lastFolrut, 0, "MEX", 0, 0, "0", "0", "L", 0, 0, 0, 0, 0, 0, 0, 0, 0, "1002", "", "", "", isExternal?checador:"GENRUTAS_LYDE", "", "", "", folioLyde, mtvo, tipRuta, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, isExternal?"":checador, estibador);
                                                                lastFolrut+=1;//unnecesary ?
                                                            }catch(Exception e){
                                                                resp.setError(true);
                                                                resp.setCode("GRTINS0001");
                                                                resp.setMensaje("No se registro ruta");
                                                                rutaServiceLyde.cancelTranrut(origen,rutas);//maybe this doesnt matter ? tranrut is never inserted if ctlflt fails 
                                                                return resp;
                                                            }
                                                        }else{
                                                            Map<String,Object> resultInsert=rutaServiceLyde.insertRuta(tipRuta, trans.get(0), uni, entry.getValue(), mtsModif, 1002, mtvo, "GENRUTAS_LYDE", "0", sec, folioLyde, 0, 0, 0, 0, checador, estibador, lastFolrut);
                                                            if((Boolean)resultInsert.get("Error")){
                                                                resp.setError(true);
                                                                resp.setCode(resultInsert.get("Code").toString());
                                                                resp.setMensaje((String)resultInsert.get("Message"));
                                                                if(!rutas.isEmpty())
                                                                    rutaServiceLyde.cancelTranrut(origen,rutas);//send all folrut even if it fails over another destination group
                                                                return resp;
                                                            }else{
                                                                rutaServiceLyde.updateFolRut(5, origen, (Integer)resultInsert.get("Code"));
                                                                rutas.add(((Integer)resultInsert.get("Code"))+"");
                                                                lastFolrut=(Integer)resultInsert.get("Code")+1;
                                                            }
                                                            inserts.add(resultInsert);
                                                        }
                                                    }
                                                    //rutaServiceLyde.updateFolRut(6, origen, folioLyde);
                                                    //rutaServiceLyde.updateFolRut(5, origen, lastFolrut-1);
                                                    resp.setCode("GRTOK");
                                                    resp.setError(false);
                                                    resp.setMensaje("Rutas Creadas");
                                                    resp.setRuta(rutas);
                                                    resp.setFolEnvio(folioLyde);
                                                }
                                            }
                                        /*}else{
                                            resp.setError(true);
                                            resp.setCode("GRTGU0003");
                                            resp.setMensaje("No se encontro Unidad disponible");
                                        }
                                    }
                                }*/
                            }
                        }
                    }
                }
            }else{
                resp.setError(true);
                resp.setCode("GRTVU0002");
                resp.setMensaje("No existe el usuario "+1002);
            }
        }else{
            resp.setError(true);
            resp.setCode("GRTVU0001");
            resp.setMensaje("No se pudo validar informacion de usuario");
        }
        return resp;
    }

    @Override
    public String getDocument(Integer origen, Integer folEnv, Integer folRut) {
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
            Connection conn = sccpConnection.getJdbcTemplate().getDataSource().getConnection();
            JasperPrint jp = JasperFillManager.fillReport(JasperFileName, parametros, conn);
            JasperExportManager.exportReportToPdfStream(jp, os);
            os.close();
            
            base64Document = Base64.getEncoder().encodeToString(os.toByteArray());
        }catch(Exception e){
            base64Document = "EX: "+e.getMessage();
          //  try{
              /*  logger.insertaError(1110003, 11, origen, 0, 
                    "folenv "+folEnv+" folrut "+folRut, 0, 0, "", 
                    0, 0, e.getMessage(), 
                    getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
                */
            //}catch(Exception ex){
            //}
        }
        return base64Document; 
    }
    
}
