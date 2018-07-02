package com.kevll.aop;

import com.kevll.HelloWorldService;
import com.kevll.HelloWorldServiceImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author: kevin
 * @date: 2018/7/2
 * @description:
 */
public class AspectJExpressionPointcutTest {
    /**
     * 方法匹配判断
     */

    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.kevll.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.kevll.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"),HelloWorldServiceImpl.class);
        Assert.assertTrue(matches);
    }
}
