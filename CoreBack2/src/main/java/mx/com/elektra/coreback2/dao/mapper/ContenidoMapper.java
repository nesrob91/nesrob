/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import mx.com.elektra.coreback2.beans.Contenido;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author nroblerol
 */
public class ContenidoMapper implements RowMapper<Contenido> {

    @Override
    public Contenido mapRow(ResultSet rs, int i) throws SQLException {
        Contenido c = new Contenido();
        c.setIdManh(rs.getString("ID_MANH"));
        c.setSku(rs.getString("ID_SKU"));
        c.setCantidad(rs.getInt("CANTIDAD"));
        c.setIdLpn(rs.getString("ID_LPN"));
        c.setOrderId(rs.getString("ORDER_ID"));
        c.setAdn(rs.getString("ADN"));
        c.setSo(rs.getString("SO"));
        c.setNc(rs.getString("NC"));
        return c;
    }

}
