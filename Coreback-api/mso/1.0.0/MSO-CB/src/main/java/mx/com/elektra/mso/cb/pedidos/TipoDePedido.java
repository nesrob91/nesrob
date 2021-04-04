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
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("pedidoGen")
public class TipoDePedido {
    
    protected Paquete paquete;
    

    public TipoDePedido(Paquete paquete) {
        this.paquete = paquete;
    }
    
    public Paquete getPaquete(String pedido, int idManh, String esquema, int idCaja, int idTipoPedido, String folio){
        return null;
    }
    
    public String getPedidoAlterno(){
        return null;
    }
    public String getCpOrigen(){
        return null;
    }
    public String getCpDestino(){
        return null;
    }
    public boolean insertaContenidoCaja(int idTipoPeticion, String esquema){
        return false;
    }
    
    public List<Contenido> getContenido(Paquete paquete){
        return null;
    }
    
    public Paquete setDimensionesPaquete(Paquete paquete, String esquema, int idTipoPeticion){
        //modify - check for loop in items(if necesary)
        //DimensionesQB dimensionesQB = getDimensionesPaquete2018(paquete.getIdManh(), paquete.getIdLpn(), esquema);
        DimensionesQB dimensionesQB = getDimensionesByTipoPeticion(paquete, esquema, idTipoPeticion);
        if(dimensionesQB != null){
            paquete.setLargo(dimensionesQB.getLargo());
            paquete.setAncho(dimensionesQB.getAncho());
            paquete.setAlto(dimensionesQB.getAlto());
            paquete.setPesoFisico(dimensionesQB.getPesoFisico());
            paquete.setPesoVolumetrico(dimensionesQB.getPesoVolumetrico());
            paquete.setVolumen(dimensionesQB.getVolumen());

            paquete.setPeso((dimensionesQB.getPesoVolumetrico() > dimensionesQB.getPesoFisico()) ? dimensionesQB.getPesoVolumetrico() : dimensionesQB.getPesoFisico());
            paquete.setCostoTotal((paquete.getSkus() == null || paquete.getSkus().isEmpty()) ? 0 : getCostoTotalPaquete(paquete.getSkus()));
            paquete.setError("");
        }else{
            paquete.setError("CBPD001");
        }
        return paquete;
    }
    
    protected DimensionesQB getDimensionesByTipoPeticion(Paquete paquete, String esquema, int idTipoPeticion){
        return null;
    }
    
    protected double getCostoTotalPaquete(List<DetalleSkus> skus){
        double costoTotal = 0;
        for(DetalleSkus d : skus){
            costoTotal += (d.getSku().getCostoUnitario() * d.getCantidad());
        }
        return costoTotal;
    }
    
    protected double getPesoByContenido(List<DetalleSkus> contenido){
        double pesoFisico = 0;
        for(DetalleSkus detalle : contenido){
            pesoFisico += detalle.getSku().getPeso() * detalle.getCantidad();
        }
        return pesoFisico;
    }
    
}
