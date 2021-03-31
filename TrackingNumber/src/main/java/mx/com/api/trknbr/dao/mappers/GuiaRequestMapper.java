/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import mx.com.api.trknbr.beans.GuiaRequest;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author nroblerol
 */
public class GuiaRequestMapper implements RowMapper<GuiaRequest> {

        @Override
        public GuiaRequest mapRow(ResultSet rs, int i) throws SQLException {
            
            GuiaRequest guiaRequest = new GuiaRequest();
            guiaRequest.setVtex(rs.getString("PEDIDO"));
                    guiaRequest.setIdManh(rs.getInt("ID_MANH"));
                    guiaRequest.setIdCaja(rs.getInt("ID_CAJA"));
                    guiaRequest.setIdLpn(rs.getString("ID_LPN"));
                    guiaRequest.setIdCanal(rs.getInt("ID_TIPO"));
                    guiaRequest.setIdTipoPedido(rs.getInt("ID_TIPO_PEDIDO"));
                    guiaRequest.setIdCarrier(rs.getInt("ID_CARRIER"));
                    guiaRequest.setLargo(rs.getDouble("LARGO"));
                    guiaRequest.setAncho(rs.getDouble("ANCHO"));
                    guiaRequest.setAlto(rs.getDouble("ALTO"));
                    guiaRequest.setPeso(rs.getDouble("PESO"));
            return guiaRequest;
        }
    
}
