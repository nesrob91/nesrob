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
public class EsquemaPago {
    private Integer origen;
    private Integer destino;
    private Double importe;
    private String proveedor;
    private String moneda;
    private Integer tipoPago;
    
    private String descProveedor;
    
    private String descTipoPago;
    private Integer nivelClasificacion;
    
    private String descNivelClasf;
    
    private String clasificacion;
    private Double importeClasf;
    private Integer accesorioTipo;
    
    private String descAccesorioTipo;
    private Double importeAcc;
    private Integer volumenMin;
    private Integer volumenMax;
    
    private Double importeZE;
    
    private Integer volumenSCBase;
    private Double importeSCBase;
    private Double importeSCExtra;

    public Integer getOrigen() {
        return origen;
    }

    public void setOrigen(Integer origen) {
        this.origen = origen;
    }

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getDescProveedor() {
        return descProveedor;
    }

    public void setDescProveedor(String descProveedor) {
        this.descProveedor = descProveedor;
    }

    public Integer getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(Integer tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getDescTipoPago() {
        return descTipoPago;
    }

    public void setDescTipoPago(String descTipoPago) {
        this.descTipoPago = descTipoPago;
    }

    public Integer getNivelClasificacion() {
        return nivelClasificacion;
    }

    public void setNivelClasificacion(Integer nivelClasificacion) {
        this.nivelClasificacion = nivelClasificacion;
    }

    public String getDescNivelClasf() {
        return descNivelClasf;
    }

    public void setDescNivelClasf(String descNivelClasf) {
        this.descNivelClasf = descNivelClasf;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Double getImporteClasf() {
        return importeClasf;
    }

    public void setImporteClasf(Double importeClasf) {
        this.importeClasf = importeClasf;
    }

    public Integer getAccesorioTipo() {
        return accesorioTipo;
    }

    public void setAccesorioTipo(Integer accesorioTipo) {
        this.accesorioTipo = accesorioTipo;
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

    public Integer getVolumenMin() {
        return volumenMin;
    }

    public void setVolumenMin(Integer volumenMin) {
        this.volumenMin = volumenMin;
    }

    public Integer getVolumenMax() {
        return volumenMax;
    }

    public void setVolumenMax(Integer volumenMax) {
        this.volumenMax = volumenMax;
    }

    public Double getImporteZE() {
        return importeZE;
    }

    public void setImporteZE(Double importeZE) {
        this.importeZE = importeZE;
    }

    public Integer getVolumenSCBase() {
        return volumenSCBase;
    }

    public void setVolumenSCBase(Integer volumenSCBase) {
        this.volumenSCBase = volumenSCBase;
    }

    public Double getImporteSCBase() {
        return importeSCBase;
    }

    public void setImporteSCBase(Double importeSCBase) {
        this.importeSCBase = importeSCBase;
    }

    public Double getImporteSCExtra() {
        return importeSCExtra;
    }

    public void setImporteSCExtra(Double importeSCExtra) {
        this.importeSCExtra = importeSCExtra;
    }
    
}
