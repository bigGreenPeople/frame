package com.fj.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fj.domain.UserDao;

public class Demo {
	public static void main(String[] args) {
		//��������
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//�õ�bean
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		userDao.sayHello();
	}
}
