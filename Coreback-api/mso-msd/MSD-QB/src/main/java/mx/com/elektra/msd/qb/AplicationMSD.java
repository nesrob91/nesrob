package mx.com.elektra.msd.qb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("mx")
public class AplicationMSD {

	public static void main(String[] args) {
		SpringApplication.run(AplicationMSD.class, args);
	}

}

