package com.fj.Demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.fj.damain.Goods;
import com.fj.damain.TypeGoods;
import com.fj.utils.HibernateUtils;

public class Demo {
	//此方法中
	@Test
	public void testAddDemo(){
		Session session = null;
		Transaction tc = null;
		try {
			//创建加载 
			session = HibernateUtils.getSessionFactory().openSession();
			//开启我们的事务
			tc = session.beginTransaction();
			
			//开始我们的操作
			//先创建对象
			TypeGoods typeGoods  = new TypeGoods();
			typeGoods.setTypeName("爪类");
			//这个时候goods已经有分类了
			Goods goods = new Goods();
			goods.setGoodsName("泡椒凤爪");
			goods.setPice(40f);
			goods.setTypeGoods(typeGoods);
			//我们再来配置 分类集合里面有商品
			typeGoods.getSetGoods().add(goods);
			
			//保存到数据库
			//这里请注意：我们应该先保存一的那一张表
			//也就是说有外键的那一张表应该后保存
			//还有一点：因为hibernate是双向维护的所以在
			//往goods表中添加完数据后还会更新一次goods的外键   使用inverse=true可以少一次update语句
			session.save(typeGoods);
			session.save(goods);
			
			
			//提交事务
			tc.commit();
		} catch (Exception e) {
			// TODO: handle exception
			//回滚事务
			if(tc!=null){
				tc.rollback();
			}
		}finally{
			//释放资源
			if(session!=null){
				session.close();
				
			}
		}
	}
	
	
	//这里我们来演示级联操作
	//级联操作就是保存一个对象与它有关系的对象就一起加入到了数据库中了
	//注意我们先在映射文件中的set标签中修改 cascade 的属性 为 save-update
	@Test
	public void testAddDemo2(){
		Session session = null;
		Transaction tc = null;
		try {
			//创建加载 
			session = HibernateUtils.getSessionFactory().openSession();
			//开启我们的事务
			tc = session.beginTransaction();
			
			//开始我们的操作
			//先创建对象
			//这里我们不能设置它的id值
			TypeGoods typeGoods  = new TypeGoods();
			typeGoods.setTypeName("肉类");
			//这个时候goods已经有分类了	这里演示级联操作我特意给了一个null值
			Goods goods = new Goods();
			goods.setGoodsName("牛肉粒");
			goods.setPice(20f);
			//我们再来配置 分类集合里面有商品
			typeGoods.getSetGoods().add(goods);
			
			//保存到数据库
			//这里请注意：我们应该先保存一的那一张表
			//也就是说有外键的那一张表应该后保存
			//还有一点：因为hibernate是双向维护的所以在
			//往goods表中添加完数据后还会更新一次goods的外键  
			//级联操作只需要保存一个对象
			session.save(typeGoods);
//			session.save(goods);
			
			
			//提交事务
			tc.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//回滚事务
			if(tc!=null){
				tc.rollback();
			}
		}finally{
			//释放资源
			if(session!=null){
				session.close();
				
			}
		}
	}
	
	//这里我们来演示级联删除
		//级联操作就是保存一个对象与它有关系的对象就一起影响到了数据库中了
		//注意我们先在映射文件中的set标签中修改 cascade 的属性 为 save-update,delete
		@Test
		public void testDeleteDemo(){
			Session session = null;
			Transaction tc = null;
			try {
				//创建加载 
				session = HibernateUtils.getSessionFactory().openSession();
				//开启我们的事务
				tc = session.beginTransaction();
				
				//开始我们的操作
				//先查询得到对象
				TypeGoods typeGoods = session.get(TypeGoods.class, 7);
				//调用方法删除	因为设置了级联删除所以这里会将其外键所指向的数据一起删除
				session.delete(typeGoods);
				
				//删除底层的操作是这样的:
				//先找到goods表的所有外键为7的数据
				//将goods表外键为7的外键置为null
				//然后进行删除
				
				
				//提交事务
				tc.commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				//回滚事务
				if(tc!=null){
					tc.rollback();
				}
			}finally{
				//释放资源
				if(session!=null){
					session.close();
					
				}
			}
		}
		
	//这里我们来演示级联修改
			//级联操作就是保存一个对象与它有关系的对象就一起影响到了数据库中了
			//注意我们先在映射文件中的set标签中修改 cascade 的属性 为 save-update,delete
			@Test
			public void testUpdateDemo(){
				Session session = null;
				Transaction tc = null;
				try {
					//创建加载 
					session = HibernateUtils.getSessionFactory().openSession();
					//开启我们的事务
					tc = session.beginTransaction();
					
					//开始我们的操作
					//先查询得到对象
					Goods goods = session.get(Goods.class, 2);
					TypeGoods typeGoods = session.get(TypeGoods.class, 2);
					typeGoods.getSetGoods().add(goods);
					
					//提交事务
					tc.commit();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					//回滚事务
					if(tc!=null){
						tc.rollback();
					}
				}finally{
					//释放资源
					if(session!=null){
						session.close();
						
					}
				}
			}
}
