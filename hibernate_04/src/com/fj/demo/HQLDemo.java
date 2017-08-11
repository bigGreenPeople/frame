package com.fj.demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.fj.domain.Student;
import com.fj.domain.Teacher;
import com.fj.utils.HibernateUtils;

public class HQLDemo {
	//使用HQL查询所有
	@Test
	public void HQLQuery1(){
		//创建对象引用
		Session session = null;
		Transaction ts = null;
		
		try {
//			得到我们的session
			session = HibernateUtils.getSessionFactory().openSession();
//			开启事务
			ts = session.beginTransaction();
			
			//使用HQL查询所有
			Query query = session.createQuery("from Student");
			List<Student> list = query.list();
			
			//打印出所有的学生
			for (Student student : list) {
				System.out.println(student.getId()+"  "+student.getName());
			}
			
			//提交事务
			ts.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(ts!=null){
				ts.rollback();
			}
		}finally{
			if(session!=null){
				session.close();
			}
		}
		
	}

	//使用HQL完成条件查询	以及 模糊查询
	@Test
	public void HQLQuery2(){
		//创建对象引用
		Session session = null;
		Transaction ts = null;
		
		try {
//			得到我们的session
			session = HibernateUtils.getSessionFactory().openSession();
//			开启事务
			ts = session.beginTransaction();
			
			//使用HQL查询所有
			//Query query = session.createQuery("from Student where id=? and name=?");
//			给问好注入值
//			query.setParameter(0, 4);
//			query.setParameter(1, "李学生");
			
//			Student student = (Student) query.uniqueResult();
			
			//打印出所有的学生
			//System.out.println(student.getName()+"   "+student.getId());
			
//			编写hql语句
			Query query = session.createQuery("from Student where name like ?");
			
			//设置值
			query.setParameter(0, "%学生");
			
			List<Student> list = query.list();
			
			for (Student student : list) {
				System.out.println(student.getName()+"   "+student.getId());
			}
			
			//提交事务
			ts.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(ts!=null){
				ts.rollback();
			}
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}
	//使用HQL排序查询
	@Test
	public void HQLQuery3(){
		//创建对象引用
		Session session = null;
		Transaction ts = null;
		
		try {
//			得到我们的session
			session = HibernateUtils.getSessionFactory().openSession();
//			开启事务
			ts = session.beginTransaction();
			
			//使用HQL排序查询所有	
			Query query = session.createQuery("from Student order by id desc");
			List<Student> list = query.list();
			
			//打印出所有的学生
			for (Student student : list) {
				System.out.println(student.getId()+"  "+student.getName());
			}
			
			//提交事务
			ts.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			if(ts!=null){
				ts.rollback();
			}
		}finally{
			if(session!=null){
				session.close();
			}
		}
		
	}
	
	//使用HQL分页查询
		@Test
		public void HQLQuery4(){
			//创建对象引用
			Session session = null;
			Transaction ts = null;
			
			try {
//				得到我们的session
				session = HibernateUtils.getSessionFactory().openSession();
//				开启事务
				ts = session.beginTransaction();
				
				//使用HQL排序查询所有	
				Query query = session.createQuery("from Student order");
				//设置分页从哪里开始
				query.setFirstResult(0);
				//设置分页的页数
				query.setMaxResults(2);
				List<Student> list = query.list();
				
				//打印出所有的学生
				for (Student student : list) {
					System.out.println(student.getId()+"  "+student.getName());
				}
				
				//提交事务
				ts.commit();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				if(ts!=null){
					ts.rollback();
				}
			}finally{
				if(session!=null){
					session.close();
				}
			}
			
		}
		
		//使用HQL投影查询(就是查一些字段)
		@Test
		public void HQLQuery5(){
			//创建对象引用
			Session session = null;
			Transaction ts = null;
			
			try {
//				得到我们的session
				session = HibernateUtils.getSessionFactory().openSession();
//				开启事务
				ts = session.beginTransaction();
				
				//使用HQL查询name属性
				Query query = session.createQuery("select name from Student");
				List list = query.list();
				
				//打印出所有的学生
				for (Object student : list) {
					System.out.println(student);
				}
				
				//提交事务
				ts.commit();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				if(ts!=null){
					ts.rollback();
				}
			}finally{
				if(session!=null){
					session.close();
				}
			}
			
		}

		//使用HQL聚集函数的使用
		@Test
		public void HQLQuery6(){
			//创建对象引用
			Session session = null;
			Transaction ts = null;
			
			try {
//				得到我们的session
				session = HibernateUtils.getSessionFactory().openSession();
//				开启事务
				ts = session.beginTransaction();
				
				//使用HQL查询所有
				Query query = session.createQuery("select count(*) from Student");
				
				//得到结果是一个object 
				Object ob = query.uniqueResult();
				//转换类型
				int count = ((Long)ob).intValue();
				System.out.println(count);
				
				
				//提交事务
				ts.commit();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				if(ts!=null){
					ts.rollback();
				}
			}finally{
				if(session!=null){
					session.close();
				}
			}
			
		}
}
