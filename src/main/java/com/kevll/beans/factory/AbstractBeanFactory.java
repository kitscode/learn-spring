package com.kevll.beans.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.kevll.beans.BeanDefinition;
import com.kevll.beans.BeanPostProcessor;

/**
 * @author kevin
 * @date 2018年3月6日
 */
public abstract class AbstractBeanFactory implements BeanFactory {

	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	private final List<String> beanDefinitionNames = new ArrayList<String>();

	private List<BeanPostProcessor> beanPostProcessors=new ArrayList<BeanPostProcessor>();

	@Override
	public Object getBean(String name) throws Exception{
		BeanDefinition beanDefinition = beanDefinitionMap.get(name);
		if (beanDefinition == null) {
			throw new IllegalArgumentException("No bean named " + name + " is defined");
		}
		Object bean = beanDefinition.getBean();
		if (bean == null) {
			bean = doCreateBean(beanDefinition);
            bean = initializeBean(bean, name);//植入BeanProcessor
			beanDefinition.setBean(bean);//用代理类代替原来的类
		}
		return bean;
	}

	protected Object initializeBean(Object bean, String name) throws Exception{
		for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
			bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
		}

		for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
			bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
		}
		return bean;
	}

	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception{
//        Object bean = doCreateBean(beanDefinition);此方法被延后，为了实现懒加载
//        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
	}

	//预加载
	public void preInstantiateSingletons() throws Exception {
		for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
			String beanName = (String) it.next();
			getBean(beanName);
		}
	}

	protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

	public List getBeansForType(Class type) throws Exception{
		List beans=new ArrayList();
		//根据给定class在xml中定义过的bean当中遍历，取出能实例化这个class的bean
		for(String beanDefinitonName:beanDefinitionNames){
			//isAssignableFrom -> type是否是getBeanClass的相同类或接口，或是父类或父接口
			if(type.isAssignableFrom(beanDefinitionMap.get(beanDefinitonName).getBeanClass())){
				beans.add(getBean(beanDefinitonName));
			}
		}
		return beans;
	}

	public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception{
		this.beanPostProcessors.add(beanPostProcessor);
	}
}
