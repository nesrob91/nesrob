/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.service;

import mx.com.elektra.mso.cb.model.CarrierQB;
import mx.com.elektra.mso.cb.model.Paquete;

/**
 *
 * @author dparra
 */
public interface MarcadorDePedidoService {
    
    public boolean actualizaPedidoCarrier(Paquete paquete, CarrierQB carrier, String esquema);
    
}
