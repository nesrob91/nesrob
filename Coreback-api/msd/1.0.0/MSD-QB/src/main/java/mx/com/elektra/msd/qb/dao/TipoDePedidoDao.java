/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.msd.qb.dao;

import java.util.List;
import java.util.Map;
import mx.com.elektra.msd.qb.model.CajaRf;
import mx.com.elektra.msd.qb.model.Contenido;
import mx.com.elektra.msd.qb.model.DetalleSkus;
import mx.com.elektra.msd.qb.model.DimensionesQB;
import mx.com.elektra.msd.qb.model.Paquete;
import mx.com.elektra.msd.qb.model.Pedido;

/**
 *
 * @author dparra
 */
public interface TipoDePedidoDao {
    
    public List<Map<String,Object>> getPaquete(String pedido, int idManh, String esquema, int idCaja, int idTipoPedido, String folio);
    
    public boolean insertaContenidoCajaPorPaquete(Paquete paquete);
    
    public String getPedidoAlterno(Paquete paquete);
    
    public String getCpOrigen(Paquete paquete);
    
    public String getCpDestino(Paquete paquete);
    
    public List<Contenido> getContenido(Paquete paquete);
    
    public List<DetalleSkus> getDetalleSkusRf(Paquete paquete, String esquema, List<String> lpns);
    
    public List<DetalleSkus> getDetalleSkus(Paquete paquete, String esquema);
    
    public CajaRf getCajaRf(int idManh, int idCaja, int idTipoPedido);
    
    public Double getVolumenUtilizadoCaja(Paquete paquete);
    
    public DimensionesQB getDimensionesPaquete(int idManh, String idLpn, String esquema);
    
    public String getFolioControl(Paquete paquete);
}
