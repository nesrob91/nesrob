/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author nroblerol
 */
@Component
public class application {
    @Value("${app.log.console}")
    private String writeConsole ;
    @Value("${app.log.bd}")
    private String writeBD ;

    public boolean isWriteConsole() {
        return Boolean.valueOf(writeConsole);
    }

    public boolean isWriteBD() {
        return Boolean.valueOf(writeBD);
    }
    
}
