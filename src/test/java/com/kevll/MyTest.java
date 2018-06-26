package com.kevll;

import com.kevll.beans.BeanDefinition;
import com.kevll.beans.io.ResourceLoader;
import com.kevll.beans.xml.XmlBeanDefinitionReader;
import org.junit.Test;
import com.kevll.beans.factory.AutowireCapableBeanFactory;

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
		AutowireCapableBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}

		beanFactory.preInstantiateSingletons();//预加载，关闭就是懒加载，在显示地getBean()时才去加载Bean

		// 3.获取bean
		HelloWorldServiceImpl helloWorldService = (HelloWorldServiceImpl) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();

	}
}
