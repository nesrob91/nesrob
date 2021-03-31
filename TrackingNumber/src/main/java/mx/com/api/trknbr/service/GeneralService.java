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

/**
 *
 * @author nroblerol
 */
public interface GeneralService {
    public User findByUsername(String user);
    public boolean saveByUsername(User user);
    
    public Almacen getInfoAlmn(Integer idAlm);
    public GuiaRequest insertControlGuias(String pedido, int idCaja, int idManh, int idVendor, int idCarrier, int idCanal, int idTipoPedido, String usuario, String idLpn, Map<String,Double> sizes, int tipDoc);
    
    public CarrierQB getCarrier(String codCarrier, int idCanal, int tipPed, boolean active);
}
