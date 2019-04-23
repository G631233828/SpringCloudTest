package gjb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//客戶端
//@RibbonClient(name="SPRINGCLOUD-DEPT",configuration=MySelfRule.class)
public class DeptConsumer80 {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer80.class, args);
	}

}
