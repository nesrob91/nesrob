/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao;

/**
 *
 * @author dparra
 */
public interface CredencialesDao {

    final int ID_SERVICIO_GUIAS = 1;
    final int ID_SERVICIO_ETIQUETAS = 2;
    
    public Object getCredenciales(int idCarrier, int idServicio, int idTipPed);

}
