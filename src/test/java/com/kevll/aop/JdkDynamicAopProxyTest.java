package com.kevll.aop;

import com.kevll.HelloWorldService;
import com.kevll.HelloWorldServiceImpl;
import com.kevll.context.ApplicationContext;
import com.kevll.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author: kevin
 * @date: 2018/6/26
 * @description:
 */
public class JdkDynamicAopProxyTest {
    @Test
    public void testInterceptor() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");

        // 1. 设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldService.class);
        advisedSupport.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3. 创建代理(Proxy)
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();

        // 4. 基于AOP的调用
        helloWorldServiceProxy.helloWorld();

    }
}
