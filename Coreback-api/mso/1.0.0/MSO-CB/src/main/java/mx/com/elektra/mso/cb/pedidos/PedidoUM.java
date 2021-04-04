/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.pedidos;

import java.util.List;
import mx.com.elektra.mso.cb.model.Contenido;
import mx.com.elektra.mso.cb.model.DetalleSkus;
import mx.com.elektra.mso.cb.model.DimensionesQB;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.service.TipoDePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("pedidoUm")
public class PedidoUM extends TipoDePedido{
    @Autowired
    private TipoDePedidoService pedidoUmService;
    
    public PedidoUM(Paquete paquete) {
        super(paquete);
    }

    @Override
    public Paquete getPaquete(String pedido, int idManh, String esquema, int idCaja, int idTipoPedido, String folio) {
        return pedidoUmService.getPaquete(pedido, idManh, esquema, idCaja, idTipoPedido, folio);
    }

    @Override
    public List<Contenido> getContenido(Paquete paquete) {
        return super.getContenido(paquete); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertaContenidoCaja(int idTipoPeticion, String esquema) {
        return pedidoUmService.insertaContenidoCaja(paquete, idTipoPeticion, esquema);
    }

    @Override
    public String getCpDestino() {
        return pedidoUmService.getCpDestino(paquete);
    }

    @Override
    public String getCpOrigen() {
        return pedidoUmService.getCpOrigen(paquete);
    }

    @Override
    public String getPedidoAlterno() {
        return pedidoUmService.getPedidoAlterno(paquete);
    }

    @Override
    protected DimensionesQB getDimensionesByTipoPeticion(Paquete paquete, String esquema, int idTipoPeticion) {
        DimensionesQB dimensiones = null;
        try{
            if(paquete.getSkus().size()==1){
                dimensiones=new DimensionesQB();
                dimensiones.setAlto(paquete.getSkus().get(0).getSku().getAlto());
                dimensiones.setAncho(paquete.getSkus().get(0).getSku().getAncho());
                dimensiones.setLargo(paquete.getSkus().get(0).getSku().getLargo());
                dimensiones.setPesoFisico(paquete.getSkus().get(0).getSku().getPeso());
                dimensiones.setPesoVolumetrico(dimensiones.getAlto()*dimensiones.getAncho()*dimensiones.getLargo());
                dimensiones.setVolumen(0);
            }else{
                dimensiones=new DimensionesQB();
                double peso=0;
                for(DetalleSkus ds : paquete.getSkus()){
                    peso+=paquete.getSkus().get(0).getSku().getPeso();
                }
                dimensiones.setAlto(1);
                dimensiones.setAncho(1);
                dimensiones.setLargo(1);
                dimensiones.setPesoFisico(peso);
                dimensiones.setPesoVolumetrico(0);
                dimensiones.setVolumen(0);
            }
        }catch(Exception e){
            
        }
        return dimensiones;
    }
    
}
