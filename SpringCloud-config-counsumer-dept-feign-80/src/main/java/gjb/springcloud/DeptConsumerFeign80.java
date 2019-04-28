package gjb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient // 客戶端
@EnableHystrix //开启Hystrix支持
@EnableFeignClients(basePackages = { "gjb.springcloud" })
@ComponentScan("gjb.springcloud")
public class DeptConsumerFeign80 {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumerFeign80.class, args);
	}

}
