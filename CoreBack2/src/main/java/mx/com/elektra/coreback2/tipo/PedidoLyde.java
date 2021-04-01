/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.tipo;

import java.util.List;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.service.TipoDePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("pedidoLyde")
public class PedidoLyde extends TipoDePedido{
    @Autowired
    private TipoDePedidoService pedidoLydeService;
    
    public PedidoLyde(Paquete paquete) {
        super(paquete);
    }
    
    @Override
    public String getPedidoAlterno(){
        return pedidoLydeService.getPedidoAlterno(paquete);
    }
    @Override
    public String getCpOrigen(){
        return pedidoLydeService.getCpOrigen(paquete);
    }
    @Override
    public String getCpDestino(){
        return pedidoLydeService.getCpDestino(paquete);
    }
    @Override
    public boolean insertaContenidoCaja(int idTipoPeticion, String esquema){
        return pedidoLydeService.insertaContenidoCaja(paquete, idTipoPeticion, esquema);
    }
    @Override
    public List<Contenido> getContenido(Paquete paquete){
        return pedidoLydeService.getContenido(paquete);
    }

    @Override
    protected DimensionesQB getDimensionesByTipoPeticion(Paquete paquete, String esquema, int idTipoPeticion) {
        DimensionesQB dimensionesQB = pedidoLydeService.getDimensionesPaquete(paquete, esquema, paquete.getIdTipoPedido());
        if(dimensionesQB != null){
            dimensionesQB.setPesoFisico(getPesoByContenido(paquete.getSkus()));
        }
        return dimensionesQB;
    }
    
}
