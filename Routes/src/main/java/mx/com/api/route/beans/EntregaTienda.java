/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.beans;

import lombok.Data;

/**
 *
 * @author nroblerol
 */
@Data
public class EntregaTienda {
    private Integer origen;
    private Integer destino;
    private String folrem;
    private Integer idStatus;
    private Integer usuarioModificacion;
    private String fechaEntrega;
    private String personaRecibe;
    private String comentario;
    private String pod;
    private String ref1;
    private String ref2;
    private String ref3;
}
