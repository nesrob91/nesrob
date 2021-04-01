/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.tipo;

import java.util.List;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DetalleSkus;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.service.TipoDePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("pedidoMkp")
public class PedidoMKP extends TipoDePedido{
    @Autowired
    private TipoDePedidoService pedidoDsvService;
    @Autowired
    private TipoDePedidoService pedidoMkpService;
    
    public PedidoMKP(Paquete paquete) {
        super(paquete);
    }
    
    @Override
    public String getPedidoAlterno(){
        //return pedidoDsvService.getPedidoAlternoMKP(paquete.getPedido(), paquete.getIdManh(), paquete.getIdTipoPedido());
        return pedidoDsvService.getPedidoAlterno(paquete);
    }
    @Override
    public String getCpOrigen(){
        //return tipoDePedidoService.getCpOrigenMKP(paquete.getPedido(), paquete.getIdManh(), paquete.getIdTipoPedido());
        return pedidoDsvService.getCpOrigen(paquete);
    }
    @Override
    public String getCpDestino(){
        //return tipoDePedidoService.getCpDestinoMKP(paquete.getPedidoAlterno(), paquete.getIdManh(), paquete.getIdTipoPedido());
        return pedidoDsvService.getCpDestino(paquete);
    }
    @Override
    public boolean insertaContenidoCaja(int idTipoPeticion, String esquema){
        return pedidoMkpService.insertaContenidoCaja(paquete, idTipoPeticion, esquema);
    }
    @Override
    public List<Contenido> getContenido(Paquete paquete){
        return pedidoDsvService.getContenido(paquete);
    }

    @Override
    protected DimensionesQB getDimensionesByTipoPeticion(Paquete paquete, String esquema, int idTipoPeticion) {
        DimensionesQB dimensionesQB = pedidoDsvService.getDimensionesPaquete(paquete, esquema, paquete.getIdTipoPedido());
        if(dimensionesQB != null){
            dimensionesQB.setPesoFisico(getPesoByContenido(paquete.getSkus()));
        }
        return dimensionesQB;
    }

    @Override
    protected double getPesoByContenido(List<DetalleSkus> contenido) {
        return pedidoMkpService.getPesoPaquete(paquete);
    }
    
}
