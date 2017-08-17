package com.fj.dao;

public interface UserDao {
	//增加
	public void save();
	//删除
	public void delete();
	//修改
	public void update();
	//查询单个用户
	public void queryUser();
	//查询多个用户
	public void queryUserList();
}
