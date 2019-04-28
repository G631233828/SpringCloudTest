package gjb.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gjb.springcloud.entities.Dept;
import gjb.springcloud.service.DeptClientService;

/**
 * 使用 了feign，这样就可以直接通过接口api进行调用，不需要再通过restTemplate来进行调用了。
 * @author fliay
 *
 */
@RestController
public class DeptController_Consumer {

	/**
	 * SpringCloudService-api->gjb.springcloud.service.DeptClientService
	 */
	@Autowired
	private DeptClientService deptClientService;
	
	
	@RequestMapping(value = "consumer/dept/add")
	public boolean add(Dept dept) {
		return deptClientService.add(dept);
	}

	@RequestMapping(value = "consumer/dept/get/{id}")
	public Dept get(@PathVariable(value = "id") String id) {
		return deptClientService.get(Long.valueOf(id));
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "consumer/dept/list")
	public List<Dept> list() {
		return deptClientService.list();
	}


}
