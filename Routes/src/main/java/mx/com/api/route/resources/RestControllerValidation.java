/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.resources;

import javax.validation.Valid;
import mx.com.api.route.beans.Request;
import mx.com.api.route.beans.Response;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nroblerol
 */
@RestController
@RequestMapping("/v1")
public class RestControllerValidation {
    
    @GetMapping(path = "/consultas/estatus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response createRoute(@Valid @RequestBody(required = true) Request req){
        Response resp = new Response();
        resp.setMensaje("validacion");
        return resp;
    }
    
}
