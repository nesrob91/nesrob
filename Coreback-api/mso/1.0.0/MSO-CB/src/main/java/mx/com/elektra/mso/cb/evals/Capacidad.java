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
@Component("capacidad")
public class Capacidad extends ReglaEvaluacion{
    
    @Override
    public ResultadoEvaluacion evaluacion(Paquete paquete, int idCarrier){
        ResultadoEvaluacion resultadoEvaluacion = new ResultadoEvaluacion();
        
        if(reglasServiceUm.isCapacidadValidaPorCarrier(paquete, idCarrier)){
            resultadoEvaluacion.setCantidad(1);
            resultadoEvaluacion.setMensaje("LÍMITE DE GUÍAS NO ALCANZADO POR CARRIER");
        }
        else{
            resultadoEvaluacion.setCantidad(0);
            resultadoEvaluacion.setMensaje("MÁXIMA CAPACIDAD ALCANZADA");
        }
        resultadoEvaluacion.setNulo(false);
        return resultadoEvaluacion;
    }
}
