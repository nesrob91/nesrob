/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas.service;

import java.util.List;
import mx.com.elektra.ektrutas.dao.GeneralDao;
import mx.com.elektra.ektrutas.dto.SKU;
import mx.com.elektra.ektrutas.dto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nroblerol
 */
@Service("generalService")
public class GeneralServiceImpl implements GeneralService{
    @Autowired
    private GeneralDao generalDao;
    
    @Override
    public List<SKU> getSkuInfo(List<String> sku) {
        return generalDao.getSkuInfo(sku);
    }

    @Override
    public Integer getIdUsuario(String usuario) {
        return generalDao.getIdUsuario(usuario);
    }

    @Override
    public Usuario getInfoUsuario(Integer user) {
        return generalDao.getInfoUsuario(getIdUsuario(user+""));
    }

    @Override
    public String getsysdate() {
        return generalDao.getSysdate();
    }
    
}
