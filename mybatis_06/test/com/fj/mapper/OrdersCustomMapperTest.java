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
		//�õ����sqlsession
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		//�õ�����������
		OrdersCustomMapper mapper1 = sqlSession1.getMapper(OrdersCustomMapper.class);
		OrdersCustomMapper mapper2 = sqlSession2.getMapper(OrdersCustomMapper.class);
		OrdersCustomMapper mapper3 = sqlSession3.getMapper(OrdersCustomMapper.class);
		//���÷���
		//�����Ұ������ص�����ȥ�������Է����˶���sql���
		List<Orders> list = mapper1.findOrdersListMap();
		//�ر�
		sqlSession1.close();
		//����
		//DEBUG [main] - Cache Hit Ratio [com.fj.mapper.OrdersCustomMapper]: 0.14285714285714285
		//DEBUG [main] - Cache Hit Ratio [com.fj.mapper.OrdersCustomMapper]: 0.25
		List<Orders> list2 = mapper2.findOrdersListMap();
		sqlSession2.close();
		
		List<Orders> list3 = mapper3.findOrdersListMap();
		sqlSession3.close();
	}
}
