/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service;

import java.util.List;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.beans.Regla;

/**
 *
 * @author dparra
 */
public interface EvaluacionService {
    
    
    public List<Integer> getIdCarriersCumplenCondicion(Paquete paquete, Regla regla);
    public List<Integer> getIdCarriersMenorValor(Paquete paquete, Regla regla);
    public List<Integer> getIdCarriersMayorValor(Paquete paquete, Regla regla);
    public List<Integer> getIdCarriersByRegla(Paquete paquete, Regla regla);
    public boolean actualizaCarriersEvaluados(Paquete paquete, Regla regla);
    
}
