package com.fj.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fj.po.User;

public class Demo {
	
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession sqlSession;
	
	public static void main(String[] args) throws IOException {
		createSqlSessionFactory();
		testFindUserById();
	}
	
	//�����Ự����
	public static void createSqlSessionFactory() throws IOException{
		//�õ������ļ�
		String resource = "SqlMapConfig.xml";
		//ʹ�ô˷������ǵõ�classpath�µ�·��
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//������sqlsessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//����idȥ�����û�
	public static void testFindUserById(){
		try {
			//ʹ��sqlSessionFactory����sqlsession
			sqlSession = sqlSessionFactory.openSession();
			//ʹ�����ǵĻỰ
			/*
			 * statement:��namespace+"."+select��id
			 * parameter�������Ǹ�ռλ���Ĳ���
			 * */
			User user = sqlSession.selectOne("test.findUserById", 1);
			
			System.out.println(user);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		
	}
	
	//��������ȥ�����û�
	public static void testFindUserByName(){
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			List<User> list = sqlSession.selectList("test.findUserByUsername", "С��");
			
			for (User user : list) {
				System.out.println(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		//�ȴ���sqlsession
		
	}
	
	//����û�
	public static void testInsertUser(){
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			//����user
			User user = new User();
			user.setUsername("�����");
			user.setSex("2");
			user.setBirthday(new Date());
			user.setAddress("�ϲ�");
			
			int i = sqlSession.insert("test.insertUser", user);
			System.out.println("Ӱ������:"+i);
			System.out.println("�����idΪ��"+user.getId());
			//ע������������ύ����Ͳ���־û������ݿ�
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(sqlSession!=null){
				sqlSession.rollback();
			}
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	//ɾ���û�
	public static void deleteUserById(){
		try {
			//���session�����̰߳�ȫ��
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.delete("test.deleteUserById", 39);
			
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(sqlSession!=null){
				sqlSession.rollback();
			}
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	//ɾ���û�
	public static void updateUser(){
		try {
			//���session�����̰߳�ȫ��
			sqlSession = sqlSessionFactory.openSession();
			
			User user = new User();
			//���²���һ��Ҫ����id
			user.setId(38);
			user.setUsername("��gh��");
			
			sqlSession.update("test.updateUser", user);
			
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(sqlSession!=null){
				sqlSession.rollback();
			}
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
}
