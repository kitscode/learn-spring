package org.learn.ioc.factory;

import org.learn.ioc.BeanDefinition;


/**
 * @author kevin
 * @date 2018年3月6日
 */
public interface BeanFactory {
	
	Object getBean(String name);

	void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
