/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.beans;

/**
 *
 * @author nroblerol
 */
public class Tienda {
    private Integer eco;
    private String desc;
    private Direccion dir;
    private CeCo ceco;

    public Integer getEco() {
        return eco;
    }

    public void setEco(Integer eco) {
        this.eco = eco;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Direccion getDir() {
        return dir;
    }

    public void setDir(Direccion dir) {
        this.dir = dir;
    }

    public CeCo getCeco() {
        return ceco;
    }

    public void setCeco(CeCo ceco) {
        this.ceco = ceco;
    }
    
}
