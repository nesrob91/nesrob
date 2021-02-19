/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.resources;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PostConstruct;
import mx.com.api.route.beans.ConfigBean;
import mx.com.api.route.beans.FolioResponse;
import mx.com.api.route.beans.FoliosResponse;
import mx.com.api.route.beans.Request;
import mx.com.api.route.beans.Response;
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
@RequestMapping("/wsRuta")
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
    
    @GetMapping(path = {"","/"})
    public Response index(){
        Response resp = new Response();
        resp.setEstatus(0);
        resp.setCode("0: Procesado correctamente, 1: Procesado con errores, -1: No procesado");
        resp.setMensaje("API Ruta, Response Description");
            List<String> rutas=new ArrayList<>();
            rutas.add("Folio de ruta");
        resp.setRuta(rutas);
            FoliosResponse fols=new FoliosResponse();
                List<FolioResponse> folsList=new ArrayList<>();
                    FolioResponse fol=new FolioResponse();
                    fol.setRuta("Folio enviado");
                    fol.setResultado("Resultado de procesamiento");
                folsList.add(fol);
            fols.setFolio(folsList);
        resp.setFolios(fols);
        return resp;
    }
    
    @PostMapping(path = "/ruta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> createRoute(@RequestBody(required = true) Request req){
        Response resp = new Response();
        req.setIdPeticion(idRequest.getAndIncrement());
        if(rutaSelect.validateRequest(req, 1)){
            //resp=rutaSelect.generateRoute(req);
            resp.setMensaje("Dummy");
            resp.setEstatus(0);
        }else{
            resp.setMensaje("Verifique peticion");
            resp.setEstatus(-1);
        }
        ResponseEntity re = null;
        if(resp.getEstatus()==1)
            re = new ResponseEntity(resp, HttpStatus.MULTI_STATUS);
        if(resp.getEstatus()==0)
            re = new ResponseEntity(resp, HttpStatus.OK);
        if(resp.getEstatus()==-2){
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            resp.setEstatus(-1);
        }
        if(resp.getEstatus()==-1)
            re = new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
        return re;
    }
    
    @GetMapping("/ruta/documento")
    public ResponseEntity<Response> getDocRoute(@RequestBody(required = true) Request req){
        Response resp = new Response();
        req.setIdPeticion(idRequest.getAndIncrement());
        if(rutaSelect.validateRequest(req, 2)){
            resp=rutaSelect.generateRoute(req);
        }else{
            resp.setMensaje("Verifique peticion");
            resp.setEstatus(-1);
        }
        ResponseEntity re = null;
        if(resp.getEstatus()==1)
            re = new ResponseEntity(resp, HttpStatus.MULTI_STATUS);
        if(resp.getEstatus()==0)
            re = new ResponseEntity(resp, HttpStatus.OK);
        if(resp.getEstatus()==-2){
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            resp.setEstatus(-1);
        }
        if(resp.getEstatus()==-1)
            re = new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
        return re;
    }
    
    @PostMapping("/ruta/cancelar")
    public ResponseEntity<Response> cancelRoute(@RequestBody(required = true) Request req ){
        Response resp = new Response();
        req.setIdPeticion(idRequest.getAndIncrement());
        if(rutaSelect.validateRequest(req, 3)){
            resp=rutaSelect.generateRoute(req);
        }else{
            resp.setMensaje("Verifique peticion");
            resp.setEstatus(-1);
        }
        ResponseEntity re = null;
        if(resp.getEstatus()==1)
            re = new ResponseEntity(resp, HttpStatus.MULTI_STATUS);
        if(resp.getEstatus()==0)
            re = new ResponseEntity(resp, HttpStatus.OK);
        if(resp.getEstatus()==-2){
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            resp.setEstatus(-1);
        }
        if(resp.getEstatus()==-1)
            re = new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
        return re;
    }
    
    @PutMapping("/ruta/estatus")
    public ResponseEntity<Response> statusRoute(@RequestBody(required = true) Request req ){
        Response resp = new Response();
        req.setIdPeticion(idRequest.getAndIncrement());
        if(rutaSelect.validateRequest(req, 4)){
            resp=rutaSelect.generateRoute(req);
        }else{
            resp.setMensaje("Verifique peticion");
            resp.setEstatus(-1);
        }
        ResponseEntity re = null;
        if(resp.getEstatus()==1)
            re = new ResponseEntity(resp, HttpStatus.MULTI_STATUS);
        if(resp.getEstatus()==0)
            re = new ResponseEntity(resp, HttpStatus.OK);
        if(resp.getEstatus()==-2){
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
            resp.setEstatus(-1);
        }
        if(resp.getEstatus()==-1)
            re = new ResponseEntity(resp, HttpStatus.BAD_REQUEST);
        return re;
    }
}
