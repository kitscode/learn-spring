package com.kevll.factory;

import com.kevll.BeanDefinition;
import com.kevll.PropertyValue;
import java.lang.reflect.Field;

/**
 * @author kevin
 * @date 2018年3月6日
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
		Object bean = createBeanInstatnce(beanDefinition);
		setProperties(bean, beanDefinition);
		return bean;
	}

	protected Object createBeanInstatnce(BeanDefinition beanDefinition)
			throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}
	
	protected void setProperties(Object bean,BeanDefinition bd) throws Exception{
		for (PropertyValue propertyValue : bd.getPropertyValues().getPropertyValues()) {
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			declaredField.setAccessible(true);
			declaredField.set(bean, propertyValue.getValue());
		}
	}
}
