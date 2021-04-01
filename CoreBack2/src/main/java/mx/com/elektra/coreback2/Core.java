/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mx.com.elektra.coreback2.beans.CarrierQB;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Pedido;
import mx.com.elektra.coreback2.beans.Regla;
import mx.com.elektra.coreback2.config.application;
import mx.com.elektra.coreback2.regla.Capacidad;
import mx.com.elektra.coreback2.regla.Cobertura;
import mx.com.elektra.coreback2.regla.Dimensiones;
import mx.com.elektra.coreback2.regla.Exclusiones;
import mx.com.elektra.coreback2.regla.Horario;
import mx.com.elektra.coreback2.regla.Porcentaje;
import mx.com.elektra.coreback2.regla.Rating;
import mx.com.elektra.coreback2.regla.ReglaEvaluacion;
import mx.com.elektra.coreback2.regla.Seguro;
import mx.com.elektra.coreback2.regla.Tarifas;
import mx.com.elektra.coreback2.service.DepuradorService;
import mx.com.elektra.coreback2.service.EvaluacionService;
import mx.com.elektra.coreback2.service.GeneralesService;
import mx.com.elektra.coreback2.service.MarcadorDePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("coreback")
public class Core {

    @Autowired
    private  GeneralesService generalesServiceUm ;
    @Autowired
    private  EvaluacionService evaluacionServiceUm ;
    @Autowired
    private  MarcadorDePedidoService marcadorDePedidoServiceUm ;
    @Autowired
    private  DepuradorService depuradorServiceUm ;
    @Autowired
    private application app;
    @Autowired
    private LogsPaqueterias log;
    @Autowired
    private Paquete paquete;
    @Autowired
    private Cobertura cobertura;
    @Autowired
    private Tarifas tarifa;
    @Autowired
    private Dimensiones dimension;
    @Autowired
    private Horario horario;
    @Autowired
    private Rating rating;
    @Autowired
    private Exclusiones exclusion;
    @Autowired
    private Porcentaje asignacion;
    @Autowired
    private Capacidad capacidad;
    @Autowired
    private Seguro seguro;
    
    private String esquema = "";
    
    
    
    /**
     * Método previo para iniciar la evaluacion de carrier mejor calificado para hacer un envío
     *
     * @param pedido Folio de pedido del cual se requiere realizar la evaluación
     * @param idCaja Id de la caja
     * @param idManh CD Manhattan del pedido
     * @param idCanal Canal correspondiente (1.- ECOMMERCE 2.- RETAIL)
     * @param idTipoPedido Tipo de pedido (1.- ECOMMERCE 2.- TELEFONIA 3.-
     * ENTREGA A DOMICILIO)
     * @param emular Determina si se requiere emular la evaluación o si se
     * requiere realizar el procedimiento completo
     * @param idLpn 
     * @param idTipoPeticion
     * @return CarrierQB Objeto con el id y la descripción del mejor carrier En
     * caso de error o excepciones retornará idCarrier = 0
     */
    public CarrierQB iniciaEvaluacion(String pedido, int idCaja, int idManh, int idCanal, int idTipoPedido, int emular, String idLpn, int idTipoPeticion) {
        try{
            if(app.isWriteBD()){
                //log = new LogThread(5,idManh, pedido, idCaja, idCanal, idTipoPedido, 
                  //  "QB Inicia CoreBack", getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName());
                //log.run();
                log.insertaError(100000, 5, idManh, 0, pedido, idCaja, 0, "", idCanal, idTipoPedido, 
                        "QB Inicia CoreBack", getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(),"","","","");
            }
        }catch(Exception e){System.out.println("Error "+e.toString());}
        if(app.isWriteConsole())
            System.out.println("Iniciando evaluacion");
        switch(idTipoPeticion){
            case 4: case 5: case 6:
                esquema="";
                break;
            default:
                esquema = generalesServiceUm.getEsquema(idManh);
                break;
        }
        paquete.setPedido(pedido);
        paquete.setIdCaja(idCaja);
        paquete.setIdManh(idManh);
        paquete.setIdCanal(idCanal);
        paquete.setIdTipoPedido(idTipoPedido);
        paquete.setIdLpn(idLpn);
        paquete.setError("");
        paquete.setTarifas(new HashMap<>());

        if(idTipoPedido == 4 || idTipoPedido == 5 || idTipoPedido == 6){
            paquete.setPedidoAlterno(idLpn);
        }
        if (depuradorServiceUm.limpiaTablas(paquete)) {
            try{
                if(app.isWriteBD()){
                    //log.setMsg("QB Obteniendo Paquete"); 
                    //log.run();
                    log.insertaError(100000, 5, idManh, 0, pedido, idCaja, 0, "", idCanal, idTipoPedido, 
                        "QB Obteniendo Paquete", getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(),"","","","");
                }
            }catch(Exception e){}
            paquete = generalesServiceUm.getPaquete(paquete, idTipoPeticion, esquema);
            try{
                if(app.isWriteBD()){
                    //log.setMsg("QB Paquete Completo"); 
                    //log.run();
                    log.insertaError(100000, 5, idManh, 0, pedido, idCaja, 0, "", idCanal, idTipoPedido, 
                        "QB Paquete Completo", getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(),"","","","");
                }
            }catch(Exception e){}
            if (paquete.getError().equals("")) {
                CarrierQB carrier = ejecutaEvaluacion(paquete);
                if(app.isWriteBD()){
                    //log.setMethod(getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName());
                    try{
                        log.insertaError(100000, 5, paquete.getIdManh(), 0, paquete.getPedido(), paquete.getIdCaja(), 0, "", paquete.getIdCanal(), paquete.getIdTipoPedido(), 
                            "QB Termina Eval "+carrier.getDesdCarrier(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(),"","","","");
                    }catch(Exception e){}
                }
                if (carrier.getIdCarrier()!=0) {
                    //Tarifas reglaTarifa = new Tarifas();
                    //double tarifa = reglaTarifa.obtieneTarifaMejorCarrier(paquete, carrier.getIdCarrier());
                    generalesServiceUm.actualizaCbHdr(paquete, carrier, "Core.iniciaEvaluacion()", 0);
                    if (emular == 0) {
                        try{
                            if(app.isWriteBD()){
                                //log.setMsg("QB Actualizando Pedido PC");
                                //log.run();
                                log.insertaError(100000, 5, paquete.getIdManh(), 0, paquete.getPedido(), paquete.getIdCaja(), 0, "", paquete.getIdCanal(), paquete.getIdTipoPedido(), 
                                    "QB Actualizando Pedido PC", getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(),"","","","");
                            }
                        }catch(Exception e){}
                        marcadorDePedidoServiceUm.actualizaPedidoCarrier(paquete, carrier, esquema);
                        try{
                            if(app.isWriteBD()){
                                //log.setMsg("QB Actualizado Pedido PC");
                                //log.run();
                                log.insertaError(100000, 5, paquete.getIdManh(), 0, paquete.getPedido(), paquete.getIdCaja(), 0, "", paquete.getIdCanal(), paquete.getIdTipoPedido(), 
                                    "QB Actualizado Pedido PC", getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(),"","","","");
                            }
                        }catch(Exception e){}
                    }
                    try{
                        if(app.isWriteBD()){
                            //log.setMsg("QB Termina CoreBack");
                            //log.run();
                            log.insertaError(100000, 5, paquete.getIdManh(), 0, paquete.getPedido(), paquete.getIdCaja(), 0, "", paquete.getIdCanal(), paquete.getIdTipoPedido(), 
                                "QB Termina CoreBack", getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(),"","","","");
                        }
                    }catch(Exception e){}
                    return carrier;
                } else {
                    return getCarrierError(carrier.getDesdCarrier());
                }
            } else {
                return getCarrierError(paquete.getError());
            }

        } else {
            return getCarrierError("CBD0001");
        }
    }

    private CarrierQB getCarrierError(String msj) {
        try{
            if(app.isWriteBD()){
                //log.setMsg("QB Termina CoreBack en error "+msj);
                //log.run();
            }
        }catch(Exception e){}
        CarrierQB carrier = new CarrierQB();
        carrier.setIdCarrier(0);
        carrier.setDesdCarrier(msj);
        return carrier;
    }

    private ReglaEvaluacion getReglaById(int idRegla) {

        switch (idRegla) {
            case 1:
                return cobertura;
            case 2:
                return tarifa;
            case 3:
                return dimension;
            case 4:
                return horario;
            case 5:
                return rating;
            case 6:
                return exclusion;
            case 7:
                return asignacion;
            case 8:
                return capacidad;
            case 9:
                return seguro;
            default:
                return null;
        }
    }

    private CarrierQB ejecutaEvaluacion(Paquete paquete) {
        try{
            if(app.isWriteBD()){
                //log.setMsg("QB Inicia Eval CoreBack");
                //log.setMethod(getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName());
                //log.run();
                log.insertaError(100000, 5, paquete.getIdManh(), 0, paquete.getPedido(), paquete.getIdCaja(), 0, "", paquete.getIdCanal(), paquete.getIdTipoPedido(), 
                    "QB Inicia Eval CoreBack", getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(),"","","","");
            }
        }catch(Exception e){}
        List<Regla> reglas = new ArrayList<>();
        ReglaEvaluacion reglaEvaluacion = new ReglaEvaluacion();
        reglas = generalesServiceUm.getReglas(paquete.getIdCanal(),paquete.getIdTipoPedido());
        int iteracion = 0;
        int idRegla = 0;
        List<CarrierQB> carriers = new ArrayList<>();
        CarrierQB crrError = new CarrierQB();
        crrError.setIdCarrier(0);

        for (Regla regla : reglas) {

            reglaEvaluacion = getReglaById(regla.getIdRegla());
            if (reglaEvaluacion != null) {

                carriers = generalesServiceUm.getCarriersActivos(paquete, carriers, iteracion, idRegla);

                if (carriers.size() == 1) {
                    return carriers.get(0);
                }

                for (CarrierQB carrier : carriers) {
                    if (!reglaEvaluacion.ejecutaEvaluacion(paquete, regla, carrier)) {
                        crrError.setDesdCarrier("CBER00"+regla.getIdRegla());
                        return crrError;
                    }

                }
                if (!evaluacionServiceUm.actualizaCarriersEvaluados(paquete, regla)) {
                    crrError.setDesdCarrier("CBEA001");
                    return crrError;
                }
                idRegla = regla.getIdRegla();

            }//if no java implementation for this rule then skip and continue
            /* else {
                crrError.setDesdCarrier("CBER000");
                return crrError;
            }*/

            iteracion++;
        }
        carriers = generalesServiceUm.getCarriersActivos(paquete, carriers, iteracion, idRegla);
        if (!carriers.isEmpty()) {
            try{
                if(app.isWriteBD()){
                    //log.setMsg("QB Termina Eval "+carriers.get(0).getCodCarrier());
                    //log.run();
                }
            }catch(Exception e){}
            return carriers.get(0);
        } else {
            crrError.setDesdCarrier("CBEC000");
            return crrError;
        }

    }
    
    
    /***
     * Metodo de entrada para pedido MKP para obtener el mejor carrier
     * @param idUsuario Usuario que genera peticion
     * @param idCaja Contenedor (si existe)
     * @param idVendor Proveedor
     * @param cdVendor centro de distribucion del Proveedor(si se utilizara)
     * @param pedVtex vtex
     * @param adn Pedidos ADN
     * @param lenght largo
     * @param width ancho
     * @param height alto
     * @param weight peso
     * @param genG punto de entrada desde genG
     * @param idTipPed tipo de pedido para el que se obtiene Carrier (4-MKP,5-DSV)
     * @return Objeto CarrierQB con id, nombre y codigo de carrier obtenido
     */
    public CarrierQB coreMKPDSV(int idUsuario, int idCaja, int idVendor, int cdVendor, String pedVtex, List<String> adn, double lenght, double width, double height, double weight, boolean genG, int idTipPed){
        //String pedido; String idCaja; int idManh; int idCanal; int idTipoPedido;
        Pedido pedido;
        if(app.isWriteConsole())
            System.out.println("Seleccionando Carrier");
        if(genG){
            pedido = new Pedido();
            pedido.setIdCanal(1);
            pedido.setIdLpn(pedVtex);
            pedido.setIdManh(idVendor);
            pedido.setIdTipoPedido(idTipPed);
            pedido.setLpns(adn);
            pedido.setOrderType("00");
            pedido.setIdCaja(idCaja);
            //check prefix and suffix        
            pedido.setPedido((pedVtex.startsWith("v")) ? pedVtex.substring(1, pedVtex.length()-6) : pedVtex);
        }else{
            pedido = generalesServiceUm.getPedidoMKP(adn, idVendor, idTipPed);
            if(pedido == null){
                CarrierQB error=new CarrierQB();
                error.setIdCarrier(0);
                error.setCodCarrier("");
                return error;
            }
            //check prefix and suffix        
            pedido.setPedido((pedido.getPedido().startsWith("v")) ? pedido.getPedido().substring(1, pedido.getPedido().length()-6) : pedido.getPedido());
            idCaja=generalesServiceUm.createContainer(lenght,width,height,weight,idVendor,idTipPed,idUsuario);
            //check adn insert instead of lpn
            pedido.setIdCaja(generalesServiceUm.getIdCaja(idUsuario, pedido.getPedido(), adn, pedido.getIdManh(), pedido.getIdCanal(), pedido.getIdTipoPedido(), idCaja, weight));
        }
        
        return iniciaEvaluacion(pedido.getPedido(), pedido.getIdCaja(), pedido.getIdManh(), pedido.getIdCanal(), pedido.getIdTipoPedido(), 0, pedido.getIdLpn(), pedido.getIdTipoPedido());
                
    }
    /***
     * Metodo de entrada para pedido MKP para obtener el mejor carrier
     * @param idUsuario Usuario que genera peticion
     * @param idCaja Contenedor (si existe)
     * @param idVendor Proveedor
     * @param cdVendor centro de distribucion del Proveedor(si se utilizara)
     * @param pedVtex vtex
     * @param adn Pedidos ADN
     * @param lenght largo
     * @param width ancho
     * @param height alto
     * @param weight peso
     * @param genG punto de entrada desde genG
     * @param idTipPed tipo de pedido para el que se obtiene Carrier (4-MKP,5-DSV)
     * @return Objeto CarrierQB con id, nombre y codigo de carrier obtenido
     */
    public CarrierQB coreLyde(int idUsuario, int idCaja, int idVendor, int cdVendor, String pedVtex, List<String> adn, double lenght, double width, double height, double weight, boolean genG, int idTipPed){
        //String pedido; String idCaja; int idManh; int idCanal; int idTipoPedido;
        Pedido pedido;
        if(app.isWriteConsole())
            System.out.println("Seleccionando Carrier");
        
        pedido = new Pedido();
        pedido.setIdCanal(1);
        pedido.setIdLpn(pedVtex);
        pedido.setIdManh(cdVendor);
        pedido.setIdTipoPedido(idTipPed);
        pedido.setLpns(adn);
        pedido.setOrderType("00");
        pedido.setIdCaja(idCaja);
        //check prefix and suffix        
        pedido.setPedido((pedVtex.startsWith("v")) ? pedVtex.substring(1, pedVtex.length()-6) : pedVtex);
        
        
        return iniciaEvaluacion(pedido.getPedido(), pedido.getIdCaja(), pedido.getIdManh(), pedido.getIdCanal(), pedido.getIdTipoPedido(), 0, pedido.getIdLpn(), pedido.getIdTipoPedido());
                
    }
    
    /***
     * Metodo de entrada para pedido MKP para obtener el mejor carrier
     * @param idUsuario Usuario que genera peticion
     * @param idCaja Contenedor (si existe)
     * @param idVendor Proveedor
     * @param pedVtex vtex
     * @param adn Pedidos ADN
     * @param lenght largo
     * @param width ancho
     * @param height alto
     * @param weight peso
     * @param genG punto de entrada desde genG
     * @return Objeto CarrierQB con id, nombre y codigo de carrier obtenido
     */
    public CarrierQB coreDSV(int idUsuario, int idCaja, int idVendor, String pedVtex, List<String> adn, double lenght, double width, double height, double weight, boolean genG){
        //String pedido; String idCaja; int idManh; int idCanal; int idTipoPedido;
        Pedido pedido;
        
        if(genG){
            pedido = new Pedido();
            pedido.setIdCanal(1);
            pedido.setIdLpn("");
            pedido.setIdManh(idVendor);
            pedido.setIdTipoPedido(5);
            pedido.setLpns(adn);
            pedido.setOrderType("00");
            pedido.setIdCaja(idCaja);
            //check prefix and suffix        
            pedido.setPedido((pedVtex.startsWith("v")) ? pedVtex.substring(1, pedVtex.length()-6) : pedVtex);
        }else{
            pedido = generalesServiceUm.getPedidoDSV(adn, idVendor, 5);
            if(pedido == null){
                CarrierQB error=new CarrierQB();
                error.setIdCarrier(0);
                error.setCodCarrier("");
                return error;
            }
            //check prefix and suffix        
            pedido.setPedido((pedido.getPedido().startsWith("v")) ? pedido.getPedido().substring(1, pedido.getPedido().length()-6) : pedido.getPedido());
            idCaja=generalesServiceUm.createContainer(lenght,width,height,weight,idVendor,5,idUsuario);
            //check adn insert instead of lpn
            pedido.setIdCaja(generalesServiceUm.getIdCaja(idUsuario, pedido.getPedido(), adn, pedido.getIdManh(), pedido.getIdCanal(), pedido.getIdTipoPedido(), idCaja, weight));
        }
        
        return iniciaEvaluacion(pedido.getPedido(), pedido.getIdCaja(), pedido.getIdManh(), pedido.getIdCanal(), pedido.getIdTipoPedido(), 0, pedido.getIdLpn(), 4);
        
        
    }
}
