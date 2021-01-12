/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.resources;

import com.basic.beans.Response;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author nroblerol
 */
@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

    @Autowired
    private AtomicLong requestID;

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "No bind found for " + ex.getNestedPath();
        Response apiError = new Response(requestID.incrementAndGet(), null, error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.OK);
    }
    
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
        Response apiError = new Response(requestID.incrementAndGet(), null, error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = ex.getMessage();
        Response apiError = new Response(requestID.incrementAndGet(), null, "Internal Server Error " + error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Response apiError = new Response(requestID.incrementAndGet(), null, "Not Found");
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.OK);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error="Method not supported. "+ex.getMethod();
        Response apiError = new Response(requestID.incrementAndGet(), null, error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.OK);
    }
    
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Missing parameter... "+ex.getParameterName()+". "+status.toString()+". "+ex.getMessage();
        Response apiError = new Response(requestID.incrementAndGet(), null, error);
        return new ResponseEntity<>(apiError, HttpStatus.OK); 
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Missing variable... "+ex.getVariableName()+". "+status.toString()+". "+ex.getMessage();
        Response apiError = new Response(requestID.incrementAndGet(), null, error);
        return new ResponseEntity<>(apiError, HttpStatus.OK); 
    }
    
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Response handleException(Exception ex, HttpServletRequest request) {
        System.out.println("Trying to print error");
        try{
            System.out.println("Error : "+ex.getMessage());
        }catch(Exception e){}
        Response apiError = new Response(requestID.incrementAndGet(), 0, "Not available");
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        return apiError;
    }
}
