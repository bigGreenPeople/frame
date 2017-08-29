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
		//得到sqlsession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//得到代理对象
		OrdersCustomMapper mapper = sqlSession.getMapper(OrdersCustomMapper.class);
		//调用方法
		List<Orders> list = mapper.findOrdersListMap();
		
		//遍历
		//注意这里的select * from user where id=? 会被存入一级缓存中所以只发出了两条语句
		for (Orders orders : list) {
			for (Orderdetail orderdetail : orders.getOrderdetails()) {
				System.out.println(orderdetail);
			}
		}
	}
}
