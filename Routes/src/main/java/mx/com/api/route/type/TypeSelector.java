/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.type;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import mx.com.api.route.Procesos;
import mx.com.api.route.beans.Almacen;
import mx.com.api.route.beans.Request;
import mx.com.api.route.beans.Response;
import mx.com.api.route.beans.ResponseRuta;
import mx.com.api.route.feign.beans.ApiResponse;
import mx.com.api.route.service.GeneralService;
import mx.com.api.route.feign.wsGuiasFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

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
    @Autowired
    private wsGuiasFeign wsGuia;
    
    public boolean validateRequest(Request req, Procesos op) {
        boolean valid=true;
        if(req.getIdCentro()==null || req.getIdCentro().equals(0)){
            valid=false;
        }else if(req.getFolios()==null || req.getFolios().isEmpty()){
            valid=false;
        }else{
            switch(op.getIdProceso()){
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
    
    public ResponseRuta generateRoute(Request request){
        ResponseRuta resp=new ResponseRuta();
        try{
            Almacen cd = generales.getInfoAlmn(request.getIdCentro());
            List<Integer> rems=new ArrayList<>();
            request.getFolios().forEach((rem)->{
                rems.add(Integer.parseInt(rem));
            });
            try{
                if(request.getIdCentro() == 9971 || request.getIdCentro() == 324){
                    mx.com.api.route.feign.beans.Request guiaRequest=new mx.com.api.route.feign.beans.Request();
                    guiaRequest.setIdCentro(cd.getIdManh());
                    guiaRequest.setTipoPedido(6);
                    guiaRequest.setContenido(request.getFolios());
                    ApiResponse apiGuia=wsGuia.getTrackingNumber(guiaRequest);
                    if(apiGuia.getCodigo().equals("0")){
                        if(apiGuia.getResultado().getNumGuia()==null||apiGuia.getResultado().getNumGuia().isEmpty()){
                            resp=lyde.generateFolRut(request.getIdUsuario(),cd.getIdSap(),0,rems,request.getIdTransporte(),request.getIdUnidad(), 0, 0, 0,"","","",request.getExternal());
                            if(resp.getError()){
                                resp.setDocumento("EX");
                                resp.setError(null);
                                resp.setFolEnvio(null);
                            }else{
                                resp.setDocumento(lyde.getDocument(cd.getIdSap(), resp.getRuta().size()>1?resp.getFolEnvio():0, resp.getRuta().size()>1?0:Integer.parseInt(resp.getRuta().get(0))));
                            }
                        }else{
                            resp.setMensaje("Una o mas remisiones cuentan con guia. ");
                            resp.setEstatus(1);
                            resp.setRuta(new ArrayList<>());
                            resp.getRuta().add(apiGuia.getResultado().getNumGuia());
                        }
                    }else{
                        resp.setMensaje(apiGuia.getMensaje());
                        resp.setEstatus(-2);
                    }
                    resp.setError(null);
                    resp.setCode(null);
                }else{
                    resp=elektra.generateFolRut(request.getIdUsuario(),cd.getIdSap(),0,rems,request.getIdTransporte(),request.getIdUnidad(), request.getTipoRuta(), request.getMotivo(), request.getSecuencia(), "","","",false);
                    if(resp.getError()){
                        resp.setDocumento("EX");
                    }else{
                        resp.setDocumento(elektra.getDocument(cd.getIdSap(), resp.getRuta().size()>1?resp.getFolEnvio():0, resp.getRuta().size()>1?0:Integer.parseInt(resp.getRuta().get(0))));
                    }
                }
            /*}catch(RetryableException fe){
                resp.setEstatus(-3);
                resp.setMensaje("Unable to Validate TrackingNumber: 404 "+fe.status());
            }catch(FeignException fe){
                resp.setEstatus(-3);
                resp.setMensaje("Unable to Validate TrackingNumber: FE:"+fe.status());*/
            }catch(Exception e){
                resp.setEstatus(-2);
                resp.setCode("GRT0001");
                resp.setMensaje("Error al crear Ruta");
            }
        }catch(Exception e){
            resp.setEstatus(-2);
            resp.setMensaje("Error al procesar Peticion");
        }
        return resp;
    }
    
    public ResponseRuta retrieveDoc(Request request){
        ResponseRuta resp=new ResponseRuta();
        try{
            String doc="";
            Almacen cd = generales.getInfoAlmn(request.getIdCentro());
            if(request.getIdCentro() == 9971 || request.getIdCentro() == 324){
                doc=lyde.getDocument(cd.getIdSap(), 0, Integer.valueOf(request.getFolios().get(0)));
            }else{
                //Integer folEnv=get folenv 
                doc=elektra.getDocument(request.getIdCentro(), 0, Integer.valueOf(request.getFolios().get(0)));
            }
            if(doc==null || doc.isEmpty()){
                resp.setEstatus(1);
                resp.setMensaje("No se recupero dcoumento");
            }else
            if(doc.contains("EX:")){
                resp.setEstatus(-1);
                resp.setMensaje(doc);
            }
            else{
                resp.setEstatus(0);
                resp.setMensaje(doc);
                resp.setDocumento(doc);
                resp.setMensaje("OK");
                resp.setRuta(request.getFolios());
            }
        }catch(Exception e){
            resp.setEstatus(-2);
            resp.setMensaje("Error al procesar Peticion");
        }
        return resp;
    }
    
    public ResponseRuta cancelRoute(Request req){
        ResponseRuta resp=new ResponseRuta();
        try{
            Almacen cd = generales.getInfoAlmn(req.getIdCentro());
            resp=lyde.cancelFolRut(cd.getIdSap(), req.getFolios(), req.getIdUsuario());//current impl for WS (as of feb2021)
        }catch(Exception e){
            resp.setEstatus(-2);
            resp.setMensaje("Error al procesar Peticion");
        }
        return resp;
    }
    
    public ResponseRuta modifyRoute(Request req){
        ResponseRuta resp=new ResponseRuta();
        try{
            Almacen cd = generales.getInfoAlmn(req.getIdCentro());
            List<Integer> rems=new ArrayList<>();
            req.getFolios().forEach((rem)->{
                rems.add(Integer.parseInt(rem));
            });
            resp=lyde.modifyFolRut(cd.getIdSap(), rems, req.getIdUsuario(), req.getFecha(), req.getEstatus(), req.getComentario(), req.getPod());//current impl for WS (as of feb2021)
        }catch(Exception e){
            resp.setEstatus(-2);
            resp.setMensaje("Error al procesar Peticion");
        }
        return resp;
    }
    
    public ResponseRuta getStatus(Request req){
        ResponseRuta resp=new ResponseRuta();
        try{
            Almacen cd = generales.getInfoAlmn(req.getIdCentro());
            resp=lyde.getStatRut(cd.getIdSap(), req.getFolios());//current impl for WS (as of feb2021)
        }catch(Exception e){
            resp.setEstatus(-2);
            resp.setMensaje("Error al procesar Peticion");
        }
        return resp;
    }
}
