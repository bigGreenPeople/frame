package com.fj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.EmpDao;

public class EmpServiceImp implements EmpService {
	//创建dao对象
	@Resource(name="empDaoImp")
	private EmpDao empDao;

	@Override
//	propagation配置的是传播行为（就是是不是同一事务，配置为可重复读）
	@Transactional(propagation=Propagation.REQUIRED)
	public void transfer(String from, String to, int money) {
		// TODO Auto-generated method stub
		//减少钱
		empDao.outMoney(from, money);
		
		//int i = 0/0;
		//增加钱
		empDao.inMoney(to, money);
	}

}
