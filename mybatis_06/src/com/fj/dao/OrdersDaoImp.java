package com.fj.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.fj.po.User;

public class OrdersDaoImp extends SqlSessionDaoSupport implements OrdersDao {

	@Override
	public User findOrdersById(int id) {
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("com.fj.mapper.OrdersCustomMapper.findUserById", id);
		return user;
	}

}
