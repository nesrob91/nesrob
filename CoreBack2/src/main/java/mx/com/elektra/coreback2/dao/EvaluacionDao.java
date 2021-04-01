/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.dao;

import java.util.List;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Regla;

/**
 *
 * @author dparra
 */
public interface EvaluacionDao {
    
    public List<Integer> getIdCarriersCumplenCondicion(Paquete paquete, Regla regla);
    
    public List<Integer> getIdCarriersMenorValor(Paquete paquete, Regla regla);
    
    public List<Integer> getIdCarriersMayorValor(Paquete paquete, Regla regla);
    
    public List<Integer> getIdCarriersByRegla(Paquete paquete, Regla regla);
    
    public boolean actualizaCarriers(Paquete paquete, Regla regla, List<Integer> idCarriers, int idEstatus, String usuario);
    
    
}
