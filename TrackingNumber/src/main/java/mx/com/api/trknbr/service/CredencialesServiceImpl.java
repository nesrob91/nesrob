/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.service;

import mx.com.api.trknbr.dao.CredencialesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dparra
 */
@Service("credencialesService")
public class CredencialesServiceImpl implements CredencialesService{
    
    @Autowired
    private CredencialesDao credencialesDhl ;
    @Autowired
    private CredencialesDao credencialesFedex ;
    @Autowired
    private CredencialesDao credencialesEstafeta ;
    @Autowired
    private CredencialesDao credencialesPaqueteExpress ;
    @Autowired
    private CredencialesDao credencialesTracusa ;
    
    private final int ID_SERVICIO_GUIAS = 1;
    private final int ID_SERVICIO_ETIQUETAS = 2;

    @Override
    public Object getCredenciales(int idCarrier, int idTipPed) {
        return credencialesDhl.getCredenciales(idCarrier, ID_SERVICIO_GUIAS, idTipPed);
    }
    
}
