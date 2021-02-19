/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.dao;

/**
 *
 * @author dparra
 */
public interface LogsService {
    public boolean error(Integer idError, Integer idApp, Integer idManh, Integer idEstacion, String pedido, int idCaja, Integer idCarrier, String numGuia, Integer idCanal, Integer idTipoPedido, String logs, String fuente, String usuario);
}
