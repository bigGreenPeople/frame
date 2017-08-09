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
		//得到session
		Session session = sessionFactory.openSession();
		//得到事务
		Transaction beginTransaction = session.beginTransaction();
		
		//创建对象
		User user = new User();
		user.setUsername("付杰");
		user.setPassword("1243596");
		session.save(user);
		
		//提交事务
		beginTransaction.commit();
		session.close();
		sessionFactory.close();
	}
}
