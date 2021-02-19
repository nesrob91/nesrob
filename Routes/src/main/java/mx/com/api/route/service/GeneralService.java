/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.service;

import java.util.List;
import mx.com.api.route.beans.SKU;
import mx.com.api.route.beans.Usuario;

/**
 *
 * @author nroblerol
 */
public interface GeneralService {
    public String getRequestCount();
    public List<SKU> getSkuInfo(List<String> sku);
    public Integer getIdUsuario(String usuario);
    public Usuario getInfoUsuario(Integer user);
    public String getsysdate();
    public Integer getIdSapAlmn(Integer idManh);
}
