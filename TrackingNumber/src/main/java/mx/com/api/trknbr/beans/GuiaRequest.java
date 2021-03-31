/* * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates 
 * and open the template in the editor. 
 */
package mx.com.api.trknbr.beans;

import java.util.List;


/**
 * * * @author dparra
 */
public class GuiaRequest {

    private String vtex;
    private String pedido;
    private String orderId;
    private int idManh;
    private int idCarrier;
    private double largo;
    private double ancho;
    private double alto;
    private double peso;
    private Contacto origen;
    private Contacto destino;
    private String pais1;
    private String pais2;
    private String pais3;
    private String grupo;
    private String remesa;
    private int idCaja;
    private String idLpn;
    private int idCanal;
    private int idTipoPedido;
    private List<DetalleSkus> skus;
    private boolean seguro;
    private String costoAsegurado;
    
    private String ubicacion;
    private String observaciones;
    private int idEstacion;

    public String getVtex() {
        return vtex;
    }

    public void setVtex(String vtex) {
        this.vtex = vtex;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getIdManh() {
        return idManh;
    }

    public void setIdManh(int idManh) {
        this.idManh = idManh;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Contacto getOrigen() {
        return origen;
    }

    public void setOrigen(Contacto origen) {
        this.origen = origen;
    }

    public Contacto getDestino() {
        return destino;
    }

    public void setDestino(Contacto destino) {
        this.destino = destino;
    }

    public String getPais1() {
        return pais1;
    }

    public void setPais1(String pais1) {
        this.pais1 = pais1;
    }

    public String getPais2() {
        return pais2;
    }

    public void setPais2(String pais2) {
        this.pais2 = pais2;
    }

    public String getPais3() {
        return pais3;
    }

    public void setPais3(String pais3) {
        this.pais3 = pais3;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getRemesa() {
        return remesa;
    }

    public void setRemesa(String remesa) {
        this.remesa = remesa;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
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

    public String getIdLpn() {
        return idLpn;
    }

    public void setIdLpn(String idLpn) {
        this.idLpn = idLpn;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public String getCostoAsegurado() {
        return costoAsegurado;
    }

    public void setCostoAsegurado(String costoAsegurado) {
        this.costoAsegurado = costoAsegurado;
    }

    public int getIdEstacion() {
        return idEstacion;
    }

    public void setIdEstacion(int idEstacion) {
        this.idEstacion = idEstacion;
    }
    
}
