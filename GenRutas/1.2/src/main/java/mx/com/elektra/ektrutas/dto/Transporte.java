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
public class Transporte {
    private Integer idTransporte;
    private String descRZO;
    private Direccion dir;
    private String descLIN;
    private String UMD;
    private String fecha;

    public Integer getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public String getDescRZO() {
        return descRZO;
    }

    public void setDescRZO(String descRZO) {
        this.descRZO = descRZO;
    }

    public Direccion getDir() {
        return dir;
    }

    public void setDir(Direccion dir) {
        this.dir = dir;
    }

    public String getDescLIN() {
        return descLIN;
    }

    public void setDescLIN(String descLIN) {
        this.descLIN = descLIN;
    }

    public String getUMD() {
        return UMD;
    }

    public void setUMD(String UMD) {
        this.UMD = UMD;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
