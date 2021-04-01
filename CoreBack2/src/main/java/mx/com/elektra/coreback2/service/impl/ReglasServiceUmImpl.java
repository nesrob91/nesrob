/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service.impl;

import java.util.HashMap;
import java.util.Map;
import mx.com.elektra.coreback2.beans.DetalleSkus;
import mx.com.elektra.coreback2.beans.ExclusionOInclusion;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Tarifa;
import mx.com.elektra.coreback2.dao.ReglasDao;
import mx.com.elektra.coreback2.service.ReglasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dparra
 */
@Service("reglasServiceUm")
public class ReglasServiceUmImpl implements ReglasService{
    @Autowired
    private  ReglasDao reglasDaoUm ;
    
    @Override
    public boolean isDestinoValidoParaCarrier(Paquete paquete, int idCarrier){
        return reglasDaoUm.isDestinoValidoParaCarrier(paquete, idCarrier);
    }
    
    @Override
    public int getRatingCarrier(Paquete paquete, int idCarrier){
        return reglasDaoUm.getRatingCarrier(paquete, idCarrier);
    }
    
    @Override
    public boolean isPesoFisicoSoportadoPorCarrier(Paquete paquete, int idCarrier){
        return reglasDaoUm.isPesoFisicoSoportadoPorCarrier(paquete, idCarrier);
    }
    
    @Override
    public ExclusionOInclusion validaExclusiones(Paquete paquete, int idCarrier){
        ExclusionOInclusion exclusion = new ExclusionOInclusion();
        exclusion.setTipoExclusion(0);
        for(DetalleSkus detalle : paquete.getSkus()){
            exclusion = reglasDaoUm.getExclusionesEInclusiones(detalle.getSku(), paquete, idCarrier, "E");
            if(exclusion.getTipoExclusion() != 0){
                return exclusion;
            }
        }
        return exclusion;
    }
    
    @Override
    public boolean isCapacidadValidaPorCarrier(Paquete paquete, int idCarrier){
        int guiasTotales = reglasDaoUm.getCantidadGuiasPorCarrier(paquete, idCarrier);
        int capacidad = reglasDaoUm.getCapacidadPorCarrier(paquete, idCarrier);
        if(capacidad == -1){
            return false;
        }
        else if (guiasTotales != -1 && capacidad == -1){
            return true;
        }
        else if (guiasTotales >= capacidad){
            return false;
        }
        else{
            return true;
        }
    }
    
    @Override
    public Map<Boolean, Integer> getCalculoPorcentajePorCarrier(Paquete paquete, int idCarrier){
        Map<Boolean, Integer> map = new HashMap<>();
        int guiasTotales = reglasDaoUm.getCantidadGuias(paquete);
        int guiasTotalesCarrier = reglasDaoUm.getCantidadGuiasPorCarrier(paquete, idCarrier);
        int porcentaje = reglasDaoUm.getPorcentajePorCarrier(paquete, idCarrier);
        int calculo = 0;
        boolean existePorcentaje = true;
        
        if(porcentaje == -1){
            porcentaje = reglasDaoUm.getPorcentajeRestoCarrier(paquete);
            existePorcentaje = false;
        }
        if(guiasTotales == 0){
            calculo = porcentaje;
        }
        else {
            calculo = porcentaje - ((guiasTotalesCarrier * 100) / guiasTotales);
        }
        map.put(existePorcentaje, calculo);
        
        return map;
    }
    
    @Override
    public int getEstatusHorario(Paquete paquete, int idCarrier){
        return reglasDaoUm.getEstatusHorario(paquete, idCarrier);
    }
    
    @Override
    public Tarifa getTarifaEnvio(Paquete paquete, int idCarrier){
        
        Tarifa tarifa = new Tarifa();
        tarifa = reglasDaoUm.getTarifa(paquete, idCarrier);
        if(tarifa.getTarifa() == -1){
            tarifa = reglasDaoUm.getTarifaPesoAdicional(paquete, idCarrier);
        }
        return tarifa;
    }
    
    @Override
    public boolean isPaqueteReqSeguro(Paquete paquete, int idCarrier){
        ExclusionOInclusion exclusion = new ExclusionOInclusion();
        
        if(paquete.getSkus() != null && !paquete.getSkus().isEmpty()){
            for(DetalleSkus detalle : paquete.getSkus()){
                exclusion = reglasDaoUm.getExclusionesEInclusiones(detalle.getSku(), paquete, idCarrier, "I");
                if(exclusion.getTipoExclusion() != 0){
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public double getTarifaMejorCarrier(Paquete paquete, int idCarrier){
        return reglasDaoUm.getTarifaMejorCarrier(paquete, idCarrier);
    }

    @Override
    public Tarifa getTarifaInfo(Paquete paquete, int idCarrier) {
        Tarifa t = reglasDaoUm.getTarifaInfo(paquete, idCarrier);
        if(t == null ){
            t=new Tarifa();
            t.setTarifa(-1);
            t.setTarifaFinal(-1);
        }
        return t;
    }
    
}
