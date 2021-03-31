/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Data;

/**
 *
 * @author nroblerol
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "Request", title = "Respuesta de procesamiento general")
public class Response {
    @Schema(hidden = true)
    private Long idPeticion;
    @Schema(description = "Estatus de procesamiento", format = "")
    private Integer estatus;
    @Schema(description = "Mensaje de procesamiento")
    private String mensaje;
    @Schema(description = "Guia generada")
    private String numGuia;
    @Schema(description = "Cadena de documento", format = "base64")
    private String documento;
    @Schema(description = "Carrier de guia")
    private String carrier;
    @Schema(description = "Resultado por folio enviado")
    private FoliosResponse resultado;
    @Schema(hidden = true)
    private Boolean error;
    @Schema(hidden = true)
    private String code;
    
    
}
