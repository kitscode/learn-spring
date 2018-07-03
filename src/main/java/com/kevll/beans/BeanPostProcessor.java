package com.kevll.beans;

/**
 * @author: kevin
 * @date: 2018/7/3
 * @description:
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;

    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
