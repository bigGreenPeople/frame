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

	@Override
	public void delUser() {
		// TODO Auto-generated method stub
		userDao.delUser();
	}

	@Override
	public void updUser() {
		// TODO Auto-generated method stub
		userDao.updUser();
	}

	@Override
	public void query() {
		// TODO Auto-generated method stub
		userDao.query();
	}

	@Override
	public void queryList() {
		// TODO Auto-generated method stub
		userDao.queryList();
	}

}
