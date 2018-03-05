package org.learn.test;

import org.junit.Test;
import org.learn.ioc.BeanDefinition;
import org.learn.ioc.BeanFactory;

/**
 * @author kevin
 * @date 2018年3月5日
 */
public class MyTest {
	@Test
	public void testFactory() throws Exception {
		//initialize bean factory
		BeanFactory beanFactory=new BeanFactory();
		//register to beanFactory							     //Definition中包含了真正的实体
		beanFactory.registerBean("helloService", new BeanDefinition(new HelloSerive()));
		//get bean and invoke helloSping method
		//获得bean都通过bean工厂
		HelloSerive helloSerive = (HelloSerive) beanFactory.getBean("helloService");
		helloSerive.helloSpring();
	}
}
