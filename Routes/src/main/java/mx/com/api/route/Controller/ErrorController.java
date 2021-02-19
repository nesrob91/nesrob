/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.Controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.http.HttpServletRequest;
import mx.com.api.route.beans.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author nroblerol
 */
@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Binding exception " + ex.getMessage() + ". " + ex.getNestedPath();
        Response apiError = new Response();
        apiError.setEstatus(-1);
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
        Response apiError = new Response();
        apiError.setEstatus(-1);
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = ex.getMessage();
        Response apiError = new Response();
        apiError.setEstatus(-1);
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error="Binding not found. "+ex.getMessage()+". "+request.getContextPath();
        Response apiError = new Response();
        apiError.setEstatus(-1);
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error="Request Body not found. "+status.toString();
        Response apiError = new Response();
        apiError.setEstatus(-1);
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error="Method not supported. "+ex.getMethod()+". "+request.getContextPath();
        //error+=" "+ex.getMessage()+" "+request.getDescription(true);
        Response apiError = new Response();
        apiError.setEstatus(-1);
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
    }
    
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Missing parameter... "+ex.getParameterName()+". "+status.toString()+". "+ex.getMessage();
        Response apiError = new Response();
        apiError.setEstatus(-1);
        apiError.setMensaje(error);
        return new ResponseEntity<>(apiError, HttpStatus.PARTIAL_CONTENT); 
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Missing variable... "+ex.getVariableName()+". "+status.toString()+". "+ex.getMessage();
        Response apiError = new Response();
        apiError.setEstatus(-1);
        apiError.setMensaje(error);
        return new ResponseEntity<>(apiError, HttpStatus.PARTIAL_CONTENT); 
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Missing body... "+ex.getRequestPartName()+". "+status.toString()+". "+ex.getMessage();
        Response apiError = new Response();
        apiError.setEstatus(-1);
        apiError.setMensaje(error);
        return new ResponseEntity<>(apiError, HttpStatus.PARTIAL_CONTENT); 
    }
    
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Response handleException(Exception ex, HttpServletRequest request) {
        System.out.println("Trying to print error");
        try{
            System.out.println("Error : "+ex.getMessage());
        }catch(Exception e){}
        Response apiError = new Response();
        apiError.setEstatus(-1);
        apiError.setMensaje(ex.getMessage());
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        return apiError;
    }
}
