package com.fj.action;
/*
 * ����������Ҫʵ������У��
 * ����У�������ַ���
 * һ�����ʽУ��
 * ��������У��(XML����У��)
 * ��������ʹ�ñ��ʽУ��
 * */
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.fj.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ValidateAction extends ActionSupport implements ModelDriven<User>{
	//ʹ��ģ�������ķ����õ���������
	User user = new User();
	
	//ʵ�����ǵ�ģ�������ķ���
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//�˷�����Ӧ�ñ�У��
	//�˷���û�������ύ  ���У����ᱨ����ָ���쳣
	//ʹ��ע�ⲻУ��˷���
	//@SkipValidation
	public String add() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("add����������");
		return "err";
	}
	
	public String login() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("add����������");
		return "err";
	}
	
	//��д�˷������У��
	//У�����ڷ���ִ��֮ǰ
/*	@Override
	public void validate() {
		// TODO Auto-generated method stub
		System.out.println("validateУ�쿪ʼ");
		//��֤�˺�
		if(user.getUsername().trim().equals("")){
			//��������Ϣ��ӵ�FieldError
			//FieldError��Ϣ������ֵջaction��	����ʹ�ñ�ǩ<s:fielderror fieldName="loginerr"/>ȡ��
			//��������˴˷����ͱ�����struts.xml��action��result����һ��nameΪinput�Ľ��ҳ��
			//�������ǿ���ͨ���˷�������ҳ���������
			addFieldError("loginerr", "�û�������Ϊ��");
		}
		//��֤����
		if(user.getPassword().trim().equals("")){
			//��������Ϣ��ӵ�FieldError
			addFieldError("loginerr", "���벻��Ϊ��");
		}
		
		//super.validate();
	}*/
	
	//ָ������ҪУ��ķ���
	//�˷���Ҫ��validateУ����ִ��
	public void validateLogin() {
		// TODO Auto-generated method stub
		System.out.println("У�쿪ʼ");
		//��֤�˺�
		if(user.getUsername().trim().equals("")){
			//��������Ϣ��ӵ�FieldError
			//FieldError��Ϣ������ֵջaction��	����ʹ�ñ�ǩ<s:fielderror fieldName="loginerr"/>ȡ��
			//��������˴˷����ͱ�����struts.xml��action��result����һ��nameΪinput�Ľ��ҳ��
			//�������ǿ���ͨ���˷�������ҳ���������
			addFieldError("loginerr", "�û�������Ϊ��");
		}
		//��֤����
		if(user.getPassword().trim().equals("")){
			//��������Ϣ��ӵ�FieldError
			addFieldError("loginerr", "���벻��Ϊ��");
		}
		//super.validate();
	}
}
