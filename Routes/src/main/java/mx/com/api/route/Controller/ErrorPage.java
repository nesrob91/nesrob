/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.Controller;

import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.http.HttpServletRequest;
import mx.com.api.route.beans.Response;
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

    @GetMapping
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Exception e, Throwable ex) {
        HttpStatus status = getStatus(request);
        String error;
        switch(status.value()){
            case 404:
                error= "No processor found. "+request.getMethod()+" "+request.getRequestURI()
                +". "+status.toString()+". "+e.getMessage();
                break;
            default :
                error= "No se pudo proceder con la peticion. "+request.getMethod()+" "+request.getRequestURI()
                +". "+status.toString()+". "+e.getMessage();
                break;
        }
        Response apiError = new Response();
        apiError.setEstatus(-1);
        apiError.setMensaje(error);
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
