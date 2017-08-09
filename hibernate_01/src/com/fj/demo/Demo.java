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
		//加载配置信息
		Configuration configuration = new Configuration().configure();
		//创建工厂	到这一步的时候就会在数据库里面创建表
		SessionFactory sessionFactory = configuration.buildSessionFactory();
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
