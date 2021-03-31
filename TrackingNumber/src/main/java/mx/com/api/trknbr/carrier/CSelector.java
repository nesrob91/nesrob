/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.carrier;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import mx.com.api.trknbr.configuration.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("carrier")
public class CSelector {
    @Autowired
    private Dhl dhl;
    @Autowired
    private Estafeta estafeta;
    @Autowired
    private EstafetaLTL estafetaLtl;
    @Autowired
    private Fedex fedex;
    @Autowired
    private Paquetexpress paqueteXpress;
    @Autowired
    private Ektnvia ektnvia;
    @Autowired
    private Palex palex;
    @Autowired
    private GuiasCarriers guias;
    
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    
    /***
     * Retrieve an instance given the idCarrier
     * @param idCarrier
     * @return GuiasCarriers instance
     */
    public GuiasCarriers getInstance(int idCarrier){
        switch(idCarrier){
            case 1:
                return guias;
            case 2:
                return estafeta;
            case 3:
                return dhl;
            case 6:
                return estafetaLtl;
            case 7:
                return paqueteXpress;
            case 9:
                return palex;
            case 10:
                return fedex;
            case 11:
                return ektnvia;
            default:
                logger.insertaError(
                    1020007
                    , 10
                    , null
                    , null
                    , null
                    , 0
                    , idCarrier
                    , null
                    , null
                    , null
                    , "Carrier no definido"
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
                if(conf.isWriteAll())
                    System.out.println("WARN : No impl for Carrier "+idCarrier);
                return null;
        }
    }
}
