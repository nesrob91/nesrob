/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.configuration;

import com.elektra.cadsumutils.dao.DataSources;
import com.elektra.cadsumutils.logs.error.LogsPaqueterias;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PreDestroy;
import mx.elektra.dependencias.enums.Nivel;
import mx.elektra.dependencias.service.EscribirLog;
import mx.elektra.dependencias.service.impl.EscribirLogImpl;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
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
    EscribirLog bitacora(){
        return new EscribirLogImpl();
    }
    
    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
        return factory -> {
            factory.setContextPath(application.SERVER_CONTEXT);
            factory.setPort(Integer.valueOf(application.PORT));
                };
    };
    
    @Bean
    AtomicLong idRequest() {
        bitacora().escribir(this.getClass(), Nivel.INFORMATIVO, "Initializating WS");
        Integer appYear=Calendar.getInstance().get(Calendar.YEAR);
        try{
            Map<String,Object> param=new HashMap<>();
            param.put("anio",appYear);
            param.put("app","wsguia");
            String sql = "select to_char(sysdate,'yyyy')||lpad(valornum,12,0) fol\n" +
                "from info_cd.param_gen_rutas\n" +
                "where aplicacion = :app\n" +
                "and valornum2 = :anio\n" +
                "and status = 'A'";
            String string=sccpConnection().queryForObject(sql, param, String.class);
            return new AtomicLong(Long.valueOf(string));
        }catch(Exception e){
            //System.out.println("Error creating fol "+e.getMessage());
            bitacora().escribir(this.getClass(), Nivel.ERROR, "Initializated with default");
            return new AtomicLong(Long.valueOf(appYear.toString().concat("000000000000")));
        }
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
    LogsPaqueterias logger() {
        return new LogsPaqueterias();
    }
    
    @PreDestroy
    public void onShutDown() {
        int updated=0;
        try{
            Map<String,Object> param=new HashMap<>();
            param.put("anio",Calendar.getInstance().get(Calendar.YEAR));
            param.put("app","wsguia");
            param.put("actual",idRequest().toString().substring(4));
            String sql = "update info_cd.param_gen_rutas set valornum = :actual\n" +
                "where aplicacion = :app\n" +
                "and valornum2 = :anio\n" +
                "and status = 'A'";
            updated=sccpConnection().update(sql, param);
        }catch(Exception e){
            //System.out.println("Error "+e.getMessage());
            bitacora().escribir(this.getClass(), Nivel.ERROR, "Terminating WS - ".concat(idRequest().toString()));
        }
        bitacora().escribir(this.getClass(), Nivel.INFORMATIVO, "Terminated WS");
        //System.out.println("closing application context..let's do the final resource cleanup "+updated);
    }
}
