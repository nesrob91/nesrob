/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.pedidos;

import java.util.List;
import mx.com.elektra.mso.cb.model.Contenido;
import mx.com.elektra.mso.cb.model.DimensionesQB;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.service.TipoDePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("pedidoEcom")
public class PedidoEcom extends TipoDePedido{
    @Autowired
    private TipoDePedidoService pedidoEcomService;

    public PedidoEcom(Paquete paquete) {
        super(paquete);
    }
    
    @Override
    public String getPedidoAlterno(){
        return pedidoEcomService.getPedidoAlterno(paquete);
    }
    @Override
    public String getCpOrigen(){
        return pedidoEcomService.getCpOrigen(paquete);
    }
    @Override
    public String getCpDestino(){
        return pedidoEcomService.getCpDestino(paquete);
    }
    @Override
    public boolean insertaContenidoCaja(int idTipoPeticion, String esquema){
        return pedidoEcomService.insertaContenidoCaja(paquete, idTipoPeticion, esquema);
    }
    @Override
    public List<Contenido> getContenido(Paquete paquete){
        return pedidoEcomService.getContenido(paquete);
    } 

    @Override
    protected DimensionesQB getDimensionesByTipoPeticion(Paquete paquete, String esquema, int idTipoPeticion) {
        DimensionesQB dimensionesQB = pedidoEcomService.getDimensionesPaquete(paquete, esquema, idTipoPeticion);
        return dimensionesQB;
    }
    
}
