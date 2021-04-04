/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.model;

import java.util.List;
import lombok.Data;

/**
 *
 * @author dparra
 */
@Data
public class Pedido {
    
    private String pedido; 
    private int idCaja; 
    private int idManh; 
    private int idCanal; 
    private int idTipoPedido;
    private String orderType;
    private String idLpn;
    private List<String> lpns;
    
}
