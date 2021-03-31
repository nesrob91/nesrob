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
import mx.com.api.trknbr.beans.CredencialesFedex;
import mx.com.api.trknbr.configuration.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("credencialesFedex")
public class CredencialesDaoFedex implements CredencialesDao{
     
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private NamedParameterJdbcTemplate sccpConnection;
    
    @Override
    public Object getCredenciales(int idCarrier, int idServicio, int idTipPed){
        
        String sqlFedex = " SELECT USUARIO KEY"
                + " , CONTRASENIA PASSWORD "
                + " , NUMCTE ACCOUNT_NUMBER "
                + " , ID_SUSCRIPTOR  METER_NUMBER "
                + " , 'ES' LANGUAGE_CODE "
                + " , 'MX' LOCAL_CODE "
                + " , SERVICE_TYPE_DOC_RET SERVICE_ID "
                + " , REF_FIELD_3 MAJOR"
                + " , 0 INTERMEDIATE"
                + " , 0 MINOR "
                + " , (TO_CHAR(SYSDATE +1, 'YYYY-MM-DD') ||'T'||TO_CHAR(SYSDATE, 'HH24:MI:SS'))SHIP_TIME_STAMP "
                + " , SERVICE_TYPE_ID DROPOFF_TYPE "
                + " , SERVICE_TYPE "
                + " , 'YOUR_PACKAGING' PACKAGING_TYPE "
                + " , 'KG' UNITS"
                + " , 'COMMON_2_D' LABEL_FORMAT_TYPE"
                + " , REF_FIELD_2 IMAGE_TYPE "
                + " , 'STOCK_4_X_8' LABEL_STOCK_TYPE"
                + " , 'CM' DIMENSION_UNITS "
                + " , 'SENDER' PAYMENT_TYPE"
                + " , 'SHIPPER' ROLE "
                + " , nvl(ID_PROVEEDOR, 0) ID_PROVEEDOR " 
                + " FROM INFO_CD.CE_CREDENCIALES_WS "
                + " WHERE ID_CARRIER = :idCarrier "
                + " AND ID_SERVICIO = :idServicio "
                + " AND ID_TIPO_PEDIDO =   :idTipPed   "  ;

        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("idCarrier", idCarrier);
        parametros.put("idServicio", idServicio);
        parametros.put("idTipPed", idTipPed);
        try{
            return sccpConnection.queryForObject(sqlFedex, parametros, new CredencialesFedexMapper());
            
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
    
    private static final class CredencialesFedexMapper implements RowMapper<CredencialesFedex> {

        @Override
        public CredencialesFedex mapRow(ResultSet rs, int i) throws SQLException {
            CredencialesFedex credencialesFedex = new CredencialesFedex();
            
            credencialesFedex.setKey(rs.getString("KEY"));
                credencialesFedex.setPassword(rs.getString("PASSWORD"));
                credencialesFedex.setAccountNumber(rs.getString("ACCOUNT_NUMBER"));
                credencialesFedex.setMeterNumber(rs.getString("METER_NUMBER"));
                credencialesFedex.setLanguageCode(rs.getString("LANGUAGE_CODE"));
                credencialesFedex.setLocalCode(rs.getString("LOCAL_CODE"));
                credencialesFedex.setServiceId(rs.getString("SERVICE_ID"));
                credencialesFedex.setMajor(rs.getString("MAJOR"));
                credencialesFedex.setIntermediate(rs.getString("INTERMEDIATE"));
                credencialesFedex.setMinor(rs.getString("MINOR"));
                credencialesFedex.setShipTimeStamp(rs.getString("SHIP_TIME_STAMP"));
                credencialesFedex.setDropOffType(rs.getString("DROPOFF_TYPE"));
                credencialesFedex.setServiceType(rs.getString("SERVICE_TYPE"));
                credencialesFedex.setPackagingType(rs.getString("PACKAGING_TYPE"));
                credencialesFedex.setUnits(rs.getString("UNITS"));
                credencialesFedex.setLabelFormatType(rs.getString("LABEL_FORMAT_TYPE"));
                credencialesFedex.setImageType(rs.getString("IMAGE_TYPE"));
                credencialesFedex.setLabelStockType(rs.getString("LABEL_STOCK_TYPE"));
                credencialesFedex.setDimensionUnits(rs.getString("DIMENSION_UNITS"));
                credencialesFedex.setPaymentType(rs.getString("PAYMENT_TYPE"));
                credencialesFedex.setRole(rs.getString("ROLE"));    
                credencialesFedex.setIdSap(rs.getString("ID_PROVEEDOR"));    
            return credencialesFedex;
        }

    } 

}
