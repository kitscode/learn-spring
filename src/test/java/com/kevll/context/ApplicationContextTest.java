package com.kevll.context;

import com.kevll.HelloWorldService;
import org.junit.Test;

/**
 * @author: kevin
 * @date: 2018/6/19
 * @description:
 */
public class ApplicationContextTest {
    @Test
    public void test() throws Exception{
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        HelloWorldService helloWorldService =(HelloWorldService) applicationContext.getBean("helloWorldService");
        helloWorldService.helloWorld();
    }
}
