package com.guang.webtest.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.activiti.engine.impl.persistence.StrongUuidGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guang.webtest.bean.BaseBean;
import com.guang.webtest.bean.impl.DemoBean;
import com.guang.webtest.domain.User;
import com.guang.webtest.service.impl.SimpleService;
import com.guang.webtest.task.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring-*.xml"})
@ActiveProfiles("test")
public class TestSystemService {
	@Autowired
	private SystemService service;
	@Autowired
	private LookupService lookupService;
	@Autowired
	@Qualifier("factory")
	private BaseBean baseBean;
	@Autowired
	@Qualifier("b")
	private SubService subService;
	@Autowired
	private BaseBean parentBean;
	@Autowired
	private BaseBean childBean;
	@Autowired
	private UserService userService;
	@Autowired
	private User user;
	@Autowired
	private Task task;
	@Autowired
	private SimpleService simpleService;
	
	@Test
	public void testPrintKeyLoadMessage(){
		service.printKeyLoadMessage();
	}
	
	/**
	 * bean属性lookup-method，方法注入
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年2月15日上午10:23:40
	 * @since 1.0.0
	 */
	@Test
	public void testLookupMethod(){
		lookupService.getSubService().printOK();
		lookupService.getSubService().printOK();
	}
	
	/**
	 * bean属性replaced-method，方法替换
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年2月15日上午10:24:31
	 * @since 1.0.0
	 */
	@Test
	public void testReplaceMethod(){
		service.replaceMethod("yark",5);
		service.replaceMethod2();
	}
	
	/**
	 * bean属性facotory-method和factory-bean，工厂模式
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年2月15日上午10:25:34
	 * @since 1.0.0
	 */
	@Test
	public void testFactoryMethod(){
		baseBean.printOk();
	}
	
	/**
	 * bean元素qualifier，
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年2月15日上午10:26:32
	 * @since 1.0.0
	 */
	@Test
	public void testQualifier(){
		subService.printOK();
	}
	
	/**
	 * array属性merge，子bean继承父bean集合元素
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年2月15日上午10:37:53
	 * @since 1.0.0
	 */
	@Test
	public void testMerge(){
		parentBean.printOk();
		System.out.println("***********");
		childBean.printOk();
	}
	
	@Test
	public void testSpringConfigured(){
		User user = new User();
		user.printOk();
	}
	
	/**
	 * 测试事务回滚
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年2月22日下午3:23:40
	 * @since 1.0.0
	 */
	@Test
	public void testTransaction(){
		User user = new User();
		user.setId(1);
		user.setName("test");
		user.setSex('1');
		userService.addUser(user);
	}
	
	/**
	 * 测试spring-util标签
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年2月22日下午3:25:28
	 * @since 1.0.0
	 */
	@Test
	public void testUtil(){
		System.out.println(user.getName());
		System.out.println(user.getId());
		System.out.println(Integer.MAX_VALUE);
	}
	
	/**
	 * 测试spring-task中的标签
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年2月23日上午10:15:22
	 * @since 1.0.0
	 */
	@Test
	public void testTask() throws InterruptedException, ExecutionException{
		System.out.println("invoke a asynchronous method "+Thread.currentThread().getName());
		task.asyncMethodwithVoidReturnType();
		Future<String> future = task.asyncMethodwithReturnType();
		while(true){
			if (future.isDone()) {
				System.out.println("result from future:"+future.get());
				break;
			}
			System.out.println("continue doing something else");
			Thread.sleep(2000);
		}
	}
	@Test
	public void testLogAop(){
		simpleService.test(1);
		simpleService.core(2);
		simpleService.work(3);
	}
	/**测试context:load-time-weaver
	 * @param args
	 * @exception
	 * @author zhouchenguang
	 * @date 2017年2月16日下午3:01:37
	 * @since 1.0.0
	 */
	public static void main(String[] args){
		StrongUuidGenerator generator = new StrongUuidGenerator();
		System.out.println(generator.getNextId());
	}
}
