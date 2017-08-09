package com.fj.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.fj.domain.User;

public class Demo {
	
	@Test
	public void testAdd(){
		//����������Ϣ
		Configuration configuration = new Configuration().configure();
		//��������	����һ����ʱ��ͻ������ݿ����洴����
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		//�õ�session
		Session session = sessionFactory.openSession();
		//�õ�����
		Transaction beginTransaction = session.beginTransaction();
		
		//��������
		User user = new User();
		user.setUsername("����");
		user.setPassword("1243596");
		session.save(user);
		
		//�ύ����
		beginTransaction.commit();
		session.close();
		sessionFactory.close();
	}
}
