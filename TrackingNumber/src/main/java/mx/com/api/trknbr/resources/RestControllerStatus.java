/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.resources;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.validation.Valid;
import mx.com.api.trknbr.beans.ApiResponse;
import mx.com.api.trknbr.beans.FolioResponse;
import mx.com.api.trknbr.beans.FoliosResponse;
import mx.com.api.trknbr.beans.Request;
import mx.com.api.trknbr.beans.Response;
import mx.com.api.trknbr.configuration.ConfigBean;
import mx.com.api.trknbr.enums.Urls;
import mx.com.api.trknbr.ws.GenGuia;
import mx.elektra.dependencias.service.EscribirLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nroblerol
 */
@RestController
@RequestMapping(Urls.VERSION)
public class RestControllerStatus {
    @Autowired
    private ConfigBean conf;
    @Autowired
    private AtomicLong idRequest;
    @Autowired
    private GenGuia generator;
    @Autowired
    private EscribirLog bitacora;
    
    @Operation(summary = "Get Route information", tags = "register-status")
    @ApiResponses(value = {@io.swagger.v3.oas.annotations.responses.ApiResponse(description = "OK", content = @Content(schema = @Schema(implementation = Response.class,
            example = "{\"codigo\": \"0\",\"mensaje\": \"Procesado\",\"resultado\": {\"mensaje\": \"Rutas Creadas\",\"estatus\": 0,\"ruta\": [\"613223\"],\"folios\": {\"folio\": [{\"remision\": \"222333\",\"resultado\": \"Ruta Creada\"}]}}}")))})
    @GetMapping(value = Urls.STATUS, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getTrackingNumber(@Valid @RequestBody(required = true)Request req){
        req.setIdPeticion(idRequest.getAndIncrement());
        ApiResponse resp = new ApiResponse();
        resp.setCodigo("0");
        resp.setMensaje("Procesado");
        Response re = new Response();
            FoliosResponse fols=new FoliosResponse();
                List<FolioResponse> folsList=new ArrayList<>();
                    FolioResponse fol=new FolioResponse();
                    fol.setPedido("Folio enviado");
                    fol.setResultado("Sin Guia");
                folsList.add(fol);
            fols.setPedido(folsList);
        re.setCarrier("");
        re.setEstatus(1);
        re.setNumGuia("");
        re.setMensaje("Sin guias");
        re.setResultado(fols);
        resp.setResultado(re);
        return new ResponseEntity(resp, HttpStatus.OK);
    }
    
    @Operation(summary = "Get Route information", tags = "register-status")
    @ApiResponses(value = {@io.swagger.v3.oas.annotations.responses.ApiResponse(description = "OK", content = @Content(schema = @Schema(implementation = Response.class,
            example = "{\"codigo\": \"0\",\"mensaje\": \"Procesado\",\"resultado\": {\"mensaje\": \"Rutas Creadas\",\"estatus\": 0,\"ruta\": [\"613223\"],\"folios\": {\"folio\": [{\"remision\": \"222333\",\"resultado\": \"Ruta Creada\"}]}}}")))})
    @GetMapping(value = Urls.TRKNBR, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getTrackingNumberStatus(@Valid @RequestBody(required = true)Request req){
        ApiResponse resp = new ApiResponse();
        resp.setCodigo("0");
        resp.setMensaje("Procesado");
        Response re = new Response();
        resp.setResultado(re);
        return new ResponseEntity(resp, HttpStatus.OK);
    }
}
