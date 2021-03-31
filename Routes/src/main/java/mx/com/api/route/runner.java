package mx.com.api.route;

import mx.com.api.route.configuration.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableFeignClients(value = "mainRuta", basePackages = "mx.com.api.route.feign")
public class runner {

    public static void main(String[] args) {
        System.setProperty("puertoProperty", application.PORT);
        System.setProperty("nombreProyecto", application.NOMBRE_MSO);
        SpringApplication.run(runner.class, args);
    }

}
