/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao;

import com.elektra.cadsumutils.dao.DataSources;
import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import mx.com.api.trknbr.beans.CredencialesTracusa;
import mx.com.api.trknbr.configuration.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("credencialesTracusa")
public class CredencialesDaoTracusa implements CredencialesDao{
     
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private NamedParameterJdbcTemplate sccpConnection;
    
    @Override
    public Object getCredenciales(int idCarrier, int idServicio, int idTipPed){
        
        String sqlTracusa="SELECT desc_servicio\n"
                    + ", id_servicio \n"
                    + ", contrasenia\n"
                    + ", service_type_id\n"
                    + ", service_type\n"
                    + ", ref_field_1\n"
                    + ", ref_field_3\n"
                    + ", desc_servicio \n"
                    + "FROM info_cd.ce_credenciales_ws \n"
                    + "WHERE id_carrier = :idCarrier\n"
                    + "AND id_servicio = :idServicio\n"
                    + "AND id_tipo_pedido = :idTipPed";

        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("idCarrier", idCarrier);
        parametros.put("idServicio", idServicio);
        parametros.put("idTipPed", idTipPed);
        try{
            return sccpConnection.query(sqlTracusa, parametros, new CredencialesTracusaMapper());
            
        }catch(Exception ex){
            try{
                logger.insertaError(
                    1010004
                    , 10
                    , null
                    , null
                    , null
                    , 0
                    , idCarrier
                    , null
                    , null
                    , idTipPed
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            return null;
        }
    }
    
    private static class CredencialesTracusaMapper implements RowMapper<CredencialesTracusa>{

        @Override
        public CredencialesTracusa mapRow(ResultSet rs, int rowNum) throws SQLException {
            CredencialesTracusa credencialesGuiasTracusa=new CredencialesTracusa();
            credencialesGuiasTracusa.setIdServicio(rs.getInt("id_servicio"));
            credencialesGuiasTracusa.setKey(rs.getString("contrasenia"));
            credencialesGuiasTracusa.setMode(rs.getString("service_type"));
            credencialesGuiasTracusa.setServiceType(rs.getString("service_type"));
            credencialesGuiasTracusa.setServiceTypeId(rs.getString("service_type_id"));
            credencialesGuiasTracusa.setUrl(rs.getString("ref_field_1"));
            credencialesGuiasTracusa.setDescServicio(rs.getString("desc_servicio"));
            credencialesGuiasTracusa.setPath(rs.getString("ref_field_3"));
            return credencialesGuiasTracusa;
        }
        
    }
}
