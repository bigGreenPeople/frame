package com.fj.action;

import com.opensymphony.xwork2.ActionContext;
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
		ActionContext context = ActionContext.getContext();
		//��context�з���ֵ
		context.put("name", "����");
		//��contextȡֵ
		System.out.println(context.get("name"));
		//��s:debug�����ǿ���name��������Stack Context��
		//˵��put������Stack Context������Stack Context����ActionContext
		
		return "ok";
	}
}
