/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.msd.qb.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.com.elektra.msd.qb.common.CodigosResponseCommon;
import mx.com.elektra.msd.qb.common.FolioCommon;
import mx.com.elektra.msd.qb.model.CarrierQB;
import mx.com.elektra.msd.qb.model.ExclusionOInclusion;
import mx.com.elektra.msd.qb.model.Paquete;
import mx.com.elektra.msd.qb.model.PeticionCore;
import mx.com.elektra.msd.qb.model.Regla;
import mx.com.elektra.msd.qb.model.Tarifa;
import mx.com.elektra.msd.qb.service.CorebackUm;
import mx.elektra.dependencias.contenedorresponse.model.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nroblerol
 */
@RestController
@RequestMapping("/coreback/um")
public class CorebackUmController {
    
    @Autowired
    private FolioCommon folioCommon;
    @Autowired
    private CorebackUm core;
    
    @PostMapping("/hdr")
    public ResponseService insertHdr(@RequestBody PeticionCore peticion) {
        Map<String,Boolean> result=new HashMap<>();
        boolean r=core.insertaCoreHdr(peticion.getPaquete(), peticion.getUsuario(), peticion.getCarrier());
        result.put("insert",r);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), result);
    }
    @PutMapping("/hdr")
    public ResponseService updateHdr(@RequestBody PeticionCore peticion) {
        Map<String,Boolean> result=new HashMap<>();
        boolean r=core.actualizaCoreHdr(peticion.getPaquete(), peticion.getUsuario(), peticion.getCarrier(), 0);
        result.put("update",r);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), result);
    }
    @PostMapping("/dtl")
    public ResponseService insertDtl(@RequestBody PeticionCore peticion) {
        Map<String,Boolean> result=new HashMap<>();
        boolean r=core.insertaCoreDtl(peticion.getPaquete(), peticion.getUsuario(), peticion.getCarrier(), peticion.getRegla());
        result.put("insert",r);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), result);
    }
    
    @PutMapping("/dtl")
    public ResponseService updateDtl(@RequestBody PeticionCore peticion) {
        Map<String,Boolean> result=new HashMap<>();
        boolean r=core.actualizaCoreDtl(peticion.getPaquete(), peticion.getCarrier(), peticion.getRegla(), peticion.getResultadoEvaluacion());
        result.put("update",r);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), result);
    }
    @PutMapping("/dtl/eval")
    public ResponseService updateDtlEval(@RequestBody PeticionCore peticion) {
        Map<String,Boolean> result=new HashMap<>();
        boolean r=core.actualizaCoreDtlEval(peticion.getPaquete(), peticion.getCarriers(), peticion.getRegla(), peticion.getValid(), peticion.getUsuario());
        result.put("update",r);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), result);
    }
    
    @GetMapping("/ejecucion/entrega/{entrega}/centro/{centro}")
    public ResponseService validateExecutions(@PathVariable String entrega, @PathVariable String centro) {
        Map<String,Boolean> result=new HashMap<>();
        Paquete paquete = new Paquete();
        paquete.setIdManh(Integer.valueOf(centro));
        paquete.setPedido(entrega);
        boolean r=core.existeEjecucionpPrevia(paquete);
        result.put("exist",r);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), result);
    }
    
    @PutMapping("/ejecucion/entrega/{entrega}/centro/{centro}")
    public ResponseService clearExecutions(@PathVariable String entrega, @PathVariable String centro) {
        Map<String,Boolean> result=new HashMap<>();
        Paquete paquete = new Paquete();
        paquete.setIdManh(Integer.valueOf(centro));
        paquete.setPedido(entrega);
        boolean r=core.limpiaEjecucionpPrevia(paquete);
        result.put("delete",r);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), result);
    }
    
    @GetMapping("/entrega/{entrega}/centro/{centro}")
    public ResponseService getInfoShipment(@PathVariable String entrega, @PathVariable String centro) {
        PeticionCore peticion = new PeticionCore();
        Paquete p=new Paquete();
        p.setIdManh(Integer.valueOf(centro));
        p.setPedido(entrega);
        peticion.setPaquete(p);
        Paquete paquete = core.getPaquete(peticion);
        if(paquete!=null)
            return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), paquete);
        else
            return new ResponseService(CodigosResponseCommon.CODIGO_404, folioCommon.getFolio(), null);
    }
    
    @GetMapping("/proveedores")
    public ResponseService getCouriers() {
        List<CarrierQB> carrier = core.getProveedores();
        
        if(carrier!=null && !carrier.isEmpty())
            return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), carrier);
        else
            return new ResponseService(CodigosResponseCommon.CODIGO_404, folioCommon.getFolio(), carrier);
    }
    
    @GetMapping("/proveedores/{entrega}/centro/{centro}")
    public ResponseService getCouriersHdr(@PathVariable String entrega, @PathVariable String centro, 
            @RequestParam String folio) {
        Paquete paquete = new Paquete();
        paquete.setIdManh(Integer.valueOf(centro));
        paquete.setFolio(folio);
        paquete.setPedido(entrega);
        List<CarrierQB> carrier = core.getProveedores(paquete, 0);
        if(carrier!=null && !carrier.isEmpty())
            return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), carrier);
        else
            return new ResponseService(CodigosResponseCommon.CODIGO_404, folioCommon.getFolio(), carrier);
    }
    /*
    @GetMapping("/proveedores/evaluacion/{regla}/entrega/{entrega}/centro/{centro}")
    public ResponseService getCouriersEval(@PathVariable String regla, @PathVariable String entrega, 
            @PathVariable String centro, @RequestParam String folio) {
        Paquete paquete=new Paquete();
        paquete.setIdManh(Integer.valueOf(centro));
        paquete.setFolio(folio);
        paquete.setPedido(entrega);
        List<CarrierQB> carrier = core.getProveedoresEvaluados(paquete, Integer.valueOf(regla));
        if(carrier!=null && !carrier.isEmpty())
            return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), carrier);
        else
            return new ResponseService(CodigosResponseCommon.CODIGO_404, folioCommon.getFolio(), carrier);
    }
    */
    @GetMapping("/proveedores/evaluacion/{regla}/entrega/{entrega}/centro/{centro}/condicional")
    public ResponseService getCouriersCondition(@PathVariable String regla, @PathVariable String entrega, 
            @PathVariable String centro, @RequestParam String folio) {
        Paquete paquete=new Paquete();
        paquete.setIdManh(Integer.valueOf(centro));
        paquete.setFolio(folio);
        paquete.setPedido(entrega);
        List<CarrierQB> carrier = core.getProveedoresCondicion(paquete, Integer.valueOf(regla));
        if(carrier!=null && !carrier.isEmpty())
            return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), carrier);
        else
            return new ResponseService(CodigosResponseCommon.CODIGO_404, folioCommon.getFolio(), carrier);
    }
    
    @GetMapping("/proveedores/evaluacion/{regla}/entrega/{entrega}/centro/{centro}/menor")
    public ResponseService getCouriersLess(@PathVariable String regla, @PathVariable String entrega, 
            @PathVariable String centro, @RequestParam String folio) {
        Paquete paquete=new Paquete();
        paquete.setIdManh(Integer.valueOf(centro));
        paquete.setFolio(folio);
        paquete.setPedido(entrega);
        List<CarrierQB> carrier = core.getProveedoresMenorValor(paquete, Integer.valueOf(regla));
        if(carrier!=null && !carrier.isEmpty())
            return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), carrier);
        else
            return new ResponseService(CodigosResponseCommon.CODIGO_404, folioCommon.getFolio(), carrier);
    }
    
    @GetMapping("/proveedores/evaluacion/{regla}/entrega/{entrega}/centro/{centro}/mayor")
    public ResponseService getCouriersMax(@PathVariable String regla, @PathVariable String entrega, 
            @PathVariable String centro, @RequestParam String folio) {
        Paquete paquete=new Paquete();
        paquete.setIdManh(Integer.valueOf(centro));
        paquete.setFolio(folio);
        paquete.setPedido(entrega);
        List<CarrierQB> carrier = core.getProveedoresMayorValor(paquete, Integer.valueOf(regla));
        if(carrier!=null && !carrier.isEmpty())
            return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), carrier);
        else
            return new ResponseService(CodigosResponseCommon.CODIGO_404, folioCommon.getFolio(), carrier);
    }
    
    @GetMapping("/proveedores/{regla}/entrega/{entrega}/centro/{centro}")
    public ResponseService getCouriersIteration(@PathVariable String regla, @PathVariable String entrega, 
            @PathVariable String centro, @RequestParam String folio) {
        Paquete paquete=new Paquete();
        paquete.setIdManh(Integer.valueOf(centro));
        paquete.setFolio(folio);
        paquete.setPedido(entrega);
        List<CarrierQB> carrier = core.getProveedores(paquete, Integer.valueOf(regla));
        if(carrier!=null && !carrier.isEmpty())
            return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), carrier);
        else
            return new ResponseService(CodigosResponseCommon.CODIGO_404, folioCommon.getFolio(), carrier);
    }
    
    @GetMapping("/reglas")
    public ResponseService getRules() {
        List<Regla> reglas=core.getReglasCore();
        if(reglas!=null && !reglas.isEmpty())
            return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), reglas);
        else
            return new ResponseService(CodigosResponseCommon.CODIGO_404, folioCommon.getFolio(), reglas);
    }
    
    @GetMapping("/reglas/tarifa/{carrier}")
    public ResponseService getInfoTarifa(@RequestParam String origen, @RequestParam String destino, 
            @PathVariable String carrier, @RequestParam String peso) {
        Tarifa t= core.getInfoTarifa(origen, destino, carrier, peso);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), t);
    }
    
    @GetMapping("/reglas/ei/{carrier}")
    public ResponseService getExcInc(@PathVariable String carrier, @RequestParam String[] clasf) {
        ExclusionOInclusion ei = core.getExcInc(carrier, Arrays.asList(clasf));
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), ei);
    }
    
    @GetMapping("/reglas/rating/{carrier}")
    public ResponseService getRating(@PathVariable String carrier) {
        Integer rating = core.getRating(carrier);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), rating);
    }
    
    @GetMapping("/reglas/capacidad/{carrier}")
    public ResponseService getAsig(@PathVariable String carrier) {
        Integer asig = core.getAsignacionCarrier(carrier);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), asig);
    }
    
    @GetMapping("/reglas/capacidad/{carrier}/actual")
    public ResponseService getCurrentAsig(@PathVariable String carrier) {
        Integer asig = core.getAsignacionActual(carrier);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), asig);
    }
    
    @PutMapping("/antrega")
    public ResponseService updtDelivery(@RequestBody PeticionCore peticion){
        Map<String,Boolean> result=new HashMap<>();
        boolean r=core.actualizaProveedorPedido(peticion.getPaquete(),String.valueOf(peticion.getCarrier().getIdCarrier()),null);
        result.put("update",r);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), result);
    }
}
