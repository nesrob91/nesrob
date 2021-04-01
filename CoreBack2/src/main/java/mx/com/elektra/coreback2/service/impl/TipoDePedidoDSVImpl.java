/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service.impl;

import java.util.List;
import mx.com.elektra.coreback2.beans.CajaRf;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.dao.TipoDePedidoDao;
import mx.com.elektra.coreback2.service.GeneralesService;
import mx.com.elektra.coreback2.service.TipoDePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nroblerol
 */
@Service("pedidoDsvService")
public class TipoDePedidoDSVImpl implements TipoDePedidoService{
    @Autowired
    private  TipoDePedidoDao pedidoDsvDao ;
    @Autowired
    private  TipoDePedidoDao pedidoEcomDao ;
    
    @Override
    public boolean insertaContenidoCaja(Paquete paquete, int idTipoPeticion, String esquema){
        //modify construct pack
        paquete.setSkus(pedidoDsvDao.getDetalleSkus(paquete, esquema));
        return pedidoEcomDao.insertaContenidoCajaPorPaquete(paquete);
    }
    @Override
    public String getPedidoAlterno(Paquete paquete){
        return pedidoDsvDao.getPedidoAlterno( paquete );
    }
    @Override
    public String getCpOrigen(Paquete paquete){
        //return pedidoDsvDao.getCpOrigenDSV(pedido, idManh, tipPed);
        int idManh = paquete.getIdManh();
        paquete.setIdManh(139);
        String cp=pedidoEcomDao.getCpOrigen(paquete);
        paquete.setIdManh(idManh);
        return cp;
    }
    @Override
    public String getCpDestino(Paquete paquete){
        return pedidoDsvDao.getCpDestino(paquete);
    }

    @Override
    public Paquete setDetalleSkusInfoCd(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Contenido> getContenido(Paquete paquete){
        return pedidoDsvDao.getContenido(paquete);
    }
    
    @Override
    public DimensionesQB getDimensionesPaquete(Paquete paquete, String esquema, int tipPed){
        CajaRf caja = pedidoEcomDao.getCajaRf(paquete.getIdManh(), paquete.getIdManh(), tipPed);
        DimensionesQB dimensiones = new DimensionesQB();
        dimensiones.setAlto(caja.getAlto());
        dimensiones.setAncho(caja.getAncho());
        dimensiones.setLargo(caja.getLargo());

        dimensiones.setVolumen( dimensiones.getAlto() * dimensiones.getAncho() * dimensiones.getLargo() );
        dimensiones.setPesoVolumetrico(dimensiones.getVolumen() / 5000);
        return dimensiones;
        //return generalesDao.getDimensionesPaqueteDSV(idManh, idCaja, esquema, tipPed);
    }

    @Override
    public double getPesoPaquete(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFolioControl(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
