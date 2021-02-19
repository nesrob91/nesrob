/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.dao;

import java.util.List;
import mx.com.api.route.beans.DetalleRem;
import mx.com.api.route.beans.Remision;

/**
 *
 * @author nroblerol
 */
public interface RemisionDao {
    public Remision getInfoRemision(Integer origen, Integer destino, Integer rem);
    public List<DetalleRem> getDetalleRemision(Integer origen, Integer destino, Integer rem);
}
