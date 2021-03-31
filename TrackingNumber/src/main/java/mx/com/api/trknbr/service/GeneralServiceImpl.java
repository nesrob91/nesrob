/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.service;

import com.elektra.quarterback.beans.CarrierQB;
import java.util.Map;
import mx.com.api.trknbr.beans.Almacen;
import mx.com.api.trknbr.beans.GuiaRequest;
import mx.com.api.trknbr.beans.User;
import mx.com.api.trknbr.dao.GeneralDao;
import mx.com.api.trknbr.dao.PedidoDao;
import mx.com.api.trknbr.pedidos.PSelector;
import mx.com.api.trknbr.pedidos.TipoPeticion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nroblerol
 */
@Service("generalService")
public class GeneralServiceImpl implements GeneralService{
    @Autowired
    private GeneralDao generalDao;
    @Autowired
    private PSelector pedido;
    
    @Override
    public User findByUsername(String user) {
        return generalDao.findByUsername(user);
    }
    
    @Override
    public boolean saveByUsername(User user){
        return generalDao.saveByUsername(user);
    }
    
    @Override
    public GuiaRequest insertControlGuias(String pedido, int idCaja, int idManh, int idVendor, int idCarrier, int idCanal, int idTipoPedido, String usuario, String idLpn, Map<String,Double> sizes, int tipDoc){
    
        TipoPeticion tipoPeticion = null;
        tipoPeticion = this.pedido.getInstance(idTipoPedido, sizes);
        if(tipoPeticion != null)
            return tipoPeticion.insertControlGuias(pedido, idCaja, idManh, idVendor, idCarrier, idCanal, idTipoPedido, usuario, idLpn, tipDoc);
        else{
            GuiaRequest request = new GuiaRequest();
            request.setObservaciones("GWSPT00");
            return request;
        }
    }
    
    @Override
    public Almacen getInfoAlmn(Integer idAlm) {
        return generalDao.getInfoAlmn(idAlm);
    }
    
    @Override
    public CarrierQB getCarrier(String codCarrier, int idCanal, int tipPed, boolean active) {
        return generalDao.getCarrier(codCarrier, idCanal, tipPed, active);
    }
}
