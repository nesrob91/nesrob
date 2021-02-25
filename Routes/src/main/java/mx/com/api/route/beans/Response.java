/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.beans;

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
@Schema(name = "Response", title = "Respuesta general de API")
public class Response {
    @Schema(description = "0 Procesado, 1 No procesado")
    private String codigo;
    @Schema(description = "Mensaje de respuesta")
    private String mensaje;
    @Schema(description = "Folio de peticion")
    private String folio;
    @Schema(description = "Resultado de Operacion")
    private ResponseRuta resultado;
    
    public Response() {
    }
    
}
