/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.configuration;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;

/**
 *
 * @author nroblerol
 */
public class ConfigBean {
    private final boolean writeActions=true;
    private final boolean writeBD=false;
    private final String environment="dev";
    private final LogsPaqueterias loggerBD=new LogsPaqueterias();

    public boolean isWriteActions() {
        return writeActions;
    }

    public boolean isWriteBD() {
        return writeBD;
    }
    
    public LogsPaqueterias getLoggerBD(){
        return loggerBD;
    }

    public String getEnvironment() {
        return environment;
    }
    
}
