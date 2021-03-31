/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palex.beans;

import java.util.List;
import palex.beans.Destino;
import palex.beans.Detalle;
import palex.beans.Opciones;
import palex.beans.Origen;
import palex.beans.Servicios;

/**
 *
 * @author DPARRA
 */
public class GuiasPalexRequest {
    
    int Cuenta;
    Opciones opciones;
    String Referencia1;
    String Referencia2;
    String Contiene;
    Origen origen;
    Destino destino;
    List<Detalle> detalle;
    List<Servicios> servicios;

    public int getCuenta() {
        return Cuenta;
    }

    public void setCuenta(int Cuenta) {
        this.Cuenta = Cuenta;
    }

    public Opciones getOpciones() {
        return opciones;
    }

    public void setOpciones(Opciones opciones) {
        this.opciones = opciones;
    }

    public String getReferencia1() {
        return Referencia1;
    }

    public void setReferencia1(String Referencia1) {
        this.Referencia1 = Referencia1;
    }

    public String getReferencia2() {
        return Referencia2;
    }

    public void setReferencia2(String Referencia2) {
        this.Referencia2 = Referencia2;
    }

    public String getContiene() {
        return Contiene;
    }

    public void setContiene(String Contiene) {
        this.Contiene = Contiene;
    }

    public Origen getOrigen() {
        return origen;
    }

    public void setOrigen(Origen origen) {
        this.origen = origen;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public List<Detalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Detalle> detalle) {
        this.detalle = detalle;
    }

    public List<Servicios> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicios> servicios) {
        this.servicios = servicios;
    }
    
    
}
