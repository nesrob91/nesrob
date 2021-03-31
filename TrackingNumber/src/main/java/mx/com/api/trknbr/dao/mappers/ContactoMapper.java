/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import mx.com.api.trknbr.beans.Contacto;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author nroblerol
 */
public class ContactoMapper implements RowMapper<Contacto> {

    @Override
    public Contacto mapRow(ResultSet rs, int i) throws SQLException {

        Contacto contacto = new Contacto();
        try {
            contacto.setCp(rs.getString("CP_ORIGEN"));
            contacto.setDireccion(rs.getString("DIRECCION_ORIGEN"));
            if (rs.getString("NUMERO_EXT_ORIGEN") == null || rs.getString("NUMERO_EXT_ORIGEN").equals("SN") || rs.getString("NUMERO_EXT_ORIGEN").equals("S/N") || rs.getString("NUMERO_EXT_ORIGEN").equals("")) {
                contacto.setnExt("0");
            } else {
                contacto.setnExt(rs.getString("NUMERO_EXT_ORIGEN"));
            }
            if (rs.getString("NUMERO_INT_ORIGEN") == null || rs.getString("NUMERO_INT_ORIGEN").equals("SN") || rs.getString("NUMERO_INT_ORIGEN").equals("S/N") || rs.getString("NUMERO_INT_ORIGEN").equals("")) {
                contacto.setnInt("0");
            } else {
                contacto.setnInt(rs.getString("NUMERO_INT_ORIGEN"));
            }
            contacto.setCiudad(rs.getString("CIUDAD_ORIGEN"));
            contacto.setContacto(rs.getString("CONTACTO_ORIGEN"));
            contacto.setRazonSocial(rs.getString("RAZON_SOCIAL_ORIGEN"));
            contacto.setColonia(rs.getString("COLONIA_ORIGEN"));
            contacto.setEstado(rs.getString("ESTADO_ORIGEN"));
            contacto.setIdEstado(rs.getString("ID_ESTADO_ORIGEN"));
            if (rs.getString("TELEFONO_ORIGEN") == null || rs.getString("TELEFONO_ORIGEN").equals("")) {
                contacto.setTelefono("");
            } else {
                contacto.setTelefono(rs.getString("TELEFONO_ORIGEN"));
            }
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
        try {
            contacto.setCp(rs.getString("CP_DESTINO"));
            contacto.setDireccion(rs.getString("DIRECCION_DESTINO"));
            if (rs.getString("NUMERO_EXT_DESTINO") == null || rs.getString("NUMERO_EXT_DESTINO").equals("SN") || rs.getString("NUMERO_EXT_DESTINO").equals("S/N") || rs.getString("NUMERO_EXT_DESTINO").equals("")) {
                contacto.setnExt("0");
            } else {
                contacto.setnExt(rs.getString("NUMERO_EXT_DESTINO"));
            }
            if (rs.getString("NUMERO_INT_DESTINO") == null || rs.getString("NUMERO_INT_DESTINO").equals("SN") || rs.getString("NUMERO_INT_DESTINO").equals("S/N") || rs.getString("NUMERO_INT_DESTINO").equals("")) {
                contacto.setnInt("0");
            } else {
                contacto.setnInt(rs.getString("NUMERO_INT_DESTINO"));
            }
            contacto.setCiudad(rs.getString("CIUDAD_DESTINO"));
            contacto.setContacto(rs.getString("CONTACTO_DESTINO"));
            contacto.setRazonSocial(rs.getString("RAZON_SOCIAL_DESTINO"));
            contacto.setColonia(rs.getString("COLONIA_DESTINO"));
            contacto.setEstado(rs.getString("ESTADO_DESTINO"));
            contacto.setIdEstado(rs.getString("ID_ESTADO_DESTINO"));
            if (rs.getString("TELEFONO_DESTINO") == null || rs.getString("TELEFONO_DESTINO").equals("")) {
                contacto.setTelefono("");
            } else {
                contacto.setTelefono(rs.getString("TELEFONO_DESTINO"));
            }
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }

        return contacto;
    }
}
