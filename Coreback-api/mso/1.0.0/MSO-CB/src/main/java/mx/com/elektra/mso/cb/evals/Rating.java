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
@Component("rating")
public class Rating extends ReglaEvaluacion{
    @Override
    public ResultadoEvaluacion evaluacion(Paquete paquete, int idCarrier){
        ResultadoEvaluacion resultadoEvaluacion = new ResultadoEvaluacion();
        int rating = reglasServiceUm.getRatingCarrier(paquete, idCarrier);
        if(rating == -1){
            resultadoEvaluacion.setMensaje("SIN RATING DEFINIDO");
            resultadoEvaluacion.setCantidad(0);
            resultadoEvaluacion.setNulo(true);
        }
        else{
            resultadoEvaluacion.setNulo(false);
            resultadoEvaluacion.setCantidad(rating);
            resultadoEvaluacion.setMensaje("RANKING: " + rating);
        }
        resultadoEvaluacion.setNulo(false);
        return resultadoEvaluacion;
    }
}
