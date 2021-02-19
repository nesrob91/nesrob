/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.type;

import java.util.ArrayList;
import java.util.List;
import mx.com.api.route.beans.Request;
import mx.com.api.route.beans.Response;
import mx.com.api.route.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("rutaSelect")
public class TypeSelector {
    @Autowired
    private RutaIfc lyde;
    @Autowired
    private RutaIfc elektra;
    @Autowired
    private GeneralService generales;
    
    public boolean validateRequest(Request req, int op){
        boolean valid=true;
        if(req.getIdCentro()==null || req.getIdCentro().equals(0)){
            valid=false;
        }else if(req.getFolios()==null || req.getFolios().isEmpty()){
            valid=false;
        }else{
            switch(op){
                case 1:
                    switch(req.getIdCentro()){
                        case 324: case 9971:
                            if((req.getIdTransporte()==null||req.getIdTransporte().equals(0))) //|| (req.getIdUnidad()==null||req.getIdUnidad().equals(0)))
                                valid=false;
                            break;
                        default:
                            if((req.getIdTransporte()==null||req.getIdTransporte().equals(0)) || (req.getIdUnidad()==null||req.getIdUnidad().equals(0)) || 
                                (req.getMotivo()==null||req.getMotivo().equals(0)) || (req.getSecuencia()==null||req.getSecuencia().equals(0)) || 
                                (req.getTipoRuta()==null||req.getTipoRuta().equals(0)) || (req.getEstibador()==null) || (req.getChecador()==null) )
                                valid = false;
                            break;
                    }
                    break;
                case 4:
                    if(req.getFecha()==null||req.getFecha().equals("")){
                        valid=false;
                    }
                    if(req.getEstatus()==null||req.getEstatus().equals("")){
                        valid=false;
                    }
                    break;
                default: 
                    break;
            }
        }
        if(valid){
            if(req.getExternal()==null)
                req.setExternal(false);
            for(String s:req.getFolios()){
                try {
                    Integer.valueOf(s);
                } catch (NumberFormatException e) {
                    valid = false;
                    break;
                }
            }
        }
        return valid;
    }
    
    public Response generateRoute(Request request){
        Response resp=new Response();
        try{
            int cd = (request.getIdCentro()>999?request.getIdCentro():generales.getIdSapAlmn(request.getIdCentro()));
            List<Integer> rems=new ArrayList<>();
            request.getFolios().forEach((rem)->{
                rems.add(Integer.parseInt(rem));
            });
            try{
                if(request.getIdCentro() == 9971 || request.getIdCentro() == 324){
                    resp=lyde.generateFolRut(cd,0,rems,request.getIdTransporte(),request.getIdUnidad(), 0, 0, 0,"","","",false);
                }else{
                    resp=elektra.generateFolRut(cd,0,rems,request.getIdTransporte(),request.getIdUnidad(), request.getTipoRuta(), request.getMotivo(), request.getSecuencia(), "","","",false);
                }
                resp.setError(null);
            }catch(Exception e){
                resp.setEstatus(-1);
                resp.setCode("GRT0001");
                resp.setMensaje("Error al crear Ruta");
            }
        }catch(Exception e){
            resp.setEstatus(-1);
            resp.setMensaje("Error al procesar Peticion");
        }
        return resp;
    }
}
