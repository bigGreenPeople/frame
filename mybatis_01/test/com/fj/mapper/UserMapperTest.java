package com.fj.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.fj.po.QueryVo;
import com.fj.po.User;
import com.fj.po.UserCustom;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		String res = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(res);
		//加载出我们的工厂类
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() {
		//得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		sqlSession.commit();
	}

	@Test
	public void testFindUserByUsername() {
		//得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserByUsername("小");
		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.commit();
	}

	@Test
	public void testDeleteUserById() {
		//得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUserById(38);
		sqlSession.commit();
	}

	@Test
	public void testUpdateUser() {
		//得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//创建对象
		User user = new User();
		user.setId(27);
		user.setUsername("付大杰");
		user.setBirthday(new Date());
		user.setAddress("九江");
		
		userMapper.updateUser(user);
		
		sqlSession.commit();
	}
	
	@Test
	public void testFindUserList() {
		//得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//创建QueryVo对象
		QueryVo queryVo = new QueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("2");
		userCustom.setUsername("王五");
		queryVo.setUserCustom(userCustom);
		
		List<User> list = userMapper.findUserList(queryVo);
		sqlSession.commit();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testFindUserCount(){
		//得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//得到user对象
		User user = new User();
		user.setSex("2");
		
		int findUserCount = userMapper.findUserCount(user);
		System.out.println(findUserCount);
	}

}
