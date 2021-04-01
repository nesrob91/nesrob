/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.regla;

import mx.com.elektra.coreback2.beans.CarrierQB;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Regla;
import mx.com.elektra.coreback2.beans.ResultadoEvaluacion;
import mx.com.elektra.coreback2.service.AccesoriosService;
import mx.com.elektra.coreback2.service.GeneralesService;
import mx.com.elektra.coreback2.service.ReglasService;
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
