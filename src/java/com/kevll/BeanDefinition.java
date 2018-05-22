package com.kevll;


/**
 * @author kevin
 * @date 2018年3月5日
 */
public class BeanDefinition {
	
	private Object bean;
	
	private Class beanClass;

	private String beanClassName;

	private PropertyValues propertyValues= new PropertyValues();
	
	public BeanDefinition() {
	
	}
	
	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
		try {
			this.beanClass = Class.forName(beanClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Object getBean() {
		return bean;
	}
	
	public void setBean(Object bean) {
		this.bean = bean;
	}
	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}
	
}