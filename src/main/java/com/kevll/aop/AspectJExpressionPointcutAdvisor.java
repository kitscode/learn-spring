package com.kevll.aop;

import com.kevll.aop.interfaces.Pointcut;
import com.kevll.aop.interfaces.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @author: kevin
 * @date: 2018/7/4
 * @description:
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut=new AspectJExpressionPointcut();

    private Advice advice;

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.pointcut.setExpression(expression);
    }
}
