/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.dao.impl;

import com.elektra.cadsumutils.dao.DataSources;
import java.util.HashMap;
import java.util.Map;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.dao.DepuradorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dparra
 */
@Repository("depuradorDaoUm")
public class DepuradorDaoUmImpl implements DepuradorDao{
    @Autowired
    private NamedParameterJdbcTemplate um ;
     
    @Override
    public boolean eliminaCbHdr(Paquete paquete){
        
        String sql = " UPDATE SCCENEN.corebackhdr SET FACTIVO = 0 "
                + " WHERE FIENTREGAID = :pedido  "
                + " AND FICENTROID = :idManh "
                ;

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();
            
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCanal", paquete.getIdCanal());
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());
            
            return um.update(sql, parametros) > 0;

        } catch (Exception ex) {
            return false;
        }

    }
    
    @Override
    public boolean eliminaAccesorios(Paquete paquete){
        
        String sql = " DELETE FROM INFO_CD.ECOM_CB_CTR_SERVICIOS "
                + " WHERE PEDIDO LIKE '%' || :pedido || '%' "
                + " AND ID_CAJA = :idCaja "
                + " AND CD_ID = :idManh "
                + " AND ID_TIPO = :idCanal "
                + " AND ID_TIPO_PEDIDO = :idTipoPedido "
                ;

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();
            
            
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCanal", paquete.getIdCanal());
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());
            return um.update(sql, parametros) > 0;

        } catch (Exception ex) {
            return false;
        }

    }
    
    @Override
    public boolean eliminaCbDtl(Paquete paquete){
        
        
        String sql = " DELETE FROM INFO_CD.ECOM_CB_DTL "
                + " WHERE PEDIDO LIKE '%' || :pedido || '%' "
                + " AND ID_CAJA = :idCaja "
                + " AND CD_ID = :idManh "
                ;

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();
            
            
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            
            return um.update(sql, parametros) > 0;

        } catch (Exception ex) {
            return false;
        }
        
    }
    
    @Override
    public boolean eliminaContenidoCaja(Paquete paquete){
        
        
        String sql = " DELETE FROM INFO_CD.PAQ_CTR_CAJAS_CONTENIDO "
                + " WHERE PEDIDO LIKE '%' || :pedido || '%' "
                + " AND ID_CAJA = :idCaja "
                + " AND ID_MANH = :idManh "
                + " AND ID_TIPO = :idCanal "
                + " AND ID_TIPO_PEDIDO = :idTipoPedido "
                ;

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();
            
            
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCanal", paquete.getIdCanal());
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());
            
            return um.update(sql, parametros) > 0;

        } catch (Exception ex) {
            return false;
        }

    }
    
    @Override
    public int countCbHdr(Paquete paquete){
        
        String sql = " select count(*) FROM SCCENEN.corebackhdr "
                + " WHERE FIENTREGAID = :pedido  "
                + " AND FICENTROID = :idManh "
                + " and FACTIVO = 1 "
                    ;
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idManh", paquete.getIdManh());
            
            return um.queryForObject(sql, parametros, Integer.class);
        } catch (Exception ex) {
            return 0;
        }
    
    }
    
    @Override
    public int countCbDtl(Paquete paquete){
        
        String sql = " SELECT COUNT(*) CANTIDAD "
                + " FROM INFO_CD.ECOM_CB_DTL "
                + " WHERE PEDIDO LIKE '%' || :pedido || '%' "
                + " AND ID_CAJA = :idCaja "
                + " AND CD_ID = :idManh "
                    ;
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            
            return um.queryForObject(sql, parametros, Integer.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
    
    }
    
    @Override
    public int countContenidoCaja(Paquete paquete){
        
        String sql = " SELECT COUNT(*) CANTIDAD "
                + " FROM INFO_CD.PAQ_CTR_CAJAS_CONTENIDO "
                + " WHERE PEDIDO LIKE '%' || :pedido || '%' "
                + " AND ID_CAJA = :idCaja "
                + " AND ID_MANH = :idManh "
                + " AND ID_TIPO = :idCanal "
                + " AND ID_TIPO_PEDIDO = :idTipoPedido "
                    ;
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCanal", paquete.getIdCanal());
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());
            
            return um.queryForObject(sql, parametros, Integer.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
    
    }
    
    @Override
    public int countGuia(Paquete paquete){
        
        String sql = " SELECT COUNT(*) CANTIDAD "
                + " FROM INFO_CD.CE_CONTROL_GUIAS "
                + " WHERE PEDIDO = TO_NUMBER(:pedido) "
                + " AND REF_FIELD_2 = :idCaja "
                + " AND CD_ID = :idManh "
                //+ " AND ID_TIPO = :idCanal "
                + " AND ID_TIPO_PEDIDO = :idTipoPedido "
                    ;
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCanal", paquete.getIdCanal());
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());
            
            return um.queryForObject(sql, parametros, Integer.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
    
    }
    
    
    
    @Override
    public int countAccesorios(Paquete paquete){
        
        
        String sql = " SELECT COUNT(*) CANTIDAD"
                + " FROM INFO_CD.ECOM_CB_CTR_SERVICIOS "
                + " WHERE PEDIDO LIKE '%' || :pedido || '%' "
                + " AND ID_CAJA = :idCaja "
                + " AND CD_ID = :idManh "
                + " AND ID_TIPO = :idCanal "
                + " AND ID_TIPO_PEDIDO = :idTipoPedido "
                    ;
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idCaja", paquete.getIdCaja());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCanal", paquete.getIdCanal());
            parametros.put("idTipoPedido", paquete.getIdTipoPedido());
            
            return um.queryForObject(sql, parametros, Integer.class);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return 0;
        }
    
    }
    
}
