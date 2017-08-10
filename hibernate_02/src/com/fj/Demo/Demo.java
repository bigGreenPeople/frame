package com.fj.Demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.fj.damain.Goods;
import com.fj.damain.TypeGoods;
import com.fj.utils.HibernateUtils;

public class Demo {
	//�˷�����
	@Test
	public void testAddDemo(){
		Session session = null;
		Transaction tc = null;
		try {
			//�������� 
			session = HibernateUtils.getSessionFactory().openSession();
			//�������ǵ�����
			tc = session.beginTransaction();
			
			//��ʼ���ǵĲ���
			//�ȴ�������
			TypeGoods typeGoods  = new TypeGoods();
			typeGoods.setTypeName("צ��");
			//���ʱ��goods�Ѿ��з�����
			Goods goods = new Goods();
			goods.setGoodsName("�ݽ���צ");
			goods.setPice(40f);
			goods.setTypeGoods(typeGoods);
			//������������ ���༯����������Ʒ
			typeGoods.getSetGoods().add(goods);
			
			//���浽���ݿ�
			//������ע�⣺����Ӧ���ȱ���һ����һ�ű�
			//Ҳ����˵���������һ�ű�Ӧ�ú󱣴�
			//����һ�㣺��Ϊhibernate��˫��ά����������
			//��goods������������ݺ󻹻����һ��goods�����   ʹ��inverse=true������һ��update���
			session.save(typeGoods);
			session.save(goods);
			
			
			//�ύ����
			tc.commit();
		} catch (Exception e) {
			// TODO: handle exception
			//�ع�����
			if(tc!=null){
				tc.rollback();
			}
		}finally{
			//�ͷ���Դ
			if(session!=null){
				session.close();
				
			}
		}
	}
	
	
	//������������ʾ��������
	//�����������Ǳ���һ�����������й�ϵ�Ķ����һ����뵽�����ݿ�����
	//ע����������ӳ���ļ��е�set��ǩ���޸� cascade ������ Ϊ save-update
	@Test
	public void testAddDemo2(){
		Session session = null;
		Transaction tc = null;
		try {
			//�������� 
			session = HibernateUtils.getSessionFactory().openSession();
			//�������ǵ�����
			tc = session.beginTransaction();
			
			//��ʼ���ǵĲ���
			//�ȴ�������
			//�������ǲ�����������idֵ
			TypeGoods typeGoods  = new TypeGoods();
			typeGoods.setTypeName("����");
			//���ʱ��goods�Ѿ��з�����	������ʾ�����������������һ��nullֵ
			Goods goods = new Goods();
			goods.setGoodsName("ţ����");
			goods.setPice(20f);
			//������������ ���༯����������Ʒ
			typeGoods.getSetGoods().add(goods);
			
			//���浽���ݿ�
			//������ע�⣺����Ӧ���ȱ���һ����һ�ű�
			//Ҳ����˵���������һ�ű�Ӧ�ú󱣴�
			//����һ�㣺��Ϊhibernate��˫��ά����������
			//��goods������������ݺ󻹻����һ��goods�����  
			//��������ֻ��Ҫ����һ������
			session.save(typeGoods);
//			session.save(goods);
			
			
			//�ύ����
			tc.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//�ع�����
			if(tc!=null){
				tc.rollback();
			}
		}finally{
			//�ͷ���Դ
			if(session!=null){
				session.close();
				
			}
		}
	}
	
	//������������ʾ����ɾ��
		//�����������Ǳ���һ�����������й�ϵ�Ķ����һ��Ӱ�쵽�����ݿ�����
		//ע����������ӳ���ļ��е�set��ǩ���޸� cascade ������ Ϊ save-update,delete
		@Test
		public void testDeleteDemo(){
			Session session = null;
			Transaction tc = null;
			try {
				//�������� 
				session = HibernateUtils.getSessionFactory().openSession();
				//�������ǵ�����
				tc = session.beginTransaction();
				
				//��ʼ���ǵĲ���
				//�Ȳ�ѯ�õ�����
				TypeGoods typeGoods = session.get(TypeGoods.class, 7);
				//���÷���ɾ��	��Ϊ�����˼���ɾ����������Ὣ�������ָ�������һ��ɾ��
				session.delete(typeGoods);
				
				//ɾ���ײ�Ĳ�����������:
				//���ҵ�goods����������Ϊ7������
				//��goods�����Ϊ7�������Ϊnull
				//Ȼ�����ɾ��
				
				
				//�ύ����
				tc.commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				//�ع�����
				if(tc!=null){
					tc.rollback();
				}
			}finally{
				//�ͷ���Դ
				if(session!=null){
					session.close();
					
				}
			}
		}
		
	//������������ʾ�����޸�
			//�����������Ǳ���һ�����������й�ϵ�Ķ����һ��Ӱ�쵽�����ݿ�����
			//ע����������ӳ���ļ��е�set��ǩ���޸� cascade ������ Ϊ save-update,delete
			@Test
			public void testUpdateDemo(){
				Session session = null;
				Transaction tc = null;
				try {
					//�������� 
					session = HibernateUtils.getSessionFactory().openSession();
					//�������ǵ�����
					tc = session.beginTransaction();
					
					//��ʼ���ǵĲ���
					//�Ȳ�ѯ�õ�����
					Goods goods = session.get(Goods.class, 2);
					TypeGoods typeGoods = session.get(TypeGoods.class, 2);
					typeGoods.getSetGoods().add(goods);
					
					//�ύ����
					tc.commit();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					//�ع�����
					if(tc!=null){
						tc.rollback();
					}
				}finally{
					//�ͷ���Դ
					if(session!=null){
						session.close();
						
					}
				}
			}
}
