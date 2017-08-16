package com.fj.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Demo {
	
	//这里我们使用spring接管jdbcTemplate
	@Test
	public void testJDBCTemplate2(){
		//加载配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//得到jdbcTemplate对象
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		//编写sql语句
		String sql = "insert into book values(?,?)";
		//设置？值并且发生sql语句
		jdbcTemplate.update(sql,3,"大时代");
	}
	
	
	//下面是代码编写
	@Test
	public void testJDBCTemplate(){
		//编写数据源
		DriverManagerDataSource dateSource = new DriverManagerDataSource();
		//设置数据源的相关信息
		dateSource.setDriverClassName("com.mysql.jdbc.Driver");
		dateSource.setUrl("jdbc:mysql:///mydb1");
		dateSource.setUsername("root");
		dateSource.setPassword("1243596620");
		
		//创建jdbc模板 让它加载到我们的配置 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dateSource);
		
		//编写sql语句
		String sql = "insert into book values(?,?)";
		//设置？值并且发生sql语句
		jdbcTemplate.update(sql,1,"何以笙箫默");
		
	}
}
