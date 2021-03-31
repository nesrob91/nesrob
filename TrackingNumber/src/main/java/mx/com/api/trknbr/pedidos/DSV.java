/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.pedidos;

import com.elektra.cadsumutils.generales.Generales;
import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import mx.com.api.trknbr.beans.Contacto;
import mx.com.api.trknbr.beans.DetalleSkus;
import mx.com.api.trknbr.beans.GuiaRequest;
import java.util.List;
import java.util.ArrayList;
import mx.com.api.trknbr.configuration.ConfigBean;
import mx.com.api.trknbr.dao.GuiaDao;
import mx.com.api.trknbr.dao.PedidoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("dsv")
public class DSV implements TipoPeticion{
    @Autowired
    private PedidoDao pedidoDaoDsv;
    @Autowired
    private PedidoDao pedidoDaoEcom;
    @Autowired
    private GuiaDao guiaDao;
    
    //public GeneralesService generalesService = new GeneralesServiceImpl();
    @Autowired
    public ConfigBean conf;
    
    /***
     * Metodo sobreescrito para obtener la informacion de contacto del origen y destino del pedido DSV
     * @param pedido
     * @param idCaja
     * @param idManh
     * @param cdVendor 
     * @param idCarrier
     * @param idCanal
     * @param idTipoPedido
     * @param tipoDoc
     * @return Lista de contactos, primer posicion origen, segunda posicion destino
     */
    @Override
    public List<Contacto> getContactos(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido, int tipoDoc){
        List<Contacto> contactos = new ArrayList<Contacto>();
        
        Contacto ori = pedidoDaoDsv.getOrigenPedido(pedido, idCaja, idManh, cdVendor, idCarrier, idCanal, idTipoPedido);
        if(ori != null)
            contactos.add(ori);
        Contacto des = pedidoDaoDsv.getDestinoPedido(pedido, idCaja, idManh, idCarrier, idCanal, idTipoPedido);
        if(des != null)
            contactos.add(des);
        
        if(contactos.size()!=2){
            contactos = null;
        }
        if(verifyContactInformation(contactos, idTipoPedido))
            return contactos;
        else
            return null;
    }
    
    @Override
    public List<Contacto> getContactosWs(List<Contacto> od, String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido){
        try{
            Contacto ori=pedidoDaoDsv.getOrigenPedidoWs(pedido, idCaja, idManh, cdVendor, idCarrier, idCanal, idTipoPedido);
            od.set(0, ori);
            return od;
        }catch(Exception e){
            if(conf.isWriteAll()){
                System.out.println("Error : "+e.getMessage());
                System.out.println("No se modifico informacion.");
            }
            return null;
        }
    }
    
    @Override
    public GuiaRequest getDimensiones(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido, String idLpn){
        
        return pedidoDaoDsv.getDimensiones(pedido, idCaja, idManh, idCarrier, idCanal, idTipoPedido, idLpn);
        
    }
    
    @Override
    public String getOrderId(GuiaRequest guiaRequest){
        
        return Generales.getInstance().soToNumber(guiaRequest.getPedido());
        
    }
    
    @Override
    public List<DetalleSkus> getDetalleSkus(GuiaRequest guiaRequest){
        return pedidoDaoDsv.getDetalleSkus(guiaRequest);
    }
    
    @Override
    public boolean isInsertControlGuias(GuiaRequest guiaRequest, String usuario) {
        return guiaDao.insertaControlGuias(guiaRequest, usuario);
    }
}
