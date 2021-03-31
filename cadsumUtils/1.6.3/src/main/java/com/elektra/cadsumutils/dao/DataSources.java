/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author dparra
 */
@Configuration
@PropertySources({
    @PropertySource("classpath:data.properties")
})
public class DataSources {
    @Value("${datasource.um.url}")
    private String dbUrlUM;
    @Value("${datasource.um.username}")
    private String dbUserUM;
    @Value("${datasource.um.password}")
    private String dbAuthUM;
    @Value("${datasource.um.driver-class-name}")
    private String dbDriverUM;

    @Value("${datasource.scpp.url}")
    private String dbUrlScpp;
    @Value("${datasource.scpp.username}")
    private String dbUserScpp;
    @Value("${datasource.scpp.password}")
    private String dbAuthScpp;
    @Value("${datasource.scpp.driver-class-name}")
    private String dbDriverScpp;
    
    @Value("${datasource.wm18.url}")
    private String dbUrlWm18;
    @Value("${datasource.wm18.username}")
    private String dbUserWm18;
    @Value("${datasource.wm18.password}")
    private String dbAuthWm18;
    @Value("${datasource.wm18.driver-class-name}")
    private String dbDriverWm18;
    
    @Value("${datasource.dom18.url}")
    private String dbUrlDom18;
    @Value("${datasource.dom18.username}")
    private String dbUserDom18;
    @Value("${datasource.dom18.password}")
    private String dbAuthDom18;
    @Value("${datasource.dom18.driver-class-name}")
    private String dbDriverDom18;
    
    @Value("${datasource.wm18updt.url}")
    private String dbUrlWm18updt;
    @Value("${datasource.wm18updt.username}")
    private String dbUserWm18updt;
    @Value("${datasource.wm18updt.password}")
    private String dbAuthWm18updt;
    @Value("${datasource.wm18updt.driver-class-name}")
    private String dbDriverWm18updt;
    
    private DriverManagerDataSource conexionUM() {
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbDriverUM);
        dataSource.setUrl(dbUrlUM);
        dataSource.setUsername(dbUserUM);
        dataSource.setPassword(dbAuthUM);
        return dataSource;
    }
    
    private DriverManagerDataSource conexionInfoCd() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbDriverScpp);
        dataSource.setUrl(dbUrlScpp);
        dataSource.setUsername(dbUserScpp);
        dataSource.setPassword(dbAuthScpp);
        return dataSource;
    }
    
    private DriverManagerDataSource conexionWm2018() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbDriverWm18);
        dataSource.setUrl(dbUrlWm18);
        dataSource.setUsername(dbUserWm18);
        dataSource.setPassword(dbAuthWm18);
        return dataSource;
    }
    
    private DriverManagerDataSource conexionWm2018Upd() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbDriverWm18updt);
        dataSource.setUrl(dbUrlWm18updt);
        dataSource.setUsername(dbUserWm18updt);
        dataSource.setPassword(dbAuthWm18updt);
        return dataSource;
    }
    
    private DriverManagerDataSource conexionDom2018() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbDriverDom18);
        dataSource.setUrl(dbUrlDom18);
        dataSource.setUsername(dbUserDom18);
        dataSource.setPassword(dbAuthDom18);
        return dataSource;
    }
    
    /*
    @Bean(name = "jdbcTemplate2010")
    public JdbcTemplate jdbcTemplate2010(){
        return new JdbcTemplate(conexionInfoCd());
    }*/
    
    @Bean(name = "um")
    public NamedParameterJdbcTemplate namedTemplateUM(){
        return new NamedParameterJdbcTemplate(conexionUM());
    }
    
    @Bean(name = "scpp")
    public NamedParameterJdbcTemplate namedTemplate2010(){
        return new NamedParameterJdbcTemplate(conexionInfoCd());
    }
    
    @Bean(name = "wm18")
    public NamedParameterJdbcTemplate namedTemplate2018(){
        return new NamedParameterJdbcTemplate(conexionWm2018());
    }
    
    @Bean(name = "dom18")
    public NamedParameterJdbcTemplate namedTemplateDom2018(){
        return new NamedParameterJdbcTemplate(conexionDom2018());
    }
    
    @Bean(name = "wm18upd")
    public NamedParameterJdbcTemplate namedTemplate2018Upd(){
        return new NamedParameterJdbcTemplate(conexionWm2018Upd());
    }
}

