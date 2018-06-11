package com.kevll.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.kevll.BeanDefinition;

/**
 * @author kevin
 * @date 2018年3月6日
 */
public abstract class AbstractBeanFactory implements BeanFactory {

	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	
	@Override
	public Object getBean(String name) {
		return beanDefinitionMap.get(name).getBean();
	}

	@Override
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception{
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
	}

	protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
