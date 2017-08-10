package com.fj.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.fj.domain.Student;
import com.fj.domain.Teacher;
import com.fj.utils.HibernateUtils;

public class Demo {
	//��Զ�ļ�������
	@Test
	public void testSave() {
		Session session = null;
		Transaction ts = null;
		try {
			//�õ�session
			session = HibernateUtils.getSessionFactory().openSession();
			//��������
			ts = session.beginTransaction();
			
			//���в���
			//����������ʦ
			Teacher teacher1 = new Teacher();
			teacher1.setName("����ʦ");
			Teacher teacher2 = new Teacher();
			teacher2.setName("����ʦ");
			//��������ѧ��
			Student student1 = new Student();
			student1.setName("��ѧ��");
			Student student2 = new Student();
			student2.setName("��ѧ��");			
			Student student3 = new Student();
			student3.setName("Фѧ��");	
			
			//��Ϊ�����˼�����������ֻ��Ҫһ�����뼴��
			teacher1.getSetStudent().add(student1);
			teacher1.getSetStudent().add(student2);
			
			teacher2.getSetStudent().add(student3);
			
			//����
			session.save(teacher1);
			session.save(teacher2);
			
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
	
	//��Զ�ļ���ɾ��
		@Test
		public void testDelete() {
			Session session = null;
			Transaction ts = null;
			try {
				//�õ�session
				session = HibernateUtils.getSessionFactory().openSession();
				//��������
				ts = session.beginTransaction();
				
				//���в���
				//�õ�Ҫɾ������ʦ
				Teacher teacher = session.get(Teacher.class, 1);
				//����
				session.delete(teacher);
				
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
		
	//��Զ��ά��   Ҳ���Ǹı�����ű����Ϣ
	@Test
	public void testUpd() {
		Session session = null;
		Transaction ts = null;
		try {
			//�õ�session
			session = HibernateUtils.getSessionFactory().openSession();
			//��������
			ts = session.beginTransaction();
			
			//���в���
			//�õ���ʦ
			Teacher teacher = session.get(Teacher.class, 3);
			//�õ�ѧ��
			Student student = session.get(Student.class, 6);
			Student student2 = session.get(Student.class, 4);
			//����ʦ������ѧ��
			teacher.getSetStudent().remove(student2);
			//��Фѧ��Ҳ������ʦ����
			teacher.getSetStudent().add(student);
			
			//��Ϊ���Ƕ��ǳ־�̬���Բ���Ҫ��session���б���
			
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
