package com.kevll;

/**
 * @author: kevin
 * @date: 2018/7/12
 * @description:
 */
public class OutputServiceImpl implements OutputService {
    @Override
    public void output(String text) {
        System.out.println(text);
    }
}
