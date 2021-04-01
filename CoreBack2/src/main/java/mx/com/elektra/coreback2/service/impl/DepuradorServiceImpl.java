/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service.impl;

import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.dao.DepuradorDao;
import mx.com.elektra.coreback2.service.DepuradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dparra
 */
@Service("depuradorService")
public class DepuradorServiceImpl implements DepuradorService{
    @Autowired
    private DepuradorDao depuradorDao;
    
    @Override
    public boolean limpiaTablas(Paquete paquete){
        if(depuradorDao.countGuia(paquete)>0){
            return false;
        }
        else{
            depuradorDao.eliminaContenidoCaja(paquete);
            depuradorDao.eliminaCbDtl(paquete);
            depuradorDao.eliminaCbHdr(paquete);
            depuradorDao.eliminaAccesorios(paquete);
            return ((depuradorDao.countContenidoCaja(paquete)==0) && (depuradorDao.countCbDtl(paquete)==0) && (depuradorDao.countCbHdr(paquete)==0) && depuradorDao.countAccesorios(paquete) == 0);
        }
        
    }
}
