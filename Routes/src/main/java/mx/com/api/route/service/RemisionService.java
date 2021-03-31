/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.service;

import java.util.List;
import mx.com.api.route.beans.Remision;

/**
 *
 * @author nroblerol
 */
public interface RemisionService {
    public List<Remision> getInfoRemision(Integer origen, Integer destino, List<Integer> rem, boolean dtl);
}
