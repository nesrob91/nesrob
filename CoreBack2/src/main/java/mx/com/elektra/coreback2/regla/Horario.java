/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.regla;

import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.ResultadoEvaluacion;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("horario")
public class Horario extends ReglaEvaluacion{
    @Override
    protected ResultadoEvaluacion evaluacion(Paquete paquete, int idCarrier){
        ResultadoEvaluacion resultadoEvaluacion = new ResultadoEvaluacion();
        int estatusHorario = reglasServiceUm.getEstatusHorario(paquete, idCarrier);
        if(estatusHorario == -1){
            resultadoEvaluacion.setCantidad(0);
            resultadoEvaluacion.setMensaje("SIN HORARIOS REGISTRADOS");
        }
        else if (estatusHorario == 1){
            resultadoEvaluacion.setCantidad(estatusHorario);
            resultadoEvaluacion.setMensaje("HORARIO VÁLIDO");
        }
        else{
            resultadoEvaluacion.setCantidad(estatusHorario);
            resultadoEvaluacion.setMensaje("HORARIO NO VÁLIDO");
        }
        resultadoEvaluacion.setNulo(false);
        return resultadoEvaluacion;
    }
}
