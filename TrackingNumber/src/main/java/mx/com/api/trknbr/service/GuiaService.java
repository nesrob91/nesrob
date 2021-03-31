/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.service;

import java.util.List;
import java.util.Map;

/**
 *
 * @author nroblerol
 */
public interface GuiaService {
    public Map<String, Object> getStatusTrknbr(String numGuia, int idCarrier) ;
    public Map<String, Map<String,Object>> getStatusTrknbr(List<String> contenido, int idCentro, int idTipoPedido);
    public boolean cancelTrknbr(String numGuia, int idCarrier, int tipoPedido) ;
}
