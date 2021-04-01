/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.beans;

/**
 *
 * @author dparra
 */
public class Contenido {
    
    private int cantidad;
    private String sku;
    private String idLpn;
    private String orderId;
    private String adn;
    private String so;
    private String nc;
    private String idManh;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getIdLpn() {
        return idLpn;
    }

    public void setIdLpn(String idLpn) {
        this.idLpn = idLpn;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAdn() {
        return adn;
    }

    public void setAdn(String adn) {
        this.adn = adn;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public String getNc() {
        return nc;
    }

    public void setNc(String nc) {
        this.nc = nc;
    }

    public String getIdManh() {
        return idManh;
    }

    public void setIdManh(String idManh) {
        this.idManh = idManh;
    }
    
}
