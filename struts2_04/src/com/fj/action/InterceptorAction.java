package com.fj.action;

import com.opensymphony.xwork2.ActionSupport;

public class InterceptorAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("executeִ��");
		return "ok";
	}
	
	public String add() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("addִ��");
		return "ok";
	}
}
