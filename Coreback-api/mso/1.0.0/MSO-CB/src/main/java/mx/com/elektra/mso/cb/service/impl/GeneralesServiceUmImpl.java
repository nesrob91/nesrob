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
import mx.com.elektra.mso.cb.model.DimensionesQB;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.model.Pedido;
import mx.com.elektra.mso.cb.model.PeticionCorePrstc;
import mx.com.elektra.mso.cb.model.Regla;
import mx.com.elektra.mso.cb.model.ResultadoEvaluacion;
import mx.com.elektra.mso.cb.pedidos.PSelector;
import mx.com.elektra.mso.cb.pedidos.TipoDePedido;
import mx.com.elektra.mso.cb.service.GeneralesService;
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
@Service("generalesServiceUm")
public class GeneralesServiceUmImpl implements GeneralesService {

    @Autowired
    private UrlPersistencia persistencia;

    @Autowired
    private PSelector selectorPedido;
    private TipoDePedido tipoDePedido;

    @Override
    public String getEsquema(int idManh) {
        return "";
    }

    @Override
    public boolean isLpnDifCantInicialVSEmpacado(int idManh, String idLpn, String esquema) {
        return false;
    }

    @Override
    public DimensionesQB getDimensionesLpnEvaluado(int idManh, String idLpn) {
        return null;
    }

    private List<Map<String, String>> getLpnsByAdn(List<String> adn, String esquema) {
        return null;
    }

    private List<Map<String, Object>> getVtexByAdnsOrLpns(List<String> adn, List<String> lpn, String esquema) {
        return null;
    }

    @Override
    public int getIdTipoPedidoByOrderType(String orderType) {
        return 0;
    }

    @Override
    public List<Regla> getReglas(int idCanal, int tipoPedido) {
        //return generalesDaoUm.getReglas(idCanal, tipoPedido);
        Gson gson = new GsonBuilder().create();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, String> params = new HashMap<String, String>();
        
        HttpEntity<String> responseService = restTemplate.exchange(
            persistencia.getUrlReglas(),
            HttpMethod.GET,
            entity,
            String.class,
            params
        );

        JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
        JsonArray array = convertedObject.getAsJsonArray("resultado");
        List<Regla> res = new ArrayList<>();
        
        for(Object o:array){
            Regla r=gson.fromJson(o.toString(), Regla.class);
            res.add(r);
        }
        return res;
    }

    @Override
    public boolean insertaCbDtl(Paquete paquete, CarrierQB carrier, Regla regla, String usuario) {
        //return generalesDaoUm.insertaCbDtl(paquete, carrier, regla, usuario);
        Gson gson = new GsonBuilder().create();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        RequestEntity request;
        try {
            PeticionCorePrstc req = new PeticionCorePrstc();
            req.setCarrier(carrier);
            req.setPaquete(paquete);
            req.setRegla(regla);
            req.setUsuario(usuario);
            request = new RequestEntity(req, headers, HttpMethod.POST, new URI(persistencia.getUrlDtl()));
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
            return (Boolean)r.get("insert");
        }
        return false;
    }

    @Override
    public boolean actualizaCbDtl(Paquete paquete, Regla regla, CarrierQB carrier, ResultadoEvaluacion resultadoEvaluacion) {
        //return generalesDaoUm.actualizaCbDtl(paquete, regla, carrier, resultadoEvaluacion);
        Gson gson = new GsonBuilder().create();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        RequestEntity request;
        try {
            PeticionCorePrstc req = new PeticionCorePrstc();
            req.setCarrier(carrier);
            req.setPaquete(paquete);
            req.setRegla(regla);
            req.setResultadoEvaluacion(resultadoEvaluacion);
            request = new RequestEntity(req, headers, HttpMethod.PUT, new URI(persistencia.getUrlDtl()));
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

    @Override
    public boolean actualizaCbHdr(Paquete paquete, CarrierQB carrier, String usuario, double tarifa) {
        //return generalesDaoUm.actualizaCbHdr(paquete, carrier, usuario, tarifa);
        Gson gson = new GsonBuilder().create();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        RequestEntity request;
        try {
            PeticionCorePrstc req = new PeticionCorePrstc();
            req.setCarrier(carrier);
            req.setPaquete(paquete);
            req.setUsuario(usuario);
            request = new RequestEntity(req, headers, HttpMethod.PUT, new URI(persistencia.getUrlHdr()));
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
            return (Boolean)r.get("insert");
        }
        return false;
    }

    @Override
    public CarrierQB getMejorCarrierPostCalculo(int idManh, String idLpn) {
        //return generalesDaoUm.getMejorCarrierPostCalculo(idManh, idLpn);
        return null;
    }

    @Override
    public Paquete getPaquete(Paquete paquete, int idTipoPeticion, String esquema) {

        setTipoDePedido(paquete);

        if (tipoDePedido != null) {
            Paquete p = tipoDePedido.getPaquete(paquete.getPedido(), paquete.getIdManh(), "", 0, 0, "");
            if (p != null) {
                p.setFolio(esquema);
                if (insertaCbHdrByPaquete(p, "GeneralesServiceImpl")) {
                    return p;
                } else {
                    paquete.setError("CBP0006");
                    //return paquete;
                }
            } else {
                paquete.setError("CBP0002");
                //return paquete;
            }
        } else {
            paquete.setError("CBP0001");
            //return paquete;
        }
        return paquete;
    }

    private boolean insertaCbHdrByPaquete(Paquete paquete, String usuario) {
        boolean res = false;
        List<CarrierQB> carriers = null;
        /*for(CarrierQB c : generalesDaoUm.getCarriersActivos(paquete.getIdCanal(),paquete.getIdTipoPedido())){
            boolean resultado = generalesDaoUm.insertaCbHder2018(paquete, usuario, c);
            res = (!res) ? resultado : res; 
        }*/
        Gson gson = new GsonBuilder().create();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, String> params = new HashMap<String, String>();
        params.put("centro", String.valueOf(paquete.getIdManh()));
        params.put("entrega", paquete.getPedido());

        HttpEntity<String> responseService = restTemplate.exchange(
            persistencia.getUrlProveedores(),
            HttpMethod.GET,
            entity,
            String.class,
            params
        );
        JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
        JsonArray array = convertedObject.getAsJsonArray("resultado");
        List<CarrierQB> c = new ArrayList<>();
        
        for(Object o:array){
            CarrierQB q=gson.fromJson(o.toString(), CarrierQB.class);
            c.add(q);
        }
            
        RequestEntity request;
            
        if (array != null && !c.isEmpty()) {
            Map<String,Object> r=new HashMap<>();
            for(CarrierQB cq : c){
                try {
                    PeticionCorePrstc req = new PeticionCorePrstc();
                    req.setCarrier(cq);
                    req.setPaquete(paquete);
                    req.setUsuario(usuario);
                    request = new RequestEntity(req, headers, HttpMethod.POST, new URI(persistencia.getUrlHdr()));
                } catch (URISyntaxException e) {
                    request = null;
                }
                if(request!=null){
                    responseService = restTemplate.exchange(
                        request,
                        String.class
                    );

                    convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
                    JsonObject result = convertedObject.getAsJsonObject("resultado");
                    r = gson.fromJson(result, Map.class);
                    res = (!res) ? (Boolean)r.get("insert") : res; 
                }
            }
            
        }
        return res;
    }

    @Override
    public List<CarrierQB> getCarriersActivos(Paquete paquete, List<CarrierQB> carriersActuales, int iteracion, int idRegla) {
        List<CarrierQB> carriers = new ArrayList<>();
        
        Gson gson = new GsonBuilder().create();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        Map<String, String> params = new HashMap<String, String>();
        params.put("centro", String.valueOf(paquete.getIdManh()));
        params.put("entrega", paquete.getPedido());
        params.put("folio", paquete.getFolio());

        List<CarrierQB> c;
        if (iteracion == 0) {
            HttpEntity<String> responseService = restTemplate.exchange(
                persistencia.getUrlProveedoresHdr(),
                HttpMethod.GET,
                entity,
                String.class,
                params
            );
            JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
            JsonArray array = convertedObject.getAsJsonArray("resultado");
            c = new ArrayList<>();

            for(Object o:array){
                CarrierQB q=gson.fromJson(o.toString(), CarrierQB.class);
                c.add(q);
            }
            
        } else {
            params.put("regla", String.valueOf(idRegla));
            //carriers = generalesDaoUm.getCarriersSiguienteIteracion(paquete, idRegla);
            HttpEntity<String> responseService = restTemplate.exchange(
                persistencia.getUrlProveedoresIter(),
                HttpMethod.GET,
                entity,
                String.class,
                params
            );
            JsonObject convertedObject = new Gson().fromJson(responseService.getBody(), JsonObject.class);
            JsonArray array = convertedObject.getAsJsonArray("resultado");
            c = new ArrayList<>();

            for(Object o:array){
                CarrierQB q=gson.fromJson(o.toString(), CarrierQB.class);
                c.add(q);
            }
        }
        if (carriers.isEmpty()) {
            carriers = c;
        }
        return carriers;
    }

    @Override
    public boolean isPaqueteProcesado(Pedido pedido) {

        return false;
    }

    @Override
    public boolean isLpnModificado(DimensionesQB lpnPrimeraEvaluacion, DimensionesQB lpnSegundaEvaluacion) {
        return (lpnPrimeraEvaluacion.getLargo() != lpnSegundaEvaluacion.getLargo()
                && lpnPrimeraEvaluacion.getAncho() != lpnSegundaEvaluacion.getAncho()
                && lpnPrimeraEvaluacion.getAlto() != lpnSegundaEvaluacion.getAlto()
                && lpnPrimeraEvaluacion.getVolumen() != lpnSegundaEvaluacion.getVolumen()
                && lpnPrimeraEvaluacion.getPesoFisico() != lpnSegundaEvaluacion.getPesoFisico()
                && lpnPrimeraEvaluacion.getPesoVolumetrico() != lpnSegundaEvaluacion.getPesoVolumetrico());
    }

    private void setTipoDePedido(Paquete paquete) {
        /*switch (paquete.getIdTipoPedido()){
            case 1: case 7:
                tipoDePedido = selectorPedido.getPedidoEcom();
                break;
            case 4:
                tipoDePedido = selectorPedido.getPedidoMkp();
                break;
            case 5:
                tipoDePedido = selectorPedido.getPedidoDsv();
                break;
            case 6:
                tipoDePedido = selectorPedido.getPedidoLyde();
                break;
            default:
                tipoDePedido = null;
                break;
        }
         */
        tipoDePedido = selectorPedido.getPedidoUm();
    }

    @Override
    public List<Integer> getCdsOfLpns(Paquete paquete) {
        return null;
    }

}
