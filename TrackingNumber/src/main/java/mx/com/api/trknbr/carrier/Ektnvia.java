/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.carrier;

import mx.com.api.trknbr.beans.DatosEktnvia;
import mx.com.api.trknbr.beans.GuiaResponse;
import mx.com.api.trknbr.service.EktnviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("ektnvia")
public class Ektnvia extends GuiasCarriers{

    @Autowired
    protected EktnviaService ektnviaService ;
    
    @Override
    protected Object getCredenciales() throws Exception {
        return new Object();
    }

    @Override
    protected Object generaPeticion() throws Exception {
        peticion = ektnviaService.getEktnviaRequest(guiaRequest);
        return peticion;
    }

    @Override
    protected Object consumeWs() throws Exception {
        return new Object();
    }

    @Override
    protected GuiaResponse procesaRespuesta() throws Exception {
        DatosEktnvia ektnvia = (DatosEktnvia)peticion;
        GuiaResponse guiasResponse = new GuiaResponse();
        //modify - check for info data source
        if(!guiaRequest.getUbicacion().equals("NA")){ 

            String guia = ektnviaService.getNumGuia(ektnvia.getCdId(), ektnvia.getIdCaja(), ektnvia.getPedido(),guiaRequest.getIdTipoPedido(), usuario);

            if(guia != null && !guia.trim().equals("")){
                guiasResponse.setNumGuia(guia);
                guiasResponse.setIdEstatusGuia(10);
                guiasResponse.setEtiqueta(ektnviaService.getEtiquetaByNumGuia(ektnvia, desarrollo, guia));
                guiasResponse.setCarrier(ektnvia.getIdCarrier());
                guiasResponse.setEncrypt(0);
            }else{
                guiasResponse.setIdEstatusGuia(-1);
                guiasResponse.setMensaje("Error al obtener número de guía");
            }
        }
        else { 
            guiasResponse.setIdEstatusGuia(-1); 
            guiasResponse.setEtiqueta(null); 
            guiasResponse.setNumGuia(null); 
            guiasResponse.setMensaje("CP sin Zona"); 
        } 
        guiasResponse.setInput(xmlUtil.getXmlByObject(ektnvia));
        guiasResponse.setOutput(xmlUtil.getXmlByObject(guiasResponse));
        
        return guiasResponse;
    }
  
}
