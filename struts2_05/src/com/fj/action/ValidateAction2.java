package com.fj.action;
/*
 * ����������Ҫʵ������У��
 * ����У�������ַ���
 * һ�����ʽУ��
 * ��������У��(XML����У��)
 * ��������ʹ�ñ��ʽУ��
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
