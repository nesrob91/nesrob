/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.beans;

/**
 *
 * @author nroblerol
 */
public class Almacen {
    private String desc;
    private Integer idManh;
    private Integer idSap;
    private String grupoWm;
    private String grupoWm18;
    private Integer flgMigrated;
    private String pais;
    private Integer activo;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getIdManh() {
        return idManh;
    }

    public void setIdManh(Integer idManh) {
        this.idManh = idManh;
    }

    public Integer getIdSap() {
        return idSap;
    }

    public void setIdSap(Integer idSap) {
        this.idSap = idSap;
    }

    public String getGrupoWm() {
        return grupoWm;
    }

    public void setGrupoWm(String grupoWm) {
        this.grupoWm = grupoWm;
    }

    public String getGrupoWm18() {
        return grupoWm18;
    }

    public void setGrupoWm18(String grupoWm18) {
        this.grupoWm18 = grupoWm18;
    }

    public Integer getFlgMigrated() {
        return flgMigrated;
    }

    public void setFlgMigrated(Integer flgMigrated) {
        this.flgMigrated = flgMigrated;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }
    
}
