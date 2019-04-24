package gjb.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gjb.springcloud.entities.Dept;

/**
 * 
 * @author fliay 修改api 根据已经有的DeptClientService接口新建实现
 *         实现FallbackFactory接口的类DeptClientServiceFallbackFactory
 *         将所有的需要进行熔断的交给了DeptClientServiceFallbackFactory来进行处理
 *
 *
 */

//@FeignClient(value = "SPRINGCLOUD-DEPT")// 未使用熔断hystrix使用这个
@FeignClient(value = "SPRINGCLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

}
