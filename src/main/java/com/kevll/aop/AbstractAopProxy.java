package com.kevll.aop;

import com.kevll.aop.interfaces.AopProxy;

/**
 * @author: kevin
 * @date: 2018/7/5
 * @description:
 */
public abstract class AbstractAopProxy implements AopProxy {
    protected AdvisedSupport advised;

    public AbstractAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }
}
