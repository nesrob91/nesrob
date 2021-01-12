/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.resources;

import com.basic.beans.Request;
import com.basic.beans.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nroblerol
 */
@RestController
@RequestMapping("/Test")
public class RestControllerTester {
    
    private String temmplate;
    
    @Autowired
    private AtomicLong requestID;
    @Autowired
    private Boolean debug;
    @Autowired
    private ObjectMapper parseJson;

    @GetMapping("/")
    public Response getInfo(){
        Response resp=new Response();
        resp.setIdPeticion(requestID.incrementAndGet());
        resp.setMessage("OK");
        return resp;
    }
    
    @GetMapping(value={"/getMessage","/getMessage/{request}"})
    public Response getMessage(@PathVariable String request){
        try{
            if(debug)
                System.out.println("Peticion : "+parseJson.writeValueAsString(request));
        }catch(JsonProcessingException e){
            System.out.println("Error converting request"+e.getMessage());
        }
        Response resp=new Response();
        resp.setIdPeticion(requestID.incrementAndGet());
        resp.setMessage(request);
        resp.setUser(0);
        return resp;
    }
    
    @GetMapping(value={"/process/"})
    public Response postRequest(@RequestBody(required = false) Request request, @RequestParam(required = true) String token){
        try{
            if(debug)
                System.out.println("Peticion : "+parseJson.writeValueAsString(request));
        }catch(JsonProcessingException e){
            System.out.println("Error converting request"+e.getMessage());
        }
        Response resp=new Response();
        resp.setIdPeticion(requestID.incrementAndGet());
        resp.setMessage("Processed");
        resp.setUser(request.getUser());
        return resp;
    }
}
