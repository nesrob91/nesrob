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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dparra
 */
@Repository
public class LogsDaoImpl {
    
    //private Conexion con = new Conexion(false);
    @Autowired
    private NamedParameterJdbcTemplate scpp;
    
    public boolean error(Integer idError, Integer idApp, Integer idManh, Integer idEstacion, String pedido, int idCaja, Integer idCarrier, String numGuia, Integer idCanal, 
            Integer idTipoPedido, String logs, String fuente, String usuario, String ref_field_1,String ref_field_2,String ref_field_3){
        
        String query = " INSERT INTO INFO_CD.PAQ_LOG_ERRORES "
                + " (ID_ERROR, ID_APLICACION, ID_MANH, ID_ESTACION, ID_CANAL, ID_TIPO_PEDIDO, PEDIDO, ID_CAJA, ID_CARRIER "
                + " , NUM_GUIA, LOGS, ID_ESTATUS, FUENTE, USUARIO_CREACION, FECHA_CREACION, REF_FIELD_1,REF_FIELD_2,REF_FIELD_3) "
                + " VALUES "
                + " ( :idError, :idApp, :idManh, :idEstacion, :idCanal, :idTipoPedido, :pedido, :idCaja, :idCarrier, :numGuia, :logs, 0, :fuente, :usuario, sysdate, :rf1, :rf2, :rf3)"
                ;

        try {
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("idError",idError);
            parametros.put("idApp",idApp);
            parametros.put("idManh",idManh);
            parametros.put("idEstacion",idEstacion);
            parametros.put("idCanal",idCanal);
            parametros.put("idTipoPedido",idTipoPedido);
            parametros.put("pedido",pedido);
            parametros.put("idCaja",idCaja);
            parametros.put("idCarrier",idCarrier);
            parametros.put("numGuia",numGuia);
            parametros.put("logs",logs);
            parametros.put("fuente",fuente);
            parametros.put("usuario",usuario);
            parametros.put("rf1",ref_field_1);
            parametros.put("rf2",ref_field_2);
            parametros.put("rf3",ref_field_3);
            return scpp.update(query, parametros) > 0;
        } catch (Exception ex) {
            return false;
        }
    }
    
}
