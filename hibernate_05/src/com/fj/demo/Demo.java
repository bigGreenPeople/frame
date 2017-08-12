package com.fj.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.fj.domain.Goods;
import com.fj.domain.TypeGoods;
import com.fj.utils.HibernateUtils;

public class Demo {
	
//	我们在TypeGoods.hbm.xml中配置了
//	cascade="save-update,delete" inverse="true"
//	这个时候我们添加数据会出现什么情况？
	@Test
	public void testDemo(){
		Session session=null;
		Transaction ts = null;
		
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			ts = session.beginTransaction();
			
			//创建一个商品
			Goods goods = new Goods();
			goods.setGoodsName("小米6");
			goods.setPice(2700f);
			
			//创建一个分类
			TypeGoods typeGoods = new TypeGoods();
			typeGoods.setTypeName("手机类");
			
			//添加进分类的set中
			typeGoods.getSetGoods().add(goods);
			
			session.save(typeGoods);
			//结果为
//			数据都添加进去了
//			但是goods的外键为空
//			其实inverse放弃的是对外键的维护
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
