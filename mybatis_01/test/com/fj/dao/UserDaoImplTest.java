package com.fj.dao;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.fj.po.User;

public class UserDaoImplTest {


	private SqlSessionFactory sqlSessionFactory;

	//��ʼ������
	@Before
	public void setUp() throws Exception {
		String source = "SqlMapConfig.xml";
		//�õ������ļ�����
		InputStream inputStream = Resources.getResourceAsStream(source);
		//ʹ��SqlSessionFactoryBuilder��inputStream�õ����ǵĻỰ����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testGetUserById() throws Exception {
		//�õ�����dao������
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		//����dao�ķ���
		User user = userDao.getUserById(1);
		System.out.println(user);
	}

	
}
