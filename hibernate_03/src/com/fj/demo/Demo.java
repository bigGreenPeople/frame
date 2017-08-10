package com.fj.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.fj.domain.Student;
import com.fj.domain.Teacher;
import com.fj.utils.HibernateUtils;

public class Demo {
	//多对多的级联操作
	@Test
	public void testSave() {
		Session session = null;
		Transaction ts = null;
		try {
			//得到session
			session = HibernateUtils.getSessionFactory().openSession();
			//开启事务
			ts = session.beginTransaction();
			
			//进行操作
			//创建俩个老师
			Teacher teacher1 = new Teacher();
			teacher1.setName("付老师");
			Teacher teacher2 = new Teacher();
			teacher2.setName("顾老师");
			//创建两个学生
			Student student1 = new Student();
			student1.setName("李学生");
			Student student2 = new Student();
			student2.setName("廖学生");			
			Student student3 = new Student();
			student3.setName("肖学生");	
			
			//因为配置了级联操作我们只需要一方加入即可
			teacher1.getSetStudent().add(student1);
			teacher1.getSetStudent().add(student2);
			
			teacher2.getSetStudent().add(student3);
			
			//保存
			session.save(teacher1);
			session.save(teacher2);
			
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
	
	//多对多的级联删除
		@Test
		public void testDelete() {
			Session session = null;
			Transaction ts = null;
			try {
				//得到session
				session = HibernateUtils.getSessionFactory().openSession();
				//开启事务
				ts = session.beginTransaction();
				
				//进行操作
				//得到要删除的老师
				Teacher teacher = session.get(Teacher.class, 1);
				//保存
				session.delete(teacher);
				
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
		
	//多对多的维护   也就是改变第三张表的信息
	@Test
	public void testUpd() {
		Session session = null;
		Transaction ts = null;
		try {
			//得到session
			session = HibernateUtils.getSessionFactory().openSession();
			//开启事务
			ts = session.beginTransaction();
			
			//进行操作
			//得到老师
			Teacher teacher = session.get(Teacher.class, 3);
			//得到学生
			Student student = session.get(Student.class, 6);
			Student student2 = session.get(Student.class, 4);
			//付老师开除李学生
			teacher.getSetStudent().remove(student2);
			//让肖学生也到付老师手下
			teacher.getSetStudent().add(student);
			
			//因为他们都是持久态所以不需要用session进行保存
			
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
