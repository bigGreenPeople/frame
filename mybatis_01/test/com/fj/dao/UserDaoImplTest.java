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

	//初始化方法
	@Before
	public void setUp() throws Exception {
		String source = "SqlMapConfig.xml";
		//得到配置文件的流
		InputStream inputStream = Resources.getResourceAsStream(source);
		//使用SqlSessionFactoryBuilder和inputStream得到我们的会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testGetUserById() throws Exception {
		//得到我们dao的引用
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		//调用dao的方法
		User user = userDao.getUserById(1);
		System.out.println(user);
	}

	
}
