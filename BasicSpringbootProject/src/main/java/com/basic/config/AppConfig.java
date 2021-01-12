/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.config;

import com.elektra.cadsumutils.dao.DataSources;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.boot.autoconfigure.jdbc.NamedParameterJdbcOperationsDependsOnPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 *
 * @author nroblerol
 */
@Configuration
public class AppConfig {
    @Bean
    AtomicLong requestID(){
        return new AtomicLong();
    }
    
    @Bean
    Boolean debug(){
        return true;
    }
    
    @Bean
    ObjectMapper parseJson(){
        return new ObjectMapper();
    }
    
    @Bean
    NamedParameterJdbcTemplate sccpConection(){
        return new DataSources().namedTemplate2010();
    }
    
    @Bean
    NamedParameterJdbcTemplate wm18Conection(){
        return new DataSources().namedTemplate2018();
    }
    
    @Bean
    NamedParameterJdbcTemplate dom18Conection(){
        return new DataSources().namedTemplateDom2018();
    }
}
