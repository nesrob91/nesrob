/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.service;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import mx.com.api.route.configuration.ConfigBean;
import mx.com.api.route.dao.RemisionDao;
import mx.com.api.route.beans.DetalleRem;
import mx.com.api.route.beans.Remision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author nroblerol
 */
@Service("remisionService")
public class RemisionServiceImpl implements RemisionService{

    @Autowired
    private RemisionDao remisionDao;
    @Autowired
    private LogsPaqueterias logger;
    @Autowired
    private ConfigBean configuration;
    @Autowired
    private AtomicLong idRequest;
    
    @Override
    public List<Remision> getInfoRemision(Integer origen, Integer destino, List<Integer> rem, boolean dtl) {
        List<Remision> result=new ArrayList<>();
        try{
            for(Integer r : rem){
                List<DetalleRem> detRem;
                if(dtl)
                    detRem=remisionDao.getDetalleRemision(origen, destino, r);
                else
                    detRem=new ArrayList<>();
                if(detRem!=null){
                    Remision infoRem=remisionDao.getInfoRemision(origen,destino,r);
                    if(infoRem==null){
                        
                    }else{
                        infoRem.setDetalle(detRem);
                        result.add(infoRem);
                    }
                }else{
                    
                }
            }
        }catch(Exception e){
            if(configuration.isWriteActions())
                System.out.println("ERROR : "+e.getMessage());
            try{
                logger.insertaError(1110002, 11, origen, 0, 
                    "", 0, 0, 
                    "", 0, 0, 
                    e.getMessage(), getClass().getName()+"."+new Object(){}.getClass().getEnclosingMethod().getName(), "");//, idRequest.toString(), "","");
            }catch(Exception ex){
            }
            result=null;
        }
        return result;
    }
    
}
