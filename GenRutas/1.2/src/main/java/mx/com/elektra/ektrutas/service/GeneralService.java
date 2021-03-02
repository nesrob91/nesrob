/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas.service;

import java.util.List;
import mx.com.elektra.ektrutas.dto.SKU;
import mx.com.elektra.ektrutas.dto.Usuario;

/**
 *
 * @author nroblerol
 */
public interface GeneralService {
    public List<SKU> getSkuInfo(List<String> sku);
    public Integer getIdUsuario(String usuario);
    public Usuario getInfoUsuario(Integer user);
    public String getsysdate();
}
