/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service;

import java.util.List;
import mx.com.elektra.coreback2.beans.Accesorio;
import mx.com.elektra.coreback2.beans.Paquete;

/**
 *
 * @author dparra
 */
public interface AccesoriosService {
    public double getCalculoAccesorios(Paquete paquete, int idCarrier);
    public List<Accesorio> getAccesorios(Paquete paquete, int idCarrier);
    public double getMonto(Paquete paquete, Accesorio accesorio);
    public double getMontoTotalAccesorios(Paquete paquete, int idCarrier);
    public boolean insertaAccesorio(Paquete paquete, int idCarrier, Accesorio accesorio, String usuario);
}
