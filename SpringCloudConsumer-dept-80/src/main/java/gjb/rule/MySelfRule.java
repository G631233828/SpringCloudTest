//package gjb.rule;
//
//import org.springframework.context.annotation.Configuration;
//
//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.AbstractLoadBalancerRule;
//import com.netflix.loadbalancer.ILoadBalancer;
//import com.netflix.loadbalancer.Server;
//
///**
// * 自定义 ribbon规则
// * 
// * @author fliay
// *
// */
//@Configuration
//public class MySelfRule extends AbstractLoadBalancerRule {
//
//	//total = 0  //当 total ==5 以后，我们指针才能往下走
//	//index = 0  //当前对外提供服务的服务器地址
//	//total 需要重新置为 0  ，但是已经达到过一个5次 ， 我们的index =1
//	private int total = 0; // 总共被调用的次数，目前要求每台被调用5次
//	private int currrentIndex = 0; // 当前提供服务的机器号
//
//	/*
//	 * @Bean public IRule myRule() {
//	 * 
//	 * return new
//	 * RetryRule();//先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务，
//	 * 自动会去除失败的服务器 }
//	 */
//
//	public Server choose(ILoadBalancer lb, Object key) {
//
//		if (lb == null) {
//			return null;
//		}
//		Server server = null;
//
//		while (server == null) {
//			if (Thread.interrupted()) {
//				return null;
//			}
//			
//			
//			
//			
//
//		}
//
//	}
//
//	@Override
//	public Server choose(Object key) {
//		return choose(getLoadBalancer(), key);
//	}
//
//	@Override
//	public void initWithNiwsConfig(IClientConfig clientConfig) {
//	}
//
//}
