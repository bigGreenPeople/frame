package com.fj.demo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fj.domain.User;

public class Demo {
	@Test
	public void testIoc(){
		
		//∂¡»°≈‰÷√Œƒº˛
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		User user = (User) applicationContext.getBean("user");
		
		System.out.println(user);
	}
}
