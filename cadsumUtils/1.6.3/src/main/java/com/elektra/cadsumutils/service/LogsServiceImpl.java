/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.service;

import com.elektra.cadsumutils.dao.LogsDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dparra
 */
@Service
public class LogsServiceImpl implements LogsService{
    @Autowired
    private LogsDaoImpl logsDao ;
    
    @Override
    public boolean error(Integer idError, Integer idApp, Integer idManh, Integer idEstacion, String pedido, int idCaja, Integer idCarrier, String numGuia, Integer idCanal, 
            Integer idTipoPedido, String logs, String fuente, String usuario, String ref_field_1,String ref_field_2,String ref_field_3){
        return logsDao.error(idError, idApp, idManh, idEstacion, pedido, idCaja, idCarrier, numGuia, idCanal, idTipoPedido, logs, fuente, usuario, ref_field_1,ref_field_2,ref_field_3);
    }
}
