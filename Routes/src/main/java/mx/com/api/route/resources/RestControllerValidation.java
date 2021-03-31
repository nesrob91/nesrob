/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.resources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import mx.com.api.route.Procesos;
import mx.com.api.route.beans.Request;
import mx.com.api.route.beans.Response;
import mx.com.api.route.beans.ResponseRuta;
import mx.com.api.route.configuration.ConfigBean;
import mx.com.api.route.service.GeneralService;
import mx.com.api.route.type.TypeSelector;
import mx.elektra.dependencias.dto.DatosKibana;
import mx.elektra.dependencias.enums.Nivel;
import mx.elektra.dependencias.service.EscribirLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.com.api.route.enums.Urls;

/**
 *
 * @author nroblerol
 */
@RestController
@RequestMapping(Urls.VERSION)
public class RestControllerValidation {
    @Autowired
    private ConfigBean configuration;
    @Autowired
    private AtomicLong idRequest;
    @Autowired
    private TypeSelector rutaSelect;
    @Autowired
    EscribirLog bitacora;
    
    private DatosKibana data=new DatosKibana();
    
    @PostConstruct
    private void init(){
        data.setSistema("local");
        data.setServicio("WSRuta");
    }
    
    @Operation(summary = "Get Route information", tags = "info-route")
    @ApiResponses(value = {@ApiResponse(description = "OK", content = @Content(schema = @Schema(implementation = Response.class),
            examples = @ExampleObject(value = "{\"codigo\": \"0\",\"mensaje\": \"Procesado\",\"resultado\": {\"mensaje\": \"Informacion Obtenida\",\"estatus\": 0,\"folios\": {\"folio\": [{\"remision\": \"222333\",\"resultado\": \"Ruta Creada\"}]}}}")))})
    @GetMapping(value = Urls.STATUS, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> statusRoute(@Valid @RequestBody(required = true) Request req) {
        Response resp = new Response();
        data.setUrl(Urls.STATUS);
        req.setIdPeticion(idRequest.getAndIncrement());
        req.setIdUsuario(1002);
        ResponseRuta ruta= new ResponseRuta();
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WSRT".concat(req.getIdPeticion().toString()), data);
        if(rutaSelect.validateRequest(req, Procesos.STATUS)){
            ruta=rutaSelect.getStatus(req);
            resp.setMensaje("Procesado");
            resp.setCodigo("0");
        }else{
            resp.setMensaje("Verifique peticion");
            resp.setCodigo("1");
            ruta.setEstatus(-1);
            ruta.setMensaje("Peticion invalida");
        }
        ResponseEntity re = null;
        resp.setResultado(ruta);
        resp.setFolio(idRequest.toString());
        if(ruta.getEstatus()==1 || ruta.getEstatus()==-3){
            ruta.setEstatus(1);
            re = new ResponseEntity(resp, HttpStatus.ACCEPTED);
        }
        if(ruta.getEstatus()==0)
            re = new ResponseEntity(resp, HttpStatus.OK);
        if(ruta.getEstatus()==-1)
            re = new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
        if(ruta.getEstatus()==-2){
            ruta.setEstatus(-1);
            resp.setCodigo("1");
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WSRT".concat(req.getIdPeticion().toString()), data);
        return re;
    }
    
}
