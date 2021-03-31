/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.ws;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import com.elektra.quarterback.Core;
import com.elektra.quarterback.beans.CarrierQB;
import com.elektra.quarterback.beans.DetalleSkus;
import com.elektra.quarterback.beans.ExclusionOInclusion;
import com.elektra.quarterback.beans.Paquete;
import com.elektra.quarterback.beans.Sku;
import com.elektra.quarterback.service.GeneralesService;
import com.elektra.quarterback.service.ReglasService;
import com.elektra.quarterback.service.ReglasServiceImpl;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.api.trknbr.beans.ApiResponse;
import mx.com.api.trknbr.beans.GuiaRequest;
import mx.com.api.trknbr.beans.GuiaResponse;
import mx.com.api.trknbr.beans.Request;
import mx.com.api.trknbr.carrier.CSelector;
import mx.com.api.trknbr.carrier.GuiasCarriers;
import mx.com.api.trknbr.configuration.ConfigBean;
import mx.com.api.trknbr.feign.RouteFeign;
import mx.com.api.trknbr.feign.beans.FolioResponse;
import mx.com.api.trknbr.feign.beans.RequestRoute;
import mx.com.api.trknbr.feign.beans.ResponseRoute;
import mx.com.api.trknbr.service.GeneralService;
import mx.com.api.trknbr.service.GuiaService;
import mx.com.elektra.ecomcajas.GenCajas;
import mx.com.elektra.ecomcajas.dto.Caja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("tnGenerator")
public class TNGenerator {
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private GuiaService guiaService;
    @Autowired
    private GeneralService generalesService;
    @Autowired
    private CSelector carrier;
    
    private GenCajas genCajas = new GenCajas();
    @Autowired
    private RouteFeign wsRutas;
    
    private GuiasCarriers carrierWs;
    
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
    public GuiaResponse generateTrackingNumber(Request request){
        if(conf.isWriteAll())
            System.out.println("Entrada a Servicio");
        int flg=0;
        GuiaResponse response = null;
        
        CarrierQB carrier = null;
        GuiaRequest guiaRequest = null;
        //request.setTipPed(4);
        int idCaja=getCaja(request);
        Map<String,Double> sizes = null;
        if(idCaja == 0){
            flg = 3;
            carrier = new CarrierQB();
            carrier.setDesdCarrier("GCJ00000");
            guiaRequest = new GuiaRequest();
            guiaRequest.setObservaciones("GCJ00000");
        }else{
            try{
                switch(request.getTipoPedido()){
                    case 4: case 5: 
                        if(conf.isWriteAll())
                            System.out.println("Entrada a Core");
                        carrier=/*new CarrierQB();*/new Core().coreMKPDSV(//call QuarterBack to get Carrier
                            request.getIdUsuario(),
                            idCaja, 
                            request.getIdVendor(), 
                            request.getIdCentro(),
                            request.getPedVtex(),
                            request.getContenido(), 
                            request.getLargo(), 
                            request.getAncho(), 
                            request.getAlto(), 
                            request.getPeso(),
                            true,
                            request.getTipoPedido()
                        );//create Carrier ws request by id*/
                        //carrier.setCodCarrier("FDX");
                        //carrier.setDesdCarrier("FEDEX");
                        //carrier.setIdCarrier(10);
                        sizes=new HashMap<>();
                        request.setTipoDocumento(0);
                        break;
                    case 6: default:
                        if(conf.isWriteAll())
                            System.out.println("Buscando carrier");
                        carrier=getIdCarrier(request.getCarrier(), 1, request.getTipoPedido(),true);/*/new Core().coreLyde(//call QuarterBack to get Carrier
                            request.getIdUsuario(),
                            idCaja, 
                            request.getIdVendor(), 
                            request.getIdCentro(),
                            request.getPedVtex(),
                            request.getAdn(), 
                            request.Largo(), 
                            request.Ancho(), 
                            request.Alto(), 
                            request.Peso(),
                            true,
                            request.ogetTipPedido()
                        );//create Carrier ws request by id*/
                        sizes=new HashMap<>();
                        sizes.put("height", request.getAlto());
                        sizes.put("width", request.getAncho());
                        sizes.put("lenght", request.getLargo());
                        sizes.put("weight", request.getPeso());
                        break;
                }
            }catch(Exception e){
                flg=4;//search IdError 1020007 in BD logger or QB errors
                carrier=new CarrierQB();
                carrier.setDesdCarrier("GWSQB");
            }
            if(conf.isWriteAll())
                System.out.println("Carrier seleccionado "+carrier.getIdCarrier());
            carrierWs = getCarrier(carrier.getIdCarrier());
            guiaRequest = null;
            if(carrierWs != null){
                boolean create=true;
                switch(request.getTipoPedido()){
                    case 6:
                        ResponseRoute respRuta=getRoute3pl(request);
                        if(respRuta.getCodigo().equals("0")){
                            for(FolioResponse fr:(respRuta.getResultado().getFolios().getFolio())){
                                if(fr.getResultado().contains("Cancelada") || fr.getRuta().equals("")) {
                                }else{
                                    create=false;
                                    break;
                                }
                            }
                        }else{
                            create=false;
                            flg=6;
                        }
                        break;
                    default :
                        break;
                }
                if(create){
                    guiaRequest = generalesService.insertControlGuias(request.getPedVtex(), idCaja, request.getIdCentro(), request.getIdVendor(), carrier.getIdCarrier(), 1, request.getTipoPedido(), request.getIdUsuario()+"", "", sizes, request.getTipoDocumento());
                    if(!guiaRequest.getObservaciones().contains("GWSP")){
                        if(guiaRequest.getIdTipoPedido()==6)
                            validateExclusion(guiaRequest);
                        if(carrier.getIdCarrier()==11)
                            guiaRequest.setIdEstacion(request.getIdEstacion());
                        response = carrierWs.generaGuia(guiaRequest, conf.isWriteAll(), "10.20.22.21", "8080", request.getIdUsuario()+"");
                        response.setIdCaja(idCaja);
                        if(response.getIdEstatusGuia()==10){
                            if(request.getTipoPedido() != 6){
                                response.setEtiqueta("");
                                response.setMensaje(carrier.getDesdCarrier());
                            }else{
                                ResponseRoute respRuta = createRoute3pl(request);
                                if(respRuta.getCodigo().equals("0"))
                                    response.setMensaje("No se vinculo guia con ruta");
                                else
                                    response.setMensaje(carrier.getCodCarrier());
                            }
                        }
                        if(response.getIdEstatusGuia()<0){
                            genCajas.cancelCaja(idCaja,request.getTipoPedido());
                            flg=-1;
                            try{
                                logger.insertaError(1020001, 10, request.getIdCentro(), 0, request.getPedVtex(), idCaja, carrier.getIdCarrier(), 
                                    "", 1, request.getTipoPedido(), response.getEtiqueta(), "generateTrackingNumber", request.getIdUsuario()+"");    
                            }catch(Exception e){}
                        }
                    }else{
                        flg=2;
                    }
                }else{
                    flg=(flg>1)?flg:5;
                }
            }else{
                flg=(flg>1)?flg:1;//if already failed doesnt validate the carrierWs error
                guiaRequest = new GuiaRequest();
                guiaRequest.setObservaciones("");
            }
        }
        if(flg>0){
            response = new GuiaResponse();
            //response.setEtiqueta("");
            response.setIdEstatusGuia(-1);
            response.setNumGuia("");
            response.setCarrier(0);
            switch(flg){
                case 1:
                    response.setMensaje("No se pudo establecer Carrier");
                    response.setEtiqueta(carrier.getDesdCarrier());
                    break;
                case 2:
                    response.setMensaje("No se registro en central de guias");
                    response.setEtiqueta(guiaRequest.getObservaciones());
                    break;
                case 3:
                    response.setMensaje("No se pudo obtener caja");
                    response.setEtiqueta("GWSC000");
                    break;
                case 4:
                    response.setMensaje("No se pudo obtener carrier");
                    response.setEtiqueta("GWSCR00");
                    break;
                case 5:
                    response.setMensaje("Ya existe informacion de ruta");
                    response.setEtiqueta("GWSWR00");
                    break;
                case 6:
                    response.setMensaje("No se pudo copmprobar informacion de ruta");
                    response.setEtiqueta("GWSWR01");
                    break;
                default:
                    response.setMensaje("Ocurrio un error");
                    response.setEtiqueta("GWS0000");
                    break;
            }
            genCajas.cancelCaja(idCaja,request.getTipoPedido());
            try{
                logger.insertaError(1020001, 10, request.getIdCentro(), 0, request.getPedVtex(), idCaja, carrier.getIdCarrier(), 
                    "", 1, request.getTipoPedido(), response.getEtiqueta(), "generateTrackingNumber", request.getIdUsuario()+"");    
            }catch(Exception e){}
        }
        return response;
    }   
    
    private ResponseRoute createRoute3pl(Request request){
        RequestRoute requestRoute=new RequestRoute();
        requestRoute.setIdCentro(generalesService.getInfoAlmn(request.getIdCentro()).getIdSap());
        requestRoute.setFolios(request.getContenido());
        requestRoute.setIdTransporte(carrierWs.getIdSap());
        requestRoute.setIdUnidad(0);
        requestRoute.setMotivo(0);
        requestRoute.setTipoRuta(0);
        requestRoute.setSecuencia(0);
        requestRoute.setExternal(true);
        requestRoute.setChecador(request.getNumGuia());
        ResponseRoute resp2 = wsRutas.createRoute(requestRoute);
        return resp2;
    }
    private ResponseRoute getRoute3pl(Request request){
        RequestRoute requestRoute=new RequestRoute();
        requestRoute.setIdCentro(generalesService.getInfoAlmn(request.getIdCentro()).getIdSap());
        requestRoute.setFolios(request.getContenido());
        requestRoute.setIdTransporte(carrierWs.getIdSap());
        requestRoute.setIdUnidad(0);
        requestRoute.setMotivo(0);
        requestRoute.setTipoRuta(0);
        requestRoute.setSecuencia(0);
        requestRoute.setExternal(true);
        requestRoute.setChecador(request.getNumGuia());
        ResponseRoute resp2 = wsRutas.getRouteStat(requestRoute);
        return resp2;
    }
    private ResponseRoute cancelRoute3pl(Request request){
        RequestRoute requestRoute=new RequestRoute();
        requestRoute.setIdCentro(generalesService.getInfoAlmn(request.getIdCentro()).getIdSap());
        requestRoute.setFolios(request.getContenido());
        requestRoute.setIdTransporte(carrierWs.getIdSap());
        requestRoute.setIdUnidad(0);
        requestRoute.setMotivo(0);
        requestRoute.setTipoRuta(0);
        requestRoute.setSecuencia(0);
        requestRoute.setExternal(true);
        requestRoute.setChecador(request.getNumGuia());
        ResponseRoute resp2 = wsRutas.cancelRoute(requestRoute);
        return resp2;
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
     */
    /*
    public GuiaResponse generateTrkNbrLyde(Request request){
        GuiaResponse response = new GuiaResponse();
        Map<String,Object> validate;
        if((request.getContenido()==null || request.getContenido().isEmpty())){
            if(conf.isWriteAll())
                System.out.println("Sin contenido");
            response.setCarrier(0);
            response.setMensaje("Sin remision o NCs. Validar peticion");
            response.setIdEstatusGuia(-1);
        }
        request.setPedVtex(request.getContenido().get(0));
        request.setIdUsuario(1002);
        request.setTipoPedido(6);
        switch(request.getTipPet()){
            case 1:
                if(conf.isWriteAll())
                    System.out.println("Peticion de rutas");
                List<Integer> rems=new ArrayList<>();
                request.getContenido().forEach((rem)->{
                    rems.add(Integer.parseInt(rem));
                });
                Respuesta respR = genRutas.getFolRutLyde(generalesService.getInfoAlmn(request.getIdCentro()).getIdSap(), rems, request.getIdTransp(), request.getIdUnidad(), 0, "", "", false);
                if(respR.isError()){
                    response.setCarrier(0);
                    response.setMensaje(respR.getMsg());
                    response.setEtiqueta(respR.getCode());
                }else{
                    response.setCarrier(0);
                    response.setEtiqueta(respR.getDocument());
                    response.setMensaje(respR.getMsg());
                    response.setRuta(respR.getRuta());
                }
                response.setIdEstatusGuia(respR.isError()?-10:11);
                break;
            case 2:
                if(conf.isWriteAll())
                    System.out.println("Peticion de Guia");
                switch(request.getTipoDocumento()){
                    case 1:
                        if(conf.isWriteAll())
                            System.out.println("Contenido : Remision");
                        //validate=generalesService.validateRemisionWithRoute(request.getContenido(),generalesService.getIdSap(request.getIdCentro()));
                        validate = generalesService.validateRemisionWithTN(request.getContenido(),request.getIdCentro());
                        if((boolean)validate.get("valid")){
                            //validate rem info
                            validate = generalesService.validateRemisionDestino(request.getContenido(),request.getIdCentro());
                            if((boolean)validate.get("valid")){
                                //validate = generalesService.validateRemisionWithTN(request.getContenido(),request.getIdCentro());
                                validate = genRutas.validateRemision(request.getContenido(),generalesService.getIdSap(request.getIdCentro()));
                                if((boolean)validate.get("valid")){
                                    response = generateTrackingNumber(request);
                                    if(response.getIdEstatusGuia()>=10){
                                        List<Integer> rem2=new ArrayList<>();
                                        request.getContenido().forEach((rem)->{
                                            rem2.add(Integer.parseInt(rem));
                                        });
                                        Respuesta resp2 = genRutas.getFolRutLyde(generalesService.getIdSap(request.getIdCentro()), rem2, carrierWs.getIdSap(), 0, 0, response.getNumGuia(), "", true);
                                        if(resp2.isError())
                                            response.setMensaje(resp2.getCode()+":No se vinculo guia con ruta");
                                    }
                                }else{
                                    response.setCarrier(0);
                                    if(validate.containsKey("remision") && validate.containsKey("folios"))
                                        response.setMensaje((String)validate.get("message")+" "+(String)validate.get("remision"));
                                    else
                                        response.setMensaje((String)validate.get("message"));
                                    response.setIdEstatusGuia(-7);
                                }
                            }else{
                                response.setCarrier(0);
                                response.setMensaje((String)validate.get("message"));
                                response.setIdEstatusGuia(-5);
                            }
                        }else{
                            if(validate.containsKey("folios")){
                                response.setCarrier(Integer.parseInt(validate.get("carrierId").toString()));
                                response.setMensaje((String)validate.get("carrierCod"));
                                response.setNumGuia((String)validate.get("guia"));
                                response.setIdEstatusGuia(10);
                            }else{
                                response.setCarrier(0);
                                response.setMensaje((String)validate.get("message")+
                                        (validate.containsKey("folios")?(String)validate.get("folTexto"):""));
                                response.setIdEstatusGuia(-5);
                            }
                        }
                        break;
                    case 2:
                        if(conf.isWriteAll())
                            System.out.println("Contenido : NC");
                        //validate nc info
                        validate = generalesService.validateNCVtex(request.getContenido(),request.getIdCentro());
                        if((boolean)validate.get("valid")){
                            request.setPedVtex((String)validate.get("message"));
                            validate = generalesService.validateNCwithTN(request.getContenido(),request.getIdCentro());
                            if((boolean)validate.get("valid")){
                                validate = generalesService.validateNCStatus(request.getContenido(),request.getIdCentro());
                                if((boolean)validate.get("valid")){
                                    response = generateTrackingNumber(request);
                                }else{
                                    response.setCarrier(0);
                                    response.setMensaje((String)validate.get("message"));
                                    response.setIdEstatusGuia(-6);
                                }
                            }else{
                                response.setCarrier(0);
                                response.setMensaje((String)validate.get("message"));
                                response.setIdEstatusGuia(-6);
                            }
                        }else{
                            response.setCarrier(0);
                            response.setMensaje((String)validate.get("message"));
                            response.setIdEstatusGuia(-6);
                        }
                        break;
                }
                break;
            case 3:
                if(conf.isWriteAll())
                    System.out.println("Peticion Registra guia");
                //validate if exists ?
                switch(request.getTipoDocumento()){
                    case 1:
                        response = registerTrckNbr(request);
                        if(response.getIdEstatusGuia()>=10){
                            List<Integer> rem2=new ArrayList<>();
                            request.getContenido().forEach((rem)->{
                                rem2.add(Integer.parseInt(rem));
                            });
                            Integer prov = carrierWs.getIdSap();
                            Respuesta resp2 = genRutas.getFolRutLyde(generalesService.getIdSap(request.getIdCentro()), rem2, prov, 0, 0, response.getNumGuia(), "", true);
                            if(resp2.isError())
                                response.setMensaje(resp2.getCode()+":No se vinculo guia con ruta");
                        }
                        break;
                    case 2:
                        break;
                }
                break;
        }
        return response;
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
     * @return GuiaResponse with TrackingNumber/Carrier (idEstatusGuia -8 if not registered)
     */
    public GuiaResponse registerTrckNbr(Request request){
        //RequestMKP request = parseRequestTrkNbr(requestws);
        if(conf.isWriteAll())
            System.out.println("Entrada a Servicio");
        int flg=0;
        GuiaResponse response = null;
        
        CarrierQB carrier = null;
        GuiaRequest guiaRequest = null;
        //request.setTipPed(4);
        int idCaja=getCaja(request);
        Map<String,Double> sizes = new HashMap<>();
        
        sizes.put("height", request.getAlto());
        sizes.put("width", request.getAncho());
        sizes.put("lenght", request.getLargo());
        sizes.put("weight", request.getPeso());
        if(request.getTipoPedido()==6)
            request.setIdUsuario(1002);
        if(idCaja == 0){
            flg = 3;
        }else{
            try{
                carrier = getIdCarrier(request.getCarrier(), 1, request.getTipoPedido(), request.getTipoPedido()!=5);
            }catch(Exception e){
                if(conf.isWriteAll())
                    System.out.println("Error - "+e.getMessage());
                flg=4;
                carrier = new CarrierQB();
            }
            if(conf.isWriteAll())
                System.out.println("Carrier seleccionado "+carrier.getIdCarrier());
            carrierWs = getCarrier(1);
            guiaRequest = null;
            if(carrierWs != null){
                guiaRequest = generalesService.insertControlGuias(request.getPedVtex(), idCaja, request.getIdCentro(), request.getIdVendor(), carrier.getIdCarrier(), 1, request.getTipoPedido(), request.getIdUsuario()+"", "", sizes, request.getTipoDocumento());
                if(!guiaRequest.getObservaciones().contains("GWSP")){
                    response = new GuiaResponse();
                    response.setCarrier(carrier.getIdCarrier());
                    response.setIdEstatusGuia(10);
                    response.setEtiqueta("");
                    response.setNumGuia(request.getNumGuia());
                    response.setIdCaja(idCaja);
                    response.setMensaje("Se registro Correctamente");
                    response.setEncrypt(0);
                    response.setInput("");
                    response.setOutput("");
                    carrierWs.externalTrackingNumber(guiaRequest, response);
                    //ActualizaGuia ag = new ActualizaGuia(guiaRequest, response, "1002");
                    carrierWs.actualizaGuia();
                    //ag.actualizaGuia();
                }else{
                    flg=2;
                }
            }else{
                flg=(flg>1)?flg:1;
            }
        }
        if(flg>0){
            response = new GuiaResponse();
            //response.setEtiqueta("");
            response.setIdEstatusGuia(-8);
            response.setNumGuia(request.getNumGuia());
            response.setCarrier(0);
            switch(flg){
                case 1:
                    response.setMensaje("No se pudo establecer Carrier");
                    response.setEtiqueta("GWSCR00");
                    break;
                case 2:
                    response.setMensaje("No se registro en central de guias");
                    response.setEtiqueta(guiaRequest.getObservaciones());
                    break;
                case 3:
                    response.setMensaje("No se pudo obtener caja");
                    response.setEtiqueta("GWSC000");
                    break;
                case 4:
                    response.setMensaje("No se pudo obtener carrier");
                    response.setEtiqueta("GWSCR00");
                    break;
                default:
                    response.setMensaje("Ocurrio un error");
                    response.setEtiqueta("GWS0000");
                    break;
            }
            genCajas.cancelCaja(idCaja,request.getTipoPedido());
        }
        return response;
    }
    
    private CarrierQB getIdCarrier(String codCarrier, int idCanal, int tipoPedido, boolean active) throws Exception{
        CarrierQB c = generalesService.getCarrier(codCarrier, idCanal, tipoPedido, active);
        if(c==null)
            throw new Exception("No se recupero informacion de carrier para el tipo de pedido: "+tipoPedido);
        else
            return c;
    }
    
    private int getCaja(Request request){
        int idCaja = request.getIdCaja();
        if(idCaja==0){
            Caja req = new Caja();
            req.setContenido(request.getContenido());
            req.setHeight(request.getAlto());
            req.setIdContainer(request.getIdContenedor());
            req.setIdUsuario(request.getIdUsuario());
            req.setIdVendor(request.getIdCentro());//(as of feb 2021)
            req.setLenght(request.getLargo());
            req.setPedVtex(request.getPedVtex());
            req.setTipPed(request.getTipoPedido());
            req.setWeight(request.getPeso());
            req.setWidth(request.getAncho());
            idCaja = genCajas.generateEcomCaja(req);
        }
        return idCaja;
    }
    
    private GuiasCarriers getCarrier(int idCarrier){
        return carrier.getInstance(idCarrier);
    }
    
    /***
     * Cancel Tracking Number 
     * @param numGuia tracking number
     * @param carrier 3 char carrier code
     * @param tipoPedido 
     * @return GuiaResponse
     */
    public GuiaResponse cancelTrackingNumber(String numGuia, String carrier, int tipoPedido){
        if(conf.isWriteAll())
            System.out.println("Entrada a Servicio.");
        GuiaResponse gr = new GuiaResponse();
        CarrierQB c;
        try{
            if(conf.isWriteAll())
                System.out.println("Recuperando carrier...");
            c=getIdCarrier(carrier, 1, tipoPedido, tipoPedido!=5);
        }catch(Exception e){
            gr.setCarrier(0);
            gr.setIdEstatusGuia(-1);
            gr.setNumGuia(numGuia);
            gr.setMensaje("GWSCG00");
            gr.setEtiqueta(e.getMessage());
            return gr;
        }
        if(c.getIdCarrier()!=0){
            if(conf.isWriteAll())
                System.out.println("Validando Estatus Guia...");
            Map<String,Object> result = guiaService.getStatusTrknbr(numGuia,c.getIdCarrier());
            if((Boolean) result.get("valid")){
                if(conf.isWriteAll())
                    System.out.println("Cancelando Guia...");
                switch((Integer)result.get("STAT")){
                    case 99 :
                        gr.setMensaje("Guia ya se encuentra cancelada");
                        break;
                    case -1:
                        gr.setMensaje("Guia se encuentra en error");
                        break;
                    case 5:
                        gr.setMensaje("Estatus invalido");
                        break;
                    case 10:
                        if(guiaService.cancelTrknbr(numGuia,c.getIdCarrier(),tipoPedido)){
                            if(conf.isWriteAll())
                                System.out.println("Cancelando Caja");
                            genCajas.cancelCaja((Integer)result.get("CAJA"), tipoPedido);
                            //if(result.get("FOLRUT").toString().equals("A"))
                                //genRutas.cancelRuta(result.get("FOLRUT").toString(),result.get("ALMJD").toString());
                            gr.setCarrier(c.getIdCarrier());
                            gr.setIdEstatusGuia(99);
                            gr.setNumGuia(numGuia);
                            gr.setEtiqueta("GWSCGOK");
                            gr.setMensaje("Cancelacion correcta");
                        }else{
                            gr.setCarrier(c.getIdCarrier());
                            gr.setIdEstatusGuia(10);
                            gr.setNumGuia(numGuia);
                            gr.setEtiqueta("GWSCG03");
                            gr.setMensaje("No se cancelo guia");
                        }
                        break;
                    default:
                        gr.setMensaje("Guia ya cuenta con movimiento");
                        break;
                }
            }else{
                if(conf.isWriteAll())
                    System.out.println("Guia no cancelada");
                gr.setCarrier(0);
                gr.setIdEstatusGuia(-1);
                gr.setNumGuia(numGuia);
                gr.setEtiqueta("GWSCG02");
                gr.setMensaje((String)result.get("message"));
                
            }
        }else{
            if(conf.isWriteAll())
                System.out.println("Carrier no encontrado.");
            gr.setCarrier(0);
            gr.setIdEstatusGuia(-1);
            gr.setNumGuia(numGuia);
            gr.setMensaje("GWSCG01");
            gr.setEtiqueta("Carrier incorecto");
        }
        return gr;
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
    public GuiaResponse putStatusTrkNbr(Request request, boolean external){
        GuiaResponse gr=new GuiaResponse();
        CarrierQB c;
        try{
            if(conf.isWriteAll())
                System.out.println("Recuperando carrier...");
            c=getIdCarrier(request.getCarrier(), 1, request.getTipoPedido(), external);
        }catch(Exception e){
            gr.setCarrier(0);
            gr.setIdEstatusGuia(-1);
            gr.setNumGuia(request.getNumGuia());
            gr.setMensaje("GWSSG00");
            gr.setEtiqueta(e.getMessage());
            return gr;
        }
        if(c.getIdCarrier()!=0){
            Map<String,Object> result = guiaService.getStatusTrknbr(request.getNumGuia(),c.getIdCarrier());
            if((Boolean) result.get("valid")){
                switch((Integer)result.get("STAT")){
                    case 99 :
                        gr.setMensaje("Guia ya se encuentra cancelada");
                        break;
                    case -1:
                        gr.setMensaje("Guia se encuentra en error");
                        break;
                    case 5:
                        gr.setMensaje("Guia en estatus invalido");
                        break;
                    case 10:case 20:
                        if(guiaService.cancelTrknbr(request.getNumGuia(), c.getIdCarrier(), request.getTipoPedido())){
                            if(conf.isWriteAll())
                                System.out.println("Cancelando Caja");
                            genCajas.cancelCaja((Integer)result.get("CAJA"), request.getTipoPedido());
                            gr.setEtiqueta("GWSSGOK");
                            gr.setMensaje("Modificacion correcta");
                            gr.setIdEstatusGuia(request.getEstatus());
                        }else{
                            gr.setEtiqueta("GWSCG03");
                            gr.setMensaje("No se modifico guia");
                            gr.setIdEstatusGuia(-1);
                        }
                        gr.setCarrier(c.getIdCarrier());
                        gr.setNumGuia(request.getNumGuia());
                        break;
                    default:
                        gr.setMensaje("Guia en estatus final ("+result.get("STAT") +")");
                        break;
                }
            }else{
                if(conf.isWriteAll())
                    System.out.println("Guia no cancelada");
                gr.setCarrier(0);
                gr.setIdEstatusGuia(-1);
                gr.setNumGuia(request.getNumGuia());
                gr.setEtiqueta("GWSSG02");
                gr.setMensaje((String)result.get("message"));
                
            }
        }else{
            if(conf.isWriteAll())
                System.out.println("Carrier no encontrado.");
            gr.setCarrier(0);
            gr.setIdEstatusGuia(-1);
            gr.setNumGuia(request.getNumGuia());
            gr.setEtiqueta("GWSSG01");
            gr.setMensaje("Carrier incorecto");
        }
        return gr;
    }
    
    private void validateExclusion(GuiaRequest gr){
        if(gr.getIdTipoPedido() == 6){
            ReglasService reglaServ = new ReglasServiceImpl();
            Paquete paquete=new Paquete();
            paquete.setIdCanal(gr.getIdTipoPedido());
            List<DetalleSkus> ls=new ArrayList<>();
            double insurance=0;
            DecimalFormat df2 = new DecimalFormat("#.00");
            for(mx.com.api.trknbr.beans.DetalleSkus sku : gr.getSkus()){
                DetalleSkus ds = new DetalleSkus();
                Sku s = new Sku();
                    s.setIdClase(sku.getSku().getIdClase());
                    s.setIdDepartamento(sku.getSku().getIdDepartamento());
                    s.setIdSku(sku.getSku().getIdSku());
                    s.setIdSubclase(sku.getSku().getIdSubclase());
                    s.setIdSubdepartamento(sku.getSku().getIdSubdepartamento());
                ds.setSku(s);
                ls.add(ds);
            }
            paquete.setSkus(ls);
            try{
                ExclusionOInclusion ei = reglaServ.validaExclusiones(paquete, gr.getIdCarrier());
                if(ei.getTipoExclusion()!=0){
                    gr.setSeguro(true);
                    for(mx.com.api.trknbr.beans.DetalleSkus sku : gr.getSkus()){
                        if(sku.getSku().getIdSubdepartamento().equals(ei.getSku().getIdSubdepartamento()))
                            insurance+=sku.getSku().getCostoUnitario();
                    }
                    gr.setCostoAsegurado(df2.format(insurance));
                }else{
                    gr.setSeguro(false);
                    gr.setCostoAsegurado("0");
                }
            }catch(Exception e){
                System.out.println(e.toString());
                if(conf.isWriteAll())
                    System.out.println("Error : "+e.getMessage());
                try{
                    logger.insertaError(1010000, 10, gr.getIdManh(), 0, gr.getVtex(), gr.getIdCaja(), gr.getIdCarrier(), "", gr.getIdCanal(), gr.getIdTipoPedido(), 
                            e.toString(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");
                }catch(Exception el){}
                gr.setSeguro(false);
                gr.setCostoAsegurado("0");
            }
        }else{
            gr.setSeguro(false);
            gr.setCostoAsegurado("0");
        }
    }
    
    public List<GuiaResponse> getTrackingNumber(Request request){
        List<GuiaResponse> lgr = new ArrayList<>();
        CarrierQB c;
        try{
            if(conf.isWriteAll())
                System.out.println("Recuperando carrier...");
            c=getIdCarrier(request.getCarrier(), 1, request.getTipoPedido(), request.getTipoPedido()!=5);
        }catch(Exception e){
            GuiaResponse gr = new GuiaResponse();
            gr.setCarrier(0);
            gr.setIdEstatusGuia(-1);
            gr.setNumGuia(request.getNumGuia());
            gr.setMensaje("GWSSG00");
            gr.setEtiqueta(e.getMessage());
            lgr.add(gr);
            return lgr;
        }
        if(c.getIdCarrier()!=0){
            Map<String,Map<String,Object>> result = guiaService.getStatusTrknbr(request.getContenido(),request.getIdCentro(),request.getTipoPedido());
            if((Boolean)result.get("valid").get("valid")){
                for(Map.Entry<String, Map<String,Object>> e:result.entrySet()){
                    GuiaResponse gr = new GuiaResponse();
                    gr.setCarrier(c.getIdCarrier());
                    gr.setNumGuia(e.getValue().get("GUIA").toString());
                    gr.setMensaje(e.getValue().get("STATUS").toString());
                    gr.setIdEstatusGuia((Integer)e.getValue().get("STAT"));
                    gr.setIdCaja((Integer)e.getValue().get("CAJA"));
                    lgr.add(gr);
                }
            }else{
                GuiaResponse gr = new GuiaResponse();
                gr.setCarrier(0);
                gr.setIdEstatusGuia((Integer)result.get("valid").get("STAT"));
                gr.setNumGuia("");
                gr.setMensaje((String)result.get("valid").get("message"));
                lgr.add(gr);
            }
        }else{
            GuiaResponse gr = new GuiaResponse();
            if(conf.isWriteAll())
                System.out.println("Carrier no encontrado.");
            gr.setCarrier(0);
            gr.setIdEstatusGuia(-1);
            gr.setNumGuia(request.getNumGuia());
            gr.setEtiqueta("GWSSG01");
            gr.setMensaje("Carrier incorecto");
            lgr.add(gr);
        }
        return lgr;
    }
}
