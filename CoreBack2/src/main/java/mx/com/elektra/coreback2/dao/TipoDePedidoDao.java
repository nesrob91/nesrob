/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.dao;

import java.util.List;
import mx.com.elektra.coreback2.beans.CajaRf;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DetalleSkus;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.Paquete;

/**
 *
 * @author dparra
 */
public interface TipoDePedidoDao {
    
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
