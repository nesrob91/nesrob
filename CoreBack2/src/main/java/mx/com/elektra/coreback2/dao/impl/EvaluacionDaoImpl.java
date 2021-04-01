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
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Regla;
import mx.com.elektra.coreback2.dao.EvaluacionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dparra
 */
@Repository("evaluacionDao")
public class EvaluacionDaoImpl implements EvaluacionDao{
    @Autowired
    private NamedParameterJdbcTemplate scpp ;
    
    @Override
    public List<Integer> getIdCarriersCumplenCondicion(Paquete paquete, Regla regla){
        
        String sql = " SELECT ID_CARRIER "
                    + " FROM INFO_CD.ECOM_CB_DTL "
                    + " WHERE PEDIDO = :pedido "
                    + " AND ID_CAJA = :idCaja "
                    + " AND CD_ID = :idManh "
                    + " AND ID_CRITERIO = :idRegla "
                    + " AND CANTIDAD = 1 "
                    + " ORDER BY ID_CARRIER ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idRegla", regla.getIdRegla());
            
            return scpp.queryForList(sql, parametros, Integer.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Integer> getIdCarriersMenorValor(Paquete paquete, Regla regla){
        
        String sql = " SELECT ID_CARRIER "
                    + " FROM INFO_CD.ECOM_CB_DTL "
                    + " WHERE PEDIDO = :pedido "
                    + " AND ID_CAJA = :idCaja "
                    + " AND CD_ID = :idManh "
                    + " AND ID_CRITERIO = :idRegla "
                    + " AND NVL(CANTIDAD, -1) IN( "
                    + " SELECT NVL(MIN(CANTIDAD), -1) "
                    + " FROM INFO_CD.ECOM_CB_DTL "
                    + " WHERE PEDIDO = :pedido "
                    + " AND ID_CAJA = :idCaja "
                    + " AND CD_ID = :idManh "
                    + " AND ID_CRITERIO = :idRegla "
                    + " ) "
                    + " ORDER BY ID_CARRIER "
                    ;
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idRegla", regla.getIdRegla());
            
            return scpp.queryForList(sql, parametros, Integer.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
        
    }
    
    @Override
    public List<Integer> getIdCarriersMayorValor(Paquete paquete, Regla regla){
        
        String sql = " SELECT ID_CARRIER "
                    + " FROM INFO_CD.ECOM_CB_DTL "
                    + " WHERE PEDIDO = :pedido "
                    + " AND ID_CAJA = :idCaja "
                    + " AND CD_ID = :idManh "
                    + " AND ID_CRITERIO = :idRegla "
                    + " AND NVL(CANTIDAD, -1) IN( "
                    + " SELECT NVL(MAX(CANTIDAD), -1) "
                    + " FROM INFO_CD.ECOM_CB_DTL "
                    + " WHERE PEDIDO = :pedido "
                    + " AND ID_CAJA = :idCaja "
                    + " AND CD_ID = :idManh "
                    + " AND ID_CRITERIO = :idRegla "
                    + " ) "
                    + " ORDER BY ID_CARRIER "
                    ;
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idRegla", regla.getIdRegla());
            
            return scpp.queryForList(sql, parametros, Integer.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
        
    }
    
    @Override
    public List<Integer> getIdCarriersByRegla(Paquete paquete, Regla regla){
        
        String sql = " SELECT ID_CARRIER "
                    + " FROM INFO_CD.ECOM_CB_DTL "
                    + " WHERE PEDIDO = :pedido "
                    + " AND ID_CAJA = :idCaja "
                    + " AND CD_ID = :idManh "
                    + " AND ID_CRITERIO = :idRegla "
                    + " ORDER BY ID_CARRIER "
                    ;
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idRegla", regla.getIdRegla());
            
            return scpp.queryForList(sql, parametros, Integer.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
        
        
    }
    
    @Override
    public boolean actualizaCarriers(Paquete paquete, Regla regla, List<Integer> idCarriers, int idEstatus, String usuario){
        
        String sql = " UPDATE INFO_CD.ECOM_CB_DTL"
                + " SET FLG_VALIDO = :flgValido "
                + " , USUARIO_MODIFICACION = SUBSTR( :usuarioModificacion , 0, 45) "
                + " , FECHA_MODIFICACION = SYSDATE "
                + " WHERE PEDIDO = :pedido "
                + " AND ID_CRITERIO = :idRegla "
                + " AND ID_CAJA = :idCaja "
                + " AND ID_CARRIER IN( :idCarriers )"
                ;

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("flgValido", idEstatus);
            parametros.put("usuarioModificacion", usuario);
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idRegla", regla.getIdRegla());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idCarriers", idCarriers);
            
            return scpp.update(sql, parametros) > 0;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }
    
}
