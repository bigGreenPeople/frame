package com.fj.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fj.demo2.User;

/**
 * ʹ��xml���ü�ע�ⴴ��ע�����
 * @author bigGeenPeople
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���������ļ�
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//�õ�bean
		User user = (User) context.getBean("user");
		//���÷���
		user.sayBook();
	}

}
