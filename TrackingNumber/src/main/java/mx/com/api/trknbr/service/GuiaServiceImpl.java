/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.api.trknbr.dao.GuiaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nroblerol
 */
@Service("guiaService")
public class GuiaServiceImpl implements GuiaService{
    @Autowired
    private GuiaDao guiaDao;
    
    @Override
    public Map<String, Object> getStatusTrknbr(String numGuia, int idCarrier) {
        List<Map<String, Object>> result = guiaDao.getStatusTrknbr(numGuia, idCarrier);
        Map<String, Object> resp= new HashMap<>();
        if(result.isEmpty()){
            resp.put("valid", false);
            resp.put("message", "No se encontro informacion de la guia.");
            resp.put("STAT", 0);
        }else{
            if(result.size()==1 && result.get(0).containsKey("valid")){
                resp.put("valid", false);
                resp.put("STAT", 0);
                resp.put("message", result.get(0).get("message"));
            }else{
                int count=0;
                for(Map<String, Object> r : result){
                    count++;
                    if(Integer.parseInt(r.get("STAT").toString()) >= 10 && Integer.parseInt(r.get("STAT").toString()) <= 99){
                        resp.put("CAJA", Integer.parseInt(r.get("CAJA").toString()));
                        resp.put("STAT", r.get("STAT"));
                    }
                }
                switch(count){
                    case 0:
                        resp.put("valid", false);
                        if(!resp.containsKey("message"))
                            resp.put("message", "Estatus invalido");
                        resp.put("STAT", 0);
                        break;
                    case 1:
                        resp.put("valid", true);
                        resp.put("message", "Valid");
                        break;
                    default:
                        resp.put("valid", false);
                        resp.put("message", "Hay mas de una guia activa");
                        resp.put("STAT", 0);
                        break;
                }
            }
        }
        return resp;
    }

    @Override
    public Map<String, Map<String,Object>> getStatusTrknbr(List<String> contenido, int idCentro, int idTipoPedido) {
        List<Map<String, Object>> result = guiaDao.getStatusTrknbr(contenido, idCentro, idTipoPedido);
        Map<String, Map<String,Object>> resp= new HashMap<>();
        if(result.isEmpty()){
            resp.put("valid", new HashMap<>());
            resp.get("valid").put("message", "No se encontro informacion de guia.");
            resp.get("valid").put("valid", false);
            resp.get("valid").put("STAT", 0);
        }else{
            if(result.size()==1 && result.get(0).containsKey("valid")){
                resp.put("valid", new HashMap<>());
                resp.get("valid").put("STAT", -1);
                resp.get("valid").put("valid", false);
                resp.get("valid").put("message", result.get(0).get("message"));
            }else{
                resp.put("valid", new HashMap<>());
                resp.get("valid").put("message", "Informacion recuperada");
                resp.get("valid").put("valid", true);
                resp.get("valid").put("STAT", 1);
                for(Map<String, Object> r : result){
                    if(resp.containsKey(r.get("OLPN").toString())){
                        if((Integer)resp.get(r.get("OLPN").toString()).get("STAT") > 30)
                            continue;
                        resp.get(r.get("OLPN").toString()).put("CAJA", Integer.parseInt(r.get("PKIDCAJAHDR").toString()));
                        resp.get(r.get("OLPN").toString()).put("STAT", r.get("STAT"));
                        resp.get(r.get("OLPN").toString()).put("STATUS", r.get("DESC_ESTATUS"));
                        resp.get(r.get("OLPN").toString()).put("GUIA", r.get("NUM_GUIA").toString());
                    }
                    else{
                        resp.get(r.get("OLPN").toString()).put(r.get("OLPN").toString(),new HashMap<String, Object>());
                        resp.get(r.get("OLPN").toString()).put("CAJA", Integer.parseInt(r.get("PKIDCAJAHDR").toString()));
                        resp.get(r.get("OLPN").toString()).put("STAT", Integer.valueOf(r.get("STAT").toString()));
                        resp.get(r.get("OLPN").toString()).put("GUIA", r.get("NUM_GUIA").toString());
                        resp.get(r.get("OLPN").toString()).put("STATUS", r.get("DESC_ESTATUS").toString());
                    }
                }
                for(String s:contenido){
                    if(!resp.containsKey(s)){
                        resp.put(s, new HashMap<>());
                        resp.get(s).put("STAT", 0);
                        resp.get(s).put("STATUS", "Sin Guia");
                        resp.get(s).put("NUM_GUIA", "SIN GUIA");
                        resp.get(s).put("CAJA", 0);
                    }
                }
            }
        }
        return resp;
    }
    
    @Override
    public boolean cancelTrknbr(String numGuia, int idCarrier, int tipoPedido) {
        return guiaDao.cancelTrknbr(numGuia, idCarrier, tipoPedido);
    }
}
