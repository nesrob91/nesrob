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
public class ResultadoEvaluacion {
    private double cantidad;
    private double tarifaBase;
    private double tarifaFinal;
    private String mensaje;
    private boolean procesado;
    private boolean valido;
    private boolean nulo;

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public double getTarifaFinal() {
        return tarifaFinal;
    }

    public void setTarifaFinal(double tarifaFinal) {
        this.tarifaFinal = tarifaFinal;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isProcesado() {
        return procesado;
    }

    public void setProcesado(boolean procesado) {
        this.procesado = procesado;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public boolean isNulo() {
        return nulo;
    }

    public void setNulo(boolean nulo) {
        this.nulo = nulo;
    }
    
}
