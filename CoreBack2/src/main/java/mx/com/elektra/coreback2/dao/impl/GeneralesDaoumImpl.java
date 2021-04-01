/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.coreback2.beans.CarrierQB;
import mx.com.elektra.coreback2.beans.DetalleSkus;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.FamiliaSap;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Pedido;
import mx.com.elektra.coreback2.beans.Regla;
import mx.com.elektra.coreback2.beans.ResultadoEvaluacion;
import mx.com.elektra.coreback2.beans.Sku;
import mx.com.elektra.coreback2.config.application;
import mx.com.elektra.coreback2.dao.GeneralesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dparra
 */
@Repository("generalesDaoUm")
public class GeneralesDaoumImpl implements GeneralesDao {
    @Autowired
    private NamedParameterJdbcTemplate wm18 ;
    @Autowired
    private NamedParameterJdbcTemplate um ;
    @Autowired
    private application app;
    
    @Override
    public String getEsquema(int idManh){
        String sql = " select grupo\n" +
"from info_cd.ekt_cat_almacen\n" +
"where id_manh = :idManh ";
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idManh", idManh);

            return um.queryForObject(sql, parametros, String.class);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public boolean isCajaExistente(int idManh, String idLpn){
        String sql = " SELECT COUNT(*) "
                + " FROM INFO_CD.ECOM_CAJA_HDR CH "
                + " JOIN INFO_CD.ECOM_CAJA_DTL CD "
                + " ON CH.PKIDCAJAHDR = CD.FKIDCAJAHDR "
                + " WHERE ID_MANH = :idManh "
                + " AND CD.OLPN = :idLpn "
                + " AND CH.FKIDESTATUS <> 5 ";
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idLpn", idLpn);
            parametros.put("idManh", idManh);

            return um.queryForObject(sql, parametros, Integer.class) > 0;
        } catch (Exception ex) {
            return false;
        }
    }
    
    @Override
    public int getIdCajaByLpn(int idManh, String idLpn){
        String sql = " SELECT NVL(MAX(CH.PKIDCAJAHDR), 0) ID_CAJA "
                + " FROM INFO_CD.ECOM_CAJA_HDR CH "
                + " JOIN INFO_CD.ECOM_CAJA_DTL CD "
                + " ON CH.PKIDCAJAHDR = CD.FKIDCAJAHDR "
                + " WHERE ID_MANH = :idManh "
                + " AND CD.OLPN = :idLpn "
                + " AND CH.FKIDESTATUS <> 5 ";
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idLpn", idLpn);
            parametros.put("idManh", idManh);

            return um.queryForObject(sql, parametros, Integer.class);
        } catch (Exception ex) {
            return 0;
        }
    }
    
    @Override
    public boolean isLpnDifCantInicialVSEmpacado(int idManh, String idLpn, String esquema){
        String sql = "SELECT COUNT(*) "
                + " FROM "+esquema+".LPN L "
                + " JOIN "+esquema+".LPN_DETAIL LD "
                + " ON L.LPN_ID = LD.LPN_ID "
                + " WHERE L.C_FACILITY_ALIAS_ID = :idManh "
                + " AND L.TC_LPN_ID = :idLpn "
                + " AND LD.INITIAL_QTY <> LD.SIZE_VALUE ";
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idLpn", idLpn);
            parametros.put("idManh", idManh);

            return wm18.queryForObject(sql, parametros, Integer.class) > 0;
        } catch (Exception ex) {
            return false;
        }
    }
    
    @Override
    public DimensionesQB getDimensionesLpnEvaluado(int idManh, String idLpn){
        String sql = " SELECT DISTINCT LARGO "
                + " , ANCHO "
                + " , ALTO "
                + " , VOLUMEN "
                + " , PESO_VOLUMETRICO "
                + " , PESO_FISICO "
                + " FROM INFO_CD.ECOM_CB_HDR "
                + " WHERE CD_ID = :idManh "
                + " AND ID_LPN = :idLpn ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idManh", idManh);
            parametros.put("idLpn", idLpn);
            
            return um.queryForObject(sql, parametros, new DimensionesQBMapper());
        } catch (Exception ex) {

            return null;
        }
    }
    
    
    
    @Override
    public DimensionesQB getDimensionesPaquete2018Rf(int idManh, int idCaja, int idTipoPedido) {
        String sql = " SELECT MAX(ZI.LAENG) * 100 LARGO "
                + " , MAX(ZI.BREIT) * 100 ANCHO "
                + " , MAX(ZI.HOEHE) * 100 ALTO "
                + " , ((MAX(ZI.LAENG) * 100)"
                + " * (MAX(ZI.BREIT)* 100) "
                + " * (MAX(ZI.HOEHE)* 100)) VOLUMEN "
                + " , ((MAX(ZI.LAENG) * 100) "
                + " * (MAX(ZI.BREIT)* 100) "
                + " * (MAX(ZI.HOEHE)* 100)) / 5000 PESO_VOLUMETRICO "
                + " , SUM(ZI.BRGEW * GD.CANTIDAD) PESO_FISICO "
                + " FROM INFO_CD.Z_INVMST ZI"
                + " JOIN INFO_CD.CE_CONTROL_GUIAS_DTL GD "
                + " ON ZI.INUMBER = GD.ID_SKU "
                + " JOIN INFO_CD.ECOM_CAJA_HDR CH "
                + " ON GD.ID_CAJA = CH.PKIDCAJAHDR "
                + " AND CH.ID_TIPO_PEDIDO = GD.ID_TIPO_PEDIDO "
                + " JOIN INFO_CD.ECOM_CAJA_DTL CD "
                + " ON GD.ID_LPN = CD.OLPN "
                + " AND CH.PKIDCAJAHDR = CD.FKIDCAJAHDR "
                + " WHERE GD.ID_CAJA = :idCaja "
                + " AND CH.ID_MANH = :idManh "
                + " AND GD.ID_TIPO_PEDIDO = :idTipoPedido "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idCaja", idCaja);
            parametros.put("idManh", idManh);
            parametros.put("idTipoPedido", idTipoPedido);

            return um.queryForObject(sql, parametros, new DimensionesQBMapper());
        } catch (Exception ex) {

            return null;
        }
        
        
        /*
        
        String sql = " SELECT MAX(ICB.UNIT_LENGTH) * 100 LARGO \n" +
" , MAX(ICB.UNIT_WIDTH) * 100 ANCHO \n" +
" , MAX(ICB.UNIT_HEIGHT) * 100 ALTO \n" +
" , ((MAX(ICB.UNIT_LENGTH) * 100)\n" +
" * (MAX(ICB.UNIT_WIDTH)* 100) \n" +
" * (MAX(ICB.UNIT_HEIGHT)* 100)) VOLUMEN \n" +
" , ((MAX(ICB.UNIT_LENGTH) * 100)\n" +
" * (MAX(ICB.UNIT_WIDTH)* 100) \n" +
" * (MAX(ICB.UNIT_HEIGHT)* 100)) / 5000 PESO_VOLUMETRICO \n" +
" , SUM(ICB.UNIT_WEIGHT * (CASE WHEN NVL(LD.SIZE_VALUE, 0) = 0 THEN LD.INITIAL_QTY ELSE LD.SIZE_VALUE END)) PESO_FISICO  \n" +
" FROM "+esquema+".LPN L \n" +
" JOIN "+esquema+".LPN_DETAIL LD \n" +
" ON L.LPN_ID = LD.LPN_ID \n" +
" JOIN "+esquema+".ITEM_CBO ICB \n" +
" ON LD.ITEM_ID = ICB.ITEM_ID \n" +
" WHERE L.TC_LPN_ID in (:idLpns) \n" +
" AND L.C_FACILITY_ALIAS_ID = :idManh \n" 
//+" GROUP BY \n" +
//" ICB.UNIT_LENGTH \n" +
//", ICB.UNIT_WIDTH \n" +
//", ICB.UNIT_HEIGHT "
        ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idLpns", getLpnsByCaja(idCaja, idManh));
            parametros.put("idManh", idManh);

            return wm18.queryForObject(sql, parametros, new DimensionesQBMapper());
        } catch (Exception ex) {

            return null;
        }
        */
    }

    @Override
    public DimensionesQB getDimensionesPaqueteMKP(int idManh, int idCaja, String esquema, int tipPed) {
        String sql = " select c.ALTO,c.ANCHO,c.LARGO,(c.ALTO*c.ANCHO*c.LARGO) volumen, ((c.ALTO*c.ANCHO*c.LARGO)/5000) PESO_VOLUMETRICO, ch.VOLUMENUTILIZADO PESO_FISICO \n" +
            "from info_cd.ECOM_CAJA_HDR ch join info_cd.ECOM_CAT_CONTENEDOR c on c.PKIDCONTENEDOR=ch.FKIDCONTENEDOR and ch.ID_TIPO_PEDIDO=c.ID_TIPO_PEDIDO\n" +
            "where ch.ID_MANH = :idorigen and ch.PKIDCAJAHDR = :idcaja and ch.ID_TIPO_PEDIDO = :tipped"; 
            //modify - check formula for volumen
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idcaja", idCaja);
            parametros.put("idorigen", idManh);
            parametros.put("tipped", tipPed);

            return um.queryForObject(sql, parametros, new DimensionesQBMapper());
        } catch (Exception ex) {

            return null;
        }
    }
    
    @Override
    public Pedido getPedidoEpi(String idLpn, String esquema) {

        String sql = "SELECT L.TC_LPN_ID ID_LPN "
                + " , 0 ID_CAJA "
                + " , O.O_FACILITY_ALIAS_ID ID_MANH "
                + " , O.ORDER_TYPE "
                + " , O.EXT_PURCHASE_ORDER PEDIDO "
                + " , 0 ID_CANAL "
                + " , 0 ID_TIPO_PEDIDO "
                + " FROM "+esquema+".LPN L "
                + " JOIN "+esquema+".ORDERS O "
                + " ON L.TC_ORDER_ID = O.TC_ORDER_ID "
                + " WHERE L.TC_LPN_ID = :lpn ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("lpn", idLpn);

            return wm18.queryForObject(sql, parametros, new PedidoMapper());
        } catch (Exception ex) {

            return null;
        }
    }
    @Override
    public List<Map<String,Object>> getPedidoMKP(List<String> adn, int idVendor, int idTipoPedido) {

        String sql = "select ph.id_origen,pd.adn,ph.id_pedido from info_cd.ecom_ctr_pedidos_hdr ph \n"
                + "join info_cd.ecom_ctr_pedidos_dtl pd on ph.id_pedido=pd.id_pedido and ph.id_tipo_pedido=pd.id_tipo_pedido\n"
                + "where pd.adn in (:adn) and ph.id_origen = :idvend and pd.id_tipo_pedido = :tipope";
        //modify - check for real columns
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("adn", adn);
            parametros.put("idvend", idVendor);
            parametros.put("tipope", idTipoPedido);

            return um.queryForList(sql, parametros);
        } catch (Exception ex) {

            return null;
        }
    }
    @Override
    public List<Map<String,Object>> getPedidoDSV(List<String> adn, int idVendor, int idTipoPedido){
        String sql = "";
        //modify - check for real info datasource
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("adn", adn);
            parametros.put("idvend", idVendor);
            parametros.put("tipope", idTipoPedido);

            return um.queryForList(sql, parametros);
        } catch (Exception ex) {

            return null;
        }
    }
    @Override
    public List<Map<String,String>> getLpnsByAdn(List<String> adn, String esquema){
        return new ArrayList<Map<String,String>>() ;
    }
    @Override
    public List<Map<String,Object>> getVtexByAdnsOrLpns(List<String> adn, List<String> lpn, String esquema){
        String sql = "SELECT L.TC_LPN_ID ID_LPN \n" +
            ", O.O_FACILITY_ALIAS_ID ID_MANH \n" +
            ", O.ORDER_TYPE \n" +
            ", O.EXT_PURCHASE_ORDER PEDIDO \n" +
            ", OLI.Ref_field4 adn \n" +
            "FROM "+esquema+".LPN L \n" +
            "JOIN "+esquema+".ORDERS O \n" +
            "ON L.TC_ORDER_ID = O.TC_ORDER_ID \n" +
            "join "+esquema+".ORDER_LINE_ITEM OLI \n" +
            "on O.ORDER_ID = OLI.ORDER_ID\n" +
            "WHERE "+(adn.isEmpty()?" L.TC_LPN_ID in (:lpn) ":" OLI.REF_FIELD4 in (:adn)");
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("lpn", lpn);
            parametros.put("adn", adn);

            return wm18.queryForList(sql, parametros);
        } catch (Exception ex) {

            return null;
        }
    }

    @Override
    public int getIdTipoPedidoByOrderType(String orderType) {

        String sql = " SELECT ID_TIPO_PEDIDO "
                + " FROM INFO_CD.CE_CAT_TIPO_PEDIDO "
                + " WHERE REF_FIELD_1 = :orderType ";

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("orderType", orderType);

            return um.queryForObject(sql, parametros, Integer.class);

        } catch (Exception ex) {

            return 0;
        }
    }

    @Override
    public List<Regla> getReglas(int idCanal, int tipoPedido) {

        String sql = " select FICRITERIO id_criterio,FTIPOREGLA tipo,FPRIORIDAD prioridad from SCCENEN.corebackrgl where FACTIVO = 1";

        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            return um.query(sql, parametros, new ReglaMapper());
        } catch (Exception ex) {
            if(app.isWriteConsole())
                System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public List<String> getLpnsByCaja(int idCaja, int idManh){
        String sql = " SELECT CD.OLPN "
                + " FROM INFO_CD.ECOM_CAJA_HDR CH "
                + " JOIN INFO_CD.ECOM_CAJA_DTL CD "
                + " ON CH.PKIDCAJAHDR = CD.FKIDCAJAHDR "
                + " JOIN INFO_CD.CE_CONTROL_GUIAS_DTL GD "
                + " ON CH.PKIDCAJAHDR = CD.FKIDCAJAHDR"
                + " AND CD.FKIDCAJAHDR  = GD.ID_CAJA "
                + " WHERE CH.ID_MANH = :idManh "
                + " AND CH.PKIDCAJAHDR = :idCaja ";

        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idCaja", idCaja);
            parametros.put("idManh", idManh);

            return um.queryForList(sql, parametros, String.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Integer> getCdsOfLpns(Paquete paquete){
        try {

            String sql = " SELECT DISTINCT GD.ID_MANH "
                    + " FROM INFO_CD.CE_CONTROL_GUIAS_DTL GD "
                    + " JOIN INFO_CD.ECOM_CAJA_HDR CH "
                    + " ON GD.ID_CAJA = CH.PKIDCAJAHDR "
                    + " JOIN INFO_CD.ECOM_CAJA_DTL CD "
                    + " ON CH.PKIDCAJAHDR = CD.FKIDCAJAHDR "
                    + " AND GD.ID_LPN = CD.OLPN "
                    + " WHERE GD.ID_CAJA = :idCaja "
                    + " AND CH.ID_MANH = :idManh ";

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());

            return um.queryForList(sql, parametros, Integer.class);

        } catch (Exception ex) {

            return null;
        }
    }

    

    
    
    
    

    @Override
    public double getCostoSku(String sku) {
        try {

            String sql = " SELECT ZHCOST FROM INFO_CD.Z_INVMST  "
                    + " WHERE INUMBER = :sku ";

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("sku", sku);

            return um.queryForObject(sql, parametros, Double.class);

        } catch (Exception ex) {

            return 0;
        }
    }

    @Override
    public FamiliaSap getFamiliaSap(String matkl) {

        try {

            String sql = " SELECT DISTINCT ZN1NCL DEPARTAMENTO "
                    + " , ZN1CLAS DESC_DEPARTAMENTO "
                    + " , ZN2NCL SUBDEPARTAMENTO "
                    + " , ZN2CLAS DESC_SUBDEPARTAMENTO "
                    + " , ZN3NCL CLASE "
                    + " , ZN3CLAS DESC_CLASE "
                    + " , MATKL SUBCLASE "
                    + " , WGBEZ DESC_SUBCLASE "
                    + " FROM INFO_CD.ZMCLAS_SAP "
                    + " WHERE MATKL = :matkl ";

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("matkl", matkl);

            return um.queryForObject(sql, parametros, new FamiliaSapMapper());

        } catch (Exception ex) {

            return null;
        }
    }

    @Override
    public int getIdCaja() {
        try {
            String sql = " SELECT INFO_CD.SEQ_PAQ_CAJAS.NEXTVAL FROM DUAL";
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            return um.queryForObject(sql, parametros, Integer.class);
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public CarrierQB getMejorCarrierPostCalculo(int idManh, String idLpn) {
        String sql = " SELECT CC.ID_CARRIER, CC.DESC_CARRIER, CC.COD_CARRIER "
                + " FROM INFO_CD.ECOM_CB_HDR CH "
                + " JOIN INFO_CD.CE_CAT_CARRIERS CC "
                + " ON CH.ID_CARRIER = CC.ID_CARRIER "
                + " WHERE FLG_MEJOR_CARRIER = 1 "
                + " AND CD_ID = :idManh "
                + " AND ID_LPN = :idLpn ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idManh", idManh);
            parametros.put("idLpn", idLpn);

            return um.queryForObject(sql, parametros, new CarrierQBMapper());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    
    @Override
    public List<CarrierQB> getCarriersActivos(int idCanal, int tipoPedido) {
        String sql = "select fiproveedorid,fipnombre,fipcodigo from SCCENEN.taceproveedores where fipactivo=1 ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idCanal", idCanal);
            parametros.put("tipped", tipoPedido);

            return um.query(sql, parametros, new CarrierQBMapper());
        } catch (Exception ex) {
            if(app.isWriteConsole())
                System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public List<CarrierQB> getCarriersPrimeraIteracion(Paquete paquete) {

        String sql = " select cp.fiproveedorid,fipnombre,fipcodigo from SCCENEN.corebackhdr ch\n" +
            "join SCCENEN.taceproveedores cp on ch.FIPROVEEDORID=cp.FIPROVEEDORID\n" +
            "where ch.FICENTROID = :idManh\n" +
            "and ch.FIENTREGAID = :pedido\n" +
            "and ch.FACTIVO = 1 ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("pedido", paquete.getPedido());
            parametros.put("idManh", paquete.getIdManh());
            
            return um.query(sql, parametros, new CarrierQBMapper());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public List<CarrierQB> getCarriersSiguienteIteracion(Paquete paquete, int idRegla) {

        String sql = " SELECT cp.fiproveedorid,fipnombre,fipcodigo\n" +
            "FROM SCCENEN.corebackdtl cd\n" +
            "join SCCENEN.taceproveedores cp on cd.FIPROVEEDORID=cp.FIPROVEEDORID\n" +
            "AND cd.FPSELECION = 1  \n" +
                " and fpid = :folio \n" +
            "where cd.FICENTROID = :idManh\n" +
            "and cd.FIENTREGAID = :pedido\n" +
            "AND CD.FKCRITERIO = :idRegla ";

        try {
            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("pedido", paquete.getPedido());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("folio", paquete.getFolio());
            parametros.put("idRegla", idRegla);

            return um.query(sql, parametros, new CarrierQBMapper());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean insertaCbHder2018(Paquete paquete, String usuario, CarrierQB carrierQB) {

        String sql = "INSERT INTO SCCENEN.corebackhdr ( \n" +
            "FPID, FICENTROID, FIPROVEEDORID, FIENTREGAID, FCPDESTINO, FPROCESADO, FPSELECION\n" +
            ", FPLARGO, FPANCHO, FPALTO, FPVOLUMEN, FUCREACION, FFCREACION\n" +
            ", FCPORIGEN, FACTIVO\n" +
            ") VALUES ( \n" +
            ":idproc,:idManh, :idcarrier, :pedido, :cpDestino, :flgProcesado, :flgMejorCarrier\n" +
            ", :largo, :ancho, :alto, :volumen, :usuarioCreacion, SYSDATE\n" +
            ", :cpOrigen, :isactive \n" +
            ") ";

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idproc", paquete.getFolio());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idcarrier", carrierQB.getIdCarrier());
            parametros.put("pedido", paquete.getPedido());
            parametros.put("cpDestino", paquete.getCpDestino());
            parametros.put("flgProcesado", 0);
            parametros.put("flgMejorCarrier", 0);
            parametros.put("largo", paquete.getLargo());
            parametros.put("ancho", paquete.getAncho());
            parametros.put("alto", paquete.getAlto());
            parametros.put("volumen", paquete.getVolumen());
            parametros.put("usuarioCreacion", usuario);
            parametros.put("cpOrigen", paquete.getCpOrigen());
            parametros.put("isactive", 1);
            
            return um.update(sql, parametros) > 0;

        } catch (Exception ex) {
            if(app.isWriteConsole())
                System.out.println(ex.getMessage());
            return false;
        }

    }

    @Override
    public boolean actualizaCbDtl(Paquete paquete, Regla regla, CarrierQB carrier, ResultadoEvaluacion resultadoEvaluacion) {

        String sql = "UPDATE SCCENEN.corebackdtl A \n" +
            "SET A.FPROCESADO = 1 \n" +
            ", A.FUMODIFICA = SUBSTR(:usuarioModificacion,40) \n" +
            ", A.FFMODIFICA = SYSDATE \n"
                + (resultadoEvaluacion.isNulo() ? "" : " , A.FCANTIDAD = :cantidad \n")
            + " , A.FTARIFABASE = :tarifaBase \n" +
            ", A.FTARIFAFINAL = :tarifaFinal \n" +
            ", FMENSAJE = SUBSTR(:mensaje, 0, 50) \n" +
            ", FPSELECION = :flgValido \n" +
            "WHERE FIENTREGAID = :pedido \n" +
            "AND FKCRITERIO = :idRegla \n" +
            "AND FIPROVEEDORID = :idCarrier \n" +
            "AND FICENTROID = :idManh  and fpid = :idproc";

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idproc", paquete.getFolio());
            parametros.put("usuarioModificacion", "Quarterback");
            parametros.put("cantidad", resultadoEvaluacion.getCantidad());
            parametros.put("tarifaBase", resultadoEvaluacion.getTarifaBase());
            parametros.put("tarifaFinal", resultadoEvaluacion.getTarifaFinal());
            parametros.put("mensaje", resultadoEvaluacion.getMensaje());
            parametros.put("flgValido", (resultadoEvaluacion.isValido()) ? 1 : 0);
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idRegla", regla.getIdRegla());
            parametros.put("idCarrier", carrier.getIdCarrier());
            parametros.put("idManh", paquete.getIdManh());

            return um.update(sql, parametros) > 0;

        } catch (Exception ex) {
            if(app.isWriteConsole())
                System.out.println(ex.getMessage());
            return false;
        }

    }

    @Override
    public boolean actualizaCbHdr(Paquete paquete, CarrierQB carrier, String usuario, double tarifa) {

        String sql = " UPDATE SCCENEN.corebackhdr\n" +
            "SET FPROCESADO = 1 \n" +
            ", FPSELECION = (CASE WHEN FIPROVEEDORID = :idCarrier THEN 1 ELSE 0 END) \n" +
            ", FUMODIFICA = :usuarioModificacion \n" +
            ", FFMODIFICA = SYSDATE \n" +
            "WHERE FIENTREGAID = :pedido \n" +
            "AND FICENTROID = :idManh  and fpid = :idproc";

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idproc", paquete.getFolio());
            parametros.put("idCarrier", carrier.getIdCarrier());
            parametros.put("usuarioModificacion", usuario);
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idManh", paquete.getIdManh());

            return um.update(sql, parametros) > 0;

        } catch (Exception ex) {
            if(app.isWriteConsole())
                System.out.println(ex.getMessage());
            return false;
        }

    }

    @Override
    public boolean insertaCbDtl(Paquete paquete, CarrierQB carrier, Regla regla, String usuario) {

        String sql = " INSERT INTO SCCENEN.corebackdtl\n" +
            "(FPID,FICENTROID, FIPROVEEDORID, FIENTREGAID, FKCRITERIO, FUCREACION, FFCREACION, FPROCESADO, FPSELECION) \n" +
            "VALUES \n" +
            "(:idproc,:idManh, :idCarrier, :pedido,  :idRegla, :usuarioCreacion, SYSDATE, 0, 0) ";

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idproc", paquete.getFolio());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCarrier", carrier.getIdCarrier());
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idRegla", regla.getIdRegla());
            parametros.put("usuarioCreacion", usuario);

            return um.update(sql, parametros) > 0;

        } catch (Exception ex) {
            if(app.isWriteConsole())
                System.out.println(ex.getMessage());
            return false;
        }

    }
    
    @Override
    public boolean insertaCajaHdr(int idUsuario, int idCaja, int idManh, String pedido, int idCanal, int idTipPed, int idContainer, double peso){

        String sql = " INSERT INTO INFO_CD.ECOM_CAJA_HDR "
                + " (PKIDCAJAHDR, ID_MANH, PEDIDO, FKIDESTATUS, FKIDUSUARIOCREA, FKIDUSUARIOMODIF,FECHACREACION, FECHAMODIF, FKIDCONTENEDOR, ID_TIPO, ID_TIPO_PEDIDO, VOLUMENUTILIZADO) "
                + " VALUES "
                + " (:idCaja, :idManh, :pedido, 2, :ucrea, :ucrea, SYSDATE, SYSDATE, :idContainer, :tipo, :tipope, :kgped ) ";
        //modify - volume in query hard coded
        try {

            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCaja", idCaja);
            parametros.put("idManh", idManh);
            parametros.put("pedido", pedido);
            parametros.put("ucrea", idUsuario);
            parametros.put("tipo", idCanal);
            parametros.put("tipope", idTipPed);
            parametros.put("idContainer", idContainer);
            parametros.put("kgped", peso);
            
            return um.update(sql, parametros) > 0;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }
    
    @Override
    public boolean insertaCajaDtl(int idCaja, String idLpn){

        String sql = " INSERT INTO INFO_CD.ECOM_CAJA_DTL "
                + " (FKIDCAJAHDR, PKIDCAJADTL, OLPN) "
                + " VALUES "
                + " (:idCaja, :idDtl, :idLpn) ";

        int idDtl=idCajaDtl();
        try {

            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("idLpn", idLpn);
            parametros.put("idCaja", idCaja);
            parametros.put("idDtl", idDtl);

            return um.update(sql, parametros) > 0;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    private int idCajaDtl(){
        String sql="SELECT INFO_CD.SEQ_ECOM_CAJA_HDR.NEXTVAL FROM DUAL";
        try{
            return um.queryForObject(sql, new HashMap<String, Object>(), Integer.class) ;
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    /***
     * Metodo para crear contenedores por Proveedor
     * @param lenght largo
     * @param width ancho
     * @param height alto
     * @param weight peso
     * @param idVendor proveedor
     * @param idUsuario usuario
     * @return id de contenedor del proveedor (si existe) | id de contenedor creado para el proveedor
     */
    @Override
    public int createContainer(double lenght, double width, double height, double weight, int idVendor, int idTipPed, int idUsuario) {
        int idContainer=getIdContainer(lenght, width, height, weight, idVendor, idTipPed, true);
        String sql = "insert into info_cd.ecom_cat_contenedor (PKIDCONTENEDOR,usuario_creacion,fecha_creacion,descripcion,largo,alto,ancho,kilos_soportado,estatus,id_tipo_pedido,id_proveedor,usuario_modificacion,fecha_modificacion) \n" +
            "values (:idcont,:usercont,sysdate,:desc,:largo,:alto,:ancho,:kg,1,4,:vendor,:usercont,sysdate)";
        HashMap<String,Object> param=new HashMap<String,Object>();
        param.put("idcont",idContainer);
        param.put("usercont",idUsuario);
        param.put("desc","Generic");
        param.put("largo",lenght);
        param.put("alto",height);
        param.put("ancho",width);
        param.put("kg",weight);
        param.put("vendor",idVendor);
        um.update(sql, param);
        return idContainer;
    }
    /***
     * check for sequences(using unique for all vendors)
     * @param lenght largo
     * @param width ancho
     * @param height alto
     * @param weight peso
     * @param idVendor proveedor
     * @param newFlg false-busca contenedor generico del proveedor | true crea nuevo contenedor
     * @return 
     */
    @Override
    public int getIdContainer(double lenght, double width, double height, double weight, int idVendor, int idTipPed, boolean newFlg){
        String getId="select PKIDCONTENEDOR from INFO_CD.ECOM_CAT_CONTENEDOR "
                + "where largo = :largo and ancho = :ancho and alto = :alto and id_proveedor = :idvendor \n" +
                "union\n" +
                "select count(*) PKIDCONTENEDOR from INFO_CD.ECOM_CAT_CONTENEDOR "
                + "where largo = :largo and ancho = :ancho and alto = :alto and id_proveedor = :idvendor having count(*) = 0";
        String newId="SELECT info_cd.seq_ecom_contenedor_dsv.nextval FROM DUAL";
        HashMap<String,Object> param=new HashMap<String,Object>();
        param.put("largo",lenght);
        param.put("alto",height);
        param.put("ancho",width);
        param.put("idvendor",idVendor);
        if(newFlg)
            return um.queryForObject(newId, new HashMap<String, Object>(), Integer.class);
        else
            return um.queryForObject(getId, param, Integer.class);
    }
    
    

    private static final class DetalleSkusMapper implements RowMapper<DetalleSkus> {

        @Override
        public DetalleSkus mapRow(ResultSet rs, int i) throws SQLException {

            Sku sku = new Sku();
            sku.setIdSku(rs.getString("ID_SKU"));
            sku.setDescSku(rs.getString("DESC_SKU"));
            sku.setIdDepartamento(rs.getString("DEPARTAMENTO"));
            sku.setDescDepartamento(rs.getString("DESC_DEPARTAMENTO"));
            sku.setIdSubdepartamento(rs.getString("SUBDEPARTAMENTO"));
            sku.setDescSubdepartamento(rs.getString("DESC_SUBDEPARTAMENTO"));
            sku.setIdClase(rs.getString("CLASE"));
            sku.setDescClase(rs.getString("DESC_CLASE"));
            sku.setIdSubclase(rs.getString("SUBCLASE"));
            sku.setDescSubclase(rs.getString("DESC_SUBCLASE"));
            sku.setPeso(rs.getDouble("PESO"));
            sku.setLargo(rs.getDouble("LARGO"));
            sku.setAncho(rs.getDouble("ANCHO"));
            sku.setAlto(rs.getDouble("ALTO"));
            sku.setCostoUnitario(rs.getDouble("COSTO"));

            DetalleSkus detalleSku = new DetalleSkus();
            detalleSku.setSku(sku);
            detalleSku.setCantidad(rs.getInt("CANTIDAD"));

            return detalleSku;
        }

    }

    private static final class PedidoMapper implements RowMapper<Pedido> {

        @Override
        public Pedido mapRow(ResultSet rs, int i) throws SQLException {
            Pedido pedido = new Pedido();
            pedido.setIdLpn(rs.getString("ID_LPN"));
            pedido.setIdCaja(rs.getInt("ID_CAJA"));
            pedido.setPedido(rs.getString("PEDIDO"));
            pedido.setIdManh(rs.getInt("ID_MANH"));
            pedido.setIdCanal(rs.getInt("ID_CANAL"));
            pedido.setOrderType(rs.getString("ORDER_TYPE"));
            pedido.setIdTipoPedido(rs.getInt("ID_TIPO_PEDIDO"));
            return pedido;
        }

    }

    private static final class FamiliaSapMapper implements RowMapper<FamiliaSap> {

        @Override
        public FamiliaSap mapRow(ResultSet rs, int i) throws SQLException {

            FamiliaSap familiaSap = new FamiliaSap();
            familiaSap.setDepartamento(rs.getString("DEPARTAMENTO"));
            familiaSap.setDescDepartamento(rs.getString("DESC_DEPARTAMENTO"));
            familiaSap.setSubdepartamento(rs.getString("SUBDEPARTAMENTO"));
            familiaSap.setDescSubdepartamento(rs.getString("DESC_SUBDEPARTAMENTO"));
            familiaSap.setClase(rs.getString("CLASE"));
            familiaSap.setDescClase(rs.getString("DESC_CLASE"));
            familiaSap.setSubclase(rs.getString("SUBCLASE"));
            familiaSap.setDescSubclase(rs.getString("DESC_SUBCLASE"));

            return familiaSap;
        }

    }

    private static final class DimensionesQBMapper implements RowMapper<DimensionesQB> {

        @Override
        public DimensionesQB mapRow(ResultSet rs, int i) throws SQLException {
            DimensionesQB dimensionesQB = new DimensionesQB();
            dimensionesQB.setAlto(rs.getDouble("ALTO"));
            dimensionesQB.setAncho(rs.getDouble("ANCHO"));
            dimensionesQB.setLargo(rs.getDouble("LARGO"));
            dimensionesQB.setVolumen(rs.getDouble("VOLUMEN"));
            dimensionesQB.setPesoFisico(rs.getDouble("PESO_FISICO"));
            dimensionesQB.setPesoVolumetrico(rs.getDouble("PESO_VOLUMETRICO"));
            return dimensionesQB;
        }

    }

    private static final class CarrierQBMapper implements RowMapper<CarrierQB> {

        @Override
        public CarrierQB mapRow(ResultSet rs, int i) throws SQLException {
            CarrierQB carrier = new CarrierQB();
            carrier.setIdCarrier(rs.getInt("FIPROVEEDORID"));
            carrier.setDesdCarrier(rs.getString("FIPNOMBRE"));
            carrier.setCodCarrier(rs.getString("FIPCODIGO"));
            return carrier;
        }

    }

    private static final class ReglaMapper implements RowMapper<Regla> {

        @Override
        public Regla mapRow(ResultSet rs, int i) throws SQLException {

            Regla regla = new Regla();
            regla.setIdRegla(rs.getInt("ID_CRITERIO"));
            regla.setIdTipoRegla(rs.getInt("TIPO"));
            regla.setPrioridad(rs.getInt("PRIORIDAD"));
            return regla;
        }

    }
    
    
    
    /*
    @Override
    public DimensionesQB getDimensionesPaqueteDSV(int idManh, int idCaja, String esquema, int tipPed) {
        String sql = " select c.ALTO,c.ANCHO,c.LARGO,(c.ALTO*c.ANCHO*c.LARGO) volumen, ((c.ALTO*c.ANCHO*c.LARGO)/5000) PESO_VOLUMETRICO, sum(zi.BRGEW  * pd.CANTIDAD) PESO_FISICO  \n" +
            "from info_cd.ECOM_CAJA_HDR ch join info_cd.ECOM_CAT_CONTENEDOR c on c.PKIDCONTENEDOR=ch.FKIDCONTENEDOR and ch.ID_TIPO_PEDIDO=c.ID_TIPO_PEDIDO \n" +
            "join info_cd.ecom_caja_dtl cd on cd.FKIDCAJAHDR = ch.PKIDCAJAHDR\n" +
            "join info_cd.ECOM_CTR_PEDIDOS_DTL pd on pd.ADN = cd.OLPN \n" +
            "join info_cd.z_invmst zi on pd.ID_SKU = zi.INUMBER\n" +
            "where ch.ID_MANH = :idorigen and ch.PKIDCAJAHDR = :idcaja and ch.ID_TIPO_PEDIDO = :tipped \n"
                + "group by c.ALTO,c.ANCHO,c.LARGO "; 
            //modify - check formula for volumen
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idcaja", idCaja);
            parametros.put("idorigen", idManh);
            parametros.put("tipped", tipPed);

            return um.queryForObject(sql, parametros, new DimensionesQBMapper());
        } catch (Exception ex) {

            return null;
        }
    }
    */
}
