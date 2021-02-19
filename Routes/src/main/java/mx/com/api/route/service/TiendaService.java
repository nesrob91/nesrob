/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.service;

import java.util.List;
import mx.com.api.route.beans.Tienda;

/**
 *
 * @author nroblerol
 */
public interface TiendaService {
    public Tienda getInfoTienda(int tienda);
    public Integer isDistItk(List<Integer> tienda);
}
