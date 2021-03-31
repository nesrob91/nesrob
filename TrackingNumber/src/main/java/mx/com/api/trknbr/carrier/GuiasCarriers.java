/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.carrier;

import mx.com.api.trknbr.beans.GuiaRequest;
import mx.com.api.trknbr.beans.GuiaResponse;
import com.elektra.cadsumutils.generales.Generales;
import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import com.elektra.cadsumutils.ws.XmlUtil;
import java.util.Base64;
import mx.com.api.trknbr.beans.CredencialesDhl;
import mx.com.api.trknbr.beans.CredencialesEstafeta;
import mx.com.api.trknbr.beans.CredencialesFedex;
import mx.com.api.trknbr.beans.CredencialesPaquetexpress;
import mx.com.api.trknbr.service.CarriersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("guias")
public class GuiasCarriers {

    @Autowired
    protected CarriersService carrierService ;
    
    
    @Autowired
    private LogsPaqueterias logger;
    
    protected XmlUtil xmlUtil = new XmlUtil();
    
    protected Object credenciales = new Object();
    protected Object peticion = new Object();
    protected Object respuesta = new Object();
    protected boolean desarrollo;
    protected Generales utils = new Generales();
    protected GuiaRequest guiaRequest = null;
    protected String proxy = null;
    protected String puerto = null;
    protected String usuario = null;
    
    private GuiaResponse guiaResponse = null;
    private Integer idSap;
    
    private boolean isExternal=false;
    
    public void externalTrackingNumber(GuiaRequest request, GuiaResponse response){
        this.guiaRequest = request;
        this.guiaResponse = response;
        this.isExternal = true;
    }
    
    /***
     * Metodo para mandar a llamar a los diferentes carriers
     * @param guiaRequest peticion (raw) generada al insertar en control_guias
     * @param desarrollo bandera para imprimir mensajes de aplicacion
     * @param proxy proxy to internet 10.20.22.21
     * @param puerto puerto de salida 8080
     * @param usuario usuario que realiza la peticion
     * @return Objeto GuiaResponse con el resultado que devuleve el carrier
     */
    public GuiaResponse generaGuia(GuiaRequest guiaRequest, boolean desarrollo, String proxy, String puerto, String usuario) {
        
        this.desarrollo = desarrollo;
        this.guiaRequest = guiaRequest;
        this.proxy = proxy;
        this.puerto = puerto;
        this.usuario = usuario;
        
        setProxy();
        int stage = 0;
        try {
            if(desarrollo)
                System.out.println("Obteniendo Credenciales...");
            stage = 1;
            credenciales = getCredenciales();
            if (credenciales != null) {
                if(desarrollo)
                    System.out.println("Generando Peticion...");
                stage = 2;
                peticion = generaPeticion();
                if (peticion != null) {
                    if(desarrollo)
                        System.out.println("Comunicandose con carrier...");
                    stage = 3;
                    respuesta = consumeWs();
                    if (respuesta != null) {
                        if(desarrollo)
                            System.out.println("Procesando Respuesta...");
                        stage = 4;
                        guiaResponse = procesaRespuesta();
                        if(guiaResponse != null){
                            actualizaGuia();
                            return guiaResponse;
                        }else{
                            return guiaError("Error al procesar la respuesta de servicio","GWSG004");
                        }
                    } else {
                        return guiaError("Error al comunicarse con el servicio del Carrier","GWSG003");
                    }
                } else {
                    return guiaError("Error al generar la petición al ws","GWSG002");
                }
            } else {
                return guiaError("Credenciales no encontradas para carrier","GWSG001");
            }
        } catch (Exception ex) {
            int error = 0;
            switch(stage){
                case 1:
                    guiaResponse = guiaError("Credenciales no encontradas para carrier","GWSG001");
                    error = 1020002;
                    break;
                case 2:
                    guiaResponse = guiaError("Error al generar la petición al ws","GWSG002");
                    error = 1020003;
                    break;
                case 3:
                    guiaResponse = guiaError("Error al comunicarse con el servicio del Carrier","GWSG003");
                    error = 1020004;
                    break;
                case 4:
                    guiaResponse = guiaError("Error al procesar la respuesta de servicio","GWSG004");
                    error = 1020005;
                    break;
                default :
                    guiaResponse = guiaError("Ocurrió una excepción al generar la guía","GWSC000");
                    error = 1020001;
                    break;
            }
            try{
                logger.insertaError(
                    error
                    , 10
                    , guiaRequest.getIdManh()
                    , null
                    , guiaRequest.getPedido()
                    , guiaRequest.getIdCaja()
                    , guiaRequest.getIdCarrier()
                    , null
                    , guiaRequest.getIdCanal()
                    , guiaRequest.getIdTipoPedido()
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception el){}
            return guiaResponse;
        }

    }

    protected Object getCredenciales() throws Exception{
        return null;
    }

    protected Object generaPeticion() throws Exception {
        return null;
    }

    protected Object consumeWs() throws Exception {
        return null;
    }

    protected GuiaResponse procesaRespuesta() throws Exception {
        return null;
    }
    
    
    
    
    protected GuiaResponse guiaError(String mensaje, String code) {
        if (desarrollo) {
            System.out.println("Error: " + mensaje);
        }
        
        guiaResponse = new GuiaResponse();
        guiaResponse.setIdEstatusGuia(-1);
        guiaResponse.setMensaje(mensaje);
        guiaResponse.setEtiqueta(code);
        actualizaGuia();
        return guiaResponse;
    }
    
    private void setProxy(){
        
        try{
            if(proxy != null && !proxy.equals("")){

                System.setProperty("http.proxyHost", proxy);
                System.setProperty("http.proxyPort", puerto);
                System.setProperty("https.proxyHost", proxy);
                System.setProperty("https.proxyPort", puerto);

            }
            
        }catch(Exception ex){
            try{
                logger.insertaError(
                    1020006
                    , 10
                    , guiaRequest.getIdManh()
                    , null
                    , guiaRequest.getPedido()
                    , guiaRequest.getIdCaja()
                    , guiaRequest.getIdCarrier()
                    , null
                    , guiaRequest.getIdCanal()
                    , guiaRequest.getIdTipoPedido()
                    , ex.toString()
                    , new Object(){}.getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
        }
    }
    
    /*private void actualizaGuia(){
        //Thread actualizaGuiaThread = new Thread(new ActualizaGuia(guiaRequest, guiaResponse, usuario));
        ActualizaGuia actualizaGuiaThread = new ActualizaGuia(guiaRequest, guiaResponse, usuario);
        //actualizaGuiaThread.start();
        actualizaGuiaThread.actualizaGuia();
        
    }*/
    public void actualizaGuia(){
        try{
            if(guiaResponse.getIdEstatusGuia()==10){
                if(guiaResponse.getEtiqueta().contains("%PDF") || guiaResponse.getEtiqueta().contains("^XA")){
                    String encode="";
                    //Base64.Encoder base=Base64.getEncoder();
                    encode=Base64.getEncoder().encodeToString(guiaResponse.getEtiqueta().getBytes());
                    guiaResponse.setEtiqueta(encode);
                }
            }
        }catch(Exception e){
            if(desarrollo)
                System.out.println("Error al codificar etiqueta. Guardando datos originales");
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , guiaRequest.getIdManh()
                    , null
                    , guiaRequest.getPedido()
                    , guiaRequest.getIdCaja()
                    , guiaRequest.getIdCarrier()
                    , null
                    , guiaRequest.getIdCanal()
                    , guiaRequest.getIdTipoPedido()
                    , "Error al codificar etiqueta. Guardando datos originales"
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception el){}
        }
        carrierService.actualizaGuia(guiaRequest, guiaResponse, usuario, isExternal);
    }

    public Integer getIdSap() {
        if(idSap==null){
            try{
                String s="0";
                if(credenciales instanceof Object)
                    credenciales = getCredenciales();
                switch(guiaRequest.getIdCarrier()){
                    case 3:
                        s=((CredencialesDhl)credenciales).getIdSap();
                        break;
                    case 6:case 2:
                        s=((CredencialesEstafeta)credenciales).getIdSap();
                        break;
                    case 7:
                        s=((CredencialesPaquetexpress)credenciales).getIdSap();
                        break;
                    case 10:
                        s=((CredencialesFedex)credenciales).getIdSap();
                        break;
                    case 11:
                        s="0";
                        break;
                    default:
                        break;
                }
                idSap=Integer.parseInt(s);
            }catch(Exception e){
                if(desarrollo)
                    System.out.println("No se recuperaron credenciales para IdSap de carrier ");
                try{
                    logger.insertaError(
                        1010000
                        , 10
                        , guiaRequest.getIdManh()
                        , null
                        , guiaRequest.getPedido()
                        , guiaRequest.getIdCaja()
                        , guiaRequest.getIdCarrier()
                        , null
                        , guiaRequest.getIdCanal()
                        , guiaRequest.getIdTipoPedido()
                        , "CARRIER NO DEFINIDO"
                        , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                        , null);
                }catch(Exception el){}
                idSap=0;
            }
        }
        return idSap;
    }

    public void setIdSap(Integer idSap) {
        this.idSap = idSap;
    }
}
