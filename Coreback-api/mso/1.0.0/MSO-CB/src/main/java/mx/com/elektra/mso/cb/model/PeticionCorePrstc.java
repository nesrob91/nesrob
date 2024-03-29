/*
 * To change this license header;
choose License Headers in Project Properties.
 * To change this template file;
choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Data;

/**
 *
 * @author nroblerol
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PeticionCorePrstc {
    private Paquete paquete;
    private CarrierQB carrier;
    private Regla regla;
    private ResultadoEvaluacion resultadoEvaluacion;
    private String usuario;
    private double tarifa;
    private List<Integer> carriers;
    private int valid;
}
