/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.Controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.servlet.http.HttpServletRequest;
import mx.com.api.route.beans.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 * @author nroblerol
 */
@ControllerAdvice
public class ErrorController /*extends ResponseEntityExceptionHandler*/ {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Binding Error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Response.class)))})
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpServletRequest request) {
        String error = "Binding exception " + ex.getMessage() + ". " + ex.getNestedPath();
        Response apiError = new Response();
        apiError.setCodigo("-1");
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ApiResponses(value = {@ApiResponse(responseCode = "404", description = "Resource not Found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Response.class)))})
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpServletRequest request) {
        String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
        Response apiError = new Response();
        apiError.setCodigo("-1");
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    /*@ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = ex.getMessage();
        Response apiError = new Response();
        apiError.setCodigo("-1");
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Request Bind Error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Response.class)))})
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpServletRequest request) {
        String error="Binding not found. "+ex.getMessage()+". "+request.getContextPath();
        Response apiError = new Response();
        apiError.setCodigo("-1");
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Missing Body", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Response.class)))})
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpServletRequest request) {
        String error="Request Body not found. ";
        Response apiError = new Response();
        apiError.setCodigo("-1");
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    @ApiResponses(value = {@ApiResponse(responseCode = "405", description = "Method not supported", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Response.class)))})
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        String error="Method not supported. "+ex.getMethod()+". "+request.getRequestURI();
        //error+=" "+ex.getMessage()+" "+request.getDescription(true);
        Response apiError = new Response();
        apiError.setCodigo("-1");
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
    }
    
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Missing Parameter", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Response.class)))})
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpServletRequest request) {
        String error = "Missing parameter... "+ex.getParameterName()+". ";
        Response apiError = new Response();
        apiError.setCodigo("-1");
        apiError.setMensaje(error);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST); 
    }

    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Missing path variable", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Response.class)))})
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpServletRequest request) {
        String error = "Missing variable... "+ex.getVariableName()+". ";
        Response apiError = new Response();
        apiError.setCodigo("-1");
        apiError.setMensaje(error);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST); 
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Missing request part", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Response.class)))})
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpServletRequest request) {
        String error = "Missing part... "+ex.getRequestPartName()+". ";
        Response apiError = new Response();
        apiError.setCodigo("-1");
        apiError.setMensaje(error);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST); 
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Response.class)))})
    public Response handleException(Exception ex, HttpServletRequest request) {
        System.out.println("Trying to print error");
        try{
            System.out.println("Error : "+ex.getMessage());
        }catch(Exception e){}
        Response apiError = new Response();
        apiError.setCodigo("-1");
        apiError.setMensaje(ex.getMessage());
        return apiError;
    }
}
