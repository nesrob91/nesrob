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
 * @author nroblerol
 */
@Service("depuradorServiceUm")
public class DepuradorServiceUmImpl implements DepuradorService{
    @Autowired
    private DepuradorDao depuradorDaoUm;
    
    @Override
    public boolean limpiaTablas(Paquete paquete){
        //if(depuradorDaoUm.countGuia(paquete)>0){
            //return false;
        if(depuradorDaoUm.countCbHdr(paquete)==0){
            return true;
        }
        else{
            //depuradorDaoUm.eliminaContenidoCaja(paquete);
            //depuradorDaoUm.eliminaCbDtl(paquete);
            //depuradorDaoUm.eliminaCbHdr(paquete);
            //depuradorDaoUm.eliminaAccesorios(paquete);
            return depuradorDaoUm.eliminaCbHdr(paquete);//((depuradorDaoUm.countContenidoCaja(paquete)==0) && (depuradorDaoUm.countCbDtl(paquete)==0) && (depuradorDaoUm.countCbHdr(paquete)==0) && depuradorDaoUm.countAccesorios(paquete) == 0);
        }
    }
}
