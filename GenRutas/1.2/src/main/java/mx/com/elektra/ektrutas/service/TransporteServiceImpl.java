/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.ektrutas.dao.TiendaDao;
import mx.com.elektra.ektrutas.dao.TransporteDao;
import mx.com.elektra.ektrutas.dto.Remision;
import mx.com.elektra.ektrutas.dto.Transporte;
import mx.com.elektra.ektrutas.dto.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nroblerol
 */
@Service("transportService")
public class TransporteServiceImpl implements TransporteService{
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
        if(transporte!=null || transporte!=0){
            if(unidad!=null || unidad!=0){
                if(chofer!=null || !chofer.equals("")){
                    if(checador!=null || !checador.equals("")){
                        if(estibador!=null || !estibador.equals("")){
                            String folrems="";
                            for(Remision r : remision)
                                folrems+=(r.getFolrem()+",");
                            folrems=folrems.substring(0, folrems.length()-1);
                            switch(almacen){
                                case 9971:case 324:
                                    result.put("Error", false);
                                    result.put("Message","OK");
                                    break;
                                default:
                                    if(transportDao.registraVol(remision.get(0).getEmisor(),folrems)){
                                        result.put("Error", false);
                                        result.put("Message","OK");
                                    }else{
                                        result.put("Error", true);
                                        result.put("Code", "GRT0001");
                                        result.put("Message","No se registro en VOL_TRF");
                                    }
                                    break;
                            }
                        }else{
                            result.put("Error", true);
                            result.put("Message","Ingresa un estibador");
                            result.put("Code", "GRTCT0005");
                        }
                    }else{
                        result.put("Error", true);
                        result.put("Message","Ingresa un checador");
                        result.put("Code", "GRTCT0004");
                    }
                }else{
                    result.put("Error", true);
                    result.put("Message","Ingresa un chofer");
                    result.put("Code", "GRTCT0003");
                }
            }else{
                result.put("Error", true);
                result.put("Message","Ingresa una unidad");
                result.put("Code", "GRTCT0002");
            }
        }else{
            result.put("Error", true);
            result.put("Message","Ingresa un transporte");
            result.put("Code", "GRTCT0001");
        }
        return result;
    }

    @Override
    public List<Unidad> getUnidades(Integer almacen, Integer unidad, String disp) {
        return transportDao.getUnidades(almacen, unidad, disp);
    }
    
}
