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
public class CajaRf {
    
    private double largo;
    private double ancho;
    private double alto;
    private boolean empaquePropio;
    private int idTipoCaja;

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

    public boolean isEmpaquePropio() {
        return empaquePropio;
    }

    public void setEmpaquePropio(boolean empaquePropio) {
        this.empaquePropio = empaquePropio;
    }

    public int getIdTipoCaja() {
        return idTipoCaja;
    }

    public void setIdTipoCaja(int idTipoCaja) {
        this.idTipoCaja = idTipoCaja;
    }
    
    
    
}
