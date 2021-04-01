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
@Component("seguro")
public class Seguro extends ReglaEvaluacion{
    @Override
    protected ResultadoEvaluacion evaluacion(Paquete paquete, int idCarrier){
        ResultadoEvaluacion resultadoEvaluacion = new ResultadoEvaluacion();
        
        return resultadoEvaluacion;
    }
}
