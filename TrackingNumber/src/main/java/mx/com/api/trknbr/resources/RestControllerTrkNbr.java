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
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import mx.com.api.trknbr.beans.ApiResponse;
import mx.com.api.trknbr.beans.FolioResponse;
import mx.com.api.trknbr.beans.FoliosResponse;
import mx.com.api.trknbr.beans.Request;
import mx.com.api.trknbr.beans.Response;
import mx.com.api.trknbr.configuration.ConfigBean;
import mx.com.api.trknbr.enums.Urls;
import mx.com.api.trknbr.ws.GenGuia;
import mx.elektra.dependencias.dto.DatosKibana;
import mx.elektra.dependencias.enums.Nivel;
import mx.elektra.dependencias.service.EscribirLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nroblerol
 */
@RestController
@RequestMapping(Urls.VERSION)
public class RestControllerTrkNbr {
    @Autowired
    private ConfigBean conf;
    @Autowired
    private AtomicLong idRequest;
    @Autowired
    private GenGuia generator;
    @Autowired
    private EscribirLog bitacora;
    
    private DatosKibana data=new DatosKibana();
    
    @PostConstruct
    private void init(){
        data.setSistema("local");
        data.setServicio("WSGuia");
    }
    
    @Operation(summary = "Get Route information", tags = "register-status")
    @ApiResponses(value = {@io.swagger.v3.oas.annotations.responses.ApiResponse(description = "OK", content = @Content(schema = @Schema(implementation = ApiResponse.class,
            example = "{\"codigo\": \"0\",\"mensaje\": \"Procesado\",\"resultado\": {\"mensaje\": \"Rutas Creadas\",\"estatus\": 0,\"ruta\": [\"613223\"],\"folios\": {\"folio\": [{\"remision\": \"222333\",\"resultado\": \"Ruta Creada\"}]}}}")))})
    @GetMapping(value = {"","/"})
    public ApiResponse index(){
        ApiResponse apiResp=new ApiResponse();
        apiResp.setCodigo("0 Procesado, 1 Errores");
        apiResp.setMensaje("Resultado de procesamiento");
        Response resp = new Response();
        resp.setEstatus(0);
        resp.setCode("0: Procesado correctamente, 1: Procesado con errores, Sin informacion, -1: No procesado");
        resp.setMensaje("API Guias, Descripcion Response");
            FoliosResponse fols=new FoliosResponse();
                List<FolioResponse> folsList=new ArrayList<>();
                    FolioResponse fol=new FolioResponse();
                    fol.setPedido("Folio enviado");
                    fol.setResultado("Resultado de procesamiento");
                folsList.add(fol);
            fols.setPedido(folsList);
        resp.setResultado(fols);
        apiResp.setResultado(resp);
        return apiResp;
    }
    /*
    @PostMapping(value = "/ruta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getRoute(@RequestBody(required = true) Request req){
        ResponseEntity<ApiResponse> re = null;
        Response resp=new Response();
        try{
            re = wsruta.cancelRoute(new mx.com.api.trknbr.feign.beans.Request());
        }catch(RetryableException fe){
            resp.setEstatus(-1);
            resp.setMensaje("Unable to get Route: 404 "+fe.status());
            re = new ResponseEntity(resp, HttpStatus.NOT_FOUND);
        }catch(FeignException fe){
            resp.setEstatus(-1);
            resp.setMensaje("FE:"+fe.status());
            try{
                re = new ResponseEntity(fe.contentUTF8(), HttpStatus.valueOf(fe.status()));
            }catch(Exception e){
                re = new ResponseEntity(fe.contentUTF8(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }catch(Exception e){
            resp.setEstatus(-1);
            resp.setMensaje("Failed");
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return re;
    }
    */
    @Operation(summary = "Get Route information", tags = "register-status")
    @ApiResponses(value = {@io.swagger.v3.oas.annotations.responses.ApiResponse(description = "OK", content = @Content(schema = @Schema(implementation = ApiResponse.class,
            example = "{\"codigo\": \"0\",\"mensaje\": \"Procesado\",\"resultado\": {\"mensaje\": \"Guia Creada\",\"estatus\": 0,\"folios\": {\"folio\": [{\"remision\": \"222333\",\"resultado\": \"Ruta Creada\"}]}}}")))})
    @PostMapping(value = Urls.CREATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getTrackingNumber(@Valid @RequestBody(required = true) Request req){
        data.setUrl(Urls.CREATE);
        ApiResponse guia= new ApiResponse();
        req.setIdPeticion(idRequest.getAndIncrement());
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WSGG".concat(req.getIdPeticion().toString()), data);
        Response resp = new Response();
        resp=generator.generateTrkNbr(req);
        if(resp.getError()){
            guia.setMensaje("Error al procesar");
            guia.setCodigo("1");
        }else{
            guia.setMensaje("Procesado");
            guia.setCodigo("0");
        }
        resp.setError(null);
        resp.setCode(null);
        ResponseEntity re = null;
        guia.setResultado(resp);
        guia.setFolio(idRequest.toString());
        if(resp.getEstatus()==1 || resp.getEstatus()==-3){
            resp.setEstatus(1);
            re = new ResponseEntity(resp, HttpStatus.ACCEPTED);
        }
        if(resp.getEstatus()==0){
            re = new ResponseEntity(resp, HttpStatus.OK);
        }
        if(resp.getEstatus()==-1)
            re = new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
        if(resp.getEstatus()==-2){
            guia.setCodigo("1");
            resp.setEstatus(-1);
            resp.setMensaje(resp.getMensaje());
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WSGG".concat(req.getIdPeticion().toString()), data);
        return re;
    }
}
