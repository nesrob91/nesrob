/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.feign;

import javax.validation.Valid;
import mx.com.api.trknbr.beans.ApiResponse;
import mx.com.api.trknbr.feign.beans.RequestRoute;
import mx.com.api.trknbr.feign.beans.ResponseRoute;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author nroblerol
 */
//@FeignClient(value = "rutaWS",url = "localhost:8443/wsRuta/v1")
@Component("rutaWS")
public class RouteFeign {
    
    WebClient guiaWs = WebClient.builder().baseUrl("http://localhost:8443/wsRuta/v1").build();
    
    public ResponseRoute getRouteStat(@RequestBody RequestRoute req){
        ResponseRoute rutaResp = new ResponseRoute();
        try{
            ClientResponse response=guiaWs.method(HttpMethod.GET).uri("/consultas/estatus").contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(req).exchange().block();
            if(response.statusCode().is4xxClientError()){
                rutaResp=response.bodyToMono(ResponseRoute.class).block();
            }
            if(response.statusCode().is5xxServerError()){
                rutaResp=response.bodyToMono(ResponseRoute.class).block();
            }
            if(response.statusCode().is2xxSuccessful()){
                rutaResp=response.bodyToMono(ResponseRoute.class).block();
            }
            response.releaseBody();
        }catch(Exception e){
            rutaResp.setCodigo("1");
            rutaResp.setFolio(null);
            rutaResp.setMensaje("Unable to validate Tracking Number");
            rutaResp.setResultado(null);
        }
        return rutaResp;
    }
    
    public ResponseRoute cancelRoute(@RequestBody RequestRoute req){
        ResponseRoute rutaResp = new ResponseRoute();
        try{
            ClientResponse response=guiaWs.method(HttpMethod.POST).uri("/ruta/cancelar").contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(req).exchange().block();
            if(response.statusCode().is4xxClientError()){
                rutaResp=response.bodyToMono(ResponseRoute.class).block();
            }
            if(response.statusCode().is5xxServerError()){
                rutaResp=response.bodyToMono(ResponseRoute.class).block();
            }
            if(response.statusCode().is2xxSuccessful()){
                rutaResp=response.bodyToMono(ResponseRoute.class).block();
            }
            response.releaseBody();
        }catch(Exception e){
            rutaResp.setCodigo("1");
            rutaResp.setFolio(null);
            rutaResp.setMensaje("Unable to validate Tracking Number");
            rutaResp.setResultado(null);
        }
        return rutaResp;
    }
    
    public ResponseRoute createRoute(@RequestBody RequestRoute req){
        ResponseRoute rutaResp = new ResponseRoute();
        try{
            ClientResponse response=guiaWs.method(HttpMethod.POST).uri("/ruta/cancelar").contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(req).exchange().block();
            if(response.statusCode().is4xxClientError()){
                rutaResp=response.bodyToMono(ResponseRoute.class).block();
            }
            if(response.statusCode().is5xxServerError()){
                rutaResp=response.bodyToMono(ResponseRoute.class).block();
            }
            if(response.statusCode().is2xxSuccessful()){
                rutaResp=response.bodyToMono(ResponseRoute.class).block();
            }
            response.releaseBody();
        }catch(Exception e){
            rutaResp.setCodigo("1");
            rutaResp.setFolio(null);
            rutaResp.setMensaje("Unable to validate Tracking Number");
            rutaResp.setResultado(null);
        }
        return rutaResp;
    }
    
}
