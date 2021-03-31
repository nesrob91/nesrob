/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.service;

import mx.com.api.trknbr.beans.DatosEktnvia;
import mx.com.api.trknbr.beans.GuiaRequest;

/**
 *
 * @author nroblerol
 */
public interface EktnviaService {
    public Object getEktnviaRequest(GuiaRequest req);
    public String getNumGuia(int idManh, int idCaja, String pedido,int idTipoPedido, String idUsuario);
    public String getEtiquetaByNumGuia(DatosEktnvia datosGuias, boolean desarrollo, String guia) throws Exception;
}
