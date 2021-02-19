/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.dao;

import java.util.List;
import mx.com.api.route.beans.Transporte;
import mx.com.api.route.beans.Unidad;

/**
 *
 * @author nroblerol
 */
public interface TransporteDao {
    public List<Transporte> getTransportes(Integer almacen, Integer transporte);
    public String getTransporteDisponibilidad(Integer almacen, Integer proveedor, Integer eco, String placa, Integer tiempoEco);
    public Integer getTiempoEco(Integer almn);
    public List<Unidad> getUnidades(Integer almacen, Integer unidad, String disp);
    public boolean registraVol(Integer ori, String folrems);
}
