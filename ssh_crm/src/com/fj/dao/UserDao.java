package com.fj.dao;

import java.util.List;

import com.fj.domain.User;

public interface UserDao extends BaseDao<User>{
	// ��¼
	public User userLogin(User user);
	
}
