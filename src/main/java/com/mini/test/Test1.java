package com.mini.test;

import com.mini.beans.NoSuchBeanDefinitionException;
import com.mini.context.ClassPathXmlApplicationContext;
import lombok.extern.java.Log;

@Log
public class Test1 {

	public static void main(String[] args) throws NoSuchBeanDefinitionException {
		log.info("running Test1");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
	    AService aService=(AService)ctx.getBean("aService");
	    aService.sayHello();
	}
}
