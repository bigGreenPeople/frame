package com.fj.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fj.service.UserService;

public class Demo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) context.getBean("userService");
//		System.out.println(userService);
//		userService.saveUser();
//		userService.deleteUser();
//		userService.updateUser();
//		userService.queryUser();
		userService.queryUserList();
	}
}
