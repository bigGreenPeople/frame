package com.fj.action;

import java.util.List;

import com.fj.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport{
	//���Է�װ
/*	private String name;
	private String password;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}*/

	//���ʽ��װ
/*	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	//��װ��list������
	/*private List<User> list;
	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}*/
	//ģ��������װ 
	/*private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}*/
	
	

	public String add() throws Exception {
		// TODO Auto-generated method stub
		//���Է�װ
		//System.out.println(name+"   "+password);
		//���ʽ��װ
		//System.out.println(user.getName()+"   "+user.getPassword());
		//ģ��������װ 
		//System.out.println(user.getName()+"   "+user.getPassword());
		//��װ��list������
		/*for(User u:list){
			System.out.println(u.getName()+"   "+u.getPassword());
		}*/
		//��װ��map������
		
		return NONE;
	}

	
}
