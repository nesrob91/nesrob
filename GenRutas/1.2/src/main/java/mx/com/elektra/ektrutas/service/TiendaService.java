/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas.service;

import java.util.List;
import mx.com.elektra.ektrutas.dto.Tienda;

/**
 *
 * @author nroblerol
 */
public interface TiendaService {
    public Tienda getInfoTienda(int tienda);
    public Integer isDistItk(List<Integer> tienda);
}
