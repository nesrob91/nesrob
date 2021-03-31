/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.service;

import mx.com.api.trknbr.beans.GuiaRequest;
import mx.com.api.trknbr.beans.GuiaResponse;

/**
 *
 * @author nroblerol
 */
public interface CarriersService {
    public void actualizaGuia(GuiaRequest guiaRequest, GuiaResponse guiaResponse, String usuario, boolean isExternal);
    public String getTipoServicioPorPeso(GuiaRequest guiaRequest);
    public String getTipoServicioPorRangoPeso(float pesoFisico, int idCarrier, int tipo) ;
}
