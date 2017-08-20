package com.fj.action;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.User;
import com.fj.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
//	服务对象
	private UserService userService;
	private User user = new User();
//	使用模型驱动封装
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	//用户登录所过的action
	public String login() throws Exception {
		//得到登录的用户
		User userLogin = userService.userLogin(user);
		//如果用户不为空
		if(userLogin!=null){
			//将用户放入session
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}
		
		return "loginErr";
	}
	

	//xml注入属性
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
