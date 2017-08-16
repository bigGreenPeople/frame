package com.fj.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//��ע���������Զ����ɶ��� �൱��id = userSerivce
@Component(value="userService")
//��ע�����������ɵĶ����ǵ������Ƕ���
@Scope(value="singleton")
public class UserServiceImp implements UserService {

	@Override
	public void service() {
		// TODO Auto-generated method stub
		System.out.println("������service����");
	}
	
	//��ʼ������
	@PostConstruct
	public void init(){
		//System.out.println("init��ʼ��");
	}

//	���ٷ���
	@PreDestroy
	public void destroy(){
		//�˲�����û�����ٶ���ʹ�ò�����
		System.out.println("destroy����");
	}
}
