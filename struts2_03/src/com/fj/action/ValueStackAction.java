package com.fj.action;

import java.util.ArrayList;
import java.util.List;

import com.fj.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport {
	
	//��ֵջ������ݵĵ����ַ�ʽ	��action������������ɱ�����get����
	//����������ݵķ�ʽ����ԭ�� action�����������	��������������ֵջ��ջ������
	private User user = new User("����","123");
	
	public User getUser() {
		return user;
	}
	
//	��ֵջ�з��뼯��
	//list����ӵ���action��
	List<User> list = new ArrayList<User>();
	

	public List<User> getList() {
		return list;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		//�õ�ActionContext���� 
		ActionContext actionContext = ActionContext.getContext();
		//�õ�ֵջ
		ValueStack valueStack = actionContext.getValueStack();
		
		//��ֵջ������ݵĵ�һ�ַ�ʽ	
		//�������ֵ�ķ�ʽ����ֵջ��ջ�������һ��map
		valueStack.set("name", "fujie");
//		//��ֵջ������ݵĵڶ��ַ�ʽ
		//�������ֵ�ķ�ʽ����ֵջ��ջ�������һ��String����
		valueStack.push("xixi");
		
		//��list���һЩ����
		User user1 = new User("����1","1231");
		User user2 = new User("����2","1232");
		
		list.add(user1);
		list.add(user2);
		return "ognl";
	}
}
