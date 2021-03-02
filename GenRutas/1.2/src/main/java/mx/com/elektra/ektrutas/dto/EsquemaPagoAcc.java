/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas.dto;

/**
 *
 * @author nroblerol
 */
public class EsquemaPagoAcc {
    private Integer idAccesorio;
    private Integer origenAccesorio;
    private String descAccesorioTipo;
    private Double importeAcc;
    private Double volumenMin;
    private Double volumenMax;

    public Integer getIdAccesorio() {
        return idAccesorio;
    }

    public void setIdAccesorio(Integer idAccesorio) {
        this.idAccesorio = idAccesorio;
    }

    public Integer getOrigenAccesorio() {
        return origenAccesorio;
    }

    public void setOrigenAccesorio(Integer origenAccesorio) {
        this.origenAccesorio = origenAccesorio;
    }

    public String getDescAccesorioTipo() {
        return descAccesorioTipo;
    }

    public void setDescAccesorioTipo(String descAccesorioTipo) {
        this.descAccesorioTipo = descAccesorioTipo;
    }

    public Double getImporteAcc() {
        return importeAcc;
    }

    public void setImporteAcc(Double importeAcc) {
        this.importeAcc = importeAcc;
    }

    public Double getVolumenMin() {
        return volumenMin;
    }

    public void setVolumenMin(Double volumenMin) {
        this.volumenMin = volumenMin;
    }

    public Double getVolumenMax() {
        return volumenMax;
    }

    public void setVolumenMax(Double volumenMax) {
        this.volumenMax = volumenMax;
    }
    
}
