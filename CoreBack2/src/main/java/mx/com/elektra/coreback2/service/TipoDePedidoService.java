/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service;

import java.util.List;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.Paquete;

/**
 *
 * @author dparra
 */
public interface TipoDePedidoService {
    public boolean insertaContenidoCaja(Paquete paquete, int idTipoPeticion, String esquema);
    public String getPedidoAlterno(Paquete paquete);
    public String getCpOrigen(Paquete paquete);
    public String getCpDestino(Paquete paquete);
    
    public Paquete setDetalleSkusInfoCd(Paquete paquete);
    
    public List<Contenido> getContenido(Paquete paquete);
    
    public DimensionesQB getDimensionesPaquete(Paquete paquete, String esquema, int tipPed);
    
    public double getPesoPaquete(Paquete paquete);
    
    public String getFolioControl(Paquete paquete);
}
