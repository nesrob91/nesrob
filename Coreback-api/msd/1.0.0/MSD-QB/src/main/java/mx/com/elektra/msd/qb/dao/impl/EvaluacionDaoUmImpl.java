/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.msd.qb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.msd.qb.common.BrmsCommon;
import mx.com.elektra.msd.qb.dao.EvaluacionDao;
import mx.com.elektra.msd.qb.model.Paquete;
import mx.com.elektra.msd.qb.model.Regla;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dparra
 */
@Repository("evaluacionDaoUm")
public class EvaluacionDaoUmImpl implements EvaluacionDao{
    @Autowired
    private NamedParameterJdbcTemplate um ;
    @Autowired
    private BrmsCommon app;
    
    @Override
    public List<Integer> getIdCarriersCumplenCondicion(Paquete paquete, Regla regla){
        
        String sql = " SELECT FIPROVEEDORID \n" +
            "FROM SCCENEN.corebackdtl\n" +
            "WHERE FIENTREGAID = :pedido\n" +
            "AND FICENTROID = :idManh \n" +
            "AND FKCRITERIO = :idRegla \n" +
            "AND FCANTIDAD = 1 \n" +
                " and fpid = :folio\n" +
            "ORDER BY FIPROVEEDORID  ";
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("folio", paquete.getFolio());
            parametros.put("idRegla", regla.getIdRegla());
            
            return um.queryForList(sql, parametros, Integer.class);
        } catch (Exception ex) {
            if(app.isWriteConsole())
                System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<Integer> getIdCarriersMenorValor(Paquete paquete, Regla regla){
        
        String sql = " SELECT FIPROVEEDORID \n" +
            "FROM SCCENEN.corebackdtl\n" +
            "WHERE FIENTREGAID = :pedido \n" +
            "AND FICENTROID = :idManh \n" +
            "AND FKCRITERIO = :idRegla \n" +
            "AND NVL(FCANTIDAD, -1) IN( \n" +
            "SELECT NVL(MIN(FCANTIDAD), -1) \n" +
            "FROM SCCENEN.corebackdtl\n" +
            "WHERE FIENTREGAID = :pedido \n" +
            "AND FICENTROID = :idManh \n" +
            "AND FKCRITERIO = :idRegla \n" +
                " and fpid = :folio\n" +
            ") \n" +
                " and fpid = :folio\n" +
            "ORDER BY FIPROVEEDORID "
                    ;
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("folio", paquete.getFolio());
            parametros.put("idRegla", regla.getIdRegla());
            
            return um.queryForList(sql, parametros, Integer.class);
        } catch (Exception ex) {
            if(app.isWriteConsole())
                System.out.println("Error: " + ex.getMessage());
            return null;
        }
        
    }
    
    @Override
    public List<Integer> getIdCarriersMayorValor(Paquete paquete, Regla regla){
        
        String sql = " SELECT FIPROVEEDORID \n" +
            "FROM SCCENEN.corebackdtl\n" +
            "WHERE FIENTREGAID = :pedido \n" +
            "AND FICENTROID = :idManh \n" +
            "AND FKCRITERIO = :idRegla \n" +
            "AND NVL(FCANTIDAD, -1) IN( \n" +
            "SELECT NVL(MAX(FCANTIDAD), -1) \n" +
            "FROM SCCENEN.corebackdtl\n" +
            "WHERE FIENTREGAID = :pedido \n" +
            "AND FICENTROID = :idManh \n" +
            "AND FKCRITERIO = :idRegla \n" +
                " and fpid = :folio\n" +
            ") \n" +
                " and fpid = :folio\n" +
            "ORDER BY FIPROVEEDORID "
                    ;
        
        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("folio", paquete.getFolio());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idRegla", regla.getIdRegla());
            
            return um.queryForList(sql, parametros, Integer.class);
        } catch (Exception ex) {
            if(app.isWriteConsole())
                System.out.println("Error: " + ex.getMessage());
            return null;
        }
        
    }
    
    @Override
    public List<Integer> getIdCarriersByRegla(Paquete paquete, Regla regla){
        
        String sql = " SELECT FIPROVEEDORID \n" +
            "FROM SCCENEN.corebackdtl\n" +
            "WHERE FIENTREGAID = :pedido\n" +
            "AND FICENTROID = :idManh \n" +
            "AND FKCRITERIO = :idRegla \n" +
                " and fpid = :folio \n" +
            "ORDER BY FIPROVEEDORID"
                    ;
        
        try {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idRegla", regla.getIdRegla());
            parametros.put("folio", paquete.getFolio());
            
            return um.queryForList(sql, parametros, Integer.class);
        } catch (Exception ex) {
            if(app.isWriteConsole())
                System.out.println("Error: " + ex.getMessage());
            return null;
        }
        
        
    }
    
    @Override
    public boolean actualizaCarriers(Paquete paquete, Regla regla, List<Integer> idCarriers, int idEstatus, String usuario){
        
        String sql = " UPDATE SCCENEN.corebackdtl\n" +
            "SET FPSELECION = :flgValido \n" +
            ", FUMODIFICA = SUBSTR( :usuarioModificacion , 0, 40) \n" +
            ", FFMODIFICA = SYSDATE \n" +
            "WHERE FIENTREGAID = :pedido \n" +
            "AND FKCRITERIO = :idRegla \n" +
            "AND FIPROVEEDORID IN( :idCarriers )\n" +
                " and fpid = :folio\n" +
            "and FICENTROID = :idManh"
                ;

        try {

            Map<String, Object> parametros = new HashMap<String, Object>();

            parametros.put("flgValido", idEstatus);
            parametros.put("usuarioModificacion", usuario);
            parametros.put("pedido", paquete.getPedido());
            parametros.put("idRegla", regla.getIdRegla());
            parametros.put("idManh", paquete.getIdManh());
            parametros.put("idCarriers", idCarriers);
            parametros.put("folio", paquete.getFolio());
            
            return um.update(sql, parametros) > 0;

        } catch (Exception ex) {
            if(app.isWriteConsole())
                System.out.println(ex.getMessage());
            return false;
        }

    }
    
}
