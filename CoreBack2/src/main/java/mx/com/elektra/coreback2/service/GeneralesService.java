/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service;

import java.util.List;
import mx.com.elektra.coreback2.beans.CarrierQB;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DetalleSkus;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Pedido;
import mx.com.elektra.coreback2.beans.Regla;
import mx.com.elektra.coreback2.beans.ResultadoEvaluacion;

/**
 *
 * @author dparra
 */
public interface GeneralesService {
    
    
    
    public String getEsquema(int idManh);
    
    public boolean isLpnModificado(DimensionesQB lpnPrimeraEvaluacion, DimensionesQB lpnSegundaEvaluacion);
    
    public boolean isLpnDifCantInicialVSEmpacado(int idManh, String idLpn, String esquema);
    
    public DimensionesQB getDimensionesLpnEvaluado(int idManh, String idLpn);
    
    
    public Pedido getPedidoEpi(String idLpn, String esquema);
    public Pedido getPedidoMKP(List<String> adn, int idVendor, int idTipoPedido);
    public Pedido getPedidoDSV(List<String> adn, int idVendor, int idTipoPedido);
    
    public int getIdTipoPedidoByOrderType(String orderType);
    
    public List<Regla> getReglas(int idCanal, int tipoPedido);
    
    public int getIdCaja(int idUsuario, String pedido, List<String> idLpn, int idManh, int idCanal, int idTipPed, int idContainer, double peso);
    
    public Paquete getPaquete(Paquete paquete, int idTipoPeticion, String esquema);
    
    public CarrierQB getMejorCarrierPostCalculo(int idManh, String idLpn);
    
    public List<CarrierQB> getCarriersActivos(Paquete paquete, List <CarrierQB> carriersActuales, int iteracion, int idRegla);
    
    public boolean insertaCbDtl(Paquete paquete, CarrierQB carrier, Regla regla, String usuario);
    
    public boolean actualizaCbDtl(Paquete paquete, Regla regla, CarrierQB carrier, ResultadoEvaluacion resultadoEvaluacion);
    
    public boolean actualizaCbHdr(Paquete paquete, CarrierQB carrier, String usuario, double tarifa);
    
    public boolean isPaqueteProcesado(Pedido pedido);
    
    public int createContainer(double lenght, double width, double height, double weight, int idVendor, int  idTipPed, int idUsuario);

    public List<Integer> getCdsOfLpns(Paquete paquete);
    
}
