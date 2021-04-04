/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.service;

import java.util.List;
import mx.com.elektra.mso.cb.model.Accesorio;
import mx.com.elektra.mso.cb.model.Paquete;

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
