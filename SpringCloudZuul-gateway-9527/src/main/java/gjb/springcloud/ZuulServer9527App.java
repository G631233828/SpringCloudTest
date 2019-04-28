package gjb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulServer9527App {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServer9527App.class, args);
	}

}
