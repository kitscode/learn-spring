package com.kevll;

import org.junit.Test;

/**
 * @author: kevin
 * @date: 2018/6/12
 * @description:
 */
public class BeanReferenceTest {

    @Test
    public void test(){
        Object o=new Object();
        System.out.println(o instanceof BeanReference);
        HelloWorldService service=new HelloWorldService();
//        System.out.println(service instanceof BeanReference);
    }
}
