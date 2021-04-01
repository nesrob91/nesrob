/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.service.impl;

import java.util.ArrayList;
import java.util.List;
import mx.com.elektra.coreback2.beans.Accesorio;
import mx.com.elektra.coreback2.beans.Paquete;
import mx.com.elektra.coreback2.dao.AccesoriosDao;
import mx.com.elektra.coreback2.service.AccesoriosService;
import mx.com.elektra.coreback2.service.ReglasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dparra
 */
@Service("accesoriosService")
public class AccesoriosServiceImpl implements AccesoriosService{
    @Autowired
    private  AccesoriosDao accesoriosDao;
    @Autowired
    private  ReglasService reglasService;
    
    @Override
    public double getCalculoAccesorios(Paquete paquete, int idCarrier){
        
        int insertados = 0;
        List<Accesorio> accesorios = new ArrayList<>();
        accesorios = getAccesorios(paquete, idCarrier);
        double montoTotal=0;
        for(Accesorio accesorio : accesorios){
            boolean accesorioValido;
            accesorio.setMonto(getMonto(paquete, accesorio));
            switch(accesorio.getIdAccesorio()){
                case 1:
                    accesorioValido = isPaqueteReqSeguro(paquete, idCarrier) || isDestinoReqSeguro(paquete, idCarrier);
                    break;
                case 2: 
                    accesorioValido = accesorio.getMonto() > 0;
                    break;
                default:
                    accesorioValido = accesorio.getMonto() > 0;
                    break;
            }
            int prev=0+insertados;
            if(accesorioValido && accesorio.getMonto() > 0){
                insertados += insertaAccesorio(paquete, accesorio, idCarrier);
                if(insertados > prev)
                    montoTotal+=accesorio.getMonto();
            }
        }
        
        return montoTotal;
    }
    private int insertaAccesorio(Paquete paquete, Accesorio accesorio, int idCarrier) {
        int insertados = 0;
        
        if (accesoriosDao.insertaAccesorio(paquete, idCarrier, accesorio, "AccesoriosServiceImpl")) {
            insertados++;
        } else {
        }

        return insertados;
    }

    private boolean isPaqueteReqSeguro(Paquete paquete, int idCarrier){
        return reglasService.isPaqueteReqSeguro(paquete, idCarrier);
    }
    
    private boolean isDestinoReqSeguro(Paquete paquete, int idCarrier){
        return accesoriosDao.isDestinoReqSeguro(paquete, idCarrier);
    }
    
    @Override
    public double getMontoTotalAccesorios(Paquete paquete, int idCarrier){
        return accesoriosDao.getMontoTotalAccesorios(paquete, idCarrier);
    }
    
    @Override
    public List<Accesorio> getAccesorios(Paquete paquete, int idCarrier){
        return accesoriosDao.getAccesorios(paquete, idCarrier);
    }
    @Override
    public double getMonto(Paquete paquete, Accesorio accesorio){
        double monto = 0;
        if(accesorio.getTipo().equals("%")){
            monto = (paquete.getCostoTotal() * accesorio.getValor()) / 100;
        }
        else if(accesorio.getTipo().equals("$")){
            monto = accesorio.getValor();
        }
        return monto;
    }
    @Override
    public boolean insertaAccesorio(Paquete paquete, int idCarrier, Accesorio accesorio, String usuario){
        return accesoriosDao.insertaAccesorio(paquete, idCarrier, accesorio, usuario);
    }
}
