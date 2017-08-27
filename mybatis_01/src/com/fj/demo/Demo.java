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
	
	//创建会话工厂
	public static void createSqlSessionFactory() throws IOException{
		//得到配置文件
		String resource = "SqlMapConfig.xml";
		//使用此方法就是得到classpath下的路径
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建出sqlsessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//根据id去查找用户
	public static void testFindUserById(){
		try {
			//使用sqlSessionFactory创建sqlsession
			sqlSession = sqlSessionFactory.openSession();
			//使用我们的会话
			/*
			 * statement:是namespace+"."+select的id
			 * parameter就是我们给占位符的参数
			 * */
			User user = sqlSession.selectOne("test.findUserById", 1);
			
			System.out.println(user);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//释放资源
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		
	}
	
	//根据姓名去查找用户
	public static void testFindUserByName(){
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			List<User> list = sqlSession.selectList("test.findUserByUsername", "小明");
			
			for (User user : list) {
				System.out.println(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			//释放资源
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		//先创建sqlsession
		
	}
	
	//添加用户
	public static void testInsertUser(){
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			//创建user
			User user = new User();
			user.setUsername("付大杰");
			user.setSex("2");
			user.setBirthday(new Date());
			user.setAddress("南昌");
			
			int i = sqlSession.insert("test.insertUser", user);
			System.out.println("影响行数:"+i);
			System.out.println("插入的id为："+user.getId());
			//注意这里如果不提交事务就不会持久化到数据库
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(sqlSession!=null){
				sqlSession.rollback();
			}
			e.printStackTrace();
		}finally{
			//释放资源
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	//删除用户
	public static void deleteUserById(){
		try {
			//这个session不是线程安全的
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
			//释放资源
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	//删除用户
	public static void updateUser(){
		try {
			//这个session不是线程安全的
			sqlSession = sqlSessionFactory.openSession();
			
			User user = new User();
			//更新操作一定要设置id
			user.setId(38);
			user.setUsername("付gh杰");
			
			sqlSession.update("test.updateUser", user);
			
			sqlSession.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(sqlSession!=null){
				sqlSession.rollback();
			}
			e.printStackTrace();
		}finally{
			//释放资源
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
}
