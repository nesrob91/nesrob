/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
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
@Repository("reglasDao")
public class ReglasDaoImpl implements ReglasDao{

    @Autowired
    private NamedParameterJdbcTemplate scpp ;
    
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
            
            estatusDestino = scpp.queryForObject(sql, parametros, Integer.class) > 0;
        } catch (Exception ex) {
            return false;
        }
        
        return estatusDestino;
    }

    @Override
    public int getRatingCarrier(Paquete paquete, int idCarrier) {
        
        int calificacion = 0;
        String sql = " SELECT NVL( CALIFICACION, -1) CALIFICACION "
                    + " FROM "
                    + " ( "
                    + " SELECT MAX(CALIFICACION) CALIFICACION "
                    + " FROM INFO_CD.ECOM_CB_RATING "
                    + " WHERE ID_CARRIER = :idCarrier "
                    + " AND ID_TIPO_CANAL = :idCanal "
                    + " ) "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            switch(paquete.getIdTipoPedido()){
                case 7:
                    parametros.put("idCanal", paquete.getIdTipoPedido());
                    break;
                default :
                    parametros.put("idCanal", paquete.getIdCanal());
                    break;
            }
            calificacion = scpp.queryForObject(sql, parametros, Integer.class) ;
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
            
            pesoValido = scpp.queryForObject(sql, parametros, Integer.class) > 0;
            
        } catch (Exception ex) {
            pesoValido = false;
        }
        
        return pesoValido;
    }
    
    @Override
    public ExclusionOInclusion getExclusionesEInclusiones(Sku sku, Paquete paquete, int idCarrier, String tipo){
        
        ExclusionOInclusion exclusion;
        
        String sql = " SELECT E.ID_TIPO "
                    + " FROM INFO_CD.CE_EI_CARRIERS E "
                    + " WHERE FLG_ACTIVO = 1 "
                    + " AND ID_CARRIER = :idCarrier "
                    + " AND E.ID_TIPO_CANAL = :idCanal "
                    + " AND ( "
                    + " ( ID_TIPO = 1 AND DEPTO = :departamento ) "
                    + " OR ( ID_TIPO = 2 AND SDEPTO = :subdepartamento ) "
                    + " OR ( ID_TIPO = 3 AND CLASE = :clase ) "
                    + " OR ( ID_TIPO = 4 AND SCLASE = :subclase ) "
                    + " OR ( ID_TIPO = 5 AND SKU_ID = :sku ) "
                    + " )"
                    + " AND TIPO_EI = :tipo "
                    + " ORDER BY E.ID_TIPO DESC "
                ;
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("idCanal", paquete.getIdCanal());
            parametros.put("departamento", sku.getIdDepartamento());
            parametros.put("subdepartamento", sku.getIdSubdepartamento());
            parametros.put("clase", sku.getIdClase());
            parametros.put("subclase", sku.getIdSubclase());
            parametros.put("sku", sku.getIdSku());
            parametros.put("tipo", tipo);
            
            exclusion = scpp.queryForObject(sql, parametros, new ExclusionOInclusionMapper());
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
            
            capacidad = scpp.queryForObject(sql, parametros, Integer.class) > 0;
            
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
            
            capacidad = scpp.queryForObject(sql, parametros, Integer.class);
            
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
            
            porcentaje = scpp.queryForObject(sql, parametros, Integer.class);
            
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
            
            porcentaje = scpp.queryForObject(sql, parametros, Integer.class);
            
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
            
            estatusHorario = scpp.queryForObject(sql, parametros, Integer.class);
            
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
            
            cantidad = scpp.queryForObject(sql, parametros, Integer.class);
            
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
            
            cantidad = scpp.queryForObject(sql, parametros, Integer.class);
            
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
            
            tarifa = scpp.queryForObject(sql, parametros, new TarifaMapper());
            
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
            
            tarifa = scpp.queryForObject(sql, parametros, new TarifaMapper());
            
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
            
            tarifa = scpp.queryForObject(sql, parametros, Double.class);
            
        } catch (Exception ex) {
            tarifa = -1;
        }
        
        return tarifa;
    }

    @Override
    public Tarifa getTarifaInfo(Paquete paquete, int idCarrier) {
        Tarifa tarifa ;
        String sql = "select * from ( select id_carrier,cp,cp_origen,peso_f_min,peso_f_max,peso_v_min,peso_v_max,tarifa\n" +
            ",flg_seguro,costo_peso_extra,tipo_envio, tarifa tarifa_final, 0 adicional, 0 diferencia\n" +
            "from info_cd.ecom_cb_carrier_tarifas \n" +
            "where ESTATUS = 1 \n" +
            "AND ID_CARRIER = :idCarrier \n" +
            "AND :peso BETWEEN PESO_F_MIN AND PESO_F_MAX \n" +
            "AND TO_NUMBER(CP) = TO_NUMBER(:cpDestino) \n" +
            "AND TO_NUMBER(CP_ORIGEN) = TO_NUMBER(:cpOrigen) \n" +
            "AND ID_TIPO = :idCanal \n" +
            "union\n" +
            "SELECT id_carrier,cp,cp_origen,peso_f_min,peso_f_max,peso_v_min,peso_v_max,tarifa\n" +
            ",flg_seguro,costo_peso_extra,tipo_envio, TARIFA + (COSTO_PESO_EXTRA * (:peso - PESO_F_MAX)) TARIFA_FINAL \n" +
            ", COSTO_PESO_EXTRA * (:peso - PESO_F_MAX) ADICIONAL \n" +
            ", (:peso - PESO_F_MAX) DIFERENCIA \n" +
            "FROM INFO_CD.ECOM_CB_CARRIER_TARIFAS \n" +
            "WHERE ESTATUS = 1 \n" +
            "AND ID_CARRIER = :idCarrier \n" +
            "AND TO_NUMBER(CP) = TO_NUMBER(:cpDestino) \n" +
            "AND TO_NUMBER(CP_ORIGEN) = TO_NUMBER(:cpOrigen) \n" +
            "AND ID_TIPO = :idCanal \n" +
            "AND NVL(COSTO_PESO_EXTRA, 0) > 0 \n" +
            "AND PESO_F_MAX < :peso \n" + 
            "union \n" +
            "SELECT id_carrier,cp,cp_origen,peso_f_min,peso_f_max,peso_v_min,peso_v_max, 0\n" +
            ",flg_seguro,costo_peso_extra,tipo_envio, 0 tarifa_final\n" +
            ", 0 ADICIONAL \n" +
            ", 0 DIFERENCIA \n" +
            "FROM INFO_CD.ECOM_CB_CARRIER_TARIFAS \n" +
            "WHERE ESTATUS = 1 \n" +
            "AND ID_CARRIER = :idCarrier \n" +
            "AND TO_NUMBER(CP) = TO_NUMBER(:cpDestino) \n" +
            "AND TO_NUMBER(CP_ORIGEN) = TO_NUMBER(:cpOrigen) \n" +
            "AND ID_TIPO = :idCanal \n" +
            "--AND NVL(COSTO_PESO_EXTRA, 0) > 0 \n" +
            "--AND :peso < PESO_F_MAX\n" +
            "and rownum < 2\n" +
            "order by tarifa desc\n" +
            ")\n" +
            "where rownum < 2";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("cpDestino", paquete.getCpDestino());
            parametros.put("cpOrigen", paquete.getCpOrigen());
            parametros.put("peso", paquete.getPeso());
            parametros.put("idCanal", paquete.getIdCanal());
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());
            
            tarifa = scpp.queryForObject(sql, parametros, new RowMapper<Tarifa>() {
                @Override
                public Tarifa mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Tarifa t=new Tarifa();
                    t.setCostoPesoExtra(rs.getDouble("COSTO_PESO_EXTRA"));
                    t.setCpDestino(rs.getString("CP"));
                    t.setCpOrigen(rs.getString("CP_ORIGEN"));
                    t.setPesoMaximo(rs.getDouble("PESO_F_MAX"));
                    t.setPesoMinimo(rs.getDouble("PESO_F_MIN"));
                    t.setSeguro(rs.getInt("FLG_SEGURO")==1);
                    t.setTarifa(rs.getDouble("TARIFA"));
                    t.setTipoTransporte(rs.getString("TIPO_ENVIO"));
                    t.setTarifaFinal(rs.getDouble("TARIFA_FINAL"));
                    t.setPesoExtra(rs.getDouble("DIFERENCIA"));
                    t.setCostoExtra(rs.getDouble("ADICIONAL"));
                    return t;
                }
            });
            
        } catch (Exception ex) {
            tarifa = null;
        }
        return tarifa;
    }
    
}