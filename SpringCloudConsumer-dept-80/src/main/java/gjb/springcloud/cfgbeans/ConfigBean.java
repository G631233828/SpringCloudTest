package gjb.springcloud.cfgbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

	/**
	 * 使用restTemplate访问restful接口非常的简单
	 * （url,requestMap,ResponseBean.class）这三个参数分别代表了REST请求地址，请求参数，Http响应转换被转换的对象类型
	 * 
	 * @return
	 */
	
	@Autowired
	private RestTemplateBuilder builder;
	
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
      return builder.build();
    }
}
