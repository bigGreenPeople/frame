package com.fj.dao;

import java.util.List;

import com.fj.domain.User;

public interface UserDao {
	// ��¼
	public User userLogin(User user);
	
	public List<User> findAll();
}
