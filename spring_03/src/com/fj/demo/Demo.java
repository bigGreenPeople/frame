package com.fj.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fj.domain.UserDao;

public class Demo {
	public static void main(String[] args) {
		//º”‘ÿ≈‰÷√
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//µ√µΩbean
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		userDao.sayHello();
	}
}
