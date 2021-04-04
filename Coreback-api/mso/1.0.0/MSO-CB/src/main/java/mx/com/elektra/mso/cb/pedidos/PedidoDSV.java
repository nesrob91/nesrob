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
 * @author nroblerol
 */
@Component("pedidoDsv")
public class PedidoDSV extends TipoDePedido{
    @Autowired
    private TipoDePedidoService pedidoDsvService;
    
    public PedidoDSV(Paquete paquete) {
        super(paquete);
    }
    
    @Override
    public String getPedidoAlterno(){
        return pedidoDsvService.getPedidoAlterno(paquete);
    }
    @Override
    public String getCpOrigen(){
        return pedidoDsvService.getCpOrigen(paquete);
    }
    @Override
    public String getCpDestino(){
        return pedidoDsvService.getCpDestino(paquete);
    }
    @Override
    public boolean insertaContenidoCaja(int idTipoPeticion, String esquema){
        return pedidoDsvService.insertaContenidoCaja(paquete, idTipoPeticion, esquema);
    }
    @Override
    public List<Contenido> getContenido(Paquete paquete){
        return pedidoDsvService.getContenido(paquete);
    }

    @Override
    protected DimensionesQB getDimensionesByTipoPeticion(Paquete paquete, String esquema, int idTipoPeticion) {
        DimensionesQB dimensionesQB = pedidoDsvService.getDimensionesPaquete(paquete, esquema, idTipoPeticion);
        if(dimensionesQB != null){
            dimensionesQB.setPesoFisico(getPesoByContenido(paquete.getSkus()));
        }
        return dimensionesQB;
    }

}
