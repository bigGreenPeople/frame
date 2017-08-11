package com.fj.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.fj.domain.Student;
import com.fj.utils.HibernateUtils;

public class QBCDemo {
	//使用QBC查询所有
	@Test
	public void QBCQuery1(){
		//创建对象引用
		Session session = null;
		Transaction ts = null;
		
		try {
//			得到我们的session
			session = HibernateUtils.getSessionFactory().openSession();
//			开启事务
			ts = session.beginTransaction();
			
			//使用QBC查询所有
			Criteria criteria = session.createCriteria(Student.class);
			
			List<Student> list = criteria.list();
			
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
	
	//使用QBC条件查询
	@Test
	public void QBCQuery2(){
		//创建对象引用
		Session session = null;
		Transaction ts = null;
		
		try {
//			得到我们的session
			session = HibernateUtils.getSessionFactory().openSession();
//			开启事务
			ts = session.beginTransaction();
			
			//使用QBC查询所有
			Criteria criteria = session.createCriteria(Student.class);
			//开始添加条件 
			//criteria.add(Restrictions.eq("id", 4));
			//模糊查询
			criteria.add(Restrictions.like("name", "%学生"));
			List<Student> list = criteria.list();
			
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
	
	//使用QBC排序查询
		@Test
		public void QBCQuery3(){
			//创建对象引用
			Session session = null;
			Transaction ts = null;
			
			try {
//				得到我们的session
				session = HibernateUtils.getSessionFactory().openSession();
//				开启事务
				ts = session.beginTransaction();
				
				//使用QBC查询所有
				Criteria criteria = session.createCriteria(Student.class);
				
				//添加排训条件
				criteria.addOrder(Order.desc("id"));
				
				List<Student> list = criteria.list();
				
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
		//使用QBC分页查询
		@Test
		public void QBCQuery4(){
			//创建对象引用
			Session session = null;
			Transaction ts = null;
			
			try {
//				得到我们的session
				session = HibernateUtils.getSessionFactory().openSession();
//				开启事务
				ts = session.beginTransaction();
				
				//使用QBC查询所有
				Criteria criteria = session.createCriteria(Student.class);
				
				//添加分页信息
				criteria.setFirstResult(0);
				criteria.setMaxResults(2);
				
				List<Student> list = criteria.list();
				
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
		
		//使用QBC聚合函数查询
		@Test
		public void QBCQuery5(){
			//创建对象引用
			Session session = null;
			Transaction ts = null;
			
			try {
//				得到我们的session
				session = HibernateUtils.getSessionFactory().openSession();
//				开启事务
				ts = session.beginTransaction();
				
				//使用QBC查询所有
				Criteria criteria = session.createCriteria(Student.class);
				//设置操作
				criteria.setProjection(Projections.rowCount());
				
				//转换类型
				Object ob = criteria.uniqueResult();
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
	
		//使用QBC离线查询
		@Test
		public void QBCQuery6(){
			//创建对象引用
			Session session = null;
			Transaction ts = null;
			
			try {
//				得到我们的session
				session = HibernateUtils.getSessionFactory().openSession();
//				开启事务
				ts = session.beginTransaction();
				
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Student.class);
				//执行的时候才用到session
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				
				
				List<Student> list = criteria.list();
				
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
}
