/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.dao;

import java.util.List;
import java.util.Map;
import mx.com.api.route.beans.SKU;
import mx.com.api.route.beans.Usuario;

/**
 *
 * @author nroblerol
 */
public interface GeneralDao {
    public String getRequestCount();
    public List<SKU> getSkuInfo(List<String> sku);
    public Integer getIdUsuario(String usuario);
    public Usuario getInfoUsuario(Integer user);
    public String getCeCo(boolean isDist, Integer ori, Integer des, String aplicacion, String vChar, boolean tda);
    public String getSysdate();
    public Integer getIdSapAlmn(Integer idManh);
}
