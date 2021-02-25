/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.beans;

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
    private List<String> ruta;
    private String numGuia;
    private String documento;
    private String carrier;
    private List<FolioResponse> folios;
    private Boolean error;
    private String code;
    private Integer folEnvio;
    
    public Response() {
    }
    
}
