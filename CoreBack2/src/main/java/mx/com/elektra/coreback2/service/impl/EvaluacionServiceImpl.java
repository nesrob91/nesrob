/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service.impl;

import java.util.ArrayList;
import java.util.List;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Regla;
import mx.com.elektra.coreback2.dao.EvaluacionDao;
import mx.com.elektra.coreback2.service.EvaluacionService;
import org.springframework.stereotype.Service;

/**
 *
 * @author dparra
 */
@Service("evaluacionService")
public class EvaluacionServiceImpl implements EvaluacionService{
    
    
    private  EvaluacionDao evaluacionDao;
    
    @Override
    public boolean actualizaCarriersEvaluados(Paquete paquete, Regla regla){
        List<Integer> idCarriersValidos = new ArrayList<>();
        List<Integer> idCarriersNoValidos = new ArrayList<>();
        List<Integer> idCarriers = new ArrayList<>();
        
        idCarriers = getIdCarriersByRegla(paquete, regla);
        
        switch(regla.getIdTipoRegla()){
            // Retorna uno o más carriers que cumplan con una condición
            case 1:
                idCarriersValidos = getIdCarriersCumplenCondicion(paquete, regla);
                break;
            // Retorna el carrier con el parametro de menor valor
            case 2:
                idCarriersValidos = getIdCarriersMenorValor(paquete, regla);
                break;
            case 3:
            // Retorna el carrier con el parametro de mayor valor
                idCarriersValidos = getIdCarriersMayorValor(paquete, regla);
                break;
            default:
                return false;
        }
        
        if(idCarriersValidos.isEmpty()){
            return evaluacionDao.actualizaCarriers(paquete, regla, idCarriers, 1, "actualizaCarriersEvaluados()");
        }
        else{
            idCarriersNoValidos = getIdCarriersNoValidos(idCarriers, idCarriersValidos);
            if(!idCarriersNoValidos.isEmpty()){
                evaluacionDao.actualizaCarriers(paquete, regla, idCarriersNoValidos, 0, "actualizaCarriersEvaluados()");
            }
            return evaluacionDao.actualizaCarriers(paquete, regla, idCarriersValidos, 1, "actualizaCarriersEvaluados()");
        }
        
    }
    
    private List<Integer> getIdCarriersNoValidos(List<Integer> idCarriers, List<Integer> idCarriersValidos){
        List<Integer> carriersNoValidos = new ArrayList<>();
        
        for(int carrier : idCarriers){
            boolean valido = false;
            for(int carrierValido : idCarriersValidos){
                if(carrier == carrierValido){
                    valido = true;
                }
            }
            if(!valido){
                carriersNoValidos.add(carrier);
            }
        }
        return carriersNoValidos;
    }
    @Override
    public List<Integer> getIdCarriersCumplenCondicion(Paquete paquete, Regla regla){
        return evaluacionDao.getIdCarriersCumplenCondicion(paquete, regla);
    }
    @Override
    public List<Integer> getIdCarriersMenorValor(Paquete paquete, Regla regla){
        return evaluacionDao.getIdCarriersMenorValor(paquete, regla);
    }
    @Override
    public List<Integer> getIdCarriersMayorValor(Paquete paquete, Regla regla){
        return evaluacionDao.getIdCarriersMayorValor(paquete, regla);
    }
    
    @Override
    public List<Integer> getIdCarriersByRegla(Paquete paquete, Regla regla){
        return evaluacionDao.getIdCarriersByRegla(paquete, regla);
    }
    
}
