/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao;

import com.elektra.quarterback.beans.CarrierQB;
import java.util.List;
import java.util.Map;
import mx.com.api.trknbr.beans.Almacen;
import mx.com.api.trknbr.beans.User;

/**
 *
 * @author nroblerol
 */
public interface GeneralDao {
    public User findByUsername(String user);
    public boolean saveByUsername(User user);
    
    /***
     * Retrieve Remision information from given folrem
     * @param rem folrems
     * @param cd
     * @return 
     */
    public List<Map<String,Object>> getRemisionHdrInfo(List<String> rem, int cd);
    
    
    public Integer getIdSap(Integer idManh);
    
    /***
     * Get Remisions with Route created
     * @param nc Remisiones
     * @param cd Origen
     * @return Map<String,Object> if there is a tracking number already generated else false
     */
    public List<String> getRemisionWithRoute(List<String> nc, int cd);
    
    /***
     * Retrieve Carrier information
     * @param codCarrier Carrier code (3-char)
     * @param idCanal canal
     * @param tipPed tipo  de pedido
     * @param active buscar solo activos
     * @return object CarrierQB
     */
    public CarrierQB getCarrier(String codCarrier, int idCanal, int tipPed, boolean active);
    
    public int getIdCarrierByCodCarrier(int idCanal, String codCarrier);
    
    public String getOrderType(int idManh, String idLpn);
    
    public int getIdTipoPedidoByOrderType(String orderType);
    
    public Almacen getInfoAlmn(Integer idAlm);
}
