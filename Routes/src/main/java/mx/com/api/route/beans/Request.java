/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author nroblerol
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "Request", title = "Peticion para generar/modificar/consultar rutas")
public class Request {
    @Schema(hidden = true)
    private Long idPeticion;
    @JsonProperty(required = true)
    @Schema(description = "Centro de distibucion (3-digits)", required = true)
    @NotNull
    private Integer idCentro;
    @JsonProperty(required = true)
    @Schema(description = "Folio de Remision(Creacion)/Ruta(Cancelar,Estatus)", required = true)
    @NotNull
    private List<String> folios;
    @Schema(description = "Id de transporte")
    private Integer idTransporte;
    @Schema(description = "Id de unidad")
    private Integer idUnidad;
    @Schema(description = "Estatus a registrar")
    private String estatus;
    @Schema(description = "Fecha de estatus")
    private String fecha;
    @Schema(description = "Tipo de Ruta (EKT only)")
    private Integer tipoRuta;
    @Schema(description = "Motivo (EKT only)")
    private Integer motivo;
    @Schema(description = "Secuencia (EKT only)")
    private Integer secuencia;
    @Schema(hidden = true)
    private Boolean external;
    @Schema(description = "Estibador (EKT only)")
    private String estibador;
    @Schema(description = "Checador (EKT only)")
    private String checador;
    
}
