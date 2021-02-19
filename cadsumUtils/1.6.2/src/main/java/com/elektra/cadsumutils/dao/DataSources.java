/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author dparra
 */
@Configuration
public class DataSources {
    
    private DriverManagerDataSource conexionInfoCd() {
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS_LIST = (LOAD_BALANCE = off)  (FAILOVER = ON) (ADDRESS = (PROTOCOL = TCP)(HOST = 10.82.26.56)(PORT = 1521)) (ADDRESS = (PROTOCOL = TCP)(HOST = 10.82.26.57)(PORT = 1521)))(CONNECT_DATA = (SERVER = DEDICATED)(SERVICE_NAME = LECTURA_SCPP)(FAILOVER_MODE =(TYPE = SELECT) (METHOD = BASIC) (BACKUP = LECTURA_SCPP) (RETRIES = 180)  (DELAY = 5))))");
        dataSource.setUsername("info_cd");
        dataSource.setPassword("info_cd_22_fhrt");

        return dataSource;
    }
    
    private DriverManagerDataSource conexionWm2018() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS_LIST = (LOAD_BALANCE = off)  (FAILOVER = ON) (ADDRESS = (PROTOCOL = TCP)(HOST = 10.54.75.87)(PORT = 1521)) )(CONNECT_DATA = (SERVER = DEDICATED)(SERVICE_NAME = manbdqa)(FAILOVER_MODE =(TYPE = SELECT) (METHOD = BASIC)  (RETRIES = 180)  (DELAY = 5))))");
        dataSource.setUsername("LECTURA_CADSUM_DIST");
        dataSource.setPassword("C4DSUMD1ST");

        return dataSource;
    }
    
    private DriverManagerDataSource conexionWm2018Upd() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS_LIST = (LOAD_BALANCE = off)  (FAILOVER = ON) (ADDRESS = (PROTOCOL = TCP)(HOST = 10.54.75.87)(PORT = 1521)) )(CONNECT_DATA = (SERVER = DEDICATED)(SERVICE_NAME = manbdqa)(FAILOVER_MODE =(TYPE = SELECT) (METHOD = BASIC)  (RETRIES = 180)  (DELAY = 5))))");
        dataSource.setUsername("WMR_SSD_ELEKDIS");
        dataSource.setPassword("u5r3L3kWmRDe54");

        return dataSource;
    }
    
    private DriverManagerDataSource conexionDom2018() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS_LIST = (LOAD_BALANCE = off)  (FAILOVER = ON) (ADDRESS = (PROTOCOL = TCP)(HOST = 10.54.75.87)(PORT = 1521)) )(CONNECT_DATA = (SERVER = DEDICATED)(SERVICE_NAME = manbdqa)(FAILOVER_MODE =(TYPE = SELECT) (METHOD = BASIC)  (RETRIES = 180)  (DELAY = 5))))");
        dataSource.setUsername("LECTURA_CADSUM_DIST");
        dataSource.setPassword("C4DSUMD1ST");

        return dataSource;
    }
    
    /*
    @Bean(name = "jdbcTemplate2010")
    public JdbcTemplate jdbcTemplate2010(){
        return new JdbcTemplate(conexionInfoCd());
    }*/
    @Bean(name = "namedTemplate2010")
    public NamedParameterJdbcTemplate namedTemplate2010(){
        return new NamedParameterJdbcTemplate(conexionInfoCd());
    }
    
    @Bean(name = "namedTemplate2018")
    public NamedParameterJdbcTemplate namedTemplate2018(){
        return new NamedParameterJdbcTemplate(conexionWm2018());
    }
    
    @Bean(name = "namedTemplateDom2018")
    public NamedParameterJdbcTemplate namedTemplateDom2018(){
        return new NamedParameterJdbcTemplate(conexionDom2018());
    }
    
    @Bean(name = "namedTemplate2018Upd")
    public NamedParameterJdbcTemplate namedTemplate2018Upd(){
        return new NamedParameterJdbcTemplate(conexionWm2018Upd());
    }
}
