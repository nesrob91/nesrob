/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.configuration;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public String getEnvironment() {
        return environment;
    }

    public boolean isWriteAll() {
        return writeAll;
    }
    
}
