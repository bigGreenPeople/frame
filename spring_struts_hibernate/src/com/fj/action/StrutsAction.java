package com.fj.action;

import javax.annotation.Resource;

import com.fj.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class StrutsAction extends ActionSupport {
	
	@Resource(name="userServiceImp")
	private UserService userService;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("action...............");
		//����service��ķ���
		userService.addUser();
		return NONE;
	}
}
