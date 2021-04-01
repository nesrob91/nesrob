/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.regla;

import mx.com.elektra.coreback2.beans.ExclusionOInclusion;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.ResultadoEvaluacion;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("exclusion")
public class Exclusiones extends ReglaEvaluacion{
    @Override
    protected ResultadoEvaluacion evaluacion(Paquete paquete, int idCarrier){
        ResultadoEvaluacion resultadoEvaluacion = new ResultadoEvaluacion();
        ExclusionOInclusion exclusion = reglasServiceUm.validaExclusiones(paquete, idCarrier);
        if(exclusion.getTipoExclusion() == 0){
            resultadoEvaluacion.setCantidad(1);
        }
        else if(exclusion.getTipoExclusion() == -1){
            resultadoEvaluacion.setCantidad(0);
        }
        else{
            String mensaje = "";
            switch(exclusion.getTipoExclusion()){
                case 1:
                    mensaje = "EXC: DEPARTAMENTO " + exclusion.getSku().getIdDepartamento() + " " + exclusion.getSku().getDescDepartamento();
                    break;
                case 2:
                    mensaje = "EXC: SUBDEPARTAMENTO " + exclusion.getSku().getIdSubdepartamento() + " " + exclusion.getSku().getDescSubdepartamento();
                    break;
                case 3:
                    mensaje = "EXC: CLASE " + exclusion.getSku().getIdClase() + " " + exclusion.getSku().getDescClase();
                    break;
                case 4:
                    mensaje = "EXC: SUBCLASE "+ exclusion.getSku().getIdSubclase()+ " " + exclusion.getSku().getDescSubclase();
                    break;
                case 5:
                    mensaje = "EXC: SKU "+ exclusion.getSku().getIdSku() + " " + exclusion.getSku().getDescSku(); 
                    break;
                default:
                    mensaje = "Exclusión no identificada";
                    break;
            }
            resultadoEvaluacion.setCantidad(0);
            resultadoEvaluacion.setMensaje(mensaje);
        }
        resultadoEvaluacion.setNulo(false);
        return resultadoEvaluacion;
    }
}
