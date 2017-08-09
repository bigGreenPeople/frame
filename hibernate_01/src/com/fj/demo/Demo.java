package com.fj.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.fj.domain.User;
import com.fj.utils.HibernateUtils;

public class Demo {
	
	@Test
	public void testAdd(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
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
