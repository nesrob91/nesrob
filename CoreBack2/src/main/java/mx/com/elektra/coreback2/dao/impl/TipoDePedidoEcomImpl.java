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
import mx.com.elektra.coreback2.beans.CajaRf;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DetalleSkus;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.dao.TipoDePedidoDao;
import mx.com.elektra.coreback2.dao.mapper.CajaRfMapper;
import mx.com.elektra.coreback2.dao.mapper.ContenidoMapper;
import mx.com.elektra.coreback2.dao.mapper.DetalleSkusMapper;
import mx.com.elektra.coreback2.dao.mapper.DimensionesQBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dparra
 */
@Repository("pedidoEcomDao")
public class TipoDePedidoEcomImpl implements TipoDePedidoDao{
    @Autowired
    private NamedParameterJdbcTemplate scpp ;
    @Autowired
    private NamedParameterJdbcTemplate wm18 ;
    
    @Override
    public boolean insertaContenidoCajaPorPaquete(Paquete paquete){
        
        int cantidadAfectados = 0;
        
        try{
            
            String sql = " INSERT INTO INFO_CD.PAQ_CTR_CAJAS_CONTENIDO "
                    + " ( "
                    + " ID_MANH, PEDIDO, ID_CAJA, ID_TIPO, ID_TIPO_PEDIDO, ID_SKU, DESC_SKU "
                    + " , DEPARTAMENTO, DESC_DEPARTAMENTO, SUBDEPARTAMENTO, DESC_SUBDEPARTAMENTO, MATKL, CLASE, DESC_CLASE, SUBCLASE, DESC_SUBCLASE "
                    + " , CANTIDAD, PESO, LARGO, ANCHO, ALTO, COSTO "
                    + " ) "
                    + " VALUES "
                    + " ( "
                    + " :idManh, :pedido, :idCaja, :idCanal, :idTipoPedido, :idSku, :descSku "
                    + " , :departamento, :descDepartamento, :subdepartamento, :descSubdepartamento, :subclase, :clase, :descClase, :subclase "
                    + " , :descSubclase, :cantidad, :peso, :largo, :ancho, :alto, :costo "
                    + " ) ";
            
            for(DetalleSkus d : paquete.getSkus()){
                
                Map<String, Object> parametros = new HashMap<String, Object>();
                parametros.put("idManh", paquete.getIdManh());
                parametros.put("pedido", paquete.getPedido());
                parametros.put("idCaja", paquete.getIdCaja());
                parametros.put("idCanal", paquete.getIdCanal());
                parametros.put("idTipoPedido", paquete.getIdTipoPedido());
                parametros.put("idSku", d.getSku().getIdSku());
                parametros.put("descSku", d.getSku().getDescSku());
                
                parametros.put("departamento", d.getSku().getIdDepartamento());
                parametros.put("descDepartamento", d.getSku().getDescDepartamento());
                parametros.put("subdepartamento", d.getSku().getIdSubdepartamento());
                parametros.put("descSubdepartamento", d.getSku().getDescSubdepartamento());
                parametros.put("clase", d.getSku().getIdClase());
                parametros.put("descClase", d.getSku().getDescClase());
                parametros.put("subclase", d.getSku().getIdSubclase());
                parametros.put("descSubclase", d.getSku().getDescSubclase());
                parametros.put("cantidad", d.getCantidad());
                parametros.put("peso", d.getSku().getPeso());
                parametros.put("largo", d.getSku().getLargo());
                parametros.put("ancho", d.getSku().getAncho());
                parametros.put("alto", d.getSku().getAlto());
                parametros.put("costo", d.getSku().getCostoUnitario());
                
                cantidadAfectados += scpp.update(sql, parametros);
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return cantidadAfectados > 0;
    }
    
    @Override
    public String getPedidoAlterno(Paquete paquete){
        
        String sql = " SELECT DISTINCT GD.SO "
                + " FROM INFO_CD.ECOM_CAJA_HDR CH "
                + " JOIN INFO_CD.ECOM_CAJA_DTL CD "
                + " ON CH.PKIDCAJAHDR = CD.FKIDCAJAHDR "
                + " JOIN INFO_CD.CE_CONTROL_GUIAS_DTL GD "
                + " ON CH.PKIDCAJAHDR = CD.FKIDCAJAHDR "
                + " AND GD.ID_LPN = CD.OLPN "
                + " AND CD.FKIDCAJAHDR  = GD.ID_CAJA "
                + " WHERE CH.ID_MANH = :idManh "
                + " AND CH.PKIDCAJAHDR = :idCaja "
                + " AND GD.SO IS NOT NULL "
                + " AND ROWNUM < 2 "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCaja", paquete.getIdCaja());
            
            return scpp.queryForObject(sql, parametros, String.class);
        } catch (Exception ex) {
            return null;
        }
        
        
    }
    
    @Override
    public String getCpDestino(Paquete paquete){
        
        String sql = " SELECT DISTINCT LPAD(TO_NUMBER(CP), 5, '0') CP "
                + " FROM INFO_CD.PED_CENT  "
                + " WHERE STORE_NBR = 9797 "
                + " AND WHSE = :idManh "
                + " AND CONTRAS = :pedido ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("pedido", paquete.getPedidoAlterno());
            
            return scpp.queryForObject(sql, parametros, String.class);
        } catch (Exception ex) {
            return null;
        }
        
    }
    
    @Override
    public String getCpOrigen(Paquete paquete){
        
        String sql = " SELECT ZT.POST_CODE1 CP "
                + " FROM INFO_CD.E3ALTWHS WHS "
                + " , INFO_CD.ZMTIENDAS ZT "
                + " WHERE WHS.ALMJD = ZT.ZSTRNUM "
                + " AND WHS.ALMMN = :idManh ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idManh", paquete.getIdManh());
            
            return scpp.queryForObject(sql, parametros, String.class);
        } catch (Exception ex) {
            return null;
        }
        
    }
    
    @Override
    public List<Contenido> getContenido(Paquete paquete) {
        String sql = " SELECT GD.ID_MANH "
                + " , GD.ID_SKU "
                + " , GD.CANTIDAD "
                + " , GD.ORDER_ID "
                + " , GD.ADN "
                + " , GD.ID_LPN "
                + " , GD.SO "
                + " , GD.NC"
                + " FROM INFO_CD.ECOM_CAJA_HDR CH "
                + " JOIN INFO_CD.ECOM_CAJA_DTL CD "
                + " ON CH.PKIDCAJAHDR = CD.FKIDCAJAHDR "
                + " JOIN INFO_CD.CE_CONTROL_GUIAS_DTL GD "
                + " ON CH.PKIDCAJAHDR = CD.FKIDCAJAHDR "
                + " AND GD.ID_LPN = CD.OLPN "
                + " AND CD.FKIDCAJAHDR  = GD.ID_CAJA "
                + " WHERE CH.FKIDESTATUS <> 5 "
                + " AND CH.PKIDCAJAHDR = :idCaja "
                + " AND CH.ID_MANH = :idManh "
                + " AND CH.ID_TIPO_PEDIDO = :idTipoPedido ";

        try {
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());

            return scpp.query(sql, parametros, new ContenidoMapper());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<DetalleSkus> getDetalleSkus(Paquete paquete, String esquema) {

        try {

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
                    + ", (ICB.UNIT_LENGTH * 100) LARGO "
                    + ", (ICB.UNIT_WIDTH * 100) ANCHO "
                    + ", (ICB.UNIT_HEIGHT * 100) ALTO "
                    + ", 0 COSTO "
                    + ", (CASE WHEN NVL(LD.SIZE_VALUE, 0) = 0 THEN LD.INITIAL_QTY ELSE LD.SIZE_VALUE END) CANTIDAD "
                    + "FROM "+esquema+".LPN L "
                    + "JOIN "+esquema+".LPN_DETAIL LD "
                    + "ON L.LPN_ID = LD.LPN_ID "
                    + "JOIN "+esquema+".ITEM_CBO ICB "
                    + "ON LD.ITEM_ID = ICB.ITEM_ID "
                    + "WHERE INBOUND_OUTBOUND_INDICATOR = 'O' "
                    + "AND C_FACILITY_ALIAS_ID = :idManh "
                    + "AND TC_LPN_ID = :idLpn ";

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idLpn", paquete.getIdLpn());
            parametros.put("idManh", paquete.getIdManh());

            return wm18.query(sql, parametros, new DetalleSkusMapper());

        } catch (Exception ex) {

            return null;
        }
    }

    @Override
    public List<DetalleSkus> getDetalleSkusRf(Paquete paquete, String esquema, List<String> lpns) {

        try {

            String sql = " SELECT ZI.INUMBER ID_SKU "
                    + "  , ZI.MAKTX DESC_SKU "
                    + " , ZC.ZN1NCL DEPARTAMENTO "
                    + " , ZC.ZN1CLAS DESC_DEPARTAMENTO "
                    + " , ZC.ZN2NCL SUBDEPARTAMENTO "
                    + " , ZC.ZN2CLAS DESC_SUBDEPARTAMENTO "
                    + " , ZC.ZN3NCL CLASE "
                    + " , ZC.ZN3CLAS DESC_CLASE "
                    + " , ZI.MATKL SUBCLASE "
                    + " , ZC.WGBEZ DESC_SUBCLASE "
                    + " , ZI.BRGEW PESO "
                    + " , (ZI.LAENG * 100) LARGO "
                    + " , (ZI.BREIT * 100) ANCHO "
                    + " , (ZI.HOEHE * 100) ALTO "
                    + " , zi.ZHCOST COSTO "
                    + " , GD.CANTIDAD "
                    + " FROM INFO_CD.Z_INVMST ZI "
                    + " JOIN INFO_CD.ZMCLAS_SAP ZC "
                    + " ON ZI.MATKL = ZC.MATKL "
                    + " JOIN INFO_CD.CE_CONTROL_GUIAS_DTL GD "
                    + " ON ZI.INUMBER = GD.ID_SKU "
                    + " JOIN INFO_CD.ECOM_CAJA_HDR CH "
                    + " ON GD.ID_CAJA = CH.PKIDCAJAHDR "
                    + " JOIN INFO_CD.ECOM_CAJA_DTL CD " 
                    + " ON CH.PKIDCAJAHDR = CD.FKIDCAJAHDR "
                    + " AND GD.ID_LPN = CD.OLPN "
                    + " WHERE GD.ID_CAJA = :idCaja "
                    + " AND CH.ID_MANH = :idManh "
                    ;

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());

            return scpp.query(sql, parametros, new DetalleSkusMapper());

        } catch (Exception ex) {

            return null;
        }
        
        /*
        
        try {

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
                    + ", (ICB.UNIT_LENGTH * 100) LARGO "
                    + ", (ICB.UNIT_WIDTH * 100) ANCHO "
                    + ", (ICB.UNIT_HEIGHT * 100) ALTO "
                    + ", 0 COSTO "
                    + ", (CASE WHEN NVL(LD.SIZE_VALUE, 0) = 0 THEN LD.INITIAL_QTY ELSE LD.SIZE_VALUE END) CANTIDAD "
                    + "FROM "+esquema+".LPN L "
                    + "JOIN "+esquema+".LPN_DETAIL LD "
                    + "ON L.LPN_ID = LD.LPN_ID "
                    + "JOIN "+esquema+".ITEM_CBO ICB "
                    + "ON LD.ITEM_ID = ICB.ITEM_ID "
                    + "WHERE INBOUND_OUTBOUND_INDICATOR = 'O' "
                    + "AND C_FACILITY_ALIAS_ID = :idManh "
                    + "AND TC_LPN_ID IN (:idLpns) ";

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idLpns", ((lpns == null || lpns.isEmpty()) ? getLpnsByCaja(paquete.getIdCaja(), paquete.getIdManh()) : lpns));
            parametros.put("idManh", paquete.getIdManh());

            return wm18.query(sql, parametros, new DetalleSkusMapper());

        } catch (Exception ex) {

            return null;
        }
        
        */
    }
    
    @Override
    public CajaRf getCajaRf(int idManh, int idCaja, int idTipoPedido){
        String sql = " SELECT (CASE WHEN C.PKIDCONTENEDOR in (11, 12) THEN 1 ELSE 0 END) EMPAQUE_PROPIO\n" +
            ", C.LARGO\n" +
            ", C.ANCHO\n" +
            ", C.ALTO\n" +
            ", C.PKIDCONTENEDOR ID_TIPO_CAJA\n" +
            "FROM  INFO_CD.ECOM_CAJA_HDR H\n" +
            ", INFO_CD.ECOM_CAT_CONTENEDOR C\n" +
            "WHERE H.FKIDCONTENEDOR = C.PKIDCONTENEDOR\n" +
            "AND H.ID_TIPO_PEDIDO = C.ID_TIPO_PEDIDO\n" +
            "AND H.ID_TIPO_PEDIDO = :idTipoPedido \n" +
            "AND H.ID_MANH = :idManh \n" +
            "AND H.PKIDCAJAHDR = :idCaja ";
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idManh", idManh);
            parametros.put("idCaja", idCaja);
            parametros.put("idTipoPedido", idTipoPedido);

            return scpp.queryForObject(sql, parametros, new CajaRfMapper());
        } catch (Exception ex) {
            return null;
        }
    }
    
    @Override
    public DimensionesQB getDimensionesPaquete(int idManh, String idLpn, String esquema) {
        String sql = " SELECT (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_LENGTH ELSE CNT.LEN END) LARGO "
                + " , (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_WIDTH ELSE CNT.WIDTH END) ANCHO "
                + " , (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_HEIGHT ELSE CNT.HT END) ALTO "
                + " , ((CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_LENGTH ELSE CNT.LEN END) "
                + " * (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_WIDTH ELSE CNT.WIDTH END) "
                + " * (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_HEIGHT ELSE CNT.HT END)) VOLUMEN "
                + " , ((CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_LENGTH ELSE CNT.LEN END) "
                + " * (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_WIDTH ELSE CNT.WIDTH END) "
                + " * (CASE WHEN CNT.MAX_CNTR_UNITS = 1 THEN ICB.UNIT_HEIGHT ELSE CNT.HT END)) / 5000 PESO_VOLUMETRICO "
                + " , SUM(ICB.UNIT_WEIGHT * (CASE WHEN NVL(LD.SIZE_VALUE, 0) = 0 THEN LD.INITIAL_QTY ELSE LD.SIZE_VALUE END)) PESO_FISICO "
                + " FROM "+esquema+".LPN L "
                + " JOIN "+esquema+".LPN_DETAIL LD "
                + " ON L.LPN_ID = LD.LPN_ID "
                + " JOIN "+esquema+".ITEM_CBO ICB "
                + " ON LD.ITEM_ID = ICB.ITEM_ID "
                + " JOIN "+esquema+".CNTR_TYPE CNT "
                + " ON L.CONTAINER_TYPE = CNT.CNTR_TYPE "
                + " WHERE L.TC_LPN_ID = :idLpn "
                + " AND L.C_FACILITY_ALIAS_ID = :idManh "
                + " GROUP BY CNT.LEN "
                + ", CNT.WIDTH "
                + ", CNT.HT "
                + ", CNT.MAX_CNTR_UNITS "
                + ", ICB.UNIT_LENGTH "
                + ", ICB.UNIT_WIDTH "
                + ", ICB.UNIT_HEIGHT ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idLpn", idLpn);
            parametros.put("idManh", idManh);

            return wm18.queryForObject(sql, parametros, new DimensionesQBMapper());
        } catch (Exception ex) {

            return null;
        }
    }

    @Override
    public Double getVolumenUtilizadoCaja(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFolioControl(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
