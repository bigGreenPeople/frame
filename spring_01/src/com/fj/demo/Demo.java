package com.fj.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fj.createBean1.User;

public class Demo {
	public static void main(String[] args) {
		//º”‘ÿ≈‰÷√Œƒº˛
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//
		User user1 = (User) applicationContext.getBean("user1");
		User user2 = (User) applicationContext.getBean("user2");
		User user3 = (User) applicationContext.getBean("user3");
		
		System.out.println("user1 = "+user1);
		System.out.println("user2 = "+user2);
		System.out.println("user3 = "+user3);
	}
}
