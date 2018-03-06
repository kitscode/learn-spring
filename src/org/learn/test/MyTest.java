package org.learn.test;

import org.junit.Test;
import org.learn.ioc.BeanDefinition;
import org.learn.ioc.factory.AutowireCapableBeanFactory;
import org.learn.ioc.factory.BeanFactory;

/**
 * @author kevin
 * @date 2018年3月5日
 */
public class MyTest {
	@Test
	public void testFactory() throws Exception {
		//initialize bean factory
		BeanFactory beanFactory=new AutowireCapableBeanFactory();
		
		//register to beanFactory						
		BeanDefinition beanDefinition=new BeanDefinition();
		beanDefinition.setBeanClassName("org.learn.test.HelloSerive");
		beanFactory.registerBeanDefinition("helloService",beanDefinition);
		
		//get bean and invoke helloSping method
		//获得bean都通过bean工厂
		HelloSerive helloSerive = (HelloSerive) beanFactory.getBean("helloService");
		helloSerive.helloSpring();
	}
}
