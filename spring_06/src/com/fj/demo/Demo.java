package com.fj.demo;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Demo {
	
	//��������ʹ��spring�ӹ�jdbcTemplate
	@Test
	public void testJDBCTemplate2(){
		//���������ļ�
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//�õ�jdbcTemplate����
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		//��дsql���
		String sql = "insert into book values(?,?)";
		//���ã�ֵ���ҷ���sql���
		jdbcTemplate.update(sql,3,"��ʱ��");
	}
	
	
	//�����Ǵ����д
	@Test
	public void testJDBCTemplate(){
		//��д����Դ
		DriverManagerDataSource dateSource = new DriverManagerDataSource();
		//��������Դ�������Ϣ
		dateSource.setDriverClassName("com.mysql.jdbc.Driver");
		dateSource.setUrl("jdbc:mysql:///mydb1");
		dateSource.setUsername("root");
		dateSource.setPassword("1243596620");
		
		//����jdbcģ�� �������ص����ǵ����� 
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dateSource);
		
		//��дsql���
		String sql = "insert into book values(?,?)";
		//���ã�ֵ���ҷ���sql���
		jdbcTemplate.update(sql,1,"��������Ĭ");
		
	}
}
