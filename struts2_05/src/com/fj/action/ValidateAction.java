package com.fj.action;
/*
 * 此类中我们要实现输入校验
 * 输入校验有两种方法
 * 一：编程式校验
 * 二：配置校验(XML配置校验)
 * 这里我们使用编程式校检
 * */
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.fj.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ValidateAction extends ActionSupport implements ModelDriven<User>{
	//使用模型驱动的方法得到表单的数据
	User user = new User();
	
	//实现我们的模型驱动的方法
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//此方法不应该被校检
	//此方法没有数据提交  如果校检则会报出空指针异常
	//使用注解不校检此方法
	//@SkipValidation
	public String add() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("add方法被调用");
		return "err";
	}
	
	public String login() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("add方法被调用");
		return "err";
	}
	
	//重写此方法完成校检
	//校检是在方法执行之前
/*	@Override
	public void validate() {
		// TODO Auto-generated method stub
		System.out.println("validate校检开始");
		//验证账号
		if(user.getUsername().trim().equals("")){
			//将错误信息添加到FieldError
			//FieldError信息将会在值栈action中	可以使用标签<s:fielderror fieldName="loginerr"/>取出
			//如果调用了此方法就必须在struts.xml中action的result配置一个name为input的结果页面
			//所有我们可以通过此方法决定页面调往哪里
			addFieldError("loginerr", "用户名不能为空");
		}
		//验证密码
		if(user.getPassword().trim().equals("")){
			//将错误信息添加到FieldError
			addFieldError("loginerr", "密码不能为空");
		}
		
		//super.validate();
	}*/
	
	//指定我们要校检的方法
	//此方法要比validate校检先执行
	public void validateLogin() {
		// TODO Auto-generated method stub
		System.out.println("校检开始");
		//验证账号
		if(user.getUsername().trim().equals("")){
			//将错误信息添加到FieldError
			//FieldError信息将会在值栈action中	可以使用标签<s:fielderror fieldName="loginerr"/>取出
			//如果调用了此方法就必须在struts.xml中action的result配置一个name为input的结果页面
			//所有我们可以通过此方法决定页面调往哪里
			addFieldError("loginerr", "用户名不能为空");
		}
		//验证密码
		if(user.getPassword().trim().equals("")){
			//将错误信息添加到FieldError
			addFieldError("loginerr", "密码不能为空");
		}
		//super.validate();
	}
}
