/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.regla;

import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.ResultadoEvaluacion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
