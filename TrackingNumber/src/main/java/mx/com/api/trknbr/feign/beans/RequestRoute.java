/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.feign.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

/**
 *
 * @author nroblerol
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestRoute {
    private Long idPeticion;
    @JsonProperty(required = true)
    private Integer idCentro;
    @JsonProperty(required = true)
    private List<String> folios;
    private Integer idTransporte;
    private Integer idUnidad;
    private String estatus;
    private String fecha;
    private Integer tipoRuta;
    private Integer motivo;
    private Integer secuencia;
    private Boolean external;
    private String estibador;
    private String checador;
    
    
}
