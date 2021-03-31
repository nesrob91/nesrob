/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.feign.beans;

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
public class Response {
    private Long idPeticion;
    private Integer estatus;
    private String mensaje;
    private String numGuia;
    private String documento;
    private String carrier;
    private FoliosResponse resultado;
    private Boolean error;
    private String code;
    
}
