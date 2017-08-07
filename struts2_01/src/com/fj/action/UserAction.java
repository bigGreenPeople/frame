package com.fj.action;

import java.util.List;

import com.fj.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport{
	//属性封装
/*	private String name;
	private String password;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}*/

	//表达式封装
/*	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	//封装到list集合中
	/*private List<User> list;
	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}*/
	//模型驱动封装 
	/*private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}*/
	
	

	public String add() throws Exception {
		// TODO Auto-generated method stub
		//属性封装
		//System.out.println(name+"   "+password);
		//表达式封装
		//System.out.println(user.getName()+"   "+user.getPassword());
		//模型驱动封装 
		//System.out.println(user.getName()+"   "+user.getPassword());
		//封装到list集合中
		/*for(User u:list){
			System.out.println(u.getName()+"   "+u.getPassword());
		}*/
		//封装到map集合中
		
		return NONE;
	}

	
}
