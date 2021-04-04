/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import mx.com.elektra.mso.cb.common.UrlPersistencia;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.service.DepuradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author nroblerol
 */
@Service("depuradorServiceUm")
public class DepuradorServiceUmImpl implements DepuradorService {

    @Autowired
    private UrlPersistencia persistance;

    @Override
    public boolean limpiaTablas(Paquete paquete) {
        //if(depuradorDaoUm.countGuia(paquete)>0){
        //return false;
        /*if(depuradorDaoUm.countCbHdr(paquete)==0){
            return true;
        }
        else{
            return depuradorDaoUm.eliminaCbHdr(paquete);
        }*/
        Gson gson = new GsonBuilder().create();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, String> params = new HashMap<String, String>();
        params.put("centro", String.valueOf(paquete.getIdManh()));
        params.put("entrega", paquete.getPedido());

        HttpEntity<String> responseService = restTemplate.exchange(
            persistance.getUrlEvalPrev(),
            HttpMethod.GET,
            entity,
            String.class,
            params
        );

        JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
        JsonObject result = convertedObject.getAsJsonObject("resultado");
        Map<String, Object> res = gson.fromJson(result, Map.class);

        if (!(Boolean) res.get("exist")) {
            return true;
        } else {
            responseService = restTemplate.exchange(
                persistance.getUrlEvalPrev(),
                HttpMethod.PUT,
                entity,
                String.class,
                params
            );
            convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
            result = convertedObject.getAsJsonObject("resultado");
            res = gson.fromJson(result, Map.class);
            return (Boolean)res.get("delete");
        }
    }
}
