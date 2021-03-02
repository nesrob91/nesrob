/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.logs.error;

import com.elektra.cadsumutils.service.LogsService;
import com.elektra.cadsumutils.service.LogsServiceImpl;
import java.io.IOException;

/**
 *
 * @author dparra
 */
public class LogsPaqueterias{
    
    private final LogsService logsService = new LogsServiceImpl();
    /***
     * Inserta Errores de aplicacion o Validaciones no cumplidas
     * @param idError id en PAQ_CAT_ERRORES
     * @param idApp id en EKT_CAT_APLICACIONES
     * @param idManh id cd (Si se tiene)
     * @param idEstacion id estacion (Si se tiene)
     * @param pedido pedido (Si se tiene) 
     * @param idCaja id cd (Si se tiene)
     * @param idCarrier id carrier (Si se tiene)
     * @param numGuia numero de guias (Si se obtuvo)
     * @param idCanal id canal (Si se tiene)
     * @param idTipoPedido id tipo pedido (Si se tiene)
     * @param logs Error o validacion que no se cumplio
     * @param fuente clase que arrojo el error 
     * @param usuario usuario (si se tiene)
     */
    public void insertaError(Integer idError, Integer idApp, Integer idManh, Integer idEstacion, String pedido, int idCaja, Integer idCarrier, String numGuia, Integer idCanal, Integer idTipoPedido, String logs, String fuente, String usuario){
        
        if(!logsService.error(idError, idApp, idManh, idEstacion, pedido, idCaja, idCarrier, numGuia, idCanal, idTipoPedido, logs, fuente, usuario)){
            System.out.println("Error al guardar log: " + idError);
            System.out.println("Fuente: " + fuente);
            System.out.println("Log: " + logs);
        }
        
    }
}
