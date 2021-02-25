package mx.com.api.trknbr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "mx.com.api.trknbr.feign")
public class runner {

	public static void main(String[] args) {
		SpringApplication.run(runner.class, args);
	}
}
