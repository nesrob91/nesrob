/* * To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates * and open the template in the editor. */
package mx.com.api.trknbr.beans;

import java.io.Serializable;
import java.util.List;

/**
 * * * @author dparra
 */
public class GuiaResponse implements Serializable{

    private String numGuia;
    private List<String> ruta;
    private String mensaje;
    private String etiqueta;
    private int idEstatusGuia;
    private String input;
    private String output;
    private int carrier;
    private int idCaja;
    private int encrypt;

    public String getNumGuia() {
        return numGuia;
    }

    public void setNumGuia(String numGuia) {
        this.numGuia = numGuia;
    }

    public List<String> getRuta() {
        return ruta;
    }

    public void setRuta(List<String> ruta) {
        this.ruta = ruta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getIdEstatusGuia() {
        return idEstatusGuia;
    }

    public void setIdEstatusGuia(int idEstatusGuia) {
        this.idEstatusGuia = idEstatusGuia;
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

    public int getCarrier() {
        return carrier;
    }

    public void setCarrier(int carrier) {
        this.carrier = carrier;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public int getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(int encrypt) {
        this.encrypt = encrypt;
    }
    
}
