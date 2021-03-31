/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.controller;

import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.servlet.http.HttpServletRequest;
import mx.com.api.trknbr.beans.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Binding Error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = mx.com.api.trknbr.beans.ApiResponse.class),
            examples = @ExampleObject(value = "{\"codigo\": \"1\",\"mensaje\": \"Binding exception [errDesc]\",\"resultado\": {}}")))})
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpServletRequest request) {
        String error = "Binding exception " + ex.getMessage() + ". " + ex.getNestedPath();
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ApiResponses(value = {@ApiResponse(responseCode = "404", description = "Resource not Found", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = mx.com.api.trknbr.beans.ApiResponse.class),
            examples = @ExampleObject(value = "{\"codigo\": \"1\",\"mensaje\": \"no handler found for [METHOD] [url]\",\"resultado\": {}}")))})
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpServletRequest request) {
        String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    /*@ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = ex.getMessage();
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Request Bind Error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = mx.com.api.trknbr.beans.ApiResponse.class),
            examples = @ExampleObject(value = "{\"codigo\": \"1\",\"mensaje\": \"Binding not found. [errDesc]\",\"resultado\": {}}")))})
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpServletRequest request) {
        String error="Binding not found. "+ex.getMessage()+". "+request.getContextPath();
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Missing Body", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = mx.com.api.trknbr.beans.ApiResponse.class),
            examples = @ExampleObject(value = "{\"codigo\": \"1\",\"mensaje\": \"Unreadable Body.\",\"resultado\": {}}")))})
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpServletRequest request) {
        String error="Unreadable Body. ";
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    @ApiResponses(value = {@ApiResponse(responseCode = "405", description = "Method not supported", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = mx.com.api.trknbr.beans.ApiResponse.class),
            examples = @ExampleObject(value = "{\"codigo\": \"1\",\"mensaje\": \"Method not supported. PATCH. [url]\",\"resultado\": {}}")))})
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpServletRequest request) {
        String error="Method not supported. "+ex.getMethod()+". "+request.getRequestURI();
        //error+=" "+ex.getMessage()+" "+request.getDescription(true);
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(error);
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
    }
    
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Missing Parameter", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = mx.com.api.trknbr.beans.ApiResponse.class),
            examples = @ExampleObject(value = "{\"codigo\": \"1\",\"mensaje\": \"Missing parameter... var1\",\"resultado\": {}}")))})
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpServletRequest request) {
        String error = "Missing parameter... "+ex.getParameterName()+". ";
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(error);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST); 
    }

    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Missing path variable", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = mx.com.api.trknbr.beans.ApiResponse.class),
            examples = @ExampleObject(value = "{\"codigo\": \"1\",\"mensaje\": \"Missing variable... var1\",\"resultado\": {}}")))})
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpServletRequest request) {
        String error = "Missing variable... "+ex.getVariableName()+". ";
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(error);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST); 
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Missing request part", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = mx.com.api.trknbr.beans.ApiResponse.class),
            examples = @ExampleObject(value = "{\"codigo\": \"1\",\"mensaje\": \"Missing Part... parameter\",\"resultado\": {}}")))})
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpServletRequest request) {
        String error = "Missing part... "+ex.getRequestPartName()+". ";
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(error);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST); 
    }
    
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ApiResponses(value = {@ApiResponse(responseCode = "415", description = "MediaType Not Supported", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = mx.com.api.trknbr.beans.ApiResponse.class),
            examples = @ExampleObject(value = "{\"codigo\": \"1\",\"mensaje\": \"Invalid MediaType... application/xml\",\"resultado\": {}}")))})
    protected ResponseEntity<Object> handleMediaTypeException(HttpMediaTypeNotSupportedException ex, HttpServletRequest request) {
        String error = "Inalid MediaType... "+ex.getContentType()+". ";
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(error);
        return new ResponseEntity<>(apiError, HttpStatus.UNSUPPORTED_MEDIA_TYPE); 
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ApiResponses(value = {@ApiResponse(responseCode = "400", description = "Validate Request", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = mx.com.api.trknbr.beans.ApiResponse.class),
            examples = @ExampleObject(value = "{\"codigo\": \"1\",\"mensaje\": \"Validate Fields... |idCentro|\",\"resultado\": {}}")))})
    protected ResponseEntity<Object> handle(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String fields ="";
        fields = ex.getBindingResult().getFieldErrors().stream().map((fe) -> ("|").concat(fe.getField()).concat("|")).reduce(fields, String::concat);
        String error = "Validate Fields... "+fields+". ";
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(error);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST); 
    }
    
    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @Hidden
    protected ResponseEntity<Object> handleExpiredToken(ExpiredJwtException ex, HttpServletRequest request) {
        String error ="Auth Invalid... "+ex.getMessage();
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(error);
        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN); 
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ApiResponses(value = {@ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = mx.com.api.trknbr.beans.ApiResponse.class),
            examples = @ExampleObject(value = "{\"codigo\": \"1\",\"mensaje\": \"null pointer exception\",\"resultado\": {}}")))})
    public mx.com.api.trknbr.beans.ApiResponse handleException(Exception ex, HttpServletRequest request) {
        mx.com.api.trknbr.beans.ApiResponse apiError = new mx.com.api.trknbr.beans.ApiResponse();
        apiError.setCodigo("1");
        apiError.setMensaje(ex.getMessage());
        return apiError;
    }
}
