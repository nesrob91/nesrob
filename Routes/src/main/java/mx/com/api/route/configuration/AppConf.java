/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.configuration;

import com.elektra.cadsumutils.dao.DataSources;
import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.util.concurrent.atomic.AtomicLong;
import mx.com.api.route.beans.ConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 *
 * @author nroblerol
 */
@Configuration
public class AppConf {
    @Bean
    ConfigBean configuration(){
        return new ConfigBean();
    }
    
    @Bean
    AtomicLong idRequest(){
        return new AtomicLong();
    }
    
    @Bean
    NamedParameterJdbcTemplate sccpConnection(){
        return new DataSources().namedTemplate2010();
    }
    
    @Bean
    NamedParameterJdbcTemplate wm18Connection(){
        return new DataSources().namedTemplate2018();
    }
    
    @Bean
    NamedParameterJdbcTemplate dom18Connection(){
        return new DataSources().namedTemplateDom2018();
    }
    
    @Bean
    LogsPaqueterias logger(){
        return new LogsPaqueterias();
    }
}
