package com.fj.action;

import com.opensymphony.xwork2.ActionSupport;

public class FristAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("默认的方法被调用 ");
		return super.execute();
	}
}
