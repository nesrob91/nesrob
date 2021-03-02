/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Data;

/**
 *
 * @author darkn
 */
@Data
@Schema(name = "RespuestaRuta")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseRuta {
    @Schema(hidden = true)
    private Long idPeticion;
    @Schema(hidden = true)
    private Integer estatus;
    @Schema(hidden = true)
    private String mensaje;
    @Schema(description = "Folio de Ruta (Creacion)")
    private List<String> ruta;
    @Schema(description = "Cadena de documento", format = "base64")
    private String documento;
    @Schema(description = "Folios enviados para procesamiento")
    private FoliosResponse folios;
    @Schema(hidden = true)
    private Boolean error;
    @Schema(hidden = true)
    private String code;
    @Schema(description = "Folio de envio (EKT only)")
    private Integer folEnvio;
     
}
