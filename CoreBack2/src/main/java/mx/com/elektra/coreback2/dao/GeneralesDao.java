/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.dao;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.util.List;
import java.util.Map;
import mx.com.elektra.coreback2.beans.CajaRf;
import mx.com.elektra.coreback2.beans.CarrierQB;
import mx.com.elektra.coreback2.beans.Contenido;
import mx.com.elektra.coreback2.beans.DetalleSkus;
import mx.com.elektra.coreback2.beans.DimensionesQB;
import mx.com.elektra.coreback2.beans.FamiliaSap;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Pedido;
import mx.com.elektra.coreback2.beans.Regla;
import mx.com.elektra.coreback2.beans.ResultadoEvaluacion;
/**
 *
 * @author dparra
 */
public interface GeneralesDao {
    
    
    public String getEsquema(int idManh);
    
    public boolean isCajaExistente(int idManh, String idLpn);
    
    public int getIdCajaByLpn(int idManh, String idLpn);
    
    public boolean isLpnDifCantInicialVSEmpacado(int idManh, String idLpn, String esquema);

    public DimensionesQB getDimensionesLpnEvaluado(int idManh, String idLpn);
            
    public DimensionesQB getDimensionesPaquete2018Rf(int idManh, int idCaja, int idTipoPedido);
    
    
    
    public DimensionesQB getDimensionesPaqueteMKP(int idManh, int idCaja, String esquema, int tipPed);
    
    public Pedido getPedidoEpi(String idLpn, String esquema);
    public List<Map<String,Object>> getPedidoMKP(List<String> adn, int idVendor, int idTipoPedido);
    public List<Map<String,Object>> getPedidoDSV(List<String> adn, int idVendor, int idTipoPedido);
    
    public List<Map<String,String>> getLpnsByAdn(List<String> adn, String esquema);
    public List<Map<String,Object>> getVtexByAdnsOrLpns(List<String> adn, List<String> lpn, String esquema);
    
    public int getIdTipoPedidoByOrderType(String orderType);
    
    public List<Regla> getReglas(int idCanal, int tipoPedido);
    
    public double getCostoSku(String sku);
    
    public FamiliaSap getFamiliaSap(String matkl);
    
    public int getIdCaja();

    //public boolean insertaContenidoCajaEcom(String pedido, int idCaja, int idManh, int idCanal, int idTipoPedido);
    
    //public Paquete getPaquete(Paquete paquete);
    
    public CarrierQB getMejorCarrierPostCalculo(int idManh, String idLpn);

    public List<CarrierQB> getCarriersActivos(int idCanal, int tipoPedido);
    
    public List<CarrierQB> getCarriersPrimeraIteracion(Paquete paquete);
    
    public List<CarrierQB> getCarriersSiguienteIteracion(Paquete paquete, int idRegla);
    
    //public List<DetalleSkus> getDetalleSkus(Paquete paquete);
    
    public boolean insertaCbHder2018(Paquete paquete, String usuario, CarrierQB carrierQB);
    
    //public boolean insertaCbHder(Paquete paquete, String usuario);
    
    public boolean actualizaCbDtl(Paquete paquete, Regla regla, CarrierQB carrier, ResultadoEvaluacion resultadoEvaluacion);
    
    public boolean actualizaCbHdr(Paquete paquete, CarrierQB carrier, String usuario, double tarifa);
        
    public boolean insertaCbDtl(Paquete paquete, CarrierQB carrier, Regla regla, String usuario);
    
    public boolean insertaCajaHdr(int idUsuario, int idCaja, int idManh, String pedido, int idCanal, int idTipPed, int idContainer, double peso);
    
    public boolean insertaCajaDtl(int idCaja, String idLpn);
    
    public int getIdContainer(double lenght, double width, double height, double weight, int idVendor, int idTipPed, boolean newFlg) ;
    public int createContainer(double lenght, double width, double height, double weight, int idVendor, int idTipPed, int idUsuario) ;
    
    public List<Integer> getCdsOfLpns(Paquete paquete);
    
    
    //public DimensionesQB getDimensionesPaqueteDSV(int idManh, int idCaja, String esquema, int tipPed);
}
