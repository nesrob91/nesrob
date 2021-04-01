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
public class ExclusionOInclusion {
    
    private Sku sku;
    private int tipoExclusion;

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public int getTipoExclusion() {
        return tipoExclusion;
    }

    public void setTipoExclusion(int tipoExclusion) {
        this.tipoExclusion = tipoExclusion;
    }
    
    
}
