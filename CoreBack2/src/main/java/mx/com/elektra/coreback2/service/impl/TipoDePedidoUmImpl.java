/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service.impl;

import java.util.List;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DetalleSkus;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.FamiliaSap;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.dao.GeneralesDao;
import mx.com.elektra.coreback2.dao.TipoDePedidoDao;
import mx.com.elektra.coreback2.service.TipoDePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nroblerol
 */
@Service("pedidoUmService")
public class TipoDePedidoUmImpl implements TipoDePedidoService{
    @Autowired
    private  TipoDePedidoDao pedidoUmDao ;

    @Override
    public boolean insertaContenidoCaja(Paquete paquete, int idTipoPeticion, String esquema) {
        List<DetalleSkus> detalle = pedidoUmDao.getDetalleSkus(paquete, esquema);
        if(detalle != null)
            paquete.setSkus(detalle);
        else
            return false;
        return true;
    }

    @Override
    public String getPedidoAlterno(Paquete paquete) {
        return pedidoUmDao.getPedidoAlterno(paquete);
    }

    @Override
    public String getCpOrigen(Paquete paquete) {
        return pedidoUmDao.getCpOrigen(paquete);
    }

    @Override
    public String getCpDestino(Paquete paquete) {
        return pedidoUmDao.getCpDestino(paquete);
    }

    @Override
    public Paquete setDetalleSkusInfoCd(Paquete paquete) {
        for(DetalleSkus d : paquete.getSkus()){
            d.getSku().setDescDepartamento("");
            d.getSku().setDescSubdepartamento("");
            d.getSku().setDescClase("");
            d.getSku().setDescSubclase("");
            d.getSku().setCostoUnitario(0);
        }
        return paquete;
    }

    @Override
    public List<Contenido> getContenido(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DimensionesQB getDimensionesPaquete(Paquete paquete, String esquema, int tipPed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPesoPaquete(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFolioControl(Paquete paquete) {
        return pedidoUmDao.getFolioControl(paquete);
    }
    
}
