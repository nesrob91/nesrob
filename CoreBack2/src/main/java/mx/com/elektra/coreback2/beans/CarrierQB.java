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
public class CarrierQB {
    private int idCarrier;
    private String desdCarrier;
    private String codCarrier;

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public String getDesdCarrier() {
        return desdCarrier;
    }

    public void setDesdCarrier(String desdCarrier) {
        this.desdCarrier = desdCarrier;
    }

    public String getCodCarrier() {
        return codCarrier;
    }

    public void setCodCarrier(String codCarrier) {
        this.codCarrier = codCarrier;
    }

    @Override
    public String toString() {
        return "CarrierQB{" + "idCarrier=" + idCarrier + ", desdCarrier=" + desdCarrier + ", codCarrier=" + codCarrier + '}';
    }
    
}
