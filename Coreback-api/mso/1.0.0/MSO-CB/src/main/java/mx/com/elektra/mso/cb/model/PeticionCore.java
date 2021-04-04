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
import lombok.Data;

/**
 *
 * @author nroblerol
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PeticionCore {
    private String pedido;
    private int idCaja;
    private int idManh;
    private int idCanal;
    private int idTipoPedido;
    private int emular;
    private String idLpn;
    private int idTipoPeticion;
}
