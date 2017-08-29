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
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fj.dao.OrdersDao;
import com.fj.po.Orderdetail;
import com.fj.po.Orders;
import com.fj.po.OrdersAndOrdersDetail;
import com.fj.po.OrdersCustom;
import com.fj.po.User;

public class OrdersCustomMapperTest {
	//使用传统的接口dao的方式
	@Test
	public void demo(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrdersDao ordersDao = (OrdersDao) context.getBean("ordersDao");
		User user = ordersDao.findOrdersById(2);
		System.out.println(user);
	}
	
/*	//使用MapperFactoryBean
	@Test
	public void demo2(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MapperFactoryBean mapperFactory = (MapperFactoryBean) context.getBean("mapperFactory");
		User user = mapperFactory.get
		System.out.println(user);
	}*/

	//	使用mapper扫描器
	@Test
	public void demo3(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		OrdersCustomMapper mapper = (OrdersCustomMapper) context.getBean("ordersCustomMapper");
		
		List<Orders> list = mapper.findOrdersListMap();
		
		for (Orders orders : list) {
			System.out.println(orders);
		}
		
	}
}
