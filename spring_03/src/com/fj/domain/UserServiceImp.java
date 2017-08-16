package com.fj.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//此注释配置了自动生成对象 相当于id = userSerivce
@Component(value="userService")
//此注释配置了生成的对象是单例还是多例
@Scope(value="singleton")
public class UserServiceImp implements UserService {

	@Override
	public void service() {
		// TODO Auto-generated method stub
		System.out.println("调用了service方法");
	}
	
	//初始化方法
	@PostConstruct
	public void init(){
		//System.out.println("init初始化");
	}

//	销毁方法
	@PreDestroy
	public void destroy(){
		//此测试中没有销毁对象使用不调用
		System.out.println("destroy销毁");
	}
}
