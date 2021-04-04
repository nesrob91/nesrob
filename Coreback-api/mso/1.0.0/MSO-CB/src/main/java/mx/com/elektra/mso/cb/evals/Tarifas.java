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
@Component("tarifa")
public class Tarifas extends ReglaEvaluacion{
    
    @Override
    protected ResultadoEvaluacion evaluacion(Paquete paquete, int idCarrier){
        ResultadoEvaluacion resultadoEvaluacion = new ResultadoEvaluacion();
        double montoAccesorios = 0;
        if(!paquete.getTarifas().containsKey(idCarrier))
            paquete.getTarifas().put(idCarrier,reglasServiceUm.getTarifaInfo(paquete,idCarrier));
        //resultadoEvaluacion.setTarifaBase(reglasService.getTarifaEnvio(paquete, idCarrier).getTarifa());
        resultadoEvaluacion.setTarifaBase(paquete.getTarifas().get(idCarrier).getTarifaFinal() > paquete.getTarifas().get(idCarrier).getTarifa() ? paquete.getTarifas().get(idCarrier).getTarifaFinal() : paquete.getTarifas().get(idCarrier).getTarifa());
        if(resultadoEvaluacion.getTarifaBase()==-1){
            resultadoEvaluacion.setMensaje("SIN TARIFA DADA DE ALTA");
            resultadoEvaluacion.setNulo(true);
        }
        else{
            
            //if(accesorioService.getCalculoAccesorios(paquete, idCarrier) > 0){
                //montoAccesorios = accesorioService.getMontoTotalAccesorios(paquete, idCarrier);
            //}
            if(resultadoEvaluacion.getTarifaBase()>0){
                //montoAccesorios = accesorioServiceUm.getCalculoAccesorios(paquete, idCarrier);
                resultadoEvaluacion.setTarifaFinal(resultadoEvaluacion.getTarifaBase() + montoAccesorios);
                resultadoEvaluacion.setMensaje("$ " + resultadoEvaluacion.getTarifaFinal());
                resultadoEvaluacion.setCantidad(resultadoEvaluacion.getTarifaFinal());
                resultadoEvaluacion.setNulo(false);
            }else{
                resultadoEvaluacion.setMensaje("SIN TARIFA DADA DE ALTA");
                resultadoEvaluacion.setNulo(true);
            }
        }
        
        return resultadoEvaluacion;
    }
    
    public double obtieneTarifaMejorCarrier(Paquete paquete, int idCarrier){
        double tarifa = reglasServiceUm.getTarifaMejorCarrier(paquete, idCarrier);
        if(tarifa == -1){
            
            tarifa = reglasServiceUm.getTarifaEnvio(paquete, idCarrier).getTarifa();
            if(tarifa == -1){
                tarifa = 0;
            }
            else{
                if(accesorioServiceUm.getCalculoAccesorios(paquete, idCarrier) > 0){
                    tarifa += accesorioServiceUm.getMontoTotalAccesorios(paquete, idCarrier);
                }
                
            }
        }
        return tarifa;
    }
}
