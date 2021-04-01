/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.dao;

import java.util.List;
import mx.com.elektra.coreback2.beans.Paquete;

/**
 *
 * @author dparra
 */
public interface MarcadorDePedidoDao {
    
    public boolean actualizaNcPedidoEcom(Paquete paquete, String codigoCarrier, List<String> adns);
    
    public boolean actualizaPedCentPedidoEcom(Paquete paquete, String codigoCarrier, List<String> adns);
    
    public List<String> getAdnPedidoEcom2018(Paquete paquete, String esquema);
    
    public List<String> getLpnsByIdCaja(Paquete paquete);
    
}
