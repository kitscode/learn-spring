package com.kevll.factory;

import com.kevll.BeanDefinition;


/**
 * @author kevin
 * @date 2018年3月6日
 */
public interface BeanFactory {
	
	Object getBean(String name) throws Exception;

	void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
