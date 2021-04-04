/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.msd.qb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mx.com.elektra.msd.qb.dao.DepuradorDao;
import mx.com.elektra.msd.qb.dao.EvaluacionDao;
import mx.com.elektra.msd.qb.dao.GeneralesDao;
import mx.com.elektra.msd.qb.dao.MarcadorDePedidoDao;
import mx.com.elektra.msd.qb.dao.ReglasDao;
import mx.com.elektra.msd.qb.dao.TipoDePedidoDao;
import mx.com.elektra.msd.qb.model.CarrierQB;
import mx.com.elektra.msd.qb.model.DetalleSkus;
import mx.com.elektra.msd.qb.model.ExclusionOInclusion;
import mx.com.elektra.msd.qb.model.Paquete;
import mx.com.elektra.msd.qb.model.PeticionCore;
import mx.com.elektra.msd.qb.model.Regla;
import mx.com.elektra.msd.qb.model.ResultadoEvaluacion;
import mx.com.elektra.msd.qb.model.Sku;
import mx.com.elektra.msd.qb.model.Tarifa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nroblerol
 */
@Service
public class CorebackUm {
    
    @Autowired
    private GeneralesDao generalesDaoUm;
    @Autowired
    private DepuradorDao depuradorDaoUm;
    @Autowired
    private EvaluacionDao evaluacionDaoUm;
    @Autowired
    private MarcadorDePedidoDao marcadorPedidoDaoUm;
    @Autowired
    private ReglasDao reglasDaoUm;
    @Autowired
    private TipoDePedidoDao pedidoUmDao;
    
    public boolean existeEjecucionpPrevia(Paquete paquete){
        boolean isPrev=depuradorDaoUm.countCbHdr(paquete)>0;
        return isPrev;
    }
    
    public boolean limpiaEjecucionpPrevia(Paquete paquete){
        boolean clean=depuradorDaoUm.eliminaCbHdr(paquete);
        return clean;
    }
    
    public boolean insertaCoreHdr(Paquete paquete, String usuario, CarrierQB carrierQB){
        boolean insert=generalesDaoUm.insertaCbHder2018(paquete, usuario, carrierQB);
        return insert;
    }
    
    public boolean actualizaCoreHdr(Paquete paquete, String usuario, CarrierQB carrier, double tarifa){
        boolean update=generalesDaoUm.actualizaCbHdr(paquete, carrier, usuario, tarifa);
        return update;
    }
    
    public boolean insertaCoreDtl(Paquete paquete, String usuario, CarrierQB carrier, Regla regla){
        boolean insert=generalesDaoUm.insertaCbDtl(paquete, carrier, regla, usuario);
        return insert;
    }
    
    public boolean actualizaCoreDtl(Paquete paquete, CarrierQB carrier, Regla regla, ResultadoEvaluacion resultadoEvaluacion){
        boolean update=generalesDaoUm.actualizaCbDtl(paquete, regla, carrier, resultadoEvaluacion);
        return update;
    }
    
    public boolean actualizaCoreDtlEval(Paquete paquete, List<Integer> idCarriers, Regla regla, int valid, String usuario){
        boolean update=evaluacionDaoUm.actualizaCarriers(paquete, regla, idCarriers, valid, usuario);
        return update;
    }
    
    public Paquete getPaquete(PeticionCore peticion){
        List<Map<String,Object>> lp=pedidoUmDao.getPaquete(peticion.getPaquete().getPedido(), peticion.getPaquete().getIdManh(), "", 0, 0, "");
        Paquete paquete=null;
        if(lp!=null && !lp.isEmpty()){
            try{
                paquete=new Paquete();
                List<DetalleSkus> dt=new ArrayList<>();
                Iterator<Map<String,Object>> p = lp.iterator();
                Double peso=0.0;
                p.forEachRemaining((i)->{
                    DetalleSkus d=new DetalleSkus();
                    Sku sku=new Sku();
                    d.setCantidad(Integer.valueOf(i.get("CANTIDAD").toString()));
                    sku.setAlto(Double.valueOf(i.get("ALTO").toString()));
                    sku.setLargo(Double.valueOf(i.get("LARGO").toString()));
                    sku.setAncho(Double.valueOf(i.get("ANCHO").toString()));
                    sku.setPeso(Double.valueOf(i.get("PESO").toString()));
                    sku.setIdClase("");
                    sku.setIdDepartamento("");
                    sku.setIdSubclase("");
                    sku.setIdSubdepartamento("");
                    sku.setIdSku(i.get("ID_SKU").toString());
                    sku.setDescClase("");
                    sku.setDescDepartamento("");
                    sku.setDescSku("");
                    sku.setDescSubclase("");
                    sku.setDescSubdepartamento("");
                    sku.setCostoUnitario(0);
                    d.setSku(sku);
                    dt.add(d);
                    peso.sum(peso, sku.getPeso());
                });
                paquete.setSkus(dt);
                paquete.setAlto(0);
                paquete.setAlto(0);
                paquete.setAlto(0);
                paquete.setPeso(peso);
                paquete.setCostoTotal(0);
                paquete.setVolumen(0);
                paquete.setPedido(peticion.getPaquete().getPedido());
                paquete.setPedidoAlterno(lp.get(0).get("FIPEDIDOID").toString());
                paquete.setCpDestino(lp.get(0).get("FICODPOSTAL").toString());
                paquete.setCpOrigen(lp.get(0).get("FCCODPOSTAL").toString());
                paquete.setIdManh(peticion.getPaquete().getIdManh());
                paquete.setTarifas(new HashMap<>());
                paquete.setError("");
            }catch(Exception e){
                
            }
        }
        return paquete;
    }
    
    public List<CarrierQB> getProveedores(){
        List<CarrierQB> carrier = generalesDaoUm.getCarriersActivos(0, 0);
        
        return carrier;
    }
    
    public List<CarrierQB> getProveedoresEvaluados(Paquete paquete, int regla){
        Regla r=new Regla();
        r.setIdRegla(regla);
        List<Integer> carrier = evaluacionDaoUm.getIdCarriersByRegla(paquete, r);
        List<CarrierQB> carriers = new ArrayList<>();
        carrier.forEach((i) -> {
            CarrierQB c=new CarrierQB();
            c.setIdCarrier(i);
        });
        return carriers;
    }
    
    public List<CarrierQB> getProveedoresCondicion(Paquete paquete, int regla){
        Regla r=new Regla();
        r.setIdRegla(regla);
        List<Integer> carrier = evaluacionDaoUm.getIdCarriersCumplenCondicion(paquete, r);
        List<CarrierQB> carriers = new ArrayList<>();
        carrier.forEach((i) -> {
            CarrierQB c=new CarrierQB();
            c.setIdCarrier(i);
            carriers.add(c);
        });
        
        return carriers;
    }
    
    public List<CarrierQB> getProveedoresMenorValor(Paquete paquete, int regla){
        Regla r=new Regla();
        r.setIdRegla(regla);
        List<Integer> carrier = evaluacionDaoUm.getIdCarriersMenorValor(paquete, r);
        List<CarrierQB> carriers = new ArrayList<>();
        carrier.forEach((i) -> {
            CarrierQB c=new CarrierQB();
            c.setIdCarrier(i);
            carriers.add(c);
        });
        return carriers;
    }
    
    public List<CarrierQB> getProveedoresMayorValor(Paquete paquete, int regla){
        Regla r=new Regla();
        r.setIdRegla(regla);
        List<Integer> carrier = evaluacionDaoUm.getIdCarriersMayorValor(paquete, r);
        List<CarrierQB> carriers = new ArrayList<>();
        carrier.forEach((i) -> {
            CarrierQB c=new CarrierQB();
            c.setIdCarrier(i);
            carriers.add(c);
        });
        return carriers;
    }
    
    public List<CarrierQB> getProveedores(Paquete paquete, int regla){
        List<CarrierQB> carrier = null;
        if(regla==0)
            carrier = generalesDaoUm.getCarriersPrimeraIteracion(paquete);
        else
            carrier = generalesDaoUm.getCarriersSiguienteIteracion(paquete,regla);
        return carrier;
    }
    
    public List<Regla> getReglasCore(){
        List<Regla> reglas = generalesDaoUm.getReglas(0, 0);
        
        return reglas;
    }
    
    public Tarifa getInfoTarifa(String origen, String destino, String carrier, String peso){
        Paquete paquete=new Paquete();
        paquete.setCpOrigen(origen);
        paquete.setCpDestino(destino);
        paquete.setPeso(Double.valueOf(peso));
        Tarifa t = reglasDaoUm.getTarifaInfo(paquete, Integer.valueOf(carrier));
        if(t == null ){
            t=new Tarifa();
            t.setTarifa(-1);
            t.setTarifaFinal(-1);
        }
        return t;
    }
    
    public ExclusionOInclusion getExcInc(String carrier, List<String> clasf){
        ExclusionOInclusion ei = reglasDaoUm.getExclusionesEInclusiones(null, null, Integer.valueOf(carrier), "E", clasf);
        return ei;
    }
    
    public Integer getRating(String carrier){
        Integer rating = reglasDaoUm.getRatingCarrier(null, Integer.valueOf(carrier));
        return rating;
    }
    
    public Integer getAsignacionActual(String carrier){
        Integer asig = reglasDaoUm.getCapacidadPorCarrier(null, Integer.valueOf(carrier));
        return asig;
    }
    
    public Integer getAsignacionCarrier(String carrier){
        Integer asig = reglasDaoUm.getCantidadGuiasPorCarrier(null, Integer.valueOf(carrier));
        return asig;
    }
    
    public boolean actualizaProveedorPedido(Paquete paquete, String carrier, List<String> adns){
        return marcadorPedidoDaoUm.actualizaPedCentPedidoEcom(paquete, carrier, null);
    }
}
