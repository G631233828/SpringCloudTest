package gjb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer 
public class Config3344APP {

	public static void main(String[] args) {
		SpringApplication.run(Config3344APP.class, args);
	}

}
