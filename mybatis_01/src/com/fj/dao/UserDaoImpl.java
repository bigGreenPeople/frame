package com.fj.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fj.po.User;

public class UserDaoImpl implements UserDao {
	//ʹ�ù��췽���ﵽ���ǵ���sqlSessionFactory��Ŀ��
	public SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated constructor stub
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User getUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		//�õ�һ��session
		//��Ϊsqlsession���̲߳���ȫ����������Ҫ�ڷ���������(�����Ͳ�������߳���ռ������)
		SqlSession session = sqlSessionFactory.openSession();
		
		User user = session.selectOne("test.findUserById", id);
		//�ͷ���Դ
		session.close();
		
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		//�õ�һ��session
		//��Ϊsqlsession���̲߳���ȫ����������Ҫ�ڷ���������(�����Ͳ�������߳���ռ������)
		SqlSession session = sqlSessionFactory.openSession();
		//��������
		session.insert("test.insertUser", user);
		//�ͷ���Դ
		session.close();
	}

}
