/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.service;

import com.elektra.cadsumutils.dao.LogsDaoImpl;

/**
 *
 * @author dparra
 */
public class LogsServiceImpl implements LogsService{
    
    private final LogsDaoImpl logsDao = new LogsDaoImpl();
    
    @Override
    public boolean error(Integer idError, Integer idApp, Integer idManh, Integer idEstacion, String pedido, int idCaja, Integer idCarrier, String numGuia, Integer idCanal, Integer idTipoPedido, String logs, String fuente, String usuario){
        return logsDao.error(idError, idApp, idManh, idEstacion, pedido, idCaja, idCarrier, numGuia, idCanal, idTipoPedido, logs, fuente, usuario);
    }
}
