/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.msd.qb.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import mx.com.elektra.msd.qb.model.DetalleSkus;
import mx.com.elektra.msd.qb.model.Sku;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author nroblerol
 */
public class DetalleSkusMapper implements RowMapper<DetalleSkus> {

        @Override
        public DetalleSkus mapRow(ResultSet rs, int i) throws SQLException {

            Sku sku = new Sku();
            sku.setIdSku(rs.getString("ID_SKU"));
            sku.setDescSku(rs.getString("DESC_SKU"));
            sku.setIdDepartamento(rs.getString("DEPARTAMENTO"));
            sku.setDescDepartamento(rs.getString("DESC_DEPARTAMENTO"));
            sku.setIdSubdepartamento(rs.getString("SUBDEPARTAMENTO"));
            sku.setDescSubdepartamento(rs.getString("DESC_SUBDEPARTAMENTO"));
            sku.setIdClase(rs.getString("CLASE"));
            sku.setDescClase(rs.getString("DESC_CLASE"));
            sku.setIdSubclase(rs.getString("SUBCLASE"));
            sku.setDescSubclase(rs.getString("DESC_SUBCLASE"));
            sku.setPeso(rs.getDouble("PESO"));
            sku.setLargo(rs.getDouble("LARGO"));
            sku.setAncho(rs.getDouble("ANCHO"));
            sku.setAlto(rs.getDouble("ALTO"));
            sku.setCostoUnitario(rs.getDouble("COSTO"));

            DetalleSkus detalleSku = new DetalleSkus();
            detalleSku.setSku(sku);
            detalleSku.setCantidad(rs.getInt("CANTIDAD"));

            return detalleSku;
        }
    
}
