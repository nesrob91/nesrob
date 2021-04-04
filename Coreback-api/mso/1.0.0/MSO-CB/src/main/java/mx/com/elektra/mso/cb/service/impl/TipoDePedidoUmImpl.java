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
import java.util.List;
import java.util.Map;
import mx.com.elektra.mso.cb.common.UrlPersistencia;
import mx.com.elektra.mso.cb.model.Contenido;
import mx.com.elektra.mso.cb.model.DimensionesQB;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.service.TipoDePedidoService;
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
@Service("pedidoUmService")
public class TipoDePedidoUmImpl implements TipoDePedidoService{
    @Autowired
    private UrlPersistencia prop;
    
    @Override
    public Paquete getPaquete(String pedido, int idManh, String esquema, int idCaja, int idTipoPedido, String folio) {
        Gson gson = new GsonBuilder().create();
        
        RestTemplate restTemplate = new RestTemplate();
        
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        
        Map<String, String> params = new HashMap<String, String>();
            params.put("centro", String.valueOf(idManh));
            params.put("entrega", pedido);
        
        HttpEntity<String> responseService = restTemplate.exchange(
                    prop.getUrlPaquete(),
                    HttpMethod.GET,
                    entity,
                    String.class,
                    params
            );
        
        JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
        JsonObject result = convertedObject.getAsJsonObject("resultado");
        Paquete paquete = null;
        if(result!=null)
            paquete = gson.fromJson(result, Paquete.class);
        
        return paquete;
    }

    @Override
    public boolean insertaContenidoCaja(Paquete paquete, int idTipoPeticion, String esquema) {
        return false;
    }

    @Override
    public String getPedidoAlterno(Paquete paquete) {
        return "";
    }

    @Override
    public String getCpOrigen(Paquete paquete) {
        return "";
    }

    @Override
    public String getCpDestino(Paquete paquete) {
        return "";
    }

    @Override
    public Paquete setDetalleSkusInfoCd(Paquete paquete) {
        return paquete;
    }

    @Override
    public List<Contenido> getContenido(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DimensionesQB getDimensionesPaquete(Paquete paquete, String esquema, int tipPed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPesoPaquete(Paquete paquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
