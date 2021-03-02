/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.beans;

/**
 *
 * @author dparra / eaceves
 */
public class TrackingResponse {
    
    private int idEstatusGuia;
    private String idEstatusGuiaCarrier;
    private String refField1;
    private String refField3;
    private String recibe;
    private String fechaRecepcion;
    private String fechaRecoleccion;
    private String input;
    private String output;
    
    public int getIdEstatusGuia() {
        return idEstatusGuia;
    }

    public void setIdEstatusGuia(int idEstatusGuia) {
        this.idEstatusGuia = idEstatusGuia;
    }

    public String getIdEstatusGuiaCarrier() {
        return idEstatusGuiaCarrier;
    }

    public void setIdEstatusGuiaCarrier(String idEstatusGuiaCarrier) {
        this.idEstatusGuiaCarrier = idEstatusGuiaCarrier;
    }

    public String getRefField1() {
        return refField1;
    }

    public void setRefField1(String refField1) {
        this.refField1 = refField1;
    }

	public String getRecibe() {
		return recibe;
	}

	public void setRecibe(String recibe) {
		this.recibe = recibe;
	}

	public String getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(String fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getRefField3() {
		return refField3;
	}

	public void setRefField3(String refField3) {
		this.refField3 = refField3;
	}

	public String getFechaRecoleccion() {
		return fechaRecoleccion;
	}

	public void setFechaRecoleccion(String fechaRecoleccion) {
		this.fechaRecoleccion = fechaRecoleccion;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}
        	
}
