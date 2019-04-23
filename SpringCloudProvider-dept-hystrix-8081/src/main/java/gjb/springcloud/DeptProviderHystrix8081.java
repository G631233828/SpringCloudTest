package gjb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//本服务启动之后会自动注册金eureka服务中
@EnableDiscoveryClient//服务发现
@EnableCircuitBreaker  //对Hystrix熔断器的支持
public class DeptProviderHystrix8081 {

	public static void main(String[] args) {
		SpringApplication.run(DeptProviderHystrix8081.class, args);
	}

}
