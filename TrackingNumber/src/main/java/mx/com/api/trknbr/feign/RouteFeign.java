/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.feign;

import mx.com.api.trknbr.beans.Request;
import mx.com.api.trknbr.beans.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nroblerol
 */
@FeignClient(value = "rutaWS",url = "localhost:8443/wsRuta")
public interface RouteFeign {
    @RequestMapping("/")
    public Response getInfo();
    
    @RequestMapping(value = "/ruta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createRoute(Request req);
    
    @RequestMapping(value = "/ruta/cancelar")
    public Response cancelRoute(Request req);
    
    @RequestMapping(value = "/ruta/estatus")
    public Response statusRoute(Request req);
}
