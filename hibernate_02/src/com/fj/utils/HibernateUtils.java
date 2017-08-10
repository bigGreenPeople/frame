package com.fj.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	
	static{
		//加载配置信息
		configuration = new Configuration().configure();
		//创建工厂	到这一步的时候就会在数据库里面创建表
		//因为此过程非常消耗资源所以我们把它放在静态代码块里只加载一次
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
