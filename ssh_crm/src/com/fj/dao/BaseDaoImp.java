package com.fj.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
@SuppressWarnings("all")
public class BaseDaoImp<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	//泛型的实际类型
	private Class pclazz;
	
	//使用构造方法	得到父类的泛型信息
	public BaseDaoImp() {
		// TODO Auto-generated constructor stub
		//先得到我们的类信息
		Class clazz = this.getClass();
		//得到参数化类型BaseDaoImp<Customer>
		Type type = clazz.getGenericSuperclass();
		//转换为子接口
		ParameterizedType ptype = (ParameterizedType) type;
		//得到<Customer>
		Type[] types = ptype.getActualTypeArguments();
		//把Type转换为Class(Type是Class的接口)
		//这样就得到了我们泛型传递过来的实际类了
		pclazz = (Class) types[0];
		System.out.println(pclazz);
		
	}
	
	//增加
	@Override
	public void add(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(t);
	}
	//修改
	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(t);
	}
	//删除
	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(t);
	}
	
	//下面两个方法要使用到泛型的名字我们同一在构造方法里面得到泛型的信息
	//根据id查询
	@Override
	public T findById(int id) {
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(pclazz, id);
	}
	//查询所有
	
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) this.getHibernateTemplate().find("from "+pclazz.getSimpleName());
	}
	
}
