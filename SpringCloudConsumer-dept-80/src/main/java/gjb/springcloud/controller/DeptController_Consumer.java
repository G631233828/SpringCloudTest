package gjb.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import gjb.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {

	@Autowired
	private RestTemplate restTemplate;

//	private static final String REST_URL_PREFIX = "http://localhost:8081";
	private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-DEPT";//配置正式微服务

	@RequestMapping(value = "consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
	}

	@RequestMapping(value = "consumer/dept/get/{id}")
	public Dept add(@PathVariable(value = "id") String id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
	}

	@RequestMapping(value = "consumer/dept/discovery")
	public Object discovery() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
	}

}
