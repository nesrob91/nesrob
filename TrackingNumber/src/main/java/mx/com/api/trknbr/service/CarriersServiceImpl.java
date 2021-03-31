/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.service;

import mx.com.api.trknbr.beans.GuiaRequest;
import mx.com.api.trknbr.beans.GuiaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.api.trknbr.dao.GuiaDao;

/**
 *
 * @author nroblerol
 */
@Service("carrierService")
public class CarriersServiceImpl implements CarriersService{
    @Autowired
    private GuiaDao carrierDao;
    
    @Override
    public void actualizaGuia(GuiaRequest guiaRequest, GuiaResponse guiaResponse, String usuario, boolean isExternal){
        if(carrierDao.actualizaControlGuias(guiaRequest, guiaResponse, usuario)){
            if(!isExternal){
                carrierDao.insertaMensajesWs(guiaRequest, guiaResponse, "GENERA_GUIAS");
            }
            if(guiaResponse.getIdEstatusGuia()==10 && guiaResponse.getEtiqueta() != null && !guiaResponse.getEtiqueta().trim().equals("")){
                carrierDao.insEtiqueta(guiaRequest, guiaResponse);
            }
        }
    }
    
    @Override
    public String getTipoServicioPorPeso(GuiaRequest guiaRequest){
        return carrierDao.getTipoServicioPorPeso(guiaRequest);
    }
    
    @Override
    public String getTipoServicioPorRangoPeso(float pesoFisico, int idCarrier, int tipo) {
        return carrierDao.getTipoServicioPorRangoPeso(pesoFisico, idCarrier, tipo);
    }
}
