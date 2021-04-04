/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.service.impl;

import mx.com.elektra.mso.cb.model.CarrierQB;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.service.MarcadorDePedidoService;
import org.springframework.stereotype.Service;

/**
 *
 * @author dparra
 */
@Service("marcadorDePedidoServiceUm")
public class MarcadorDePedidoServiceUmImpl implements MarcadorDePedidoService{
    
    @Override
    public boolean actualizaPedidoCarrier(Paquete paquete, CarrierQB carrier, String esquema){
        //return marcadorPedidoDaoUm.actualizaPedCentPedidoEcom(paquete, carrier.getIdCarrier()+"", null);
        return true;
    }
    
}
