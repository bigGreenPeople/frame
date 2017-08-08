package com.fj.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InterceptorAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("execute执行");
		return "ok";
	}
	
	public String add() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("add执行");
		ActionContext context = ActionContext.getContext();
		//向context中放入值
		context.put("name", "付杰");
		//从context取值
		System.out.println(context.get("name"));
		//在s:debug中我们看的name出现在了Stack Context中
		//说明put就是向Stack Context放数据Stack Context就是ActionContext
		
		return "ok";
	}
}
