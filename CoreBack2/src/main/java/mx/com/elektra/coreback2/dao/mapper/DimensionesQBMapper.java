/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author nroblerol
 */
public class DimensionesQBMapper implements RowMapper<DimensionesQB> {

        @Override
        public DimensionesQB mapRow(ResultSet rs, int i) throws SQLException {
            DimensionesQB dimensionesQB = new DimensionesQB();
            dimensionesQB.setAlto(rs.getDouble("ALTO"));
            dimensionesQB.setAncho(rs.getDouble("ANCHO"));
            dimensionesQB.setLargo(rs.getDouble("LARGO"));
            dimensionesQB.setVolumen(rs.getDouble("VOLUMEN"));
            dimensionesQB.setPesoFisico(rs.getDouble("PESO_FISICO"));
            dimensionesQB.setPesoVolumetrico(rs.getDouble("PESO_VOLUMETRICO"));
            return dimensionesQB;
        }

    }
