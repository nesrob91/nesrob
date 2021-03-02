/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas.tipos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.ektrutas.dto.Remision;
import mx.com.elektra.ektrutas.dto.Respuesta;
import mx.com.elektra.ektrutas.dto.Ruta;
import mx.com.elektra.ektrutas.dto.Transporte;
import mx.com.elektra.ektrutas.dto.Unidad;
import mx.com.elektra.ektrutas.dto.Usuario;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("rutaLyde")
public class Lyde extends Rutas{
    
    @Override
    public Respuesta generateFolRut(int origen, int folioLyde, List<Integer> rem, int idTransporte, int eco, int tipRuta, Integer mtvo, int sec, String sello, String checador, String estibador, boolean isExternal){
        Respuesta resp = new Respuesta();
        Usuario user = generalService.getInfoUsuario(1002);//2250
        if(user!=null){
            if(!user.getUSUARIO().equals("ERROR")){
                List<Remision> rems=remisionService.getInfoRemision(origen, 0, rem);
                if(rems==null){
                    resp.setError(true);
                    resp.setCode("GRTGR0001");
                    resp.setMsg("No se puedo obtener informacion de las remisiones");
                }else{
                    if(rems.size()<rem.size()){
                        resp.setError(true);
                        resp.setCode("GRTGR0002");
                        resp.setMsg("No se encontro informacion de una o mas Remisiones");
                    }else{
                        for(Remision r : rems){
                            switch(r.getStsreg()){
                                case 1: 
                                    break;
                                default:
                                    resp.setError(true);
                                    resp.setCode("GRTGR0002");
                                    resp.setMsg("Una o mas Remisiones con Estatus Invalido");
                                    break;
                            }
                        }
                        if(resp.isError())
                            return resp;
                        List<Integer> tiendas=new ArrayList<>();
                        rems.forEach((re)->{
                            tiendas.add(re.getRecept());
                        });
                        Map<String,Object> result=new HashMap<>();
                        Integer isDist=tiendaService.isDistItk(tiendas);
                        if(isDist!=null){
                            if(isDist>0){

                            }else{

                            }
                        }else{
                            result.put("Error", true);
                            result.put("Code", "GRTVI0001");
                            result.put("Message","No se pudo comprobar destinos ITK");
                        }
                        List<Transporte> trans = transportService.getTransportes(origen, idTransporte, isDist);
                        if(trans==null){
                            resp.setError(true);
                            resp.setCode("GRTGT0001");
                            resp.setMsg("No se pudo validar Transporte");
                        }else{
                            if(trans.isEmpty() && !isExternal){
                                resp.setError(true);
                                resp.setCode("GRTGT0002");
                                resp.setMsg("No se encontro Transporte");
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
                                    resp.setMsg("No se puedo validar Unidad");
                                }else{
                                    if(unids.isEmpty() && !isExternal){
                                        resp.setError(true);
                                        resp.setCode("GRTGU0002");
                                        resp.setMsg("No se encontro Unidad");
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
                                                resultTrans=transportService.capturaTransporte(origen, rems, idTransporte, 1, folioLyde, "XX", checador, estibador);
                                            if((Boolean) resultTrans.get("Error")){
                                                resp.setError(true);
                                                resp.setCode((String)resultTrans.get("Code"));
                                                resp.setMsg((String)resultTrans.get("Message"));
                                            }else{
                                                Map<String,Object> resultRuta=rutaService.registraRuta( origen,  rems,  isExternal?new Transporte():trans.get(0),  isExternal?new Unidad():uni,  0,  folioLyde,  checador,  estibador);
                                                if((Boolean)resultRuta.get("Error")){
                                                    resp.setError(true);
                                                    resp.setCode((String)resultRuta.get("Code"));
                                                    resp.setMsg((String)resultRuta.get("Message"));
                                                    if(resultRuta.containsKey("Folios")){
                                                        resp.setError(false);
                                                        resp.setCode("GRTOK");
                                                        resp.setFolEnvio("0");
                                                        resp.setRuta((ArrayList)resultRuta.get("Folios"));
                                                        resp.setMsg((String)resultRuta.get("Message"));
                                                    }
                                                }else{
                                                    folioLyde = (Integer)resultRuta.get("v_fol_env");
                                                    if(!rutaService.updateFolRut(6, origen, folioLyde)){
                                                        resp.setError(true);
                                                        resp.setCode("GRTGF0001");
                                                        resp.setMsg("No se recupero folio");
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
                                                        lastFolrut=rutaService.getFolRut(5, rems.get(0).getEmisor());
                                                        if(isExternal){
                                                            if(lastFolrut==null){
                                                                resp.setError(true);
                                                                resp.setCode("GRTGF0002");
                                                                resp.setMsg("No se recupero folio");
                                                                return resp;
                                                            }
                                                            if(!rutaService.updateFolRut(5, origen, lastFolrut)){
                                                                resp.setError(true);
                                                                resp.setCode("GRTUF0001");
                                                                resp.setMsg("No se recupero folio");
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
                                                                rutaService.insertsRutas(rems, t, u, 0, lastFolrut, 0, "MEX", 0, 0, "0", "0", "L", 0, 0, 0, 0, 0, 0, 0, 0, 0, "1002", "", "", "", isExternal?checador:"GENRUTAS_LYDE", "", "", "", folioLyde, mtvo, tipRuta, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, isExternal?"":checador, estibador);
                                                                //lastFolrut+=1;//unnecesary ?
                                                            }catch(Exception e){
                                                                resp.setError(true);
                                                                resp.setCode("GRTINS0001");
                                                                resp.setMsg("No se registro ruta");
                                                                rutaService.cancelTranrut(origen,rutas);//maybe this doesnt matter ? tranrut is never inserted if ctlflt fails 
                                                                return resp;
                                                            }
                                                        }else{
                                                            Map<String,Object> resultInsert=rutaService.insertRuta(tipRuta, trans.get(0), uni, entry.getValue(), mtsModif, 1002, mtvo, "GENRUTAS_LYDE", "0", sec, folioLyde, 0, 0, 0, 0, checador, estibador, lastFolrut);
                                                            if((Boolean)resultInsert.get("Error")){
                                                                resp.setError(true);
                                                                resp.setCode(resultInsert.get("Code").toString());
                                                                resp.setMsg((String)resultInsert.get("Message"));
                                                                if(!rutas.isEmpty())
                                                                    rutaService.cancelTranrut(origen,rutas);//send all folrut even if it fails over another destination group
                                                                return resp;
                                                            }else{
                                                                rutaService.updateFolRut(5, origen, (Integer)resultInsert.get("Code"));
                                                                rutas.add(((Integer)resultInsert.get("Code"))+"");
                                                                //lastFolrut=(Integer)resultInsert.get("Code")+1;
                                                            }
                                                            inserts.add(resultInsert);
                                                        }
                                                    }
                                                    //rutaService.updateFolRut(6, origen, folioLyde);
                                                    //rutaService.updateFolRut(5, origen, lastFolrut-1);
                                                    resp.setCode("GRTOK");
                                                    resp.setError(false);
                                                    resp.setMsg("Rutas Creadas");
                                                    resp.setRuta(rutas);
                                                    resp.setFolEnvio(folioLyde+"");
                                                }
                                            }
                                        /*}else{
                                            resp.setError(true);
                                            resp.setCode("GRTGU0003");
                                            resp.setMsg("No se encontro Unidad disponible");
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
                resp.setMsg("No existe el usuario "+1002);
            }
        }else{
            resp.setError(true);
            resp.setCode("GRTVU0001");
            resp.setMsg("No se pudo validar informacion de usuario");
        }
        return resp;
    }

    @Override
    public String getSysdate() {
        return generalService.getsysdate();
    }
    
    @Override
    public Map<String,Object> validateRemisionAndTrkNbr(List<String> rems, Integer emisor){
        List<Integer> remInt=new ArrayList<>();
        for(String s:rems)
            remInt.add(Integer.parseInt(s));
        List<Remision> rem = remisionService.getInfoRemision(emisor, 0, remInt);
        Map<String,Object> response = rutaService.validateRemisionTranrut(rem);
        if((Boolean)response.get("error"))
            response.put("valid",false);
        else
            response.put("valid",true);
        return response;
    }
}
