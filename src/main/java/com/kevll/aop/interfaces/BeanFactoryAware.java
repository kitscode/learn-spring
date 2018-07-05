package com.kevll.aop.interfaces;

import com.kevll.beans.factory.BeanFactory;

/**
 * @author: kevin
 * @date: 2018/7/3
 * @description:
 */
public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
