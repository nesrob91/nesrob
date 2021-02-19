/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.service;

import java.util.List;
import mx.com.api.route.dao.TiendaDao;
import mx.com.api.route.beans.Tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nroblerol
 */
@Service("tiendaService")
public class TiendaServiceImpl implements TiendaService{
    @Autowired
    TiendaDao tiendaDao;

    @Override
    public Tienda getInfoTienda(int tienda) {
        return tiendaDao.getInfoTienda(tienda);
    }

    @Override
    public Integer isDistItk(List<Integer> tienda) {
        return tiendaDao.isDistItk(tienda);
    }
    
}
