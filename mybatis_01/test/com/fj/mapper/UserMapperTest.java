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
		//���س����ǵĹ�����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() {
		//�õ�sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�õ��������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		sqlSession.commit();
	}

	@Test
	public void testFindUserByUsername() {
		//�õ�sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�õ��������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> list = userMapper.findUserByUsername("С");
		for (User user : list) {
			System.out.println(user);
		}
		sqlSession.commit();
	}

	@Test
	public void testDeleteUserById() {
		//�õ�sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�õ��������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.deleteUserById(38);
		sqlSession.commit();
	}

	@Test
	public void testUpdateUser() {
		//�õ�sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�õ��������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//��������
		User user = new User();
		user.setId(27);
		user.setUsername("�����");
		user.setBirthday(new Date());
		user.setAddress("�Ž�");
		
		userMapper.updateUser(user);
		
		sqlSession.commit();
	}
	
	@Test
	public void testFindUserList() {
		//�õ�sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�õ��������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//����QueryVo����
		QueryVo queryVo = new QueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("2");
		userCustom.setUsername("����");
		queryVo.setUserCustom(userCustom);
		
		List<User> list = userMapper.findUserList(queryVo);
		sqlSession.commit();
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testFindUserCount(){
		//�õ�sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�����������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//�õ�user����
		User user = new User();
		user.setSex("2");
		
		int findUserCount = userMapper.findUserCount(user);
		System.out.println(findUserCount);
	}

}
