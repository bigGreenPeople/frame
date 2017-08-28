package com.fj.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.fj.po.Orders;
import com.fj.po.OrdersCustom;
import com.fj.po.User;

public class OrdersCustomMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindOrdersList() {
		//得到我们的会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到代理对象
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		//调用方法
		List<OrdersCustom> list = ordersCustomMapper.findOrdersList();
		
		for (OrdersCustom ordersCustom : list) {
			System.out.println(ordersCustom);
		}
		
	}
	

	@Test
	public void testFindOrdersListMap() {
		//得到我们的会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到代理对象
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		//调用方法
		List<Orders> list = ordersCustomMapper.findOrdersListMap();
		
		for (Orders orders : list) {
			System.out.println(orders);
		}
		
	}

	@Test
	public void testFindOrdersDetailList() {
		//得到我们的会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到代理对象
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		//调用方法
		List<Orders> list = ordersCustomMapper.findOrdersDetailList();
		
		for (Orders orders : list) {
			System.out.println(orders);
		}
		
	}
	
	@Test
	public void testFindOrderListResultMap() {
		//得到我们的会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到代理对象
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		//调用方法
		List<User> list = ordersCustomMapper.findOrderListResultMap();
		
		for (User user : list) {
			System.out.println(user);
		}
		
	}
}
