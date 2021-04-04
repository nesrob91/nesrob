/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.service;

import java.util.List;
import mx.com.elektra.mso.cb.model.CarrierQB;
import mx.com.elektra.mso.cb.model.DimensionesQB;
import mx.com.elektra.mso.cb.model.Paquete;
import mx.com.elektra.mso.cb.model.Pedido;
import mx.com.elektra.mso.cb.model.Regla;
import mx.com.elektra.mso.cb.model.ResultadoEvaluacion;

/**
 *
 * @author dparra
 */
public interface GeneralesService {
    public String getEsquema(int idManh);
    
    public Paquete getPaquete(Paquete paquete, int idTipoPeticion, String esquema);
    
    public boolean isLpnModificado(DimensionesQB lpnPrimeraEvaluacion, DimensionesQB lpnSegundaEvaluacion);
    
    public boolean isLpnDifCantInicialVSEmpacado(int idManh, String idLpn, String esquema);
    
    public DimensionesQB getDimensionesLpnEvaluado(int idManh, String idLpn);
    
    
    public int getIdTipoPedidoByOrderType(String orderType);
    
    public List<Regla> getReglas(int idCanal, int tipoPedido);
    
    
    public CarrierQB getMejorCarrierPostCalculo(int idManh, String idLpn);
    
    public List<CarrierQB> getCarriersActivos(Paquete paquete, List <CarrierQB> carriersActuales, int iteracion, int idRegla);
    
    public boolean insertaCbDtl(Paquete paquete, CarrierQB carrier, Regla regla, String usuario);
    
    public boolean actualizaCbDtl(Paquete paquete, Regla regla, CarrierQB carrier, ResultadoEvaluacion resultadoEvaluacion);
    
    public boolean actualizaCbHdr(Paquete paquete, CarrierQB carrier, String usuario, double tarifa);
    
    public boolean isPaqueteProcesado(Pedido pedido);
    
    public List<Integer> getCdsOfLpns(Paquete paquete);
    
}
