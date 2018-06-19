package com.kevll.beans.factory;

import com.kevll.beans.BeanDefinition;
import com.kevll.beans.BeanReference;
import com.kevll.beans.PropertyValue;
import java.lang.reflect.Field;

/**
 * @author kevin
 * @date 2018年3月6日
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
		Object bean = createBeanInstatnce(beanDefinition);
		beanDefinition.setBean(bean);//懒加载，Bean的set改到了这
		setProperties(bean, beanDefinition);
		return bean;
	}

	protected Object createBeanInstatnce(BeanDefinition beanDefinition) throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}
	
	protected void setProperties(Object bean,BeanDefinition mbd) throws Exception{
		for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValues()) {
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			declaredField.setAccessible(true);
			Object value = propertyValue.getValue();
			if (value instanceof BeanReference) {
				BeanReference beanReference = (BeanReference) value;
				value = getBean(beanReference.getName());
			}
			declaredField.set(bean, value);
		}
	}
}
