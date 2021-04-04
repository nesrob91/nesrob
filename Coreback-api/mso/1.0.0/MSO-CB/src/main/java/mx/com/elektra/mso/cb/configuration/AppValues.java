/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.mso.cb.configuration;

import mx.com.elektra.mso.cb.model.Paquete;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author nroblerol
 */
@Configuration
public class AppValues {
    
    @Bean
    Paquete paquete(){
        return new Paquete();
    }
}
