/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.beans;

import java.util.List;
import java.util.Map;

/**
 *
 * @author dparra
 */
public class Paquete {
    private int idManh;
    private String pedido;
    private int idCaja;
    private String cpOrigen;
    private String cpDestino;
    private double pesoFisico;
    private double pesoVolumetrico;
    private double peso;
    private double largo;
    private double ancho;
    private double alto;
    private double volumen;
    private int idCanal;
    private int idTipoPedido;
    private List<DetalleSkus> skus;
    private String pedidoAlterno;
    private double costoTotal;
    private String idLpn;
    private List<String> lpns;
    private List<String> adns;
    private String error;
    Map<Integer, Tarifa> tarifas;
    private String folio;
    
    public int getIdManh() {
        return idManh;
    }

    public void setIdManh(int idManh) {
        this.idManh = idManh;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public String getCpOrigen() {
        return cpOrigen;
    }

    public void setCpOrigen(String cpOrigen) {
        this.cpOrigen = cpOrigen;
    }

    public String getCpDestino() {
        return cpDestino;
    }

    public void setCpDestino(String cpDestino) {
        this.cpDestino = cpDestino;
    }

    public double getPesoFisico() {
        return pesoFisico;
    }

    public void setPesoFisico(double pesoFisico) {
        this.pesoFisico = pesoFisico;
    }

    public double getPesoVolumetrico() {
        return pesoVolumetrico;
    }

    public void setPesoVolumetrico(double pesoVolumetrico) {
        this.pesoVolumetrico = pesoVolumetrico;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public int getIdCanal() {
        return idCanal;
    }

    public void setIdCanal(int idCanal) {
        this.idCanal = idCanal;
    }

    public int getIdTipoPedido() {
        return idTipoPedido;
    }

    public void setIdTipoPedido(int idTipoPedido) {
        this.idTipoPedido = idTipoPedido;
    }

    public List<DetalleSkus> getSkus() {
        return skus;
    }

    public void setSkus(List<DetalleSkus> skus) {
        this.skus = skus;
    }

    public String getPedidoAlterno() {
        return pedidoAlterno;
    }

    public void setPedidoAlterno(String pedidoAlterno) {
        this.pedidoAlterno = pedidoAlterno;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getIdLpn() {
        return idLpn;
    }

    public void setIdLpn(String idLpn) {
        this.idLpn = idLpn;
    }

    public List<String> getLpns() {
        return lpns;
    }

    public void setLpns(List<String> lpns) {
        this.lpns = lpns;
    }

    public List<String> getAdns() {
        return adns;
    }

    public void setAdns(List<String> adns) {
        this.adns = adns;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<Integer, Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(Map<Integer, Tarifa> tarifas) {
        this.tarifas = tarifas;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
    
}
