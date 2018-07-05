package com.kevll.aop.interfaces;

/**
 * @author: kevin
 * @date: 2018/7/4
 * @description:
 */
public interface PointcutAdvisor extends Advisor {

    Pointcut getPointcut();
}
