package mx.com.elektra.mso.cb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("mx")
public class MsoApplication {

    public static void main(String[] args) {
        System.setProperty("puertoProperty", "10443");
        SpringApplication.run(MsoApplication.class, args);
    }

}
