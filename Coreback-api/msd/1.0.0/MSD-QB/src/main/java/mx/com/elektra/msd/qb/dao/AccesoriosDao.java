/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.msd.qb.dao;

import java.util.List;
import mx.com.elektra.msd.qb.model.Accesorio;
import mx.com.elektra.msd.qb.model.Paquete;

/**
 *
 * @author dparra
 */
public interface AccesoriosDao {
    
    
    public List<Accesorio> getAccesorios(Paquete paquete, int idCarrier);
    
    public double getMontoTotalAccesorios(Paquete paquete, int idCarrier);
    
    public boolean insertaAccesorio(Paquete paquete, int idCarrier, Accesorio accesorio, String usuario);
    
    public boolean isDestinoReqSeguro(Paquete paquete, int idCarrier);
    

    
}
