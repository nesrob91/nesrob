/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.dao;

import java.util.List;
import mx.com.api.route.beans.Tienda;

/**
 *
 * @author nroblerol
 */
public interface TiendaDao {
    public Tienda getInfoTienda(int tienda);
    public Integer isDistItk(List<Integer> tienda);
    public Integer isCD(Integer tienda);
    public String getPaisTda(Integer tda);
}
