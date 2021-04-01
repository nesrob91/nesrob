/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.dao.impl;

import com.elektra.cadsumutils.dao.DataSources;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.dao.MarcadorDePedidoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dparra
 */
@Repository("marcadorDePedidoDao")
public class MarcadorDePedidoDaoImpl implements MarcadorDePedidoDao{
    
    @Autowired
    private NamedParameterJdbcTemplate wm18 ;
    @Autowired
    private NamedParameterJdbcTemplate scpp ;
    
    @Override
    public boolean actualizaNcPedidoEcom(Paquete paquete, String codigoCarrier, List<String> adns){
        
        String sql = " UPDATE INFO_CD.NOTACARGOHDR "
                + " SET ANIO = :codCarrier "
                + " WHERE TIPONC = 6 "
                + " AND CD_ID = :idManh "
                + " AND REMISION IN (:adns)"
        ;

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("codCarrier", codigoCarrier);
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("adns", adns);
            
            return scpp.update(sql, parametros) > 0;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    
        
    }
    
    @Override
    public boolean actualizaPedCentPedidoEcom(Paquete paquete, String codigoCarrier, List<String> adns){
        
        String sql = " UPDATE INFO_CD.PED_CENT "
                + " SET PGM = :codCarrier "
                + " WHERE STORE_NBR = 9797 "
                + " AND WHSE = :idManh "
                + " AND PEDIDO IN (:adns)"
        ;

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("codCarrier", codigoCarrier);
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("adns", adns);
            
            return scpp.update(sql, parametros) > 0;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
    }
    
    
    @Override
    public List<String> getAdnPedidoEcom2018(Paquete paquete, String esquema){
        
        String sql = " SELECT OLI.REF_FIELD4 "
                + " FROM "+esquema+".ORDERS O "
                + " JOIN "+esquema+".ORDER_LINE_ITEM OLI "
                + " ON O.ORDER_ID = OLI.ORDER_ID "
                + " JOIN "+esquema+".LPN L "
                + " ON L.TC_ORDER_ID = O.TC_ORDER_ID "
                + " JOIN "+esquema+".LPN_DETAIL LD "
                + " ON L.LPN_ID = LD.LPN_ID "
                + " AND (LD.DISTRIBUTION_ORDER_DTL_ID = OLI.LINE_ITEM_ID "
                + " OR LD.DISTRIBUTION_ORDER_DTL_ID = OLI.REFERENCE_LINE_ITEM_ID) "
                + " AND LD.ITEM_ID = OLI.ITEM_ID "
                + " WHERE OLI.DO_DTL_STATUS <= 190 "
                + " AND O.O_FACILITY_ALIAS_ID = :idManh "
                + " and L.TC_LPN_ID IN (:idLpns) ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idLpns", getLpnsByIdCaja(paquete));
            
            return wm18.queryForList(sql, parametros, String.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
        
    }
    
    @Override
    public List<String> getLpnsByIdCaja(Paquete paquete){
        
        String sql = " SELECT CD.OLPN "
                + " FROM INFO_CD.ECOM_CAJA_HDR CH"
                + " , INFO_CD.ECOM_CAJA_DTL CD"
                + " WHERE CH.PKIDCAJAHDR = CD.FKIDCAJAHDR"
                + " AND CH.ID_MANH = :idManh "
                + " AND CH.PKIDCAJAHDR = :idCaja ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCaja", paquete.getIdCaja());
            
            return scpp.queryForList(sql, parametros, String.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
        
    }
    
    
    
    
}
