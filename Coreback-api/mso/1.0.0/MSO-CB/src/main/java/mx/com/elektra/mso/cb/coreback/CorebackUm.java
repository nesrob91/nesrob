/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.coreback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mx.com.elektra.mso.cb.common.BrmsCommon;
import mx.com.elektra.mso.cb.common.FolioCommon;
import mx.com.elektra.mso.cb.common.UrlPersistencia;
import mx.com.elektra.mso.cb.evals.Capacidad;
import mx.com.elektra.mso.cb.evals.Cobertura;
import mx.com.elektra.mso.cb.evals.Dimensiones;
import mx.com.elektra.mso.cb.evals.Exclusiones;
import mx.com.elektra.mso.cb.evals.Horario;
import mx.com.elektra.mso.cb.evals.Porcentaje;
import mx.com.elektra.mso.cb.evals.Rating;
import mx.com.elektra.mso.cb.evals.ReglaEvaluacion;
import mx.com.elektra.mso.cb.evals.Seguro;
import mx.com.elektra.mso.cb.evals.Tarifas;
import mx.com.elektra.mso.cb.model.CarrierQB;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.model.PeticionCore;
import mx.com.elektra.mso.cb.model.Regla;
import mx.com.elektra.mso.cb.service.DepuradorService;
import mx.com.elektra.mso.cb.service.EvaluacionService;
import mx.com.elektra.mso.cb.service.GeneralesService;
import mx.com.elektra.mso.cb.service.MarcadorDePedidoService;
import mx.elektra.dependencias.enums.Nivel;
import mx.elektra.dependencias.service.EscribirLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("cbum")
public class CorebackUm {
    @Autowired
    private  GeneralesService generalesServiceUm ;
    @Autowired
    private  EvaluacionService evaluacionServiceUm ;
    @Autowired
    private  MarcadorDePedidoService marcadorDePedidoServiceUm ;
    @Autowired
    private  DepuradorService depuradorServiceUm ;
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
    @Autowired
    private EscribirLog bitacora;
    @Autowired
    FolioCommon folio;
    @Autowired
    private BrmsCommon brms;
    @Autowired
    private UrlPersistencia urlsPersistencia;
    
    /**
     * Método previo para iniciar la evaluacion de carrier mejor calificado para hacer un envío
     * @param peticion Objeto que contiene informacion del pedido a evaluar
     * <br/>- pedido Folio de pedido del cual se requiere realizar la evaluación
     * <br/>- idCaja Id de la caja
     * <br/>- idManh CD Manhattan del pedido
     * <br/>- idCanal Canal correspondiente (1.- ECOMMERCE 2.- RETAIL)
     * <br/>- idTipoPedido Tipo de pedido (1.- ECOMMERCE 2.- TELEFONIA 3.-ENTREGA A DOMICILIO)
     * <br/>- emular Determina si se requiere emular la evaluación o si se requiere realizar el procedimiento completo
     * <br/>- idLpn carton/pedidoVtex
     * <br/>- idTipoPeticion unused (as april 2021)
     * @param folio Folio que identifica todo el procesamiento
     * @return <code>CarrierQB</code> Objeto con el id y la descripción del mejor carrier En
     * caso de error o excepciones retornará idCarrier = 0
     */
    public CarrierQB iniciaEvaluacion(PeticionCore peticion, String folio) {
        
        if(brms.isWriteConsole())
            bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "QB Inicia CoreBack");
        
        paquete.setPedido(peticion.getPedido());
        paquete.setIdCaja(0);
        paquete.setIdManh(peticion.getIdManh());
        paquete.setIdCanal(0);
        paquete.setIdTipoPedido(0);
        paquete.setIdLpn("");
        paquete.setError("");
        paquete.setTarifas(new HashMap<>());

        if (depuradorServiceUm.limpiaTablas(paquete)) {
            if(brms.isWriteConsole())
                bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "QB Obteniendo paquete");
            paquete = generalesServiceUm.getPaquete(paquete, peticion.getIdTipoPeticion(), folio);
            if(brms.isWriteConsole())
                bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "QB Paquete finalizado");
            
            if (paquete.getError().equals("")) {
                CarrierQB carrier = ejecutaEvaluacion(paquete);
                if(brms.isWriteConsole())
                    bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "QB Termina Eval");
                if (carrier.getIdCarrier()!=0) {
                    //Tarifas reglaTarifa = new Tarifas();
                    //double tarifa = reglaTarifa.obtieneTarifaMejorCarrier(paquete, carrier.getIdCarrier());
                    generalesServiceUm.actualizaCbHdr(paquete, carrier, "Core.iniciaEvaluacion()", 0);
                    if (peticion.getEmular() == 0) {
                        if(brms.isWriteConsole())
                            bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "QB Entrega actualizando");
                        marcadorDePedidoServiceUm.actualizaPedidoCarrier(paquete, carrier, "");
                        if(brms.isWriteConsole())
                            bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "QB Entrega actualizada");
                    }
                    if(brms.isWriteConsole())
                        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "QB Termina CoreBack");
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
        if(brms.isWriteConsole())
            bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "QB Termina CoreBack en error ".concat(msj));
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
        if(brms.isWriteConsole())
            bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "QB Inicia Eval CoreBack");
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
                if (!evaluacionServiceUm.actualizaCarriersEvaluados(paquete, regla, carriers)) {
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
            return carriers.get(0);
        } else {
            crrError.setDesdCarrier("CBEC000");
            return crrError;
        }

    }
    
}
