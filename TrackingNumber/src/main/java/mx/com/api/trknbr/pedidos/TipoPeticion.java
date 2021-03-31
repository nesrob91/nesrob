/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.pedidos;

import com.elektra.cadsumutils.generales.Generales;
import java.util.HashMap;
import mx.com.api.trknbr.beans.Contacto;
import mx.com.api.trknbr.beans.DetalleSkus;
import mx.com.api.trknbr.beans.GuiaRequest;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
//@Component("peticion")
public interface TipoPeticion {
    
    //AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
    //public GeneralesService generalesService = appContext.getBean(GeneralesService.class);
    public Map<String,Double> trknbrSize = new HashMap<>();
    
    /***
     * Metodo para insertar en control_guias la informacion del pedido
     * @param pedido pedido
     * @param idCaja caja
     * @param idManh origen 
     * @param idVendor 
     * @param idCarrier carrier
     * @param idCanal canal
     * @param idTipoPedido tipo pedido
     * @param usuario usuario
     * @param idLpn carton
     * @param tipDoc tipo de documento (for Lyde request as of oct/2020)
     * @return Objeto GuiaRequest con la informacion para realizar una peticion de Guia a un carrier
     */
    public default GuiaRequest insertControlGuias(String pedido, int idCaja, int idManh, int idVendor, int idCarrier, int idCanal, int idTipoPedido, String usuario, String idLpn, int tipDoc){
        //if(DEBUGGER)
          //  System.out.println("Obteneiendo Dimensiones...");
        GuiaRequest guiaRequest = getDimensiones(pedido, idCaja, idManh, idCarrier, idCanal, idTipoPedido, idLpn);
        
        if(guiaRequest != null){
            //if(DEBUGGER)
              //  System.out.println("Obteneiendo Origen Destino...");
            guiaRequest.setPedido(Generales.getInstance().soToNumber(pedido));
            List<Contacto> contactos = getContactos(pedido, idCaja, idManh, idVendor, idCarrier, idCanal, idTipoPedido, tipDoc);
            
            if(contactos != null){
                
                guiaRequest.setOrigen(contactos.get(0));
                guiaRequest.setDestino(contactos.get(1));
                //if(DEBUGGER)
                  //  System.out.println("Obteneiendo Order_Id...");
                String orderId;
                switch(idTipoPedido){
                    case 6://for Lyde
                        if(tipDoc==1){//if is not a NC
                            orderId = Generales.getInstance().padding(guiaRequest.getVtex(),0,'0',8);
                        }else{
                            orderId = getOrderId(guiaRequest);
                        }
                        break;
                    default :
                        orderId = getOrderId(guiaRequest);
                        break;
                }
                if(orderId != null && !orderId.equals("")){
                    
                    guiaRequest.setOrderId(orderId);
                    guiaRequest.setSkus(getDetalleSkus(guiaRequest));
                    guiaRequest.setPais1("MEXICO");
                    guiaRequest.setPais2("MEX");
                    guiaRequest.setPais3("MX");
                    //if(DEBUGGER)
                      //  System.out.println("Insertando en CTR_Guias...");
                    if(isInsertControlGuias(guiaRequest, usuario)){
                        switch(idTipoPedido){
                            case 5:
                                //if(DEBUGGER)
                                  //  System.out.println("Modificando informacion para impresion de etiqueta...");
                                List<Contacto> contactosWs = getContactosWs(contactos, pedido, idCaja, idManh, idVendor, idCarrier, idCanal, idTipoPedido);
                                if(contactosWs != null && contactosWs.get(0) != null)
                                    guiaRequest.setOrigen(contactosWs.get(0));
                                break;
                            default :
                                break;
                        }
                        guiaRequest.setObservaciones("");
                        //return guiaRequest;
                    }
                    else{
                        //if(DEBUGGER)
                          //  System.out.println("No se inserto en CTR_Guias.");
                        guiaRequest.setObservaciones("GWSP004");
                        //return null;
                    }
                }
                else{
                    //if(DEBUGGER)
                      //  System.out.println("No se obtuvo order id.");
                    guiaRequest.setObservaciones("GWSP003");
                    //return null;
                }
            }
            else{
                //if(DEBUGGER)
                  //  System.out.println("No se obtuvo informacion de contacto.");
                guiaRequest.setObservaciones("GWSP002");
                //return null;
            }
            
        }
        else{
            //if(DEBUGGER)
              //  System.out.println("No se obtuvieron Dimensiones.");
            guiaRequest=new GuiaRequest();
            guiaRequest.setObservaciones("GWSP001");
            //return null;
        }
        return guiaRequest;
        
    }
    /***
     * Metodo para obtener la informacion de contacto del origen-destino del pedido
     * Sobreescrito dependiendo del tipo de pedido EPI|DSV|...
     * @param pedido
     * @param idCaja
     * @param idManh
     * @param cdVendor
     * @param idCarrier
     * @param idCanal
     * @param idTipoPedido
     * @param tipoDoc
     * @return Lista de contactos, primer posicion origen, segunda posicion destino
     */
    public List<Contacto> getContactos(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido, int tipoDoc);
    
    /***
     * Metodo para obtener la informacion de contacto del origen-destino del pedido
     * Sobreescrito dependiendo del tipo de pedido EPI|DSV|...
     * @param od origen|destino a sobreescribir
     * @param pedido
     * @param idCaja
     * @param idManh
     * @param cdVendor
     * @param idCarrier
     * @param idCanal
     * @param idTipoPedido
     * @return Lista de contactos, primer posicion origen, segunda posicion destino
     */
    public List<Contacto> getContactosWs(List<Contacto> od, String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido);
    
    /***
     * Metodo para obtener las dimensiones con las que se creara la guia del pedido
     * Sobreescrito dependiendo del tipo de pedido EPI|DSV|...
     * @param pedido
     * @param idCaja
     * @param idManh
     * @param idCarrier
     * @param idCanal
     * @param idTipoPedido
     * @param idLpn
     * @return 
     */
    public GuiaRequest getDimensiones(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido, String idLpn);
    
    /***
     * Metodo para obtener el orderId(WM, si requiere) del pedido
     * Sobreescrito dependiendo del tipo de pedido EPI|DSV|...
     * @param guiaRequest
     * @return 
     */
    public String getOrderId(GuiaRequest guiaRequest);
    
    /***
     * Metodo para obtener los skus del pedido
     * Sobreescrito dependiendo del tipo de pedido EPI|DSV|...
     * @param guiaRequest
     * @return List de skus
     */
    public List<DetalleSkus> getDetalleSkus(GuiaRequest guiaRequest);
    
    /***
     * Metodo para insertar en control guias
     * @param guiaRequest datos para generar guia
     * @param usuario usuario que realiza la invocacion
     * @return true, if inserted, false otherwise
     */
    public boolean isInsertControlGuias(GuiaRequest guiaRequest, String usuario);
    
    public default boolean verifyContactInformation(List<Contacto> contactos,int idTipPed){
        boolean valid=true;
        ////if(DEBUGGER)
          //  //System.out.println("Validando informacion de Contactos");
        for(Contacto c : contactos){
            try{
                if(c.getContacto().equals("")){
                    valid = false;
                    break;
                }
                if(c.getCp().equals("")){
                    valid = false;
                    break;
                }
                if(c.getRazonSocial().equals("")){
                    valid = false;
                    break;
                }
                if(c.getTelefono().equals("")){
                    valid = false;
                    break;
                }
            }catch(Exception e){
                valid = false;
                break;
            }
        }
        return valid;
    }
}
