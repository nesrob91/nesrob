/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 *
 * @author dparra
 */
public class LogsDaoImpl {
    
    //private Conexion con = new Conexion(false);
    private NamedParameterJdbcTemplate jdbcTemplate2010 = new DataSources().namedTemplate2010();
    
    public boolean error(Integer idError, Integer idApp, Integer idManh, Integer idEstacion, String pedido, int idCaja, Integer idCarrier, String numGuia, Integer idCanal, Integer idTipoPedido, String logs, String fuente, String usuario){
        
        String query = " INSERT INTO INFO_CD.PAQ_LOG_ERRORES "
                + " (ID_ERROR, ID_APLICACION, ID_MANH, ID_ESTACION, ID_CANAL, ID_TIPO_PEDIDO, PEDIDO, ID_CAJA, ID_CARRIER "
                + " , NUM_GUIA, LOGS, ID_ESTATUS, FUENTE, USUARIO_CREACION, FECHA_CREACION) "
                + " VALUES "
                + " ( "
                + ((idError == null) ? " NULL " : "'" + idError + "'")
                + " , " + ((idApp == null) ? " NULL " : "'" + idApp + "'")
                + " , " + ((idManh == null) ? " NULL " : "'" + idManh + "'")
                + " , " + ((idEstacion == null) ? " NULL " : "'" + idEstacion + "'")
                + " , " + ((idCanal == null) ? " NULL " : "'" + idCanal + "'")
                + " , " + ((idTipoPedido == null) ? " NULL " : "'" + idTipoPedido + "'")
                + " , " + ((pedido == null) ? " NULL " : "'" + pedido + "'")
                + " , " + ((idCaja == 0) ? " NULL " : "'" + idCaja + "'")
                + " , " + ((idCarrier == null) ? " NULL " : "'" + idCarrier + "'")
                + " , " + ((numGuia == null) ? " NULL " : "'" + numGuia + "'")
                + " , " + ((logs == null) ? " NULL " : "'" + logs + "'")
                + " , 0 "
                + " , " + ((fuente == null) ? " NULL " : "'" + fuente + "'")
                + " , " + ((usuario == null) ? " NULL " : "'" + usuario + "'")
                + " , SYSDATE "
                + " ) "
                ;

        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            
            return jdbcTemplate2010.update(query, parametros) > 0;
        } catch (Exception ex) {
            return false;
        }
    }
    
}