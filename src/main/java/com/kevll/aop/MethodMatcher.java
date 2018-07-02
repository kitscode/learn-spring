package com.kevll.aop;

import java.lang.reflect.Method;

/**
 * @author: kevin
 * @date: 2018/7/2
 * @description:
 */
public interface MethodMatcher {
    boolean matches(Method method, Class targetClass);
}
