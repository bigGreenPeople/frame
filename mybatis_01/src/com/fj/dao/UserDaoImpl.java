package com.fj.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.fj.po.User;

public class UserDaoImpl implements UserDao {
	//使用构造方法达到我们单例sqlSessionFactory的目的
	public SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated constructor stub
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User getUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		//得到一个session
		//因为sqlsession是线程不安全的所以我们要在方法体里面(这样就不会出现线程抢占的问题)
		SqlSession session = sqlSessionFactory.openSession();
		
		User user = session.selectOne("test.findUserById", id);
		//释放资源
		session.close();
		
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		//得到一个session
		//因为sqlsession是线程不安全的所以我们要在方法体里面(这样就不会出现线程抢占的问题)
		SqlSession session = sqlSessionFactory.openSession();
		//插入数据
		session.insert("test.insertUser", user);
		//释放资源
		session.close();
	}

}
