/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.api.trknbr.beans.Contacto;
import mx.com.api.trknbr.beans.DetalleSkus;
import mx.com.api.trknbr.beans.GuiaRequest;
import mx.com.api.trknbr.configuration.ConfigBean;
import mx.com.api.trknbr.dao.mappers.ContactoMapper;
import mx.com.api.trknbr.dao.mappers.DetalleSkusMapper;
import mx.com.api.trknbr.dao.mappers.GuiaRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nroblerol
 */
@Repository("pedidoDaoEcom")
public class PedidoDaoEcom implements PedidoDao{
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private NamedParameterJdbcTemplate sccpConnection;
    @Autowired
    private NamedParameterJdbcTemplate wm18Connection;

    @Override
    public List<Map<String, Object>> getPedido(List<String> contenido, int idManh, String idLpn, int tipoPedido) {
        String sql = " SELECT O.EXT_PURCHASE_ORDER "
                + " FROM WMECOM18DM.ORDERS O "
                + " JOIN WMECOM18DM.LPN L "
                + " ON L.TC_ORDER_ID = O.TC_ORDER_ID "
                + " AND L.C_FACILITY_ALIAS_ID = O.O_FACILITY_ALIAS_ID "
                + " AND L.TC_LPN_ID = :idLpn "
                + " AND O.O_FACILITY_ALIAS_ID = :idManh " ;
        
        Map<String, Object> parametros = new HashMap<>();
        try {

        parametros.put("idLpn", idLpn);
        parametros.put("idManh", idManh);

        return wm18Connection.queryForList(sql, parametros);

        } catch (Exception ex) {
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            try{
                logger.insertaError(
                    1010000
                    , 10
                    , idManh
                    , null
                    , idLpn
                    , 0
                    , null
                    , null
                    , 0
                    , 0
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            return null;
        }
    }

    @Override
    public GuiaRequest getDimensiones(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido, String idLpn) {
        String sql = " SELECT :pedido PEDIDO "
                 + " , L.C_FACILITY_ALIAS_ID ID_MANH "
                 + " , :idCaja ID_CAJA "
                 + " , L.TC_LPN_ID ID_LPN "
                 + " , :idCarrier ID_CARRIER "
                 + " , :idCanal ID_TIPO "
                 + " , :idTipoPedido ID_TIPO_PEDIDO "
                 + " , (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_LENGTH ELSE CNT.LEN END) LARGO "
                 + " , (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_WIDTH ELSE CNT.WIDTH END) ANCHO "
                 + " , (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_HEIGHT ELSE CNT.HT END) ALTO "
                 + " , (CASE WHEN "
                 + " (((CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_LENGTH ELSE CNT.LEN END) "
                 + " * (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_WIDTH ELSE CNT.WIDTH END) "
                 + " * (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_HEIGHT ELSE CNT.HT END)"
                 + " ) / 5000) "
                 + " >"
                 + " (SUM(ICB.UNIT_WEIGHT * (CASE WHEN NVL(LD.SIZE_VALUE, 0) = 0 THEN LD.INITIAL_QTY ELSE LD.SIZE_VALUE END)))"
                 + " THEN "
                 + " (((CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_LENGTH ELSE CNT.LEN END) "
                 + " * (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_WIDTH ELSE CNT.WIDTH END) "
                 + " * (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_HEIGHT ELSE CNT.HT END)"
                 + " ) / 5000) "
                 + " ELSE"
                 + " (SUM(ICB.UNIT_WEIGHT * (CASE WHEN NVL(LD.SIZE_VALUE, 0) = 0 THEN LD.INITIAL_QTY ELSE LD.SIZE_VALUE END)))"
                 + " END) PESO"
                 + " FROM WMECOM18DM.LPN L "
                 + " JOIN WMECOM18DM.LPN_DETAIL LD "
                 + " ON L.LPN_ID = LD.LPN_ID "
                 + " JOIN WMECOM18DM.ITEM_CBO ICB "
                 + " ON LD.ITEM_ID = ICB.ITEM_ID "
                 + " JOIN WMECOM18DM.CNTR_TYPE CNT "
                 + " ON L.CONTAINER_TYPE = CNT.CNTR_TYPE "
                 + " WHERE L.TC_LPN_ID = :idLpn "
                 + " AND L.C_FACILITY_ALIAS_ID = :idManh "
                 + " GROUP BY L.C_FACILITY_ALIAS_ID "
                 + " , L.TC_LPN_ID "
                 + " , CNT.LEN  "
                 + " , CNT.WIDTH  "
                 + " , CNT.HT "
                 + " , CNT.MAX_CNTR_UNITS "
                 + " , ICB.UNIT_LENGTH "
                 + " , ICB.UNIT_WIDTH "
                 + " , ICB.UNIT_HEIGHT  " ;
        Map<String, Object> parametros = new HashMap<String, Object>();
        try {
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("idCanal", idCanal);
            parametros.put("idTipoPedido", idTipoPedido);
            parametros.put("idManh", idManh);
            parametros.put("idCaja", idCaja);
            parametros.put("pedido", pedido);
            parametros.put("idLpn", idLpn);
            
            return wm18Connection.queryForObject(sql, parametros, new GuiaRequestMapper());
        } catch (Exception ex) {
            try{
                logger.insertaError(
                    1010001
                    , 10
                    , idManh
                    , null
                    , pedido
                    , idCaja
                    , idCarrier
                    , null
                    , idCanal
                    , idTipoPedido
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            return null;
        }

    }

    @Override
    public Contacto getOrigenPedido(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido) {
        String sql = " SELECT DISTINCT lpad(to_number(ZT.POST_CODE1),5,'0')  CP_ORIGEN "
                    + " , ZT.STREET DIRECCION_ORIGEN "
                    //modify - check for real dir number - check usage in request creation
                    + " , 0 NUMERO_INT_ORIGEN, 0 NUMERO_EXT_ORIGEN "
                    + " , ZT.REGION CIUDAD_ORIGEN "
                    + " , 'ELEKTRA DEL MILENIO S.A. DE CV.' CONTACTO_ORIGEN "
                    + " , 'ELEKTRA DEL MILENIO S.A. DE CV.' RAZON_SOCIAL_ORIGEN  "
                    + " , ZT.ZCOLONIA COLONIA_ORIGEN "
                    + " , ZT.ZESTADOJDA ESTADO_ORIGEN  "
                    + " , 0 ID_ESTADO_ORIGEN  "
                    + " , 0000000000 TELEFONO_ORIGEN "
                    + " FROM INFO_CD.PED_CENT P "
                    + " , INFO_CD.ZMTIENDAS ZT "
                    + " , INFO_CD.E3ALTWHS WHS "
                    + " , INFO_CD.CE_CAT_CP_CDS CP "
                    + " WHERE P.WHSE = WHS.ALMMN "
                    + " AND P.WHSE = CP.CD_ID "
                    + " AND ZT.ZSTRNUM = WHS.ALMJD "
                    + " --AND P.STORE_NBR = 9797 "
                    + ((pedido.startsWith("v")) ? " AND P.CONTRAS = :pedido  " : " AND P.CONTRAS LIKE 'v' || :pedido || '%' ")
                    + " AND P.WHSE = :idManh ";
        Map<String, Object> parametros = new HashMap<String, Object>();
         try {
            
            parametros.put("pedido", pedido);
            parametros.put("idManh", idManh);
            
            return sccpConnection.queryForObject(sql, parametros, new ContactoMapper());

        } catch (Exception ex) {
            
            try{
                logger.insertaError(
                    1010002
                    , 10
                    , idManh
                    , null
                    , pedido
                    , idCaja
                    , idCarrier
                    , null
                    , idCanal
                    , idTipoPedido
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
        }

         return null;
    }

    @Override
    public Contacto getDestinoPedido(String pedido, int idCaja, int idManh, int idCarrier, int idCanal, int idTipoPedido) {
        String sql = " SELECT DISTINCT lpad(to_number(P.CP),5,'0') CP_DESTINO "
                    //modify - if necessary - dir split
                    + " , TRIM(P.CALLE) DIRECCION_DESTINO "
                    + " , P.NUMERO NUMERO_EXT_DESTINO, (CASE WHEN NUMERINT IS NOT NULL THEN P.NUMERINT ELSE '0' END) NUMERO_INT_DESTINO"
                    + " , TRIM(P.CIZQUIE) CIUDAD_DESTINO"
                    + " , TRIM(P.NOMBCL)||' '||TRIM(P.APEPCL)||' '||TRIM(P.APEMCL) CONTACTO_DESTINO "
                    + " , TRIM(P.NOMBCL)||' '||TRIM(P.APEPCL)||' '||TRIM(P.APEMCL) RAZON_SOCIAL_DESTINO "
                    + " , TRIM(P.COLONIA)  COLONIA_DESTINO "
                    + " , TRIM(P.CIZQUIE) ESTADO_DESTINO "
                    + " , CP.ID_ESTADO ID_ESTADO_DESTINO "
                    + " , P.TELEFONO TELEFONO_DESTINO "
                    + " FROM INFO_CD.PED_CENT P "
                    + " , INFO_CD.ZMTIENDAS ZT "
                    + " , INFO_CD.E3ALTWHS WHS "
                    + " , INFO_CD.CE_CAT_CP_CDS CP "
                    + " WHERE P.WHSE = WHS.ALMMN "
                    + " AND P.WHSE = CP.CD_ID "
                    + " AND ZT.ZSTRNUM = WHS.ALMJD "
                    + " --AND P.STORE_NBR = 9797 "
                    + ((pedido.startsWith("v")) ? " AND P.CONTRAS = :pedido  " : " AND P.CONTRAS LIKE 'v' || :pedido || '%' ")
                    + " AND P.WHSE = :idManh ";
        Map<String, Object> parametros = new HashMap<String, Object>();
         try {
            
            parametros.put("pedido", pedido);
            parametros.put("idManh", idManh);
            
            return sccpConnection.queryForObject(sql, parametros, new ContactoMapper());

        } catch (Exception ex) {
            
            try{
                logger.insertaError(
                    1010002
                    , 10
                    , idManh
                    , null
                    , pedido
                    , idCaja
                    , idCarrier
                    , null
                    , idCanal
                    , idTipoPedido
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
        }

         return null;
    }

    @Override
    public Contacto getOrigenPedidoWs(String pedido, int idCaja, int idManh, int cdVendor, int idCarrier, int idCanal, int idTipoPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleSkus> getDetalleSkus(GuiaRequest guiaRequest) {
        String sql = " SELECT ICB.ITEM_NAME ID_SKU "
                + " , ICB.DESCRIPTION DESC_SKU "
                + " , ICB.REF_FIELD4 DEPARTAMENTO "
                + " , NULL DESC_DEPARTAMENTO "
                + " , ICB.REF_FIELD5 SUBDEPARTAMENTO "
                + ", NULL DESC_SUBDEPARTAMENTO "
                + ", ICB.REF_FIELD6 CLASE "
                + ", NULL DESC_CLASE "
                + ", ICB.REF_FIELD7 SUBCLASE "
                + ", NULL DESC_SUBCLASE "
                + ", ICB.UNIT_WEIGHT PESO "
                + ", ICB.UNIT_LENGTH LARGO "
                + ", ICB.UNIT_WIDTH ANCHO "
                + ", ICB.UNIT_HEIGHT ALTO "
                + ", 0 COSTO "
                + ", LD.SIZE_VALUE CANTIDAD "
                + "FROM WMECOM18DM.LPN L "
                + "JOIN WMECOM18DM.LPN_DETAIL LD "
                + "ON L.LPN_ID = LD.LPN_ID "
                + "JOIN WMECOM18DM.ITEM_CBO ICB "
                + "ON LD.ITEM_ID = ICB.ITEM_ID "
                + "WHERE INBOUND_OUTBOUND_INDICATOR = 'O' "
                + "AND C_FACILITY_ALIAS_ID = :idManh "
                + "AND TC_LPN_ID = :idLpn ";
        Map<String, Object> parametros = new HashMap<String, Object>();
        try {
        
        parametros.put("idLpn", guiaRequest.getIdLpn());
        parametros.put("idManh", guiaRequest.getIdManh());

        return sccpConnection.query(sql, parametros, new DetalleSkusMapper());

        } catch (Exception ex) {
            
            try{
                logger.insertaError(
                    1010006
                    , 10
                    , guiaRequest.getIdManh()
                    , null
                    , guiaRequest.getPedido()
                    , guiaRequest.getIdCaja()
                    , guiaRequest.getIdCarrier()
                    , null
                    , guiaRequest.getIdCanal()
                    , guiaRequest.getIdTipoPedido()
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            return null;
        }
    }

    @Override
    public String getOrderId(GuiaRequest guiaRequest, List<String> nc) {
        String sql = "SELECT TC_ORDER_ID "
                + " FROM WMECOM18DM.LPN "
                + " WHERE INBOUND_OUTBOUND_INDICATOR = 'O' "
                + " AND C_FACILITY_ALIAS_ID = :idManh "
                + " AND TC_LPN_ID = :idLpn ";
        
                    
            Map<String, Object> parametros = new HashMap<String, Object>();
        try {
        
            parametros.put("idManh", guiaRequest.getIdManh());
            parametros.put("idLpn", guiaRequest.getIdLpn());

            return sccpConnection.queryForObject(sql, parametros, String.class);
        } catch (Exception ex) {
            
            try{
                logger.insertaError(
                    1010003
                    , 10
                    , guiaRequest.getIdManh()
                    , null
                    , guiaRequest.getPedido()
                    , guiaRequest.getIdCaja()
                    , guiaRequest.getIdCarrier()
                    , null
                    , guiaRequest.getIdCanal()
                    , guiaRequest.getIdTipoPedido()
                    , ex.toString()
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
            }catch(Exception e){}
            if(conf.isWriteAll())
                System.out.println("Error : "+ex.getMessage());
            return null;
        }
    }

    @Override
    public List<String> getNCbyAdn(int idCaja, int idManh) {
        return null;
    }
    
}
