package com.kevll.aop;

/**
 * @author: kevin
 * @date: 2018/7/2
 * @description:
 */
public interface ClassFilter {
    boolean matches(Class targetClass);
}
