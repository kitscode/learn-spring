package com.kevll.test;

/**
 * @author kevin
 * @date 2018年3月5日
 */
public class HelloWorldService {
	
	private String text;

	public void helloSpring(){
		System.out.println(text);
	}
	
    public void setText(String text) {
        this.text = text;
    }
}
