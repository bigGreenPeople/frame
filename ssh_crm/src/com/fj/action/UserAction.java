package com.fj.action;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.User;
import com.fj.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
//	�������
	private UserService userService;
	private User user = new User();
//	ʹ��ģ��������װ
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	//�û���¼������action
	public String login() throws Exception {
		//�õ���¼���û�
		User userLogin = userService.userLogin(user);
		//����û���Ϊ��
		if(userLogin!=null){
			//���û�����session
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}
		
		return "loginErr";
	}
	

	//xmlע������
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
