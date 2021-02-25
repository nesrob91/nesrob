/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.resources;

import feign.FeignException;
import feign.RetryableException;
import java.util.ArrayList;
import java.util.List;
import mx.com.api.trknbr.beans.FolioResponse;
import mx.com.api.trknbr.beans.FoliosResponse;
import mx.com.api.trknbr.beans.Request;
import mx.com.api.trknbr.beans.Response;
import mx.com.api.trknbr.feign.RouteFeign;
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
@RequestMapping("/wsGuia")
public class RestControllerTrkNbr {
    @Autowired
    private RouteFeign wsruta;
    
    @GetMapping(path = {"","/"})
    public Response index(){
        Response resp = new Response();
        resp.setEstatus(0);
        resp.setCode("0: Procesado correctamente, 1: Procesado con errores, -1: No procesado");
        resp.setMensaje("API Guias, Descripcion Response");
            List<String> rutas=new ArrayList<>();
            rutas.add("Folio de ruta");
        resp.setRuta(rutas);
            List<FolioResponse> folsList=new ArrayList<>();
                FoliosResponse fols=new FoliosResponse();
                    FolioResponse fol=new FolioResponse();
                    fol.setFolio("Folio enviado");
                    fol.setResultado("Resultado de procesamiento");
                fols.setFolio(fol);
            folsList.add(fol);
        resp.setFolios(folsList);
        return resp;
    }
    
    @PostMapping(path = "/ruta", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getRoute(@RequestBody(required = true) Request req){
        ResponseEntity<Response> re = null;
        Response resp=new Response();
        try{
            re = wsruta.createRoute(req);
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
    
    @PostMapping(path = "/guia", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getTrackingNumber(@RequestBody(required = true) Request req){
        ResponseEntity<Response> re = null;
        Response resp=new Response();
        try{
            re = wsruta.createRoute(req);
        }catch(RetryableException fe){
            resp.setEstatus(-1);
            resp.setMensaje("Unable to get Route:"+fe.status());
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(FeignException fe){
            resp.setEstatus(-1);
            resp.setMensaje("FE:"+fe.status());
            re = new ResponseEntity(fe.contentUTF8(), HttpStatus.valueOf(fe.status()));
        }catch(Exception e){
            resp.setEstatus(-1);
            resp.setMensaje("Failed");
            re = new ResponseEntity(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return re;
    }
}
