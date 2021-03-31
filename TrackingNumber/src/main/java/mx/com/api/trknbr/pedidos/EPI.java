/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.pedidos;

import java.util.ArrayList;
import mx.com.api.trknbr.beans.Contacto;
import mx.com.api.trknbr.beans.DetalleSkus;
import mx.com.api.trknbr.beans.GuiaRequest;
import java.util.List;
import mx.com.api.trknbr.dao.GuiaDao;
import mx.com.api.trknbr.dao.PedidoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("epi")
public class EPI implements TipoPeticion{
    @Autowired
    private PedidoDao pedidoDaoEcom;
    @Autowired
    private GuiaDao guiaDao;
    
    @Override
    public List<Contacto> getContactos(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido, int tipoDoc){
        List<Contacto> contactos=new ArrayList<>();
        
        switch(idTipoPedido){
            case 1:
                Contacto ori = pedidoDaoEcom.getOrigenPedido(pedido, idCaja, idManh, cdVendor, idCarrier, idCanal, idTipoPedido);
                if(ori != null)
                    contactos.add(ori);
                Contacto des = pedidoDaoEcom.getDestinoPedido(pedido, idCaja, idManh, idCarrier, idCanal, idTipoPedido);
                if(des != null)
                    contactos.add(des);
                break;
            default:
                return null;
        }
        
        if(contactos.size()==2){
            return contactos;
        }
        else{
            return null;
        }
        
    }
    
    @Override
    public GuiaRequest getDimensiones(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido, String idLpn){
        
        switch(idTipoPedido){
            case 1:
                return pedidoDaoEcom.getDimensiones(pedido, idCaja, idManh, idCarrier, idCanal, idTipoPedido, idLpn);
            default:
                return null;
                
        }
        
    }
    
    @Override
    public String getOrderId(GuiaRequest guiaRequest){
        
        switch(guiaRequest.getIdTipoPedido()){
            case 1:
                return pedidoDaoEcom.getOrderId(guiaRequest, null);
            default:
                return null;
        }
        
    }
    
    @Override
    public List<DetalleSkus> getDetalleSkus(GuiaRequest guiaRequest){
        return pedidoDaoEcom.getDetalleSkus(guiaRequest);
    }
    
    @Override
    public List<Contacto> getContactosWs(List<Contacto> od, String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInsertControlGuias(GuiaRequest guiaRequest, String usuario) {
        return guiaDao.insertaControlGuias(guiaRequest, usuario);
    }
}
