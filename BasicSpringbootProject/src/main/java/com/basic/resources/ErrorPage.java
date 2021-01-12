/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.resources;

import com.basic.beans.Response;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author nroblerol
 */
@Controller("/error")
public class ErrorPage {

    @Autowired
    private AtomicLong requestID;

    @GetMapping
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Exception e, Throwable ex) {
        HttpStatus status = getStatus(request);
        String error;
        switch(status.value()){
            case 404:
                error= "No processor found. "+request.getMethod()+" "+request.getRequestURI()
                +". "+status.toString()+". "+ex.getMessage();
                break;
            default :
                error= "Internal Server Error. "+request.getMethod()+" "+request.getRequestURI()
                +". "+status.toString()+". "+ex.getMessage();
                break;
        }
        Response apiError = new Response(requestID.incrementAndGet(), 0, error);
        return new ResponseEntity<>(apiError, HttpStatus.OK);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
