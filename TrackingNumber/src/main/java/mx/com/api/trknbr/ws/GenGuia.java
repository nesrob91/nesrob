/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.ws;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mx.com.api.trknbr.beans.ApiResponse;
import mx.com.api.trknbr.beans.FolioResponse;
import mx.com.api.trknbr.beans.FoliosResponse;
import mx.com.api.trknbr.beans.GuiaResponse;
import mx.com.api.trknbr.beans.Request;
import mx.com.api.trknbr.beans.Response;
import mx.com.api.trknbr.configuration.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("mainGenerator")
public class GenGuia {
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private TNGenerator tnGenerator;

    /***
     * Metodo para obtener Carrier 
     * @param request Peticion para obtener Carrier
        int idUsuario usuario que realiza la peticion
        int idContainer tipo de contenedor a usar
        int idVendor proveedor
        int cdVendor almacen
        String pedVtex pedido Vtex
        List<String> contenido lpns, adns, folios
        double lenght largo 
        double width ancho
        double height alto 
        double weight peso
        int tipPed tipo de pedido
        int tipPet tipo de peticion (1 ruta | 2 guia | 3 registrar guia)
        int tipDoc tipo de documento (1 rem | 2 NC)
        int idTransp proveedor de trasporte (ruta)
        int idUnidad unidad de transporte (ruta)
        String carrier (si no se evalua por QB | registro de guia)
        String numGuia (para registrar)
     * @return GuiaResponse with TrackingNumber/Carrier
     */
    public Response generateTrkNbr(Request request){
        Response apiResp=new Response();
        GuiaResponse gr = new GuiaResponse();
        switch(request.getTipoPedido()){
            case 4:case 5:
                request.setIdCentro(request.getIdVendor());//(as of may2020)modify or remove for further implementations
                break;
            case 6:
                request.setPedVtex(request.getContenido().get(0));
                request.setIdUsuario(1002);
                request.setIdContenedor(0);
                break;
            default:
                break;
        }
        if(request.getIdCaja()==null)
            request.setIdCaja(0);
        if(request.getIdVendor()==null)
            request.setIdVendor(request.getIdCentro());
        try{
            gr = tnGenerator.generateTrackingNumber(request);
            
        }catch(Exception e){
            try{
                logger.insertaError(1010000, 10, 0, 0, request.toString(), 0, 0, "", 
                    -1, -1, e.toString(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), 
                    "");
            }catch(Exception ex){}
            gr.setIdEstatusGuia(0);
            gr.setEtiqueta("GWS00000");
            gr.setMensaje("No se pudo generar guia");            
        }
        FoliosResponse fols=new FoliosResponse();
        List<FolioResponse> fol=new ArrayList<>();
        if(gr.getIdEstatusGuia()<0){
            apiResp.setEstatus(1);
            apiResp.setError(false);
            apiResp.setMensaje(gr.getEtiqueta().concat(" ").concat(gr.getMensaje()));
            for(String s:request.getContenido()){
                FolioResponse f=new FolioResponse();
                f.setPedido(s);
                f.setResultado("No se genero guia");
                fol.add(f);
            }
            fols.setPedido(fol);
        }else if(gr.getIdEstatusGuia()==0){
            apiResp.setError(true);
            apiResp.setEstatus(-2);
            apiResp.setMensaje("Error al procesar");
        }else{
            apiResp.setDocumento(gr.getEtiqueta());
            apiResp.setCarrier(gr.getMensaje());
            apiResp.setEstatus(0);
            apiResp.setMensaje("Guia generada");
            apiResp.setNumGuia(gr.getNumGuia());
            for(String s:request.getContenido()){
                FolioResponse f=new FolioResponse();
                f.setPedido(s);
                f.setResultado("En guia");
                fol.add(f);
            }
            fols.setPedido(fol);
        }
        apiResp.setResultado(fols);
        return apiResp;
    }
    
    /***
     * Metodo para obtener Carrier 
     * @param request Peticion para obtener Carrier
        int idUsuario usuario que realiza la peticion
        int idContainer tipo de contenedor a usar
        int idVendor proveedor
        int cdVendor almacen
        String pedVtex pedido Vtex
        List<String> contenido lpns, adns, folios
        double lenght largo 
        double width ancho
        double height alto 
        double weight peso
        int tipPed tipo de pedido
        int tipPet tipo de peticion (1 ruta | 2 guia | 3 registrar guia)
        int tipDoc tipo de documento (1 rem | 2 NC)
        int idTransp proveedor de trasporte (ruta)
        int idUnidad unidad de transporte (ruta)
        String carrier (si no se evalua por QB | registro de guia)
        String numGuia (para registrar)
     * @return GuiaResponse with TrackingNumber/Carrier
     * @Responses (estatus)
     * 10 ok guia
     * 11 ok ruta
     * -10 fallo ruta
     * -8 fallo registrar ruta (remision) [as of 20/11/20]
     * -7 validacion guia ruta
     * -6 validacion/fallo guia NC
     * -5 validacion guia remision
     * -1 fallo guia (validate etiqueta for further information)
     */
    /*
    public ApiResponse generateTrkNbrLyde(Request request){
        try{
            GuiaResponse gr = tnGenerator.generateTrkNbrLyde(request);
        }catch(Exception e){
            try{
                logger.insertaError(1010000, 10, 0, 0, request.toString(), 0, 0, "", 
                    -1, -1, e.toString(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), 
                    "");
            }catch(Exception ex){}
            GuiaResponse gr=new GuiaResponse();
            gr.setIdEstatusGuia(-1);
            gr.setEtiqueta("GWS00000");
            gr.setMensaje("No se pudo generar guia");
            
        }
        return apiResp;
    }
    */
    /***
     * Metodo para registrar Guia externa
     * @param request Peticion para obtener Carrier
     * Required values :
        int idUsuario usuario que realiza la peticion ,
        int idContainer tipo de contenedor a usar ,
        int idVendor proveedor + ,
        int cdVendor almacen ,
        String pedVtex pedido Vtex ,
        List<String> contenido (lpns, adns, folios) ,
        double lenght largo ,  
        double width ancho ,
        double height alto ,
        double weight peso ,
        int tipPed tipo de pedido ,
        String carrier (si no se evalua por QB | registro de guia) ,
        String numGuia (para registrar) .
        + (as of january 21 is the same value as almacen)
     * @return GuiaResponse with TrackingNumber/Carrier (idEstatusGuia -1 if error, 10 otherwise)
     */
    public Response registerTrkNbr(Request request){
        Response apiResp=new Response();
        try{
            switch(request.getTipoPedido()){
                case 4:case 5:
                    request.setIdCentro(request.getIdVendor());//(as of january 2021)modify or remove for further implementations
                    break;
                default:
                    break;
            }
            GuiaResponse gr = tnGenerator.registerTrckNbr(request);
        }catch(Exception e){
            try{
               logger.insertaError(1010000, 10, 0, 0, request.toString(), 0, 0, "", 
                    -1, -1, e.toString(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), 
                    "");
            }catch(Exception ex){}
            GuiaResponse gr=new GuiaResponse();
            gr.setIdEstatusGuia(-1);
            gr.setEtiqueta("GWS00000");
            gr.setMensaje("No se pudo registrar guia");
            
        }
        return apiResp;
    }
    
    /***
     * Metodo para cancelar guia
     * @param numGuia numero de guia
     * @param carrier 3 char carrier code
     * @param tipoPedido tipo de pedido 
     * @return GuiaResponse (idEstatusGuia -1 if error, 10 not modified, 99 otherwise)
     */
    public Response cancelTrkNbr(String numGuia, String carrier, int tipoPedido){
        Response apiResp=new Response();
        try{
            GuiaResponse gr = tnGenerator.cancelTrackingNumber(numGuia, carrier, tipoPedido);
        }catch(Exception e){
            try{
               logger.insertaError(1010000, 10, 0, 0, (carrier!=null?carrier:""), 0, (carrier!=null?1:0), (numGuia!=null?numGuia:""), 
                    -1, -1, e.toString(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), 
                    "");
            }catch(Exception ex){}
            GuiaResponse gr=new GuiaResponse();
            gr.setIdEstatusGuia(-1);
            gr.setEtiqueta("GWS00000");
            gr.setMensaje("No se pudo cancelar guia");
            
        }
        return apiResp;
    }
    
    /****
     * Modify Tracking Number Status
     * @param request
     * Required values
        int idUsuario usuario que realiza la peticion
        int tipPed tipo de pedido
        String carrier (3 char carrier code)
        String numGuia (para registrar)
     * @param external true if was generated by third parties false if generated by EKT servicies
     * @return GuiaResponse
     */
    public Response statusTrkNbr(Request request, boolean external){
        Response apiResp=new Response();
        GuiaResponse gr = new GuiaResponse();
        switch(request.getTipoPedido()){
            case 4:case 5:
                request.setIdCentro(request.getIdVendor());//(as of may2020)modify or remove for further implementations
                break;
            case 6:
                request.setPedVtex(request.getContenido().get(0));
                request.setIdUsuario(1002);
                request.setIdContenedor(0);
                break;
            default:
                break;
        }
        if(request.getIdCaja()==null)
            request.setIdCaja(0);
        if(request.getIdVendor()==null)
            request.setIdVendor(request.getIdCentro());
        try{
            gr = tnGenerator.putStatusTrkNbr(request, external);
        }catch(Exception e){
            try{
               logger.insertaError(1010000, 10, 0, 0, (request.getCarrier()!=null?request.getCarrier():""), 0, 
                       (request.getCarrier()!=null?1:0), (request.getNumGuia()!=null?request.getNumGuia():""), 
                    -1, -1, e.toString(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), 
                    "");
            }catch(Exception ex){}
            gr=new GuiaResponse();
            gr.setIdEstatusGuia(-1);
            gr.setEtiqueta("GWS00000");
            gr.setMensaje("No se pudo modificar guia");
            
        }
        FoliosResponse fols=new FoliosResponse();
        List<FolioResponse> fol=new ArrayList<>();
        if(gr.getIdEstatusGuia()<0){
            apiResp.setEstatus(1);
            apiResp.setError(false);
            apiResp.setMensaje(gr.getEtiqueta().concat(" ").concat(gr.getMensaje()));
            for(String s:request.getContenido()){
                FolioResponse f=new FolioResponse();
                f.setPedido(s);
                f.setResultado("No se genero guia");
                fol.add(f);
            }
            fols.setPedido(fol);
        }else if(gr.getIdEstatusGuia()==0){
            apiResp.setError(true);
            apiResp.setEstatus(-2);
            apiResp.setMensaje("Error al procesar");
        }else{
            apiResp.setDocumento(gr.getEtiqueta());
            apiResp.setCarrier(gr.getMensaje());
            apiResp.setEstatus(0);
            apiResp.setMensaje("Guia generada");
            apiResp.setNumGuia(gr.getNumGuia());
            for(String s:request.getContenido()){
                FolioResponse f=new FolioResponse();
                f.setPedido(s);
                f.setResultado("En guia");
                fol.add(f);
            }
            fols.setPedido(fol);
        }
        apiResp.setResultado(fols);
        return apiResp;
    }
    
    /****
     * Modify Tracking Number Status
     * @param request
     * Required values
        List<String> contenido (pedidos|remisiones)
        int tipPed tipo de pedido
        int idCentro (3 digit)
     * @return GuiaResponse
     */
    public Response getTrkNbr(Request request){
        Response apiResp=new Response();
        List<GuiaResponse> lgr = new ArrayList<>();
        switch(request.getTipoPedido()){
            case 4:case 5:
                request.setIdCentro(request.getIdVendor());//(as of may2020)modify or remove for further implementations
                break;
            case 6:
                request.setPedVtex(request.getContenido().get(0));
                request.setIdUsuario(1002);
                request.setIdContenedor(0);
                break;
            default:
                break;
        }
        if(request.getIdCaja()==null)
            request.setIdCaja(0);
        if(request.getIdVendor()==null)
            request.setIdVendor(request.getIdCentro());
        try{
            lgr = tnGenerator.getTrackingNumber(request);
        }catch(Exception e){
            GuiaResponse gr = new GuiaResponse();
            try{
               logger.insertaError(1010000, 10, 0, 0, (request.getCarrier()!=null?request.getCarrier():""), 0, 
                       (request.getCarrier()!=null?1:0), (request.getNumGuia()!=null?request.getNumGuia():""), 
                    -1, -1, e.toString(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), 
                    "");
            }catch(Exception ex){}
            gr=new GuiaResponse();
            gr.setIdEstatusGuia(-1);
            gr.setEtiqueta("GWS00000");
            gr.setMensaje("No se pudo modificar guia");
            
        }
        FoliosResponse fols=new FoliosResponse();
        List<FolioResponse> fol=new ArrayList<>();
        if(lgr.get(0).getIdEstatusGuia()<0){
            apiResp.setEstatus(-2);
            apiResp.setError(true);
            apiResp.setMensaje("Error al procesar");
            apiResp.setNumGuia("");
        }else if(lgr.get(0).getIdEstatusGuia()==1){
            apiResp.setError(false);
            apiResp.setEstatus(1);
            apiResp.setMensaje("Sin Informacion");
            apiResp.setNumGuia("");
        }else{
            apiResp.setError(false);
            apiResp.setEstatus(0);
            apiResp.setMensaje("Procesado");
            Set<String> guias=new HashSet<>();
            lgr.forEach(g->{
                guias.add(g.getNumGuia());
            });
            if(guias.size()>1){
                apiResp.setNumGuia("Multiples Guias");
                int i=0;
                for(GuiaResponse gr:lgr){
                    FolioResponse f=new FolioResponse();
                    f.setPedido(request.getContenido().get(i));
                    f.setResultado(gr.getNumGuia());
                    fol.add(f);
                }
            }else{
                if(lgr.get(0).getNumGuia().equals("SIN GUIA")){
                    apiResp.setNumGuia("");
                    for(String s:request.getContenido()){
                        FolioResponse f=new FolioResponse();
                        f.setPedido(s);
                        f.setResultado("Sin Guia");
                        fol.add(f);
                    }
                }else{
                    apiResp.setNumGuia(lgr.get(0).getNumGuia());
                    for(String s:request.getContenido()){
                        FolioResponse f=new FolioResponse();
                        f.setPedido(s);
                        f.setResultado("En guia");
                        fol.add(f);
                    }
                }
            }
            fols.setPedido(fol);
        }
        apiResp.setResultado(fols);
        return apiResp;
    }
}
