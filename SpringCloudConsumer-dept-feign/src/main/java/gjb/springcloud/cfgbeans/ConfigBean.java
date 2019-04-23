package gjb.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {

	/**
	 * 使用restTemplate访问restful接口非常的简单
	 * （url,requestMap,ResponseBean.class）这三个参数分别代表了REST请求地址，请求参数，Http响应转换被转换的对象类型
	 * 
	 * @return
	 */
	@Bean
	@LoadBalanced // 默认采用的是轮询算法 Spring cloud Ribbon是基於Netflix Ribbon實現的一套客戶端负载均衡的工具
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * 
	 * @return
	 */
	@Bean
	public IRule myRule() {
		
		return new RetryRule();//先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务，自动会去除失败的服务器
		//return new RandomRule();//显示指定随机轮询
		//return new RoundRobinRule();//用我们重新选择的随机算法替换默认的轮询
	}

}
