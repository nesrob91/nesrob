/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import mx.com.elektra.coreback2.beans.CajaRf;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author nroblerol
 */
public class CajaRfMapper implements RowMapper<CajaRf> {

    @Override
    public CajaRf mapRow(ResultSet rs, int i) throws SQLException {

        CajaRf caja = new CajaRf();
        caja.setLargo(rs.getDouble("LARGO"));
        caja.setAncho(rs.getDouble("ANCHO"));
        caja.setAlto(rs.getDouble("ALTO"));
        caja.setIdTipoCaja(rs.getInt("ID_TIPO_CAJA"));
        caja.setEmpaquePropio(rs.getInt("EMPAQUE_PROPIO") == 1);
        return caja;
    }

}
