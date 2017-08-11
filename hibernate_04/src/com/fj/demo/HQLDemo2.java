package com.fj.demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.fj.domain.Student;
import com.fj.domain.Teacher;
import com.fj.utils.HibernateUtils;

public class HQLDemo2 {
	//HQL多表查询
	//内连接
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
			//注意这里setTeacher区分大小写
			Query query = session.createQuery("from Student s inner join s.setTeacher");
			
			//这里的对象数组一个可以转换为Student 一个可以转换为Teacher
			List<Object[]> list = query.list();
			
			//打印出所有的学生
			for (Object[] objects : list) {
				Student s = (Student)objects[0];
				Teacher t = (Teacher)objects[1];
				System.out.println(s.getId()+"  "+s.getName()+ "   "+t.getId()+"    "+t.getName());
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

	//内迫切连接
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
			//注意这里setTeacher区分大小写
			Query query = session.createQuery("from Student s inner join fetch s.setTeacher");
			
			//信息直接在Student里面
			List<Student> list = query.list();
			
			//打印出所有的学生
			for (Student student : list) {
				System.out.print(student.getId()+"   "+student.getName());
				
				for (Teacher teacher : student.getSetTeacher()) {
					System.out.print("----"+teacher.getId()+"   "+teacher.getName());
				}
				
				System.out.println();
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

	
	//左外连接
		@Test
		public void HQLQuery3(){
			//创建对象引用
			Session session = null;
			Transaction ts = null;
			
			try {
//				得到我们的session
				session = HibernateUtils.getSessionFactory().openSession();
//				开启事务
				ts = session.beginTransaction();
				
				//使用HQL查询所有
				//注意这里setTeacher区分大小写
				Query query = session.createQuery("from Student s left outer join s.setTeacher");
				
				//这里的对象数组一个可以转换为Student 一个可以转换为Teacher
				List<Object[]> list = query.list();
				
				//打印出所有的学生
				for (Object[] objects : list) {
					Student s = (Student)objects[0];
					Teacher t = (Teacher)objects[1];
					if(t!=null){
						System.out.println(s.getId()+"  "+s.getName()+ "   "+t.getId()+"    "+t.getName());
					}else{
						System.out.println(s.getId()+"  "+s.getName()+ "   "+"null"+"    "+"null");
					}
					
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
	
		//迫切左外连接
	@Test
	public void HQLQuery4(){
		//创建对象引用
		Session session = null;
		Transaction ts = null;
		
		try {
//			得到我们的session
			session = HibernateUtils.getSessionFactory().openSession();
//			开启事务
			ts = session.beginTransaction();
			
			//使用HQL查询所有
			//注意这里setTeacher区分大小写
			Query query = session.createQuery("from Student s left outer join fetch s.setTeacher");
			
			//信息直接在Student里面
			List<Student> list = query.list();
			
			//打印出所有的学生
			for (Student student : list) {
				System.out.print(student.getId()+"   "+student.getName());
				
				for (Teacher teacher : student.getSetTeacher()) {
					System.out.print("----"+teacher.getId()+"   "+teacher.getName());
				}
				
				System.out.println();
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
