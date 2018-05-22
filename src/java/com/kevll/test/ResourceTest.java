package com.kevll.test;

import org.junit.Test;

import java.net.URL;

/**
 * @author: kevin
 * @date: 2018/5/22
 * @description:
 */
public class ResourceTest {
    @Test
    public void test(){
        URL resource = getClass().getClassLoader().getResource("beans.xml.xml");
        System.out.println(resource);
    }

    public static void main(String[] args) {
        URL resource = new ResourceTest().getClass().getClassLoader().getResource("beans.xml.xml");
        System.out.println(resource);
    }
}
