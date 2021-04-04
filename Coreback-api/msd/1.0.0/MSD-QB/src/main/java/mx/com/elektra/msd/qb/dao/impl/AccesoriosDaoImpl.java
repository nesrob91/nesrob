/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.msd.qb.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.msd.qb.dao.AccesoriosDao;
import mx.com.elektra.msd.qb.model.Accesorio;
import mx.com.elektra.msd.qb.model.Paquete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dparra
 */
@Repository("accesoriosDao")
public class AccesoriosDaoImpl implements AccesoriosDao{
    @Autowired
    private NamedParameterJdbcTemplate scpp ;
    
    
    @Override
    public List<Accesorio> getAccesorios(Paquete paquete, int idCarrier){
        
        List<Accesorio> accesorios;
        
        String sql = " SELECT A.ID_ACCESORIO "
                    + " , A.DESCRIPCION "
                    + " , A.TIPO "
                    + " , R.VALOR "
                    + " FROM INFO_CD.PAQ_CAT_ACCESORIOS A "
                    + " , INFO_CD.PAQ_REL_CARRIER_ACCESORIO R "
                    + " WHERE A.ID_ACCESORIO = R.ID_ACCESORIO "
                    + " AND A.ID_CANAL = R.ID_CANAL "
                    + " AND A.FLG_ACTIVO = 1 "
                    + " AND R.FLG_ACTIVO = 1 "
                    + " AND R.ID_CARRIER = :idCarrier "
                    + " AND R.ID_CANAL = :idCanal "
                ;
        try {
            
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCarrier", idCarrier);
            parametros.put("idCanal", paquete.getIdCanal());
            
            accesorios = scpp.query(sql, parametros, new AccesorioMapper());
        }catch (EmptyResultDataAccessException ex) {
            accesorios = new ArrayList<>();
        } catch (Exception ex) {
            accesorios = null;
        }
        
        return accesorios;
    }
    
    @Override
    public double getMontoTotalAccesorios(Paquete paquete, int idCarrier){
        
        double montoTotal = 0;
        
        String sql = " SELECT NVL(SUM(MONTO), 0) MONTO_TOTAL "
                    + " FROM INFO_CD.ECOM_CB_CTR_SERVICIOS "
                    + " WHERE ID_CAJA = :idCaja "
                    + " AND PEDIDO = :pedido "
                    + " AND CD_ID = :idManh "
                    + " AND ID_TIPO = :idCanal "
                    + " AND ID_TIPO_PEDIDO = :idTipoPedido "
                    + " AND ID_CARRIER = :idCarrier "
                ;
        try {
            
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCanal", paquete.getIdCanal());
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());
            parametros.put("idCarrier", idCarrier);
            
            
            montoTotal = scpp.queryForObject(sql, parametros, Double.class);
        }catch (Exception ex) {
            montoTotal = 0;
        }
        
        return montoTotal;
    }
    
    @Override
    public boolean insertaAccesorio(Paquete paquete, int idCarrier, Accesorio accesorio, String usuario){
        
        int actualizados = 0;
        
        String sql = " INSERT INTO INFO_CD.ECOM_CB_CTR_SERVICIOS "
                + " (CD_ID, ID_CARRIER, PEDIDO, ID_CAJA, ID_TIPO, ID_TIPO_PEDIDO, ID_ACCESORIO, MONTO, USUARIO_CREACION, FECHA_CREACION) "
                + " VALUES "
                + " (:idManh, :idCarrier, :pedido, :idCaja, :idCanal, :idTipoPedido, :idAccesorio, :monto, :usuarioCreacion, SYSDATE)"
                ;
        try {
            
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCarrier", idCarrier);
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idCanal", paquete.getIdCanal());
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());
            parametros.put("idAccesorio", accesorio.getIdAccesorio());
            parametros.put("monto", accesorio.getMonto());
            parametros.put("usuarioCreacion", usuario);
            
            
            actualizados = scpp.update(sql, parametros);
            
        }catch (Exception ex) {
            actualizados = 0;
        }
        
        return actualizados > 0;
    }
    
    @Override
    public boolean isDestinoReqSeguro(Paquete paquete, int idCarrier){
        
        boolean destinoReqSeguro;
        
        String sql = " SELECT (CASE WHEN COUNT(*) > 1 THEN 1 ELSE COUNT(*) END) SEGURO "
                    + " FROM INFO_CD.ECOM_CB_CARRIER_TARIFAS "
                    + " WHERE ESTATUS = 1 "
                    + " AND FLG_SEGURO = 1 "
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
            
            destinoReqSeguro = scpp.queryForObject(sql, parametros, Integer.class) > 0;
            
        }catch (Exception ex) {
            destinoReqSeguro = false;
        }
        
        return destinoReqSeguro;
    }
    
    
    private static final class AccesorioMapper implements RowMapper<Accesorio> {

        @Override
        public Accesorio mapRow(ResultSet rs, int i) throws SQLException {

            Accesorio accesorio = new Accesorio();
            accesorio.setIdAccesorio(rs.getInt("ID_ACCESORIO"));
            accesorio.setTipo(rs.getString("TIPO"));
            accesorio.setValor(rs.getDouble("VALOR"));
            return accesorio;
        }

    }
    
}
