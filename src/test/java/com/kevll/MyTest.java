package com.kevll;

import com.kevll.io.ResourceLoader;
import com.kevll.xml.XmlBeanDefinitionReader;
import org.junit.Test;
import com.kevll.factory.AutowireCapableBeanFactory;
import com.kevll.factory.BeanFactory;

import java.util.Map;

/**
 * @author kevin
 * @date 2018年3月5日
 */
public class MyTest {
	@Test
	public void test() throws Exception {
		// 1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("beans.xml");

		// 2.初始化BeanFactory并注册bean
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}

		// 3.获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloSpring();

	}
}
