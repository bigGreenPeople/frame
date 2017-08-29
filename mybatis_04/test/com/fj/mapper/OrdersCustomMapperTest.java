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

import com.fj.po.Orderdetail;
import com.fj.po.Orders;
import com.fj.po.OrdersAndOrdersDetail;
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
	public void testFindOrdersListMap(){
		//�õ�sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�õ��������
		OrdersCustomMapper mapper = sqlSession.getMapper(OrdersCustomMapper.class);
		//���÷���
		List<Orders> list = mapper.findOrdersListMap();
		
		//����
		//ע�������select * from user where id=? �ᱻ����һ������������ֻ�������������
		for (Orders orders : list) {
			for (Orderdetail orderdetail : orders.getOrderdetails()) {
				System.out.println(orderdetail);
			}
		}
	}
}
