package com.fj.service;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.UserDao;
import com.fj.domain.User;

@Transactional
public class UserServiceImp implements UserService {
	
	private UserDao userDao;
	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	//µÇÂ¼
	@Override
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		return userDao.userLogin(user);
	}

}
