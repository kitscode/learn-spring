package org.learn.ioc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 * @date 2018年3月5日
 */
public class BeanFactory {
	//String:bean name
	private Map<String,BeanDefinition> beanMap=new HashMap<>();
	
	public Object getBean(String name){
		return beanMap.get(name).getBean();
	}
	
	public void registerBean(String name,BeanDefinition definition){
		beanMap.put(name, definition);
	}
}
