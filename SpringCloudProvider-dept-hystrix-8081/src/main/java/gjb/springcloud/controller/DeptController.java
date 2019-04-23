package gjb.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import gjb.springcloud.entities.Dept;
import gjb.springcloud.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;

	@Autowired
	private DiscoveryClient client;// 服务发现

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	@HystrixCommand(fallbackMethod = "processHystrix_add")
	public boolean add(@RequestBody Dept dept) {
		return deptService.addDept(dept);
	}

	/**
	 * 比如说：在方法被调用的时候，如果id传1的是能返回数据，但是如果id传入的值在数据库中是不存在的，那么我们
	 * 通过人为的方式抛出了一个运行时异常。同时HystrixCommand会执行调用fallback指定的方法 procesHystrix_get
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_get") 
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = deptService.findById(id);
		if (null == dept) {
			throw new RuntimeException("ID:" + id + "没有对应的内容。");
		}
		return dept;
	}
	public Dept processHystrix_get(@PathVariable("id") Long id) {
		
		
		return new Dept().setDeptno(id).setDbname("无法找到ID："+id+",所对应的数据").setDb_source("no database in MySql");
	}
	
	
	
	
	
	
	
	
	

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> getlist() {
		return deptService.findAll();
	}

	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery() {
		List<String> list = client.getServices();
		System.out.println("***************" + list);
		List<ServiceInstance> serlist = client.getInstances("springclout-dept");
		for (ServiceInstance element : serlist) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}
