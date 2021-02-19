/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.service;

import java.util.List;
import java.util.Map;
import mx.com.api.route.beans.Remision;
import mx.com.api.route.beans.Transporte;
import mx.com.api.route.beans.Unidad;

/**
 *
 * @author nroblerol
 */
public interface TransporteService {
    public List<Transporte> getTransportes(Integer almacen, Integer transporte, Integer isDist);
    public String getTransporteDisponibilidad(Integer almacen, Integer proveedor, Integer eco, String placa, Integer tiempoEco);
    public Integer getTiempoEco(Integer almn);
    public Map<String,Object> capturaTransporte(Integer almacen, List<Remision> remision, Integer transporte, Integer unidad, Integer folEnv, String chofer, String checador, String estibador);
    public List<Unidad> getUnidades(Integer almacen, Integer unidad, String disp);
}
