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
@Component("cobertura")
public class Cobertura extends ReglaEvaluacion{
    
    @Override
    public ResultadoEvaluacion evaluacion(Paquete paquete, int idCarrier){
        ResultadoEvaluacion resultadoEvaluacion = new ResultadoEvaluacion();
        if(!paquete.getTarifas().containsKey(idCarrier))
            paquete.getTarifas().put(idCarrier,reglasServiceUm.getTarifaInfo(paquete,idCarrier));
        //if(reglasService.isDestinoValidoParaCarrier(paquete, idCarrier)){
        if(paquete.getTarifas().get(idCarrier).getTarifa() >= 0){
            resultadoEvaluacion.setCantidad(1);
            resultadoEvaluacion.setMensaje("CP VÁLIDO");
        }
        else{
            resultadoEvaluacion.setCantidad(0);
            resultadoEvaluacion.setMensaje("CP " + paquete.getCpDestino() + " NO DADO DE ALTA");
            
        }
        resultadoEvaluacion.setNulo(false);
        return resultadoEvaluacion;
    }
}
