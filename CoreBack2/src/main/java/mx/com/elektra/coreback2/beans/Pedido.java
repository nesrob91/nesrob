/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.beans;

import java.util.List;

/**
 *
 * @author dparra
 */
public class Pedido {
    
    private String pedido; 
    private int idCaja; 
    private int idManh; 
    private int idCanal; 
    private int idTipoPedido;
    private String orderType;
    private String idLpn;
    private List<String> lpns;

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

    public int getIdManh() {
        return idManh;
    }

    public void setIdManh(int idManh) {
        this.idManh = idManh;
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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
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
    
    
}
