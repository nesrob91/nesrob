/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.dao;

import java.util.List;
import java.util.Map;
import mx.com.api.trknbr.beans.GuiaRequest;
import mx.com.api.trknbr.beans.GuiaResponse;

/**
 *
 * @author nroblerol
 */
public interface GuiaDao {
    public boolean insertaControlGuias(GuiaRequest guiaRequest, String usuario) ;
    
    public boolean actualizaControlGuias(GuiaRequest guiaRequest, GuiaResponse guiaResponse, String usuario);
    
    public boolean insertaMensajesWs(GuiaRequest guiaRequest, GuiaResponse guiaResponse, String operacion);
    
    public boolean insEtiqueta(GuiaRequest guiaRequest, GuiaResponse guiaResponse);
    
    public String getTipoServicioPorPeso(GuiaRequest guiaRequest);
    
    public String getTipoServicioPorRangoPeso(float pesoFisico, int idCarrier, int tipo) ;
    
    public GuiaResponse getLabel(String numGuia, int carrier);
    
    public List<Map<String, Object>> getTrkNbr3PL(List<String> contenido, int cd, int type);
    
    public List<Map<String,Object>> getStatusTrknbr(String numGuia, int idCarrier);
    public List<Map<String,Object>> getStatusTrknbr(List<String> contenido, int idCentro, int idTipoPedido);
    
    public boolean cancelTrknbr(String numGuia,int idCarrier,int tipoPedido);
}
