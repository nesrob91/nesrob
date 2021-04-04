/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.evals;

import java.util.HashMap;
import java.util.Map;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.model.ResultadoEvaluacion;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("asignacion")
public class Porcentaje extends ReglaEvaluacion{
    @Override
    protected ResultadoEvaluacion evaluacion(Paquete paquete, int idCarrier){
        ResultadoEvaluacion resultadoEvaluacion = new ResultadoEvaluacion();
        Map<Boolean, Integer> map = new HashMap<>();
        map = reglasServiceUm.getCalculoPorcentajePorCarrier(paquete, idCarrier);
        String mensaje ="";
        
        for(Map.Entry<Boolean, Integer> entry: map.entrySet()){
            if(!entry.getKey()){
                mensaje = "SIN % DE ASIGNACIÓN REGISTRADO";
            }
            else{
                mensaje = null;
            }
            resultadoEvaluacion.setCantidad(entry.getValue());
            resultadoEvaluacion.setMensaje(mensaje);
        }
        resultadoEvaluacion.setNulo(false);
            
        return resultadoEvaluacion;
    }
}
