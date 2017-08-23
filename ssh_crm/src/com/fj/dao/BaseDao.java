package com.fj.dao;

import java.util.List;

public interface BaseDao<T> {
	//添加
	public void add(T t);
	//修改
	public void update(T t);
	//删除
	public void delete(T t);
	//查询(根据id)
	public T findById(int id);
	//查询所有
	public List<T> findAll();
}
