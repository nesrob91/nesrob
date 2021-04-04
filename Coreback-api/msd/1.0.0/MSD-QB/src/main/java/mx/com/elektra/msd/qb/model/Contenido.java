/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.msd.qb.model;

import lombok.Data;

/**
 *
 * @author dparra
 */
@Data
public class Contenido {
    
    private int cantidad;
    private String sku;
    private String idLpn;
    private String orderId;
    private String adn;
    private String so;
    private String nc;
    private String idManh;
    
}
