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
	//ʹ��QBC��ѯ����
	@Test
	public void QBCQuery1(){
		//������������
		Session session = null;
		Transaction ts = null;
		
		try {
//			�õ����ǵ�session
			session = HibernateUtils.getSessionFactory().openSession();
//			��������
			ts = session.beginTransaction();
			
			//ʹ��QBC��ѯ����
			Criteria criteria = session.createCriteria(Student.class);
			
			List<Student> list = criteria.list();
			
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
	
	//ʹ��QBC������ѯ
	@Test
	public void QBCQuery2(){
		//������������
		Session session = null;
		Transaction ts = null;
		
		try {
//			�õ����ǵ�session
			session = HibernateUtils.getSessionFactory().openSession();
//			��������
			ts = session.beginTransaction();
			
			//ʹ��QBC��ѯ����
			Criteria criteria = session.createCriteria(Student.class);
			//��ʼ������� 
			//criteria.add(Restrictions.eq("id", 4));
			//ģ����ѯ
			criteria.add(Restrictions.like("name", "%ѧ��"));
			List<Student> list = criteria.list();
			
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
	
	//ʹ��QBC�����ѯ
		@Test
		public void QBCQuery3(){
			//������������
			Session session = null;
			Transaction ts = null;
			
			try {
//				�õ����ǵ�session
				session = HibernateUtils.getSessionFactory().openSession();
//				��������
				ts = session.beginTransaction();
				
				//ʹ��QBC��ѯ����
				Criteria criteria = session.createCriteria(Student.class);
				
				//�����ѵ����
				criteria.addOrder(Order.desc("id"));
				
				List<Student> list = criteria.list();
				
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
		//ʹ��QBC��ҳ��ѯ
		@Test
		public void QBCQuery4(){
			//������������
			Session session = null;
			Transaction ts = null;
			
			try {
//				�õ����ǵ�session
				session = HibernateUtils.getSessionFactory().openSession();
//				��������
				ts = session.beginTransaction();
				
				//ʹ��QBC��ѯ����
				Criteria criteria = session.createCriteria(Student.class);
				
				//��ӷ�ҳ��Ϣ
				criteria.setFirstResult(0);
				criteria.setMaxResults(2);
				
				List<Student> list = criteria.list();
				
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
		
		//ʹ��QBC�ۺϺ�����ѯ
		@Test
		public void QBCQuery5(){
			//������������
			Session session = null;
			Transaction ts = null;
			
			try {
//				�õ����ǵ�session
				session = HibernateUtils.getSessionFactory().openSession();
//				��������
				ts = session.beginTransaction();
				
				//ʹ��QBC��ѯ����
				Criteria criteria = session.createCriteria(Student.class);
				//���ò���
				criteria.setProjection(Projections.rowCount());
				
				//ת������
				Object ob = criteria.uniqueResult();
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
	
		//ʹ��QBC���߲�ѯ
		@Test
		public void QBCQuery6(){
			//������������
			Session session = null;
			Transaction ts = null;
			
			try {
//				�õ����ǵ�session
				session = HibernateUtils.getSessionFactory().openSession();
//				��������
				ts = session.beginTransaction();
				
				DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Student.class);
				//ִ�е�ʱ����õ�session
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				
				
				List<Student> list = criteria.list();
				
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
}
