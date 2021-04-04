/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.evals;

import mx.com.elektra.mso.cb.model.CarrierQB;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.model.Regla;
import mx.com.elektra.mso.cb.model.ResultadoEvaluacion;
import mx.com.elektra.mso.cb.service.AccesoriosService;
import mx.com.elektra.mso.cb.service.GeneralesService;
import mx.com.elektra.mso.cb.service.ReglasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("regla")
public class ReglaEvaluacion {
    @Autowired
    protected GeneralesService generalesServiceUm ;
    @Autowired
    protected ReglasService reglasServiceUm ;
    @Autowired
    protected AccesoriosService accesorioServiceUm ;
    
    protected ResultadoEvaluacion evaluacion(Paquete paquete, int idCarrier){
        return null;
    }
    public boolean ejecutaEvaluacion(Paquete paquete, Regla regla, CarrierQB carrier){
        
        if(generalesServiceUm.insertaCbDtl(paquete, carrier, regla, "ReglaEvaluacion.ejecutaEvaluacion()")){
            ResultadoEvaluacion resultadoEvaluacion = evaluacion(paquete, carrier.getIdCarrier());
            resultadoEvaluacion.setProcesado(true);
            resultadoEvaluacion.setValido(false);
            return generalesServiceUm.actualizaCbDtl(paquete, regla, carrier, resultadoEvaluacion);
        }
        else{
            return false;
        }
        
    }
    
}
