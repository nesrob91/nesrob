package mx.com.api.trknbr.dao;

import com.elektra.cadsumutils.dao.DataSources;
import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import mx.com.api.trknbr.beans.CredencialesEstafeta;
import mx.com.api.trknbr.configuration.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nroblerol
 */
@Repository("credencialesEstafeta")
public class CredencialesDaoEstafeta implements CredencialesDao{
     
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private NamedParameterJdbcTemplate sccpConnection;
    
    @Override
    public Object getCredenciales(int idCarrier, int idServicio, int idTipPed){
        
        String sqlEstafeta = " SELECT ref_field_3 PAPER_TYPE " 
                + " , 'Paquete Elektra' CONTENT " 
                + " , 0 DELIVERY_TO_ESTAFETA_OFFICE " 
                + " , 1 NUMBER_OF_LABELS " 
                + " , 4 PARCEL_TYPE "
                + " , 0 RETURN_DOCUMENT " 
                + " , C.USUARIO " 
                + " , C.CONTRASENIA " 
                + " , C.NUM_OFI "
                + " , C.ID_SUSCRIPTOR " 
                + " , C.NUMCTE " 
                + " , C.SERVICE_TYPE_ID " 
                + " , C.SERVICE_TYPE_DOC_RET " 
                + " , TO_CHAR(CURRENT_TIMESTAMP+8,'YYYYMMDD') EFFECTIVE_DATE " 
                + ", nvl(ID_PROVEEDOR, 0) ID_PROVEEDOR "
                + " FROM INFO_CD.CE_CREDENCIALES_WS C " 
                + " WHERE C.ID_CARRIER =   :carrier   " 
                + " AND C.ID_SERVICIO =   :tipserv   " 
                + " AND ID_TIPO_PEDIDO =   :idTipPed   "  ;

        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("idCarrier", idCarrier);
        parametros.put("idServicio", idServicio);
        parametros.put("idTipPed", idTipPed);
        try{
            return sccpConnection.queryForObject(sqlEstafeta, parametros, new CredencialesEstafetaMapper());
            
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
    
    private static final class CredencialesEstafetaMapper implements RowMapper<CredencialesEstafeta> {
        
        @Override
        public CredencialesEstafeta mapRow(ResultSet rs, int i) throws SQLException {
            CredencialesEstafeta credencialesEstafeta = new CredencialesEstafeta();
        
                credencialesEstafeta.setPaperType(rs.getString("PAPER_TYPE"));
                credencialesEstafeta.setContent(rs.getString("CONTENT"));
                credencialesEstafeta.setDeliveryToEstafeta(rs.getBoolean("DELIVERY_TO_ESTAFETA_OFFICE"));
                credencialesEstafeta.setNumberOfLabels(rs.getInt("NUMBER_OF_LABELS"));
                credencialesEstafeta.setParcelType(rs.getInt("PARCEL_TYPE"));
                credencialesEstafeta.setReturnDocument(rs.getBoolean("RETURN_DOCUMENT"));
                credencialesEstafeta.setUsuario(rs.getString("USUARIO"));
                credencialesEstafeta.setContrasenia(rs.getString("CONTRASENIA"));
                credencialesEstafeta.setNumOfi(rs.getString("NUM_OFI"));
                credencialesEstafeta.setIdSuscriptor(rs.getString("ID_SUSCRIPTOR"));
                credencialesEstafeta.setNumcte(rs.getString("NUMCTE"));
                credencialesEstafeta.setServiceTypeId(rs.getString("SERVICE_TYPE_ID"));
                credencialesEstafeta.setServiceTypeDocRet(rs.getString("SERVICE_TYPE_DOC_RET"));
                credencialesEstafeta.setEffectiveDate(rs.getString("EFFECTIVE_DATE"));
                credencialesEstafeta.setIdSap(rs.getString("ID_PROVEEDOR"));
                
            return credencialesEstafeta;
        }
    }

}
