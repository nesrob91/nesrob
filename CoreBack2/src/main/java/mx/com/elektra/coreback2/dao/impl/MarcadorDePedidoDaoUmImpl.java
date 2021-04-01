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
@Repository("marcadorPedidoDaoUm")
public class MarcadorDePedidoDaoUmImpl implements MarcadorDePedidoDao{
    
    @Autowired
    private NamedParameterJdbcTemplate um ;
    
    @Override
    public boolean actualizaNcPedidoEcom(Paquete paquete, String codigoCarrier, List<String> adns){
        return true;
    }
    
    @Override
    public boolean actualizaPedCentPedidoEcom(Paquete paquete, String codigoCarrier, List<String> adns){
        
        String sql = " UPDATE SCCENEN.taceentregas\n" +
            "SET FIPROVEEDOR = :codCarrier \n" +
            "WHERE FICENTROID = :idManh \n" +
            "AND FIENTREGAID IN (:adns)"
        ;

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("codCarrier", codigoCarrier);
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("adns", paquete.getPedido());
            
            return um.update(sql, parametros) > 0;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        
    }
    
    
    @Override
    public List<String> getAdnPedidoEcom2018(Paquete paquete, String esquema){
        return null;
    }
    
    @Override
    public List<String> getLpnsByIdCaja(Paquete paquete){
        return null;
    }
    
    
    
    
}
