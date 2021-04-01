/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DetalleSkus;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.FamiliaSap;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.dao.GeneralesDao;
import mx.com.elektra.coreback2.dao.TipoDePedidoDao;
import mx.com.elektra.coreback2.service.GeneralesService;
import mx.com.elektra.coreback2.service.TipoDePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dparra
 */
@Service("pedidoEcomService")
public class TipoDePedidoEcomImpl implements TipoDePedidoService{
    @Autowired
    private  TipoDePedidoDao pedidoEcomDao ;
    @Autowired
    private  GeneralesDao generalesDao ;
    
    @Override
    public boolean insertaContenidoCaja(Paquete paquete, int idTipoPeticion, String esquema){
        switch(idTipoPeticion){
            case 1:
                return insertaContenidoCaja2018(paquete, esquema);
            case 2:
                return insertaContenidoCaja2018Rf(paquete, esquema);
            default: 
                return false;
        }
        
    }
    
    private boolean insertaContenidoCaja2018(Paquete paquete, String esquema){
        paquete.setSkus(pedidoEcomDao.getDetalleSkus(paquete, esquema));
        paquete = setDetalleSkusInfoCd(paquete);
        
        return pedidoEcomDao.insertaContenidoCajaPorPaquete(paquete);
    }
    
    private boolean insertaContenidoCaja2018Rf(Paquete paquete, String esquema){
        
        paquete.setSkus(pedidoEcomDao.getDetalleSkusRf(paquete, esquema, null));
        //paquete = generalesService.setDetalleSkusInfoCd(paquete);
        return pedidoEcomDao.insertaContenidoCajaPorPaquete(paquete);
    }
    
    public List<String> getLpnsByCd(List<Contenido> contenido, int idManh){
        List<String> lpns = new ArrayList<>();
        for(Contenido c : contenido){
            if(Integer.parseInt(c.getIdManh()) == idManh){
                lpns.add(c.getIdLpn());
            }
        }
        return lpns;
    }
    
    
    @Override
    public String getPedidoAlterno(Paquete paquete){
        return pedidoEcomDao.getPedidoAlterno(paquete);
    }
    
    @Override
    public String getCpOrigen(Paquete paquete){
        return pedidoEcomDao.getCpOrigen(paquete);
    }
    
    @Override
    public String getCpDestino(Paquete paquete){
        return pedidoEcomDao.getCpDestino(paquete);
    }
    
    @Override
    public Paquete setDetalleSkusInfoCd(Paquete paquete){
        FamiliaSap familiaSap;
        
        for(DetalleSkus d : paquete.getSkus()){
            familiaSap = generalesDao.getFamiliaSap(d.getSku().getIdSubclase());
            d.getSku().setDescDepartamento(familiaSap.getDescDepartamento());
            d.getSku().setDescSubdepartamento(familiaSap.getDescSubdepartamento());
            d.getSku().setDescClase(familiaSap.getDescClase());
            d.getSku().setDescSubclase(familiaSap.getDescSubclase());
            d.getSku().setCostoUnitario(generalesDao.getCostoSku(d.getSku().getIdSku()));
        }
                
        return paquete;
    }
    
    @Override
    public List<Contenido> getContenido(Paquete paquete){
        return pedidoEcomDao.getContenido(paquete);
    }

    @Override
    public DimensionesQB getDimensionesPaquete(Paquete paquete, String esquema, int tipPed) {
        return pedidoEcomDao.getDimensionesPaquete(paquete.getIdManh(), paquete.getIdLpn(), esquema);
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
