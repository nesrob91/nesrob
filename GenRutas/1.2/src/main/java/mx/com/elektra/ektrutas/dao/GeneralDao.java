/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas.dao;

import java.util.List;
import java.util.Map;
import mx.com.elektra.ektrutas.dto.SKU;
import mx.com.elektra.ektrutas.dto.Usuario;

/**
 *
 * @author nroblerol
 */
public interface GeneralDao {
    public List<SKU> getSkuInfo(List<String> sku);
    public Integer getIdUsuario(String usuario);
    public Usuario getInfoUsuario(Integer user);
    public String getCeCo(boolean isDist, Integer ori, Integer des, String aplicacion, String vChar, boolean tda);
    public String getSysdate();
}
