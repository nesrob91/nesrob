/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.resources;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import mx.com.api.route.configuration.ConfigBean;
import mx.com.api.route.beans.FolioResponse;
import mx.com.api.route.beans.FoliosResponse;
import mx.com.api.route.beans.Request;
import mx.com.api.route.beans.Response;
import mx.com.api.route.beans.ResponseRuta;
import mx.com.api.route.service.GeneralService;
import mx.com.api.route.type.TypeSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author nroblerol
 */
@RestController
@RequestMapping("/v1")
@OpenAPIDefinition(info = @Info(title = "WS_ROUTE_MGT", version = "1.0"), servers = @Server(url = "http://localhost:8443/wsRuta/v1",description = "API Route Management"))
public class RestControllerRoute {
    @Autowired
    private ConfigBean configuration;
    @Autowired
    private GeneralService generalService;
    @Autowired
    private AtomicLong idRequest;
    @Autowired
    private TypeSelector rutaSelect;
    
    @PostConstruct
    private void init(){
        String s=generalService.getRequestCount();
        idRequest=new AtomicLong(new Long(s));
    }

    @ApiResponses(value = {@ApiResponse(description = "Index", content = @Content(schema = @Schema(implementation = Request.class)))})
    @GetMapping(path = {"","/"}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response index(){
        Response resp = new Response();
        resp.setCodigo("0 procesado, 1 No procesado");
        resp.setMensaje("Descriptor");
            ResponseRuta ruta= new ResponseRuta();
            ruta.setCode("0: Procesado correctamente, 1: Procesado con errores, -1: No procesado");
            ruta.setMensaje("API Ruta, Response Description");
                List<String> rutas=new ArrayList<>();
                rutas.add("Folio de ruta");
            ruta.setRuta(rutas);
                FoliosResponse fols=new FoliosResponse();
                    List<FolioResponse> folsList=new ArrayList<>();
                        FolioResponse fol=new FolioResponse();
                        fol.setRemision("Folio(Remision) enviado");
                        fol.setRuta("Folio(Ruta) enviado");
                        fol.setResultado("Resultado de procesamiento");
                    folsList.add(fol);
                fols.setFolio(folsList);
            ruta.setFolios(fols);
        resp.setResultado(ruta);
        return resp;
    }
    
    @Operation(summary = "Create Route given Remision fols")
    @PostMapping(path = "/ruta/creacion", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createRoute(@Valid @RequestBody(required = true) Request req){
        Response resp = new Response();
        req.setIdPeticion(idRequest.getAndIncrement());
        ResponseRuta ruta= new ResponseRuta();
        if(rutaSelect.validateRequest(req, 1)){
            ruta=rutaSelect.generateRoute(req);
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
        if(ruta.getEstatus()==1){
            re = new ResponseEntity(resp, HttpStatus.ACCEPTED);
        }
        if(ruta.getEstatus()==0){
            re = new ResponseEntity(resp, HttpStatus.OK);
        }
        if(ruta.getEstatus()==-2){
            resp.setCodigo("1");
            resp.setMensaje(ruta.getMensaje());
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(ruta.getEstatus()==-1){
            re = new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
        }
        return re;
    }
    
    @Operation(summary = "Retrieve Route Document given Ruta fols")
    @GetMapping(path = "/ruta/documento", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getDocRoute(@Valid @RequestBody(required = true) Request req){
        Response resp = new Response();
        req.setIdPeticion(idRequest.getAndIncrement());
        ResponseRuta ruta= new ResponseRuta();
        if(rutaSelect.validateRequest(req, 2)){
            ruta=rutaSelect.generateRoute(req);
        }else{
            resp.setMensaje("Verifique peticion");
            resp.setCodigo("-1");
        }
        ResponseEntity re = null;
        if(ruta.getEstatus()==1)
            re = new ResponseEntity(resp, HttpStatus.MULTI_STATUS);
        if(ruta.getEstatus()==0)
            re = new ResponseEntity(resp, HttpStatus.OK);
        if(ruta.getEstatus()==-2){
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            resp.setCodigo("-1");
        }
        if(ruta.getEstatus()==-1)
            re = new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
        return re;
    }
    
    @Operation(summary = "Cancel Route given Ruta fols")
    @PostMapping(path = "/ruta/cancelar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> cancelRoute(@Valid @RequestBody(required = true) Request req ){
        Response resp = new Response();
        req.setIdPeticion(idRequest.getAndIncrement());
        ResponseRuta ruta= new ResponseRuta();
        if(rutaSelect.validateRequest(req, 3)){
            ruta=rutaSelect.generateRoute(req);
        }else{
            resp.setMensaje("Verifique peticion");
            resp.setCodigo("-1");
        }
        ResponseEntity re = null;
        if(ruta.getEstatus()==1)
            re = new ResponseEntity(resp, HttpStatus.MULTI_STATUS);
        if(ruta.getEstatus()==0)
            re = new ResponseEntity(resp, HttpStatus.OK);
        if(ruta.getEstatus()==-2){
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            resp.setCodigo("-1");
        }
        if(ruta.getEstatus()==-1)
            re = new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
        return re;
    }
    
    @Operation(summary = "Modify Route given Ruta fols")
    @PutMapping(path = "/ruta/estatus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> statusRoute(@Valid @RequestBody(required = true) Request req ){
        Response resp = new Response();
        req.setIdPeticion(idRequest.getAndIncrement());
        ResponseRuta ruta= new ResponseRuta();
        if(rutaSelect.validateRequest(req, 4)){
            ruta=rutaSelect.generateRoute(req);
        }else{
            resp.setMensaje("Verifique peticion");
            resp.setCodigo("-1");
        }
        ResponseEntity re = null;
        if(ruta.getEstatus()==1)
            re = new ResponseEntity(resp, HttpStatus.MULTI_STATUS);
        if(ruta.getEstatus()==0)
            re = new ResponseEntity(resp, HttpStatus.OK);
        if(ruta.getEstatus()==-2){
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            resp.setCodigo("-1");
        }
        if(ruta.getEstatus()==-1)
            re = new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
        return re;
    }
}
