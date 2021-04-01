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
import mx.com.elektra.coreback2.beans.ExclusionOInclusion;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Sku;
import mx.com.elektra.coreback2.beans.Tarifa;
import mx.com.elektra.coreback2.dao.ReglasDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dparra
 */
@Repository("reglasDaoUm")
public class ReglasDaoUmImpl implements ReglasDao{

    @Autowired
    private NamedParameterJdbcTemplate um ;
    
    @Override
    public boolean isDestinoValidoParaCarrier(Paquete paquete, int idCarrier) {
        
        boolean estatusDestino = false;
        
        String sql = " SELECT COUNT(*) FLG_VALIDO "
                    + " FROM INFO_CD.ECOM_CB_CARRIER_TARIFAS "
                    + " WHERE ESTATUS = 1 "
                    + " AND ID_CARRIER = :idCarrier "
                    + " AND TO_NUMBER(CP) = TO_NUMBER(:cpDestino) "
                    + " AND TO_NUMBER(CP_ORIGEN) = TO_NUMBER(:cpOrigen) "
                    + " AND ID_TIPO = :idCanal "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("cpDestino", paquete.getCpDestino());
            parametros.put("cpOrigen", paquete.getCpOrigen());
            parametros.put("idCanal", paquete.getIdCanal());
            
            estatusDestino = um.queryForObject(sql, parametros, Integer.class) > 0;
        } catch (Exception ex) {
            return false;
        }
        
        return estatusDestino;
    }

    @Override
    public int getRatingCarrier(Paquete paquete, int idCarrier) {
        
        int calificacion = 0;
        String sql = " SELECT NVL( CALIFICACION, -1) CALIFICACION \n" +
            "FROM \n" +
            "( \n" +
            "SELECT MAX(FCALIFICACION) CALIFICACION \n" +
            "FROM SCCENEN.corebackrating\n" +
            "WHERE FIPROVEEDORID = :idCarrier \n" +
            ") ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            calificacion = um.queryForObject(sql, parametros, Integer.class) ;
        } catch (EmptyResultDataAccessException ex) {
            calificacion = 0;
        } catch (Exception ex) {
            calificacion = -1;
        }
        
        return calificacion;
    }

    @Override
    public boolean isPesoFisicoSoportadoPorCarrier(Paquete paquete, int idCarrier) {
        boolean pesoValido = false;
        String sql = " SELECT (CASE WHEN COUNT(*) > 1 THEN 1 ELSE COUNT(*)END) PESO_VALIDO "
                    + " FROM INFO_CD.ECOM_CB_CARRIER_TARIFAS "
                    + " WHERE ESTATUS = 1 "
                    + " AND ID_CARRIER = :idCarrier "
                    + " AND :peso <= PESO_F_MAX "
                    + " AND ID_TIPO = :idCanal "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("peso", paquete.getPesoFisico());
            parametros.put("idCanal", paquete.getIdCanal());
            
            pesoValido = um.queryForObject(sql, parametros, Integer.class) > 0;
            
        } catch (Exception ex) {
            pesoValido = false;
        }
        
        return pesoValido;
    }
    
    @Override
    public ExclusionOInclusion getExclusionesEInclusiones(Sku sku, Paquete paquete, int idCarrier, String tipo){
        
        ExclusionOInclusion exclusion;
        
        String sql = " SELECT E.FTIPOEI \n" +
            "FROM SCCENEN.COREBACKEI E \n" +
            "WHERE E.FACTIVO = 1 \n" +
            "AND E.FIPROVEEDORID = :idCarrier \n" +
            "AND FEI in (:excl ) \n" +
            "AND E.FTIPO = :tipo \n" +
            "ORDER BY E.FTIPOEI DESC " ;
        try {
            Map<String, Object> parametros = new HashMap<>();
            List<String> clasf=new ArrayList<>();
            clasf.add(sku.getIdClase());
            clasf.add(sku.getIdDepartamento());
            clasf.add(sku.getIdSubclase());
            clasf.add(sku.getIdSubdepartamento());
            clasf.add(sku.getIdSku());
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("excl", clasf);
            parametros.put("sku", sku.getIdSku());
            parametros.put("tipo", tipo);
            
            exclusion = um.queryForObject(sql, parametros, new ExclusionOInclusionMapper());
            exclusion.setSku(sku);
            
        } catch (EmptyResultDataAccessException ex) {
            exclusion = new ExclusionOInclusion();
            exclusion.setTipoExclusion(0);
        } catch (Exception ex) {
            exclusion = new ExclusionOInclusion();
            exclusion.setTipoExclusion(-1);
        }
        
        return exclusion;
    }
    
    @Override
    public boolean isCapacidadValidaPorCarrier(Paquete paquete, int idCarrier) {
        
        boolean capacidad = false;
        String sql = " SELECT ( "
                    + " CASE WHEN A.ID_CARRIER IS NOT NULL "
                    + " AND NVL(A.GUIAS_TOTALES, 0) <= "
                    + " ( "
                    + " SELECT COUNT(*) FROM INFO_CD.CE_CONTROL_GUIAS "
                    + " WHERE TRUNC(FECHA_CREACION) = TRUNC(SYSDATE) "
                    + " AND ID_CARRIER = :idCarrier "
                    + " AND ID_TIPO = :idCanal "
                    + " ) "
                    + " THEN 0 ELSE 1 END "
                    + " ) FLG_VALIDO "
                    + " FROM INFO_CD.CE_CAT_CARRIERS C "
                    + " LEFT JOIN INFO_CD.ECOM_CB_CARRIER_GUIAS_T A "
                    + " ON C.ID_CARRIER = A.ID_CARRIER "
                    + " AND A.FLG_ACTIVO = 1 "
                    + " AND A.ID_TIPO = :idCanal "
                    + " WHERE C.ID_CARRIER = :idCarrier "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("idCanal", paquete.getIdCanal());
            
            capacidad = um.queryForObject(sql, parametros, Integer.class) > 0;
            
        } catch (Exception ex) {
            capacidad = false;
        }
        
        return capacidad;
    }
    
    @Override
    public int getCapacidadPorCarrier(Paquete paquete, int idCarrier) {
        
        int capacidad = -1;
        
        String sql = " SELECT GUIAS_TOTALES "
                    + " FROM INFO_CD.ECOM_CB_CARRIER_GUIAS_T "
                    + " WHERE FLG_ACTIVO = 1 "
                    + " AND ID_TIPO = :idCanal "
                    + " AND ID_CARRIER = :idCarrier "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("idCanal", paquete.getIdCanal());
            
            capacidad = um.queryForObject(sql, parametros, Integer.class);
            
        } catch (Exception ex) {
            capacidad = -1;
        }
        
        return capacidad;
    }
    
    @Override
    public int getPorcentajePorCarrier(Paquete paquete, int idCarrier) {
        
        int porcentaje = -1;
        
        String sql = " SELECT PORCENTAJE "
                    + " FROM INFO_CD.ECOM_CB_PORCENTAJE_ASIGNACION "
                    + " WHERE ID_TIPO_CANAL = :idCanal "
                    + " AND ID_CARRIER = :idCarrier "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("idCanal", paquete.getIdCanal());
            
            porcentaje = um.queryForObject(sql, parametros, Integer.class);
            
        } catch (EmptyResultDataAccessException ex) {
            porcentaje = -1;
        } catch (Exception ex) {
            porcentaje = -2;
        }
        
        return porcentaje;
    }
    
    @Override
    public int getPorcentajeRestoCarrier(Paquete paquete) {
        
        int porcentaje = -1;
        
        String sql = " SELECT (100 - SUM(PORCENTAJE)) PORCENTAJE "
                    + " FROM INFO_CD.ECOM_CB_PORCENTAJE_ASIGNACION "
                    + " WHERE FLG_ACTIVO = 1 "
                    + " AND ID_TIPO_CANAL = :idCanal "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCanal", paquete.getIdCanal());
            
            porcentaje = um.queryForObject(sql, parametros, Integer.class);
            
        } catch (EmptyResultDataAccessException ex) {
            porcentaje = -1;
        } catch (Exception ex) {
            porcentaje = -2;
        }
        
        return porcentaje;
    }
    
    @Override
    public int getEstatusHorario(Paquete paquete, int idCarrier) {
        
        int estatusHorario = 0;
        
        String sql = " SELECT MAX( "
                    + " CASE "
                    + " WHEN H.ID_CARRIER IS NULL THEN -1 "
                    + " WHEN H.ID_CARRIER IS NOT NULL AND H.HORA > TO_CHAR(SYSDATE, 'HH24:MI') THEN 1 "
                    + " ELSE 0 "
                    + " END "
                    + " ) FLG_VALIDO "
                    + " FROM INFO_CD.CE_CAT_CARRIERS C "
                    + " LEFT JOIN INFO_CD.ECOM_CB_CARRIER_HORARIOS H "
                    + " ON C.ID_CARRIER = H.ID_CARRIER "
                    + " AND H.FLG_ACTIVO = 1 "
                    + " AND H.DIA IN (TO_NUMBER(TO_CHAR(SYSDATE, 'D'))) "
                    + " AND H.CD_ID = :idManh "
                    + " WHERE C.ID_CARRIER = :idCarrier "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCarrier", idCarrier);
            
            estatusHorario = um.queryForObject(sql, parametros, Integer.class);
            
        } catch (Exception ex) {
            estatusHorario = 0;
        }
        
        return estatusHorario;
    }
    
    @Override
    public int getCantidadGuiasPorCarrier(Paquete paquete, int idCarrier) {
        
        int cantidad = 0;
        
        String sql = " SELECT COUNT(*) CANTIDAD "
                    + " FROM INFO_CD.CE_CONTROL_GUIAS "
                    + " WHERE TRUNC(FECHA_CREACION) = TRUNC(SYSDATE) "
                    + " AND ID_TIPO = :idCanal "
                    + " AND ID_CARRIER = :idCarrier "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCanal", paquete.getIdCanal());
            parametros.put("idCarrier", idCarrier);
            
            cantidad = um.queryForObject(sql, parametros, Integer.class);
            
        } catch (Exception ex) {
            cantidad = 0;
        }
        
        return cantidad;
    }
    
    @Override
    public int getCantidadGuias(Paquete paquete) {
        
        int cantidad = 0;
        
        String sql = " SELECT COUNT(*) CANTIDAD "
                    + " FROM INFO_CD.CE_CONTROL_GUIAS "
                    + " WHERE TRUNC(FECHA_CREACION) = TRUNC(SYSDATE) "
                    + " AND ID_TIPO = :idCanal "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCanal", paquete.getIdCanal());
            
            cantidad = um.queryForObject(sql, parametros, Integer.class);
            
        } catch (Exception ex) {
            cantidad = 0;
        }
        
        return cantidad;
    }
    
    @Override
    public Tarifa getTarifa(Paquete paquete, int idCarrier){
        Tarifa tarifa;
        
        String sql = " SELECT NVL(MAX(TARIFA),-1) TARIFA "
                    + " FROM INFO_CD.ECOM_CB_CARRIER_TARIFAS "
                    + " WHERE ESTATUS = 1 "
                    + " AND ID_CARRIER = :idCarrier "
                    + " AND :peso BETWEEN PESO_F_MIN AND PESO_F_MAX "
                    + " AND TO_NUMBER(CP) = TO_NUMBER(:cpDestino) "
                    + " AND TO_NUMBER(CP_ORIGEN) = TO_NUMBER(:cpOrigen) "
                    + " AND ID_TIPO = :idCanal "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("peso", paquete.getPeso());
            parametros.put("cpDestino", paquete.getCpDestino());
            parametros.put("cpOrigen", paquete.getCpOrigen());
            parametros.put("idCanal", paquete.getIdCanal());
            
            tarifa = um.queryForObject(sql, parametros, new TarifaMapper());
            
        } catch (Exception ex) {
            tarifa = new Tarifa();
            tarifa.setTarifa(-1);
        }
        
        return tarifa;
    }
    
    @Override
    public Tarifa getTarifaPesoAdicional(Paquete paquete, int idCarrier){
        
        Tarifa tarifa;
        
        String sql = " SELECT  NVL(MIN(TARIFA_FINAL),-1)  TARIFA "
                    + " FROM ( "
                    + " SELECT TARIFA + COSTO_PESO_EXTRA * (:peso - PESO_F_MAX) TARIFA_FINAL "
                    + " , TARIFA "
                    + " , COSTO_PESO_EXTRA * (:peso - PESO_F_MAX) ADICIONAL "
                    + " , :peso PESO "
                    + " , PESO_F_MAX "
                    + " , (:peso - PESO_F_MAX) DIFERENCIA "
                    + " , COSTO_PESO_EXTRA "
                    + " FROM INFO_CD.ECOM_CB_CARRIER_TARIFAS "
                    + " WHERE ESTATUS = 1 "
                    + " AND ID_CARRIER = :idCarrier "
                    + " AND TO_NUMBER(CP) = TO_NUMBER(:cpDestino) "
                    + " AND TO_NUMBER(CP_ORIGEN) = TO_NUMBER(:cpOrigen) "
                    + " AND ID_TIPO = :idCanal "
                    + " AND NVL(COSTO_PESO_EXTRA, 0) > 0 "
                    + " AND PESO_F_MAX < :peso "
                    + " ) "
                ;
        try {
            
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("peso", paquete.getPeso());
            parametros.put("cpDestino", paquete.getCpDestino());
            parametros.put("cpOrigen", paquete.getCpOrigen());
            parametros.put("idCanal", paquete.getIdCanal());
            
            tarifa = um.queryForObject(sql, parametros, new TarifaMapper());
            
        } catch (Exception ex) {
            tarifa = new Tarifa();
            tarifa.setTarifa(-1);
        }
        
        return tarifa;
    }
    
    private static final class ExclusionOInclusionMapper implements RowMapper<ExclusionOInclusion> {

        @Override
        public ExclusionOInclusion mapRow(ResultSet rs, int i) throws SQLException {

            ExclusionOInclusion exclusionOInclusion = new ExclusionOInclusion();
            exclusionOInclusion.setTipoExclusion(rs.getInt("ID_TIPO"));
            return exclusionOInclusion;
        }

    }

    private static final class TarifaMapper implements RowMapper<Tarifa> {

        @Override
        public Tarifa mapRow(ResultSet rs, int i) throws SQLException {

            Tarifa tarifa = new Tarifa();
            tarifa.setTarifa(rs.getDouble("TARIFA"));
            return tarifa;
        }

    }
    
    @Override
    public double getTarifaMejorCarrier(Paquete paquete, int idCarrier) {
        
        double tarifa = 0;
        
        String sql = " SELECT NVL(D.CANTIDAD, 0) CANTIDAD "
                + " FROM INFO_CD.ECOM_CB_HDR H "
                + " JOIN INFO_CD.ECOM_CB_DTL D "
                + " ON H.ID_CAJA = D.ID_CAJA "
                + " AND H.ID_CARRIER = D.ID_CARRIER "
                + " AND H.PEDIDO = D.PEDIDO "
                + " WHERE D.ID_CRITERIO = 2 "
                + " AND H.ID_CARRIER = :idCarrier "
                + " AND H.ID_CAJA = :idCaja "
                + " AND H.PEDIDO_VTEX = :so "
                + " AND H.CD_ID = :idManh "
                + " AND H.ID_TIPO = :idCanal "
                + " AND H.ID_TIPO_PEDIDO = :idTipoPedido "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("so", paquete.getPedidoAlterno());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCanal", paquete.getIdCanal());
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());
            
            tarifa = um.queryForObject(sql, parametros, Double.class);
            
        } catch (Exception ex) {
            tarifa = -1;
        }
        
        return tarifa;
    }

    @Override
    public Tarifa getTarifaInfo(Paquete paquete, int idCarrier) {
        Tarifa tarifa ;
        String sql = " select FCPORIGEN,FCPDESTINO,FCOSEXTRA,FPESOMIN,FPESOMAX,FTARIFA,FCOSEXTRA,FTARIFA + FCOSEXTRA tarifafinal from SCCENEN.COREBACKTRF\n" +
            "where FIPROVEEDORID = 1\n" +
            "and FCPORIGEN = '04300'\n" +
            "and FCPDESTINO = '04369'\n" +
            "and :peso between FPESOMIN and FPESOMAX\n" +
            "union\n" +
            "select FCPORIGEN,FCPDESTINO,FCOSEXTRA,FPESOMIN,FPESOMAX,FTARIFA,FCOSEXTRA,FTARIFA + FCOSEXTRA tarifafinal from SCCENEN.COREBACKTRF\n" +
            "where FIPROVEEDORID = 1\n" +
            "and FCPORIGEN = '04300'\n" +
            "and FCPDESTINO = '04369'\n" +
            "and FCOSEXTRA > 0\n" +
            "and FPESOMAX < :peso\n" +
            "union\n" +
            "select FCPORIGEN,FCPDESTINO,0,0,0,0,0,0 tarifafinal from SCCENEN.COREBACKTRF\n" +
            "where FIPROVEEDORID = 1\n" +
            "and FCPORIGEN = '04300'\n" +
            "and FCPDESTINO = '04369'\n" +
            "and rownum<2\n" +
            "order by 6 desc, 7 desc";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("cpDestino", paquete.getCpDestino());
            parametros.put("cpOrigen", paquete.getCpOrigen());
            parametros.put("peso", paquete.getPeso());
            
            tarifa = um.query(sql, parametros, new RowMapper<Tarifa>() {
                @Override
                public Tarifa mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Tarifa t=new Tarifa();
                    t.setCostoPesoExtra(rs.getDouble("FCOSEXTRA"));
                    t.setCpDestino(rs.getString("FCPDESTINO"));
                    t.setCpOrigen(rs.getString("FCPORIGEN"));
                    t.setPesoMaximo(rs.getDouble("FPESOMAX"));
                    t.setPesoMinimo(rs.getDouble("FPESOMIN"));
                    t.setTarifa(rs.getDouble("FTARIFA"));
                    t.setTarifaFinal(rs.getDouble("TARIFAFINAL"));
                    return t;
                }
            }).get(0);
            
        } catch (Exception ex) {
            tarifa = null;
        }
        return tarifa;
    }
    
}
