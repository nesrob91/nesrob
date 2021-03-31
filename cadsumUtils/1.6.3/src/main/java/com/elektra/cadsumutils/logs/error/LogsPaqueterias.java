/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.logs.error;

import com.elektra.cadsumutils.service.LogsService;
import com.elektra.cadsumutils.service.LogsServiceImpl;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dparra
 */
@Component("logger")
public class LogsPaqueterias{
    @Autowired
    private  LogsService logsService ;
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
     * @param ref_field_1 idRequest [as of MAR 2021]
     * @param ref_field_2 (no use [as of MAR 2021])
     * @param ref_field_3 (no use [as of MAR 2021])
     */
    public void insertaError(Integer idError, Integer idApp, Integer idManh, Integer idEstacion, String pedido, int idCaja, Integer idCarrier, String numGuia, Integer idCanal, 
            Integer idTipoPedido, String logs, String fuente, String usuario, String ref_field_1,String ref_field_2,String ref_field_3){
        
        if(!logsService.error(idError, idApp, idManh, idEstacion, pedido, idCaja, idCarrier, numGuia, idCanal, idTipoPedido, logs, fuente, usuario,ref_field_1,ref_field_2,ref_field_3)){
            System.out.println("Error al guardar log: " + idError);
            System.out.println("Fuente: " + fuente);
            System.out.println("Log: " + logs);
        }
        
    }
}
