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
import mx.com.api.trknbr.beans.CredencialesPaquetexpress;
import mx.com.api.trknbr.configuration.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("credencialesPaqueteExpress")
public class CredencialesDaoPaqueteExpress implements CredencialesDao{
     
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private NamedParameterJdbcTemplate sccpConnection;
    
    @Override
    public Object getCredenciales(int idCarrier, int idServicio, int idTipPed){
        
        String sqlPaqueteXpress = " SELECT USUARIO ORGN_CLNT_ID "
                + " , CONTRASENIA CLNT_PSWD "
                + " , NUM_OFI FORMA_PAGO "
                + " , ID_SUSCRIPTOR DLVY_TYPE "
                + " , SERVICE_TYPE_ID INV_TYPE "
                + " , SERVICE_TYPE TYPE_EVENT "
                + " , SERVICE_TYPE_DOC_RET ACK_TYPE "
                + " , REF_FIELD_3 AGREEMENT_KEY "
                + " , '2' SHP_CODE"
                + ", nvl(ID_PROVEEDOR, 0) ID_PROVEEDOR "
                + " FROM INFO_CD.CE_CREDENCIALES_WS "
                + " WHERE ID_CARRIER = :idCarrier "
                + " AND ID_SERVICIO = :idServicio "
                + " AND ID_TIPO_PEDIDO =   :idTipPed   "  ;

        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("idCarrier", idCarrier);
        parametros.put("idServicio", idServicio);
        parametros.put("idTipPed", idTipPed);
        try{
            return sccpConnection.queryForObject(sqlPaqueteXpress, parametros, new CredencialesPaquetexpressMapper());
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
    
    
    private static final class CredencialesPaquetexpressMapper implements RowMapper<CredencialesPaquetexpress> {

        @Override
        public CredencialesPaquetexpress mapRow(ResultSet rs, int i) throws SQLException {
            CredencialesPaquetexpress credencialesPaquetexpress = new CredencialesPaquetexpress();
            
            
                credencialesPaquetexpress.setOrgnClntId(rs.getString("ORGN_CLNT_ID"));
                credencialesPaquetexpress.setClntPswd(rs.getString("CLNT_PSWD"));
                credencialesPaquetexpress.setFormaPago(rs.getString("FORMA_PAGO"));
                credencialesPaquetexpress.setDlvyType(rs.getString("DLVY_TYPE"));
                credencialesPaquetexpress.setInvType(rs.getString("INV_TYPE"));
                credencialesPaquetexpress.setTypeEvent(rs.getString("TYPE_EVENT"));
                credencialesPaquetexpress.setAckType(rs.getString("ACK_TYPE"));
                credencialesPaquetexpress.setAgreementKey(rs.getString("AGREEMENT_KEY"));
                credencialesPaquetexpress.setShpCode(rs.getString("SHP_CODE"));
                credencialesPaquetexpress.setShpCode(rs.getString("ID_PROVEEDOR"));
                
            return credencialesPaquetexpress;
        }

    } 
    
}
