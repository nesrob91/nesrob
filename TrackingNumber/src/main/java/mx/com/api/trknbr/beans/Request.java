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
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author nroblerol
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(name = "Request", title = "Peticion para generar/modificar/consultar guias")
public class Request {
    @Schema(hidden = true)
    private Long idPeticion;
    @NotNull
    @Schema(description = "Centro de distibucion (3-digits)", required = true)
    private Integer idCentro;
    @Schema(description = "Proveedor (EKT only)")
    private Integer idVendor;
    @Schema(description = "Usuario peticion (EKT only)")
    private Integer idUsuario;
    @NotNull
    @Schema(description = "Contenido de guia (ADN|REMISION|NC)", required = true)
    private List<String> contenido;
    @Schema(hidden = true)
    private String pedVtex;
    @NotNull
    @Schema(description = "Tipo de Pedido (DSV|MKP|3PL|...)", required = true)
    private Integer tipoPedido;
    @Schema(description = "Tipo de Documento (3PL only NC|REMISION)")
    private Integer tipoDocumento;
    @Schema(hidden = true)
    private Integer idCaja;
    @Schema(description = "Contenedor a usar (EKT only)")
    private Integer idContenedor;
    @Schema(description = "Medida del paquete: largo")
    private Double largo;
    @Schema(description = "Medida del paquete: alto")
    private Double alto;
    @Schema(description = "Medida del paquete: ancho")
    private Double ancho;
    @Schema(description = "Medida del paquete: peso (fisico)")
    private Double peso;
    @Schema(hidden = true)
    private Integer idEstacion;
    @Schema(description = "Guia a registrar (EKT only)")
    private String numGuia;
    @Schema(description = "Carrier de la guia a registrar (EKT only)")
    private String carrier;
    @Schema(description = "Estatus de guia a registrar (EKT only)")
    private Integer estatus;
    @Schema(description = "Fecha de registro (EKT only)")
    private String fecha;
    
}
