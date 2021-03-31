/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao;

import mx.com.api.trknbr.beans.Contacto;
import mx.com.api.trknbr.beans.DOinfo;
import mx.com.api.trknbr.beans.DetalleSkus;
import mx.com.api.trknbr.beans.GuiaRequest;
import mx.com.api.trknbr.beans.GuiaResponse;
import com.elektra.quarterback.beans.CarrierQB;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dparra
 */
public interface PedidoDao {
    
    public List<Map<String,Object>> getPedido(List<String> contenido, int idManh, String idLpn, int tipoPedido);
    
    public GuiaRequest getDimensiones(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido, String idLpn);
    
    public Contacto getOrigenPedido(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido);
    public Contacto getDestinoPedido(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido);
    public Contacto getOrigenPedidoWs(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido);
    
    public List<DetalleSkus> getDetalleSkus(GuiaRequest guiaRequest);
    
    public String getOrderId(GuiaRequest guiaRequest, List<String> nc);
    
    /***
     * Retrieve DOs from given idCaja
     * @param idCaja
     * @param idManh
     * @return List of DOs found
     */
    public List<String> getNCbyAdn(int idCaja, int idManh);
    
}
