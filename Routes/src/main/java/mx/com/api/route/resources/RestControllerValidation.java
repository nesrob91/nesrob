/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.resources;

import mx.com.api.route.beans.Request;
import mx.com.api.route.beans.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nroblerol
 */
@RestController
@RequestMapping("/wsRuta")
public class RestControllerValidation {
    
    @GetMapping("/estatus")
    public Response createRoute(@RequestBody(required = true) Request req){
        Response resp = new Response();
        resp.setMensaje("validacion");
        return resp;
    }
    
}
