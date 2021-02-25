/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr;

import com.elektra.cadsumutils.dao.DataSources;
import mx.com.api.trknbr.beans.ConfigBean;
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
    ConfigBean debug(){
        return new ConfigBean();
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
