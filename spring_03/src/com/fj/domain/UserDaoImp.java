package com.fj.domain;

import javax.annotation.PostConstruct;import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="userDao")
public class UserDaoImp implements UserDao {
	//注入普通的属性
	@Value(value="付杰")
	private String name;
	@Value(value="22")
	private int num;
	//自动装配了我们的属性
//	@Autowired
//	private UserServiceImp userService;
	//使用名称注入也就是和生成对象的values要一样
	@Resource(name="userService")
	private UserServiceImp userService;
	
	//使用注解注入属性需要UserServiceImp已经配置了创建
	@Resource(name="userService")
	private UserServiceImp userService2;
	
	public void sayHello() {
		// TODO Auto-generated method stub
		//打印出两个对象的哈希值看看是不是同一对象
		System.out.println(userService);
		System.out.println(userService2);
		//看看我们普通类型的属性注入进去没
		System.out.println(name+(num+2));
		
		userService.service();
		System.out.println("你好啊");
	}

}
