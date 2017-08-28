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
		//�õ����ǵĻỰ
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�õ��������
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		//���÷���
		List<OrdersCustom> list = ordersCustomMapper.findOrdersList();
		
		for (OrdersCustom ordersCustom : list) {
			System.out.println(ordersCustom);
		}
		
	}
	

	@Test
	public void testFindOrdersListMap() {
		//�õ����ǵĻỰ
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�õ��������
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		//���÷���
		List<Orders> list = ordersCustomMapper.findOrdersListMap();
		
		for (Orders orders : list) {
			System.out.println(orders);
		}
		
	}

	@Test
	public void testFindOrdersDetailList() {
		//�õ����ǵĻỰ
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�õ��������
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		//���÷���
		List<Orders> list = ordersCustomMapper.findOrdersDetailList();
		
		for (Orders orders : list) {
			System.out.println(orders);
		}
		
	}
	
	@Test
	public void testFindOrderListResultMap() {
		//�õ����ǵĻỰ
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�õ��������
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		//���÷���
		List<User> list = ordersCustomMapper.findOrderListResultMap();
		
		for (User user : list) {
			System.out.println(user);
		}
		
	}
}
