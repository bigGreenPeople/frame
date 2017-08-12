package com.fj.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.fj.domain.Goods;
import com.fj.domain.TypeGoods;
import com.fj.utils.HibernateUtils;

public class Demo {
	
//	������TypeGoods.hbm.xml��������
//	cascade="save-update,delete" inverse="true"
//	���ʱ������������ݻ����ʲô�����
	@Test
	public void testDemo(){
		Session session=null;
		Transaction ts = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			ts = session.beginTransaction();
			
			//����һ����Ʒ
			Goods goods = new Goods();
			goods.setGoodsName("С��6");
			goods.setPice(2700f);
			
			//����һ������
			TypeGoods typeGoods = new TypeGoods();
			typeGoods.setTypeName("�ֻ���");
			
			//��ӽ������set��
			typeGoods.getSetGoods().add(goods);
			
			session.save(typeGoods);
			//���Ϊ
//			���ݶ���ӽ�ȥ��
//			����goods�����Ϊ��
//			��ʵinverse�������Ƕ������ά��
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
