/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.beans;

/**
 *
 * @author dparra
 */
public class DatosTracking {
    
    String pedido;
    String orderId;
    int cdId;
    int idCarrier;
    String numGuia;
    String ref_field_2;
    int idCaja;

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

    public int getCdId() {
        return cdId;
    }

    public void setCdId(int cdId) {
        this.cdId = cdId;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public String getNumGuia() {
        return numGuia;
    }

    public void setNumGuia(String numGuia) {
        this.numGuia = numGuia;
    }

	public String getRef_field_2() {
		return ref_field_2;
	}

	public void setRef_field_2(String ref_field_2) {
		this.ref_field_2 = ref_field_2;
	}

	public int getIdCaja() {
		return idCaja;
	}

	public void setIdCaja(int idCaja) {
		this.idCaja = idCaja;
	}
        
}
