package com.fj.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fj.service.EmpService;

public class Demo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmpService empService = (EmpService) context.getBean("empServiceImp");
		
		empService.transfer("¸¶½Ü", "¸¶¾²", 100);
	}
}
