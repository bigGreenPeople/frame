package com.fj.service;

import java.util.List;

import com.fj.domain.User;

public interface UserService {
	public User userLogin(User user);
	//查询所有用户
	public List<User> findAll();
}
