package com.fj.domain;

import javax.annotation.PostConstruct;import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="userDao")
public class UserDaoImp implements UserDao {
	//ע����ͨ������
	@Value(value="����")
	private String name;
	@Value(value="22")
	private int num;
	//�Զ�װ�������ǵ�����
//	@Autowired
//	private UserServiceImp userService;
	//ʹ������ע��Ҳ���Ǻ����ɶ����valuesҪһ��
	@Resource(name="userService")
	private UserServiceImp userService;
	
	//ʹ��ע��ע��������ҪUserServiceImp�Ѿ������˴���
	@Resource(name="userService")
	private UserServiceImp userService2;
	
	public void sayHello() {
		// TODO Auto-generated method stub
		//��ӡ����������Ĺ�ϣֵ�����ǲ���ͬһ����
		System.out.println(userService);
		System.out.println(userService2);
		//����������ͨ���͵�����ע���ȥû
		System.out.println(name+(num+2));
		
		userService.service();
		System.out.println("��ð�");
	}

}
