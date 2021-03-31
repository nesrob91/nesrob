package mx.com.api.trknbr;

import mx.com.api.trknbr.configuration.application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableFeignClients(value = "main",basePackages = "mx.com.api.trknbr.feign")
public class runner {

    public static void main(String[] args) {
        System.setProperty("nombreProyecto", application.NOMBRE_MSO);
        System.setProperty("puertoProperty", application.PORT);
        SpringApplication.run(runner.class, args);
    }
}
