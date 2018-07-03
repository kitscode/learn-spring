package com.kevll.context;

import com.kevll.beans.BeanPostProcessor;
import com.kevll.beans.factory.AbstractBeanFactory;

import java.util.List;

/**
 * @author: kevin
 * @date: 2018/6/19
 * @description:
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception{
        loadBeanDefinitions(beanFactory);
        registerBeanPostProcessors(beanFactory);
        beanFactory.preInstantiateSingletons();
    }

    protected abstract void loadBeanDefinitions(AbstractBeanFactory beanFactory) throws Exception;

    //向BeanFactory中注入BeanProcessor
    protected void registerBeanPostProcessors(AbstractBeanFactory beanFactory) throws Exception{
        List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
