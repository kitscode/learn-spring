package com.kevll.aop;

import com.kevll.aop.interfaces.BeanFactoryAware;
import com.kevll.beans.BeanPostProcessor;
import com.kevll.beans.factory.AbstractBeanFactory;
import com.kevll.beans.factory.BeanFactory;
import org.aopalliance.intercept.MethodInterceptor;

import java.util.List;

/**
 * @author: kevin
 * @date: 2018/7/3
 * @description: 通过Pointcut筛选需要切入的方法，并BeanProcessor将代理类植入bean的创建过程，
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor,BeanFactoryAware {
    private AbstractBeanFactory beanFactory;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
       return null;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {

    }
}
