package com.kevll.context;


import com.kevll.beans.BeanDefinition;
import com.kevll.beans.factory.AbstractBeanFactory;
import com.kevll.beans.factory.AutowireCapableBeanFactory;
import com.kevll.beans.io.ResourceLoader;
import com.kevll.beans.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author yihua.huang@dianping.com
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	private String configLocation;

	public ClassPathXmlApplicationContext(String configLocation) throws Exception {
		this(configLocation, new AutowireCapableBeanFactory());
	}

	public ClassPathXmlApplicationContext(String configLocation, AbstractBeanFactory beanFactory) throws Exception {
		super(beanFactory);
		this.configLocation = configLocation;
		refresh();
		//ApplicationContext会默认实例化非懒加载的类
		//beanFactory.preInstantiateSingletons();	放到refresh中
	}

	@Override
//	public void refresh() throws Exception {	refresh中有更多的事要做
	protected void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
	}

}
