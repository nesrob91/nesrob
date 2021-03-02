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
public class Remision {
    private Integer recept;
    private Integer emisor;
    private String folrem;
    private String folref;
    private Integer tipo;
    private Integer canal;
    private String fecemi;
    private String fecpen;
    private String fecconf;
    private String fecrut;
    private String fecenv;
    private Integer stscon;
    private Integer totdet;
    private String fecart;
    private String fecing;
    private String fecren;
    private Integer ststenv;
    private Integer stsreg;
    private String flag;
    private List<DetalleRem> detalle;

    public Integer getRecept() {
        return recept;
    }

    public void setRecept(Integer recept) {
        this.recept = recept;
    }

    public Integer getEmisor() {
        return emisor;
    }

    public void setEmisor(Integer emisor) {
        this.emisor = emisor;
    }

    public String getFolrem() {
        return folrem;
    }

    public void setFolrem(String folrem) {
        this.folrem = folrem;
    }

    public String getFolref() {
        return folref;
    }

    public void setFolref(String folref) {
        this.folref = folref;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getCanal() {
        return canal;
    }

    public void setCanal(Integer canal) {
        this.canal = canal;
    }

    public String getFecemi() {
        return fecemi;
    }

    public void setFecemi(String fecemi) {
        this.fecemi = fecemi;
    }

    public String getFecpen() {
        return fecpen;
    }

    public void setFecpen(String fecpen) {
        this.fecpen = fecpen;
    }

    public String getFecconf() {
        return fecconf;
    }

    public void setFecconf(String fecconf) {
        this.fecconf = fecconf;
    }

    public String getFecrut() {
        return fecrut;
    }

    public void setFecrut(String fecrut) {
        this.fecrut = fecrut;
    }

    public String getFecenv() {
        return fecenv;
    }

    public void setFecenv(String fecenv) {
        this.fecenv = fecenv;
    }

    public Integer getStscon() {
        return stscon;
    }

    public void setStscon(Integer stscon) {
        this.stscon = stscon;
    }

    public Integer getTotdet() {
        return totdet;
    }

    public void setTotdet(Integer totdet) {
        this.totdet = totdet;
    }

    public String getFecart() {
        return fecart;
    }

    public void setFecart(String fecart) {
        this.fecart = fecart;
    }

    public String getFecing() {
        return fecing;
    }

    public void setFecing(String fecing) {
        this.fecing = fecing;
    }

    public String getFecren() {
        return fecren;
    }

    public void setFecren(String fecren) {
        this.fecren = fecren;
    }

    public Integer getStstenv() {
        return ststenv;
    }

    public void setStstenv(Integer ststenv) {
        this.ststenv = ststenv;
    }

    public Integer getStsreg() {
        return stsreg;
    }

    public void setStsreg(Integer stsreg) {
        this.stsreg = stsreg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<DetalleRem> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleRem> detalle) {
        this.detalle = detalle;
    }
    
}
