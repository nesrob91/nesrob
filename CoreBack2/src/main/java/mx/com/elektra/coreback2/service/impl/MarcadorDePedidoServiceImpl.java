/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service.impl;

import java.util.ArrayList;
import java.util.List;
import mx.com.elektra.coreback2.beans.CarrierQB;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.dao.MarcadorDePedidoDao;
import mx.com.elektra.coreback2.service.MarcadorDePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dparra
 */
@Service("marcadorDePedidoService")
public class MarcadorDePedidoServiceImpl implements MarcadorDePedidoService{
    @Autowired
    private  MarcadorDePedidoDao marcadorDePedidoDao ;
    
    @Override
    public boolean actualizaPedidoCarrier(Paquete paquete, CarrierQB carrier, String esquema){
        
        switch(paquete.getIdTipoPedido()){
            case 1:
                return actualizaPedidoECOM(paquete, carrier, esquema);
            case 4:
                return true;
            default: 
                return false;
        }
    }
    
    
    private boolean actualizaPedidoECOM(Paquete paquete, CarrierQB carrier, String esquema) {/*
        List<AdnNcEcom> adnNcEcoms = new ArrayList<>();
        adnNcEcoms = marcadorDePedidoDaoImpl.getNcsPedidoEcom(paquete);
        if (!adnNcEcoms.isEmpty()) {
            String codigoCarrier = marcadorDePedidoDaoImpl.getCodigoCarrier(carrier);
            if(codigoCarrier != null && !codigoCarrier.equals("")){
                List<String> ncs = new ArrayList<>();
                List<String> adns = new ArrayList<>();
                for (AdnNcEcom adnNcEcom : adnNcEcoms) {
                    ncs.add(adnNcEcom.getNc());
                    adns.add(adnNcEcom.getAdn());
                }
                return marcadorDePedidoDaoImpl.actualizaNcPedidoEcom(paquete, codigoCarrier, adns) && marcadorDePedidoDaoImpl.actualizaPedCentPedidoEcom(paquete, codigoCarrier, adns);    
            }
            else{
                return false;
            }
            
        } else {
            return false;
        }*/
        List<String> adns = marcadorDePedidoDao.getAdnPedidoEcom2018(paquete, esquema);
        return marcadorDePedidoDao.actualizaPedCentPedidoEcom(paquete, carrier.getCodCarrier(), adns) && marcadorDePedidoDao.actualizaNcPedidoEcom(paquete, carrier.getCodCarrier(), adns);
    }
    
}
