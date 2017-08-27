package com.fj.dao;

import com.fj.po.User;

public interface UserDao {
	public User getUserById(int id) throws Exception;
	public void insertUser(User user) throws Exception;

}
