package org.learn.ioc;

/**
 * @author kevin
 * @date 2018年3月5日
 */
public class BeanDefinition {
	
	private Object bean;

	public BeanDefinition(Object bean) {
		this.bean = bean;
	}

	public Object getBean() {
		return bean;
	}
}
