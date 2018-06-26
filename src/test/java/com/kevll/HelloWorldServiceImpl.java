package com.kevll;

/**
 * @author kevin
 * @date 2018年3月5日
 */
public class HelloWorldServiceImpl implements HelloWorldService{
	
	private String text;

	private OutputService outputService;

	public void helloWorld(){
		outputService.output(text);
	}

    public void setText(String text) {
        this.text = text;
    }
}
