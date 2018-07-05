package com.kevll.aop.interfaces;

/**
 * @author: kevin
 * @date: 2018/7/2
 * @description:
 */
public interface Pointcut {
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
