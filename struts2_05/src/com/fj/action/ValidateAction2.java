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

public class ValidateAction2 extends ActionSupport{
	
	private String username;
	private String password;
	private String tel;
	
	
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}


	
	public String login() throws Exception {
		// TODO Auto-generated method stub
		return "ok";
	}
	
	public String add() throws Exception {
		// TODO Auto-generated method stub
		return "ok";
	}
}
