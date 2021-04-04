/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.mso.cb.common.UrlPersistencia;
import mx.com.elektra.mso.cb.model.CarrierQB;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.model.PeticionCorePrstc;
import mx.com.elektra.mso.cb.model.Regla;
import mx.com.elektra.mso.cb.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dparra
 */
@Service("evaluacionServiceUm")
public class EvaluacionServiceUmImpl implements EvaluacionService{
    @Autowired
    private UrlPersistencia persistencia;
    
    @Override
    public boolean actualizaCarriersEvaluados(Paquete paquete, Regla regla, List<CarrierQB> carriers){
        List<Integer> idCarriersValidos = new ArrayList<>();
        List<Integer> idCarriersNoValidos = new ArrayList<>();
        List<Integer> idCarriers = new ArrayList<>();
        
        for(CarrierQB c : carriers)
            idCarriers.add(c.getIdCarrier());
        
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
            //idCarriers = getIdCarriersByRegla(paquete, regla);
            return updateDtlCarValidation(paquete, regla, idCarriers, 1, "actualizaCarriersEvaluados()");
        }
        else{
            idCarriersNoValidos = getIdCarriersNoValidos(idCarriers, idCarriersValidos);
            if(!idCarriersNoValidos.isEmpty()){
                updateDtlCarValidation(paquete, regla, idCarriersNoValidos, 0, "actualizaCarriersEvaluados()");
            }
            return updateDtlCarValidation(paquete, regla, idCarriersValidos, 1, "actualizaCarriersEvaluados()");
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
        //return evaluacionDaoUm.getIdCarriersCumplenCondicion(paquete, regla);
        List<Integer> car=new ArrayList<>();
        Gson gson = new GsonBuilder().create();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, String> params = new HashMap<String, String>();
        params.put("centro", String.valueOf(paquete.getIdManh()));
        params.put("entrega", paquete.getPedido());
        params.put("regla", String.valueOf(regla.getIdRegla()));
        params.put("folio", paquete.getFolio());

        HttpEntity<String> responseService = restTemplate.exchange(
            persistencia.getUrlProveedoresCond(),
            HttpMethod.GET,
            entity,
            String.class,
            params
        );
        JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
        JsonArray result = convertedObject.getAsJsonArray("resultado");
        
        for(Object cq : result){
            CarrierQB c = gson.fromJson(cq.toString(), CarrierQB.class);
            car.add(c.getIdCarrier());
        }
        return car;
    }
    
    @Override
    public List<Integer> getIdCarriersMenorValor(Paquete paquete, Regla regla){
        //return evaluacionDaoUm.getIdCarriersMenorValor(paquete, regla);}
        List<Integer> car=new ArrayList<>();
        Gson gson = new GsonBuilder().create();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, String> params = new HashMap<String, String>();
        params.put("centro", String.valueOf(paquete.getIdManh()));
        params.put("entrega", paquete.getPedido());
        params.put("regla", String.valueOf(regla.getIdRegla()));
        params.put("folio", paquete.getFolio());

        HttpEntity<String> responseService = restTemplate.exchange(
            persistencia.getUrlProveedoresMin(),
            HttpMethod.GET,
            entity,
            String.class,
            params
        );
        JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
        JsonArray result = convertedObject.getAsJsonArray("resultado");
        
        for(Object cq : result){
            CarrierQB c = gson.fromJson(cq.toString(), CarrierQB.class);
            car.add(c.getIdCarrier());
        }
        return car;
    }
    @Override
    public List<Integer> getIdCarriersMayorValor(Paquete paquete, Regla regla){
        //return evaluacionDaoUm.getIdCarriersMayorValor(paquete, regla);
        List<Integer> car=new ArrayList<>();
        Gson gson = new GsonBuilder().create();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, String> params = new HashMap<String, String>();
        params.put("centro", String.valueOf(paquete.getIdManh()));
        params.put("entrega", paquete.getPedido());
        params.put("regla", String.valueOf(regla.getIdRegla()));
        params.put("folio", paquete.getFolio());

        HttpEntity<String> responseService = restTemplate.exchange(
            persistencia.getUrlProveedoresMax(),
            HttpMethod.GET,
            entity,
            String.class,
            params
        );
        JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
        JsonArray result = convertedObject.getAsJsonArray("resultado");
        
        for(Object cq : result){
            CarrierQB c = gson.fromJson(cq.toString(), CarrierQB.class);
            car.add(c.getIdCarrier());
        }
        return car;
    }
    
    @Override
    public List<Integer> getIdCarriersByRegla(Paquete paquete, Regla regla){
        //return evaluacionDaoUm.getIdCarriersByRegla(paquete, regla);
        return null;
    }
    
    private boolean updateDtlCarValidation(Paquete paquete, Regla regla, List<Integer> idCarriers, int valid, String usuario){
        Gson gson = new GsonBuilder().create();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        RequestEntity request;
        try {
            PeticionCorePrstc req = new PeticionCorePrstc();
            req.setCarriers(idCarriers);
            req.setPaquete(paquete);
            req.setUsuario(usuario);
            req.setRegla(regla);
            req.setValid(valid);
            request = new RequestEntity(req, headers, HttpMethod.PUT, new URI(persistencia.getUrlDtlEval()));
        } catch (URISyntaxException e) {
            request = null;
        }
        if (request != null) {
            HttpEntity<String> responseService = restTemplate.exchange(
                    request,
                    String.class
                );
            Map<String,Object> r=new HashMap<>();
            JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
            JsonObject result = convertedObject.getAsJsonObject("resultado");
            r = gson.fromJson(result, Map.class);
            return (Boolean)r.get("update");
        }
        return false;
    }
}
