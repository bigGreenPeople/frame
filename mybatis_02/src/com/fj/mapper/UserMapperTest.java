package com.fj.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.fj.po.QueryVo;
import com.fj.po.User;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		//�õ�SqlMapConfig.xml���ļ���
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}


	@Test
	public void testFindUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�õ��������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//����pojo����
		User user = new User();
		user.setSex("2");
		user.setId(1);
		
		List<User> list = userMapper.findUserList(user);
		
		for (User user2 : list) {
			System.out.println(user2);
		}
	}
	
	@Test
	public void testFindUserListId(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�õ��������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//��ѯ����
		QueryVo queryVo = new QueryVo();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(27);
		queryVo.setIds(ids);
		
		List<User> list = userMapper.findUserListId(queryVo);
		for (User user : list) {
			System.out.println(user);
		}
	}

}
