package com.fj.action;

import java.util.ArrayList;
import java.util.List;

import com.fj.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport {
	
	//向值栈添加数据的第三种方式	在action定义变量，生成变量的get方法
	//这种添加数据的方式是在原来 action的引用上添加	经过测试这是在值栈的栈顶加入
	private User user = new User("付杰","123");
	
	public User getUser() {
		return user;
	}
	
//	向值栈中放入集合
	//list被添加到了action中
	List<User> list = new ArrayList<User>();
	

	public List<User> getList() {
		return list;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		//得到ActionContext对象 
		ActionContext actionContext = ActionContext.getContext();
		//得到值栈
		ValueStack valueStack = actionContext.getValueStack();
		
		//向值栈添加数据的第一种方式	
		//这种添加值的方式会在值栈的栈顶上添加一个map
		valueStack.set("name", "fujie");
//		//向值栈添加数据的第二种方式
		//这种添加值的方式会在值栈的栈顶上添加一个String对象
		valueStack.push("xixi");
		
		//给list添加一些数据
		User user1 = new User("付杰1","1231");
		User user2 = new User("付杰2","1232");
		
		list.add(user1);
		list.add(user2);
		return "ognl";
	}
}
