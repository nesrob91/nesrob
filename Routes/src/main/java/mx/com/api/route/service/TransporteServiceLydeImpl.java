/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.api.route.dao.TiendaDao;
import mx.com.api.route.dao.TransporteDao;
import mx.com.api.route.beans.Remision;
import mx.com.api.route.beans.Transporte;
import mx.com.api.route.beans.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nroblerol
 */
@Service("transportServiceLyde")
public class TransporteServiceLydeImpl implements TransporteService{
    @Autowired
    TransporteDao transportDao;
    @Autowired
    TiendaDao tiendaDao;

    @Override
    public List<Transporte> getTransportes(Integer almacen, Integer transporte, Integer isDist) {
        return transportDao.getTransportes(almacen, transporte);
    }

    @Override
    public String getTransporteDisponibilidad(Integer almacen, Integer proveedor, Integer eco, String placa, Integer tiempoEco) {
        return transportDao.getTransporteDisponibilidad(almacen, proveedor, eco, placa, tiempoEco);
    }

    @Override
    public Integer getTiempoEco(Integer almn) {
        return transportDao.getTiempoEco(almn);
    }

    @Override
    public Map<String, Object> capturaTransporte(Integer almacen, List<Remision> remision, Integer transporte, Integer unidad, Integer folEnv, String chofer, String checador, String estibador) {
        Map<String,Object> result=new HashMap<>();
        
        result.put("Error", false);
        result.put("Message","OK");
        
        return result;
    }

    @Override
    public List<Unidad> getUnidades(Integer almacen, Integer unidad, String disp) {
        return transportDao.getUnidades(almacen, unidad, disp);
    }
    
}
