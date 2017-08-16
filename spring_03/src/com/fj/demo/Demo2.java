package com.fj.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fj.demo2.User;

/**
 * 使用xml配置加注解创建注入对象
 * @author bigGeenPeople
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//加载配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//得到bean
		User user = (User) context.getBean("user");
		//调用方法
		user.sayBook();
	}

}
