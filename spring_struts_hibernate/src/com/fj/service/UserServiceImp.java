package com.fj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.UserDao;

@Transactional
public class UserServiceImp implements UserService {
	@Resource(name="UserDaoImp")
	private UserDao userDao;
	
	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		userDao.addUser();
	}

}
