/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.feign;

import mx.com.api.route.feign.beans.ApiResponse;
import mx.com.api.route.feign.beans.Request;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author nroblerol
 */
@Component("wsGuia")
public class wsGuiasFeign {
    
    WebClient guiaWs = WebClient.builder().baseUrl("http://localhost:8840/wsGuia/v1").build();
    
    public ApiResponse getTrackingNumber(@RequestBody Request req){
        ApiResponse guiaResp = new ApiResponse();
        try{
            ClientResponse response=guiaWs.method(HttpMethod.GET).uri("/consultas/estatus").contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(req).exchange().block();
            if(response.statusCode().is4xxClientError()){
                guiaResp=response.bodyToMono(ApiResponse.class).block();
            }
            if(response.statusCode().is5xxServerError()){
                guiaResp=response.bodyToMono(ApiResponse.class).block();
            }
            if(response.statusCode().is2xxSuccessful()){
                guiaResp=response.bodyToMono(ApiResponse.class).block();
            }
            response.releaseBody();
        }catch(Exception e){
            guiaResp.setCodigo("1");
            guiaResp.setFolio(null);
            guiaResp.setMensaje("Unable to validate Tracking Number");
            guiaResp.setResultado(null);
        }
        return guiaResp;
    }
    
    public ApiResponse getTrackingNumberStatus(@RequestBody Request req){
        ApiResponse guiaResp = new ApiResponse();
        WebClient.UriSpec<WebClient.RequestBodySpec> uriSpec = guiaWs.post();
        WebClient.RequestBodySpec bodySpec = uriSpec.uri("/resource");
        return guiaResp;
    }
}
