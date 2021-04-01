/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.elektra.coreback2.config;

import mx.com.elektra.coreback2.beans.Paquete;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 *
 * @author nroblerol
 */
@Configuration
@ComponentScan(basePackages = {"com.elektra.cadsumutils","mx.com.elektra.coreback2"})
@PropertySources({
    @PropertySource("classpath:application.properties")
})
public class configuration {
    @Bean
    Paquete paquete(){
        return new Paquete();
    }
}
