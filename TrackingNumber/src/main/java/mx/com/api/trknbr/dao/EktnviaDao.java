/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao;

import mx.com.api.trknbr.beans.GuiaRequest;

/**
 *
 * @author nroblerol
 */
public interface EktnviaDao {
    public Object getEktnviaRequest(GuiaRequest req);
    public String getNumGuia(int idManh, int idCaja, String pedido,int idTipoPedido, String idUsuario);
}
