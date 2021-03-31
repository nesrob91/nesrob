/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import mx.com.api.trknbr.beans.CredencialesDhl;
import mx.com.api.trknbr.configuration.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("credencialesDhl")
public class CredencialesDaoDhl implements CredencialesDao{
     
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private NamedParameterJdbcTemplate sccpConnection;
    
    @Override
    public Object getCredenciales(int idCarrier, int idServicio, int idTipPed){
        
        String sqlDhl = " SELECT TO_CHAR(CURRENT_TIMESTAMP,'YYYY-MM-DD\"T\"HH24:MI:SS.FF3')||'-06:00' MESSAGE_TIME " 
                + " , TO_CHAR(CURRENT_TIMESTAMP,'YYYYMMDDHH24MISSFF3') MESSAGE_REFERENECE " 
                + " , USUARIO " 
                + " , CONTRASENIA " 
                + " , 'AM' REGION_CODE " 
                + " , 'Y' REQUESTED_PICKUP_TIME " 
                + " , 'N' NEW_SHIPPER " 
                + " , 'EN' LANGUAGE_CODE " 
                + " , 'Y' PIECES_ENABLED " 
                + " , 'S' SHIPPING_PAYMENT_TYPE " 
                + " , 'R' DUTY_PAYMENT_TYPE " 
                + " , 'K' WEIGHT_UNIT " 
                + " , 'N' GLOBAL_CODE " 
                + " , TO_CHAR(sysdate, 'yyyy-mm-dd') FECHA " 
                + " , 'C' DIMENSION_UNIT " 
                + " , 'MXN' CURRENCY_CODE " 
                // + " , 'PDF' LABEL_IMAGE_FORMAT " se hace dinamico  OJO no olvidar el insert en la tabla "ZPL2" para cebra
                + " , REF_FIELD_2 LABEL_IMAGE_FORMAT "
                + " , REF_FIELD_1 URL " 
                + " , NUMCTE " 
                + " , 'LAST_CHECK_POINT_ONLY' LEVEL_OF_DETAILS "
                + " , 'D' ACCOUNT_TYPE " 
                + " , 'B' LOCATION_TYPE " 
                + " , 'ALMACÃ‰N' PACKAGE_LOCATION " 
                + " , '08:00' READY_BY_TIME " 
                + " , '12:00' CLOSE_TIME " 
                + " , 'DD' DOOR_TO " 
                + " , nvl(ID_PROVEEDOR, 0) ID_PROVEEDOR " 
                + " FROM INFO_CD.CE_CREDENCIALES_WS " 
                + " WHERE ID_CARRIER =   :idCarrier   " 
                + " AND ID_SERVICIO =   :idServicio   " 
                + " AND ID_TIPO_PEDIDO =   :idTipPed   "  ;
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("idCarrier", idCarrier);
        parametros.put("idServicio", idServicio);
        parametros.put("idTipPed", idTipPed);
        try{
            return sccpConnection.queryForObject(sqlDhl, parametros, new CredencialesDhlMapper());
            
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
    
        
    private static final class CredencialesDhlMapper implements RowMapper<CredencialesDhl> {


        @Override
        public CredencialesDhl mapRow(ResultSet rs, int i) throws SQLException {
            CredencialesDhl credencialesDhl = new CredencialesDhl();
            
            credencialesDhl.setMessageTime(rs.getString("MESSAGE_TIME"));
                credencialesDhl.setMessageReference(rs.getString("MESSAGE_REFERENECE"));
                credencialesDhl.setUsuario(rs.getString("USUARIO"));
                credencialesDhl.setContrasenia(rs.getString("CONTRASENIA"));
                credencialesDhl.setRegionCode(rs.getString("REGION_CODE"));
                credencialesDhl.setRequestedPickupTime(rs.getString("REQUESTED_PICKUP_TIME"));
                credencialesDhl.setNewShipper(rs.getString("NEW_SHIPPER"));
                credencialesDhl.setLanguageCode(rs.getString("LANGUAGE_CODE"));
                credencialesDhl.setPiecesRnabled(rs.getString("PIECES_ENABLED"));
                credencialesDhl.setShippingPaymentType(rs.getString("SHIPPING_PAYMENT_TYPE"));
                credencialesDhl.setDutyPaymentType(rs.getString("DUTY_PAYMENT_TYPE"));
                credencialesDhl.setWeightUnit(rs.getString("WEIGHT_UNIT"));
                credencialesDhl.setGlobalCode(rs.getString("GLOBAL_CODE"));
                credencialesDhl.setFecha(rs.getString("FECHA"));
                credencialesDhl.setDimensionUnit(rs.getString("DIMENSION_UNIT"));
                credencialesDhl.setCurrencyCode(rs.getString("CURRENCY_CODE"));
                credencialesDhl.setLabelImageFormat(rs.getString("LABEL_IMAGE_FORMAT"));
                credencialesDhl.setUrl(rs.getString("URL"));
                credencialesDhl.setNumcte(rs.getString("NUMCTE"));
                credencialesDhl.setAccountType(rs.getString("ACCOUNT_TYPE"));
                credencialesDhl.setLocationType(rs.getString("LOCATION_TYPE"));
                credencialesDhl.setPackageLocation(rs.getString("PACKAGE_LOCATION"));
                credencialesDhl.setReadyByTime(rs.getString("READY_BY_TIME"));
                credencialesDhl.setCloseTime(rs.getString("CLOSE_TIME"));
                credencialesDhl.setDoorTo(rs.getString("DOOR_TO"));
                credencialesDhl.setLevelOfDetails(rs.getString("LEVEL_OF_DETAILS"));
                credencialesDhl.setIdSap(rs.getString("ID_PROVEEDOR"));
            return credencialesDhl;
        }

    } 
}
