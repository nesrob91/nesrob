/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.mso.cb.common.UrlPersistencia;
import mx.com.elektra.mso.cb.model.DetalleSkus;
import mx.com.elektra.mso.cb.model.ExclusionOInclusion;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.model.Tarifa;
import mx.com.elektra.mso.cb.service.ReglasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dparra
 */
@Service("reglasServiceUm")
public class ReglasServiceUmImpl implements ReglasService{
    @Autowired
    private UrlPersistencia persistencia;
    
    @Override
    public boolean isDestinoValidoParaCarrier(Paquete paquete, int idCarrier){
        return true;
    }
    
    @Override
    public int getRatingCarrier(Paquete paquete, int idCarrier){
        //return reglasDaoUm.getRatingCarrier(paquete, idCarrier);
        Gson gson = new GsonBuilder().create();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, Object> params = new HashMap<>();
        params.put("carrier", String.valueOf(paquete.getIdManh()));
        
        HttpEntity<String> responseService = restTemplate.exchange(
            persistencia.getUrlRating(),
            HttpMethod.GET,
            entity,
            String.class,
            params
        );
        JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
        JsonObject result = convertedObject.getAsJsonObject("resultado");
        
        Integer rating = gson.fromJson(result, Integer.class);
        
        return rating;
    }
    
    @Override
    public boolean isPesoFisicoSoportadoPorCarrier(Paquete paquete, int idCarrier){
        return false;
    }
    
    @Override
    public ExclusionOInclusion validaExclusiones(Paquete paquete, int idCarrier){
        ExclusionOInclusion exclusion = new ExclusionOInclusion();
        exclusion.setTipoExclusion(0);
        List<String> clasf = new ArrayList<>();
        for(DetalleSkus detalle : paquete.getSkus()){
            clasf.add(detalle.getSku().getIdSku());
        }
        Gson gson = new GsonBuilder().create();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, Object> params = new HashMap<>();
        params.put("carrier", String.valueOf(paquete.getIdManh()));
        params.put("clasf", clasf);

        HttpEntity<String> responseService = restTemplate.exchange(
            persistencia.getUrlExclIncl(),
            HttpMethod.GET,
            entity,
            String.class,
            params
        );
        JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
        JsonObject result = convertedObject.getAsJsonObject("resultado");
        exclusion = gson.fromJson(result, ExclusionOInclusion.class);
        
        return exclusion;
    }
    
    @Override
    public boolean isCapacidadValidaPorCarrier(Paquete paquete, int idCarrier){
        Gson gson = new GsonBuilder().create();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, Object> params = new HashMap<>();
        params.put("carrier", String.valueOf(paquete.getIdManh()));
        
        HttpEntity<String> responseService = restTemplate.exchange(
            persistencia.getUrlCapacidad(),
            HttpMethod.GET,
            entity,
            String.class,
            params
        );
        JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
        JsonObject result = convertedObject.getAsJsonObject("resultado");
        
        Integer capacidad = gson.fromJson(result, Integer.class);
        
        params.put("carrier", String.valueOf(paquete.getIdManh()));
        
        responseService = restTemplate.exchange(
            persistencia.getUrlCapacidadAsig(),
            HttpMethod.GET,
            entity,
            String.class,
            params
        );
        convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
        result = convertedObject.getAsJsonObject("resultado");
        
        Integer asignado = gson.fromJson(result, Integer.class);
        
        return capacidad < asignado;
    }
    
    @Override
    public Map<Boolean, Integer> getCalculoPorcentajePorCarrier(Paquete paquete, int idCarrier){
        
        return null;
    }
    
    @Override
    public int getEstatusHorario(Paquete paquete, int idCarrier){
        //return reglasDaoUm.getEstatusHorario(paquete, idCarrier);
        return 0;
    }
    
    @Override
    public Tarifa getTarifaEnvio(Paquete paquete, int idCarrier){
        return null;
    }
    
    @Override
    public boolean isPaqueteReqSeguro(Paquete paquete, int idCarrier){
        return false;
    }
    
    @Override
    public double getTarifaMejorCarrier(Paquete paquete, int idCarrier){
        return 0;
    }

    @Override
    public Tarifa getTarifaInfo(Paquete paquete, int idCarrier) {
        /*Tarifa t = reglasDaoUm.getTarifaInfo(paquete, idCarrier);
        if(t == null ){
            t=new Tarifa();
            t.setTarifa(-1);
            t.setTarifaFinal(-1);
        }
        return t;*/
        Gson gson = new GsonBuilder().create();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, Object> params = new HashMap<>();
        params.put("carrier", String.valueOf(paquete.getIdManh()));
        params.put("origen", paquete.getCpOrigen());
        params.put("destino", paquete.getCpDestino());
        params.put("peso", String.valueOf(paquete.getPeso()));
        
        HttpEntity<String> responseService = restTemplate.exchange(
            persistencia.getUrlTarifa(),
            HttpMethod.GET,
            entity,
            String.class,
            params
        );
        JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
        JsonObject result = convertedObject.getAsJsonObject("resultado");
        
        Tarifa t = gson.fromJson(result, Tarifa.class);
        
        return t;
    }
    
}
