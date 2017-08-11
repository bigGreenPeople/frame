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
	//HQL����ѯ
	//������
	@Test
	public void HQLQuery1(){
		//������������
		Session session = null;
		Transaction ts = null;
		
		try {
//			�õ����ǵ�session
			session = HibernateUtils.getSessionFactory().openSession();
//			��������
			ts = session.beginTransaction();
			
			//ʹ��HQL��ѯ����
			//ע������setTeacher���ִ�Сд
			Query query = session.createQuery("from Student s inner join s.setTeacher");
			
			//����Ķ�������һ������ת��ΪStudent һ������ת��ΪTeacher
			List<Object[]> list = query.list();
			
			//��ӡ�����е�ѧ��
			for (Object[] objects : list) {
				Student s = (Student)objects[0];
				Teacher t = (Teacher)objects[1];
				System.out.println(s.getId()+"  "+s.getName()+ "   "+t.getId()+"    "+t.getName());
			}
			
			//�ύ����
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

	//����������
	@Test
	public void HQLQuery2(){
		//������������
		Session session = null;
		Transaction ts = null;
		
		try {
//			�õ����ǵ�session
			session = HibernateUtils.getSessionFactory().openSession();
//			��������
			ts = session.beginTransaction();
			
			//ʹ��HQL��ѯ����
			//ע������setTeacher���ִ�Сд
			Query query = session.createQuery("from Student s inner join fetch s.setTeacher");
			
			//��Ϣֱ����Student����
			List<Student> list = query.list();
			
			//��ӡ�����е�ѧ��
			for (Student student : list) {
				System.out.print(student.getId()+"   "+student.getName());
				
				for (Teacher teacher : student.getSetTeacher()) {
					System.out.print("----"+teacher.getId()+"   "+teacher.getName());
				}
				
				System.out.println();
			}
			
			//�ύ����
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

	
	//��������
		@Test
		public void HQLQuery3(){
			//������������
			Session session = null;
			Transaction ts = null;
			
			try {
//				�õ����ǵ�session
				session = HibernateUtils.getSessionFactory().openSession();
//				��������
				ts = session.beginTransaction();
				
				//ʹ��HQL��ѯ����
				//ע������setTeacher���ִ�Сд
				Query query = session.createQuery("from Student s left outer join s.setTeacher");
				
				//����Ķ�������һ������ת��ΪStudent һ������ת��ΪTeacher
				List<Object[]> list = query.list();
				
				//��ӡ�����е�ѧ��
				for (Object[] objects : list) {
					Student s = (Student)objects[0];
					Teacher t = (Teacher)objects[1];
					if(t!=null){
						System.out.println(s.getId()+"  "+s.getName()+ "   "+t.getId()+"    "+t.getName());
					}else{
						System.out.println(s.getId()+"  "+s.getName()+ "   "+"null"+"    "+"null");
					}
					
				}
				
				//�ύ����
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
	
		//������������
	@Test
	public void HQLQuery4(){
		//������������
		Session session = null;
		Transaction ts = null;
		
		try {
//			�õ����ǵ�session
			session = HibernateUtils.getSessionFactory().openSession();
//			��������
			ts = session.beginTransaction();
			
			//ʹ��HQL��ѯ����
			//ע������setTeacher���ִ�Сд
			Query query = session.createQuery("from Student s left outer join fetch s.setTeacher");
			
			//��Ϣֱ����Student����
			List<Student> list = query.list();
			
			//��ӡ�����е�ѧ��
			for (Student student : list) {
				System.out.print(student.getId()+"   "+student.getName());
				
				for (Teacher teacher : student.getSetTeacher()) {
					System.out.print("----"+teacher.getId()+"   "+teacher.getName());
				}
				
				System.out.println();
			}
			
			//�ύ����
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
