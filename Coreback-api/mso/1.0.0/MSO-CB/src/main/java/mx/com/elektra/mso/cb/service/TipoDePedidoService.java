/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.service;

import java.util.List;
import java.util.Map;
import mx.com.elektra.mso.cb.model.Contenido;
import mx.com.elektra.mso.cb.model.DimensionesQB;
import mx.com.elektra.mso.cb.model.Paquete;

/**
 *
 * @author dparra
 */
public interface TipoDePedidoService {
    public Paquete getPaquete(String pedido, int idManh, String esquema, int idCaja, int idTipoPedido, String folio); 
    
    public boolean insertaContenidoCaja(Paquete paquete, int idTipoPeticion, String esquema);
    
    public String getPedidoAlterno(Paquete paquete);
    public String getCpOrigen(Paquete paquete);
    public String getCpDestino(Paquete paquete);
    
    public Paquete setDetalleSkusInfoCd(Paquete paquete);
    
    public List<Contenido> getContenido(Paquete paquete);
    
    public DimensionesQB getDimensionesPaquete(Paquete paquete, String esquema, int tipPed);
    
    public double getPesoPaquete(Paquete paquete);
    
}
