/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.pedidos;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.util.Map;
import mx.com.api.trknbr.configuration.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component("pedido")
public class PSelector {
    @Autowired
    private DSV dsv;
    @Autowired
    private EPI epi;
    @Autowired
    private MKP mkp;
    @Autowired
    private Lyde lyde;
    
    @Autowired
    private ConfigBean conf;
    @Autowired
    private LogsPaqueterias logger;
    
    /***
     * Retrieve an instance given the idTipoPeddio
     * @param idTipoPeddio (4 MKP | 5 DSV | 6 Lyde)[as of oct2020]
     * @param sizes sizes of the package: width, lenght, weight, height 
     * @return TipoPeticion instance
     */
    public TipoPeticion getInstance(int idTipoPeddio, Map<String,Double> sizes){
        switch(idTipoPeddio){
            case 5:
                return dsv;
            case 4:
                return mkp;
            case 6:
                Lyde.trknbrSize.putAll(sizes);
                return lyde;
            case 1:
                return epi;
            default:
                logger.insertaError(
                    1010007
                    , 10
                    , null
                    , null
                    , null
                    , 0
                    , 0
                    , null
                    , null
                    , idTipoPeddio
                    , "Pedido no definido"
                    , getClass().getName() + "." + new Object(){}.getClass().getEnclosingMethod().getName()
                    , null);
                if(conf.isWriteAll())
                    System.out.println("WARN : No impl for TipoPedido "+idTipoPeddio);
                return null;
        }
    }
}
