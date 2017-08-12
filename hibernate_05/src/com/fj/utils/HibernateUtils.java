package com.fj.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static Configuration configuration = null;
	private static SessionFactory sessionFactory = null;
	
	static{
		//����������Ϣ
		configuration = new Configuration().configure();
		//��������	����һ����ʱ��ͻ������ݿ����洴����
		//��Ϊ�˹��̷ǳ�������Դ�������ǰ������ھ�̬�������ֻ����һ��
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
