package com.fj.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.fj.dao.UserDao;

public class UserServiceImp implements UserService {
	
	//����dao������	ע�ⷽʽע��
	@Resource(name="userDaoImp")
	private UserDao userDao;

	@Override
	public void saveUser() {
		// TODO Auto-generated method stub
		//���������ļ�
		userDao.save();
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		userDao.delete();
	}

	@Override
	public void updateUser() {
		// TODO Auto-generated method stub
		userDao.update();
	}

	@Override
	public void queryUser() {
		// TODO Auto-generated method stub
		userDao.queryUser();
	}

	@Override
	public void queryUserList() {
		// TODO Auto-generated method stub
		userDao.queryUserList();
	}

	
}
