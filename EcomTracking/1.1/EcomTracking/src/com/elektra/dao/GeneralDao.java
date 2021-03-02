/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.dao;

import java.util.List;

/**
 *
 * @author dparra
 */
public interface GeneralDao {
    
    public List<String> getGrupos();
    public int insXml(String codigo, String resultado, String descripcion, String request, String response, String pedido, String orderId, int cdId, int idCarrier, String operacion, String idCajaHdr);
    
}
