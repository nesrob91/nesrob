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
public class Tarifa {
    private double tarifa;
    private String tipoTransporte;
    private String cpOrigen;
    private String cpDestino;
    private double pesoMinimo;
    private double pesoMaximo;
    private double costoPesoExtra;
    private boolean seguro;
    private double pesoExtra;
    private double costoExtra;
    private double tarifaFinal;

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
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

    public double getPesoMinimo() {
        return pesoMinimo;
    }

    public void setPesoMinimo(double pesoMinimo) {
        this.pesoMinimo = pesoMinimo;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public double getCostoPesoExtra() {
        return costoPesoExtra;
    }

    public void setCostoPesoExtra(double costoPesoExtra) {
        this.costoPesoExtra = costoPesoExtra;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public double getPesoExtra() {
        return pesoExtra;
    }

    public void setPesoExtra(double pesoExtra) {
        this.pesoExtra = pesoExtra;
    }

    public double getCostoExtra() {
        return costoExtra;
    }

    public void setCostoExtra(double costoExtra) {
        this.costoExtra = costoExtra;
    }

    public double getTarifaFinal() {
        return tarifaFinal;
    }

    public void setTarifaFinal(double tarifaFinal) {
        this.tarifaFinal = tarifaFinal;
    }

}
