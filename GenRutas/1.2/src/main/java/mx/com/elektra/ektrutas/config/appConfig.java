/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.ektrutas.config;

import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author nroblerol
 */
@Configuration
@ComponentScan(basePackages = {"mx.com.elektra.ektrutas"})
public class appConfig {
    @Bean("DEBUGGER")
    Boolean getDEBUG(){
        return false;
    }
    @Bean("logger")
    LogsPaqueterias getLogger (){
        return new LogsPaqueterias();
    }
}
