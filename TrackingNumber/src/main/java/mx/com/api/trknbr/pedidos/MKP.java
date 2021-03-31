/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.pedidos;

import com.elektra.cadsumutils.generales.Generales;
import mx.com.api.trknbr.beans.Contacto;
import mx.com.api.trknbr.beans.DetalleSkus;
import mx.com.api.trknbr.beans.GuiaRequest;
import java.util.ArrayList;
import java.util.List;
import mx.com.api.trknbr.dao.GuiaDao;
import mx.com.api.trknbr.dao.PedidoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("mkp")
public class MKP implements TipoPeticion{
    @Autowired
    private PedidoDao pedidoDaoMkp;
    @Autowired
    private GuiaDao guiaDao;
    
    /***
     * Metodo sobreescrito para obtener la informacion de contacto del origen y destino del pedido MarketPlace
     * @param pedido
     * @param idCaja
     * @param idManh
     * @param idCarrier
     * @param idCanal
     * @param idTipoPedido
     * @return Lista de contactos, primer posicion origen, segunda posicion destino
     */
    @Override
    public List<Contacto> getContactos(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido, int tipoDoc){
        List<Contacto> contactos = new ArrayList<Contacto>();
        
        Contacto ori = pedidoDaoMkp.getOrigenPedido(pedido, idCaja, idManh, cdVendor, idCarrier, idCanal, idTipoPedido);
        if(ori != null)
            contactos.add(ori);
        Contacto des = pedidoDaoMkp.getDestinoPedido(pedido, idCaja, idManh, idCarrier, idCanal, idTipoPedido);
        if(des != null)
            contactos.add(des);
        //contactos.add(generalesService.getDestinoPedido(pedido, idManh, idManh, idManh, idManh, idManh));
        
        if(contactos == null || contactos.size()!=2){
            contactos = null;
        }
        if(!verifyContactInformation(contactos, idTipoPedido))
            contactos=null;
        return contactos;
    }
    
    @Override
    public GuiaRequest getDimensiones(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido, String idLpn){
        
        return pedidoDaoMkp.getDimensiones(pedido, idCaja, idManh, idCarrier, idCanal, idTipoPedido, idLpn);
        
    }
    
    @Override
    public String getOrderId(GuiaRequest guiaRequest){
        
        return Generales.getInstance().soToNumber(guiaRequest.getPedido().replace("v", "").replace("ekt-01", ""));
        
    }
    
    @Override
    public List<DetalleSkus> getDetalleSkus(GuiaRequest guiaRequest){
        return pedidoDaoMkp.getDetalleSkus(guiaRequest);
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
