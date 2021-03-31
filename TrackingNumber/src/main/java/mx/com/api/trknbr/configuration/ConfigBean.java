/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.configuration;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component
public class ConfigBean {
    @Value("${app.write.console}")
    private boolean writeActions;
    @Value("${app.write.bd}")
    private boolean writeBD;
    @Value("${app.write.all}")
    private boolean writeAll;
    @Value("${app.environment}")
    private String environment;
    
    public boolean isWriteActions() {
        return writeActions;
    }

    public boolean isWriteBD() {
        return writeBD;
    }

    public boolean isWriteAll() {
        return writeAll;
    }

    public String getEnvironment() {
        return environment;
    }
    
}
