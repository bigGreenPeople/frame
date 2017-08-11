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
	//ʹ��HQL��ѯ����
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
			Query query = session.createQuery("from Student");
			List<Student> list = query.list();
			
			//��ӡ�����е�ѧ��
			for (Student student : list) {
				System.out.println(student.getId()+"  "+student.getName());
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

	//ʹ��HQL���������ѯ	�Լ� ģ����ѯ
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
			//Query query = session.createQuery("from Student where id=? and name=?");
//			���ʺ�ע��ֵ
//			query.setParameter(0, 4);
//			query.setParameter(1, "��ѧ��");
			
//			Student student = (Student) query.uniqueResult();
			
			//��ӡ�����е�ѧ��
			//System.out.println(student.getName()+"   "+student.getId());
			
//			��дhql���
			Query query = session.createQuery("from Student where name like ?");
			
			//����ֵ
			query.setParameter(0, "%ѧ��");
			
			List<Student> list = query.list();
			
			for (Student student : list) {
				System.out.println(student.getName()+"   "+student.getId());
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
	//ʹ��HQL�����ѯ
	@Test
	public void HQLQuery3(){
		//������������
		Session session = null;
		Transaction ts = null;
		
		try {
//			�õ����ǵ�session
			session = HibernateUtils.getSessionFactory().openSession();
//			��������
			ts = session.beginTransaction();
			
			//ʹ��HQL�����ѯ����	
			Query query = session.createQuery("from Student order by id desc");
			List<Student> list = query.list();
			
			//��ӡ�����е�ѧ��
			for (Student student : list) {
				System.out.println(student.getId()+"  "+student.getName());
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
	
	//ʹ��HQL��ҳ��ѯ
		@Test
		public void HQLQuery4(){
			//������������
			Session session = null;
			Transaction ts = null;
			
			try {
//				�õ����ǵ�session
				session = HibernateUtils.getSessionFactory().openSession();
//				��������
				ts = session.beginTransaction();
				
				//ʹ��HQL�����ѯ����	
				Query query = session.createQuery("from Student order");
				//���÷�ҳ�����￪ʼ
				query.setFirstResult(0);
				//���÷�ҳ��ҳ��
				query.setMaxResults(2);
				List<Student> list = query.list();
				
				//��ӡ�����е�ѧ��
				for (Student student : list) {
					System.out.println(student.getId()+"  "+student.getName());
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
		
		//ʹ��HQLͶӰ��ѯ(���ǲ�һЩ�ֶ�)
		@Test
		public void HQLQuery5(){
			//������������
			Session session = null;
			Transaction ts = null;
			
			try {
//				�õ����ǵ�session
				session = HibernateUtils.getSessionFactory().openSession();
//				��������
				ts = session.beginTransaction();
				
				//ʹ��HQL��ѯname����
				Query query = session.createQuery("select name from Student");
				List list = query.list();
				
				//��ӡ�����е�ѧ��
				for (Object student : list) {
					System.out.println(student);
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

		//ʹ��HQL�ۼ�������ʹ��
		@Test
		public void HQLQuery6(){
			//������������
			Session session = null;
			Transaction ts = null;
			
			try {
//				�õ����ǵ�session
				session = HibernateUtils.getSessionFactory().openSession();
//				��������
				ts = session.beginTransaction();
				
				//ʹ��HQL��ѯ����
				Query query = session.createQuery("select count(*) from Student");
				
				//�õ������һ��object 
				Object ob = query.uniqueResult();
				//ת������
				int count = ((Long)ob).intValue();
				System.out.println(count);
				
				
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
