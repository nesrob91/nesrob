/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas.dto;

import java.util.List;

/**
 *
 * @author nroblerol
 */
public class Respuesta {
    private List<String> ruta;
    private String folEnvio;
    private String code;
    private String msg;
    private boolean error; 
    private String document;

    public List<String> getRuta() {
        return ruta;
    }

    public void setRuta(List<String> ruta) {
        this.ruta = ruta;
    }

    public String getFolEnvio() {
        return folEnvio;
    }

    public void setFolEnvio(String folEnvio) {
        this.folEnvio = folEnvio;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

}
