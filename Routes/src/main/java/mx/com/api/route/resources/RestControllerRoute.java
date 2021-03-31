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
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import mx.com.api.route.Procesos;
import mx.com.api.route.configuration.ConfigBean;
import mx.com.api.route.beans.FolioResponse;
import mx.com.api.route.beans.FoliosResponse;
import mx.com.api.route.beans.Request;
import mx.com.api.route.beans.Response;
import mx.com.api.route.beans.ResponseRuta;
import mx.com.api.route.enums.Urls;
import mx.com.api.route.service.GeneralService;
import mx.com.api.route.type.TypeSelector;
import mx.elektra.dependencias.dto.DatosKibana;
import mx.elektra.dependencias.dto.TipoLog;
import mx.elektra.dependencias.enums.Nivel;
import mx.elektra.dependencias.service.EscribirLog;
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
@RequestMapping(Urls.VERSION)
@OpenAPIDefinition(info = @Info(title = "WS_ROUTE_MGT", version = "1.0"), servers = @Server(url = "http://localhost:8443/wsRuta/v1",description = "API Route Management"))
public class RestControllerRoute {
    @Autowired
    private ConfigBean configuration;
    //@Autowired
    //private GeneralService generalService;
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

    @Operation(summary = "Index", tags = "index-response-descriptor")
    @ApiResponses(value = {@ApiResponse(description = "Index", content = @Content(schema = @Schema(implementation = Response.class),
            examples = @ExampleObject(value = "{\"codigo\":\"0 procesado, 1 No procesado\",\"mensaje\":\"Descriptor\",\"resultado\":{\"mensaje\":\"API Ruta, Response Description\",\"ruta\":[\"Folio de ruta\"],\"folios\":{\"folio\":[{\"remision\":\"Folio(Remision) enviado\",\"ruta\":\"Folio(Ruta) enviado\",\"resultado\":\"Resultado de procesamiento\"}]},\"code\":\"0: Procesado correctamente, 1: Procesado con errores, -1: No procesado\"}}")))})
    @GetMapping(path = {"","/"}, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response index(){
        data.setUrl("/");
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WS index init", data);
        idRequest.getAndIncrement();
        Response resp = new Response();
        resp.setCodigo("0 procesado, 1 No procesado");
        resp.setMensaje("Descriptor");
            ResponseRuta ruta= new ResponseRuta();
            ruta.setCode("0: Procesado correctamente, 1: Procesado con errores, -1: No procesado");
            ruta.setEstatus(0);
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
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WS index end", data);
        return resp;
    }
    
    @Operation(summary = "Create Route given Remision fols", tags = "manage-route")
    @ApiResponses(value = {@ApiResponse(description = "OK", content = @Content(schema = @Schema(implementation = Response.class),
            examples = @ExampleObject(value = "{\"codigo\": \"0\",\"mensaje\": \"Procesado\",\"resultado\": {\"mensaje\": \"Rutas Creadas\",\"estatus\": 0,\"ruta\": [\"613223\"],\"folios\": {\"folio\": [{\"remision\": \"222333\",\"resultado\": \"Ruta Creada\"}]}}}")))})
    @PostMapping(value = Urls.CREATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createRoute(@Valid @RequestBody(required = true) Request req){
        data.setUrl(Urls.CREATE);
        Response resp = new Response();
        req.setIdPeticion(idRequest.getAndIncrement());
        req.setIdUsuario(1002);
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WSRT".concat(req.getIdPeticion().toString()), data);
        ResponseRuta ruta= new ResponseRuta();
        if(rutaSelect.validateRequest(req, Procesos.CREATE)){
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
        resp.setFolio(idRequest.toString());
        if(ruta.getEstatus()==1 || ruta.getEstatus()==-3){
            ruta.setEstatus(1);
            re = new ResponseEntity(resp, HttpStatus.ACCEPTED);
        }
        if(ruta.getEstatus()==0){
            re = new ResponseEntity(resp, HttpStatus.OK);
        }
        if(ruta.getEstatus()==-1)
            re = new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
        if(ruta.getEstatus()==-2){
            resp.setCodigo("1");
            ruta.setEstatus(-1);
            resp.setMensaje(ruta.getMensaje());
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WSRT".concat(req.getIdPeticion().toString()), data);
        return re;
    }
    
    @Operation(summary = "Retrieve Route Document given Ruta fols", tags = "info-route")
    @ApiResponses(value = {@ApiResponse(description = "OK", content = @Content(schema = @Schema(implementation = Response.class),
            examples = @ExampleObject(value = "{\"codigo\": \"0\",\"mensaje\": \"Procesado\",\"resultado\": {\"mensaje\": \"Documento Recuperado\",\"estatus\": 0,\"documento\": [\"String en base64\"],\"folios\": {\"folio\": [{\"ruta\": \"616262\",\"resultado\": \"Documento Recuperado\"}]}}}")))})
    @GetMapping(value = Urls.DOCUMENT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getDocRoute(@Valid @RequestBody(required = true) Request req){
        data.setUrl(Urls.DOCUMENT);
        Response resp = new Response();
        req.setIdPeticion(idRequest.getAndIncrement());
        req.setIdUsuario(1002);
        ResponseRuta ruta= new ResponseRuta();
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WSRT".concat(req.getIdPeticion().toString()), data);
        if(rutaSelect.validateRequest(req, Procesos.DOCUMENT)){
            ruta=rutaSelect.retrieveDoc(req);
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
            resp.setCodigo("1");
            ruta.setEstatus(-1);
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WSRT".concat(req.getIdPeticion().toString()), data);
        return re;
    }
    
    @Operation(summary = "Cancel Route given Ruta fols", tags = "manage-route")
    @ApiResponses(value = {@ApiResponse(description = "OK", content = @Content(schema = @Schema(implementation = Response.class),
            examples = @ExampleObject(value = "{\"codigo\": \"0\",\"mensaje\": \"Procesado\",\"resultado\": {\"mensaje\": \"Rutas Canceladas\",\"estatus\": 0,\"folios\": {\"folio\": [{\"ruta\": \"636172\",\"resultado\": \"Ruta Cancelada\"}]}}}")))})
    @PostMapping(value = Urls.CANCEL, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> cancelRoute(@Valid @RequestBody(required = true) Request req ){
        data.setUrl(Urls.CANCEL);
        Response resp = new Response();
        req.setIdPeticion(idRequest.getAndIncrement());
        req.setIdUsuario(1002);
        ResponseRuta ruta= new ResponseRuta();
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WSRT".concat(req.getIdPeticion().toString()), data);
        if(rutaSelect.validateRequest(req, Procesos.CANCEL)){
            ruta=rutaSelect.cancelRoute(req);
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
            resp.setCodigo("1");
            ruta.setEstatus(-1);
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WSRT".concat(req.getIdPeticion().toString()), data);
        return re;
    }
    
    @Operation(summary = "Modify Route given Ruta fols", tags = "manage-route")
    @ApiResponses(value = {@ApiResponse(description = "OK", content = @Content(schema = @Schema(implementation = Response.class),
            examples = @ExampleObject(value = "{\"codigo\": \"0\",\"mensaje\": \"Procesado\",\"resultado\": {\"mensaje\": \"Estatus Registrado\",\"estatus\": 0,\"folios\": {\"folio\": [{\"remision\": \"222333\",\"resultado\": \"Estatus de Ruta Modificado\"}]}}}")))})
    @PutMapping(value = Urls.UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> statusRoute(@Valid @RequestBody(required = true) Request req ){
        data.setUrl(Urls.UPDATE);
        Response resp = new Response();
        req.setIdPeticion(idRequest.getAndIncrement());
        req.setIdUsuario(1002);
        ResponseRuta ruta= new ResponseRuta();
        bitacora.escribir(this.getClass(), Nivel.INFORMATIVO, "WSRT".concat(req.getIdPeticion().toString()), data);
        if(rutaSelect.validateRequest(req, Procesos.UPDATE)){
            ruta=rutaSelect.modifyRoute(req);
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
