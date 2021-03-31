/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.service;

import java.util.List;
import mx.com.api.route.beans.Almacen;
import mx.com.api.route.dao.GeneralDao;
import mx.com.api.route.beans.SKU;
import mx.com.api.route.beans.User;
import mx.com.api.route.beans.Usuario;
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
    public String getRequestCount() {
        return generalDao.getRequestCount();
    }
    
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
    
    @Override
    public Almacen getInfoAlmn(Integer idAlm) {
        return generalDao.getInfoAlmn(idAlm);
    }
    
    @Override
    public User findByUsername(String user) {
        return generalDao.findByUsername(user);
    }
    
    @Override
    public boolean saveByUsername(User user){
        return generalDao.saveByUsername(user);
    }
}
