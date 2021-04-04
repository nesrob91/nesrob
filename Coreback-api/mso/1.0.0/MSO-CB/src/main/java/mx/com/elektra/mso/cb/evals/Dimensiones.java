/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.evals;

import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.model.ResultadoEvaluacion;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("dimension")
public class Dimensiones extends ReglaEvaluacion{
    
    @Override
    protected ResultadoEvaluacion evaluacion(Paquete paquete, int idCarrier){
        ResultadoEvaluacion resultadoEvaluacion = new ResultadoEvaluacion();
        if(!paquete.getTarifas().containsKey(idCarrier))
            paquete.getTarifas().put(idCarrier,reglasServiceUm.getTarifaInfo(paquete,idCarrier));
        //if(reglasService.isPesoFisicoSoportadoPorCarrier(paquete, idCarrier)){
        if(paquete.getTarifas().get(idCarrier).getTarifaFinal()>0){
            resultadoEvaluacion.setCantidad(1);
            resultadoEvaluacion.setMensaje("DIMENSIONES SOPORTADAS POR EL CARRIER");
        }
        else{
            resultadoEvaluacion.setCantidad(0);
            resultadoEvaluacion.setMensaje("DIMENSIONES NO SOPORTADAS POR EL CARRIER");
        }
        resultadoEvaluacion.setNulo(false);
        return resultadoEvaluacion;
    }
    
}
