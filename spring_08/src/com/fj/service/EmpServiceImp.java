package com.fj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.EmpDao;

public class EmpServiceImp implements EmpService {
	//����dao����
	@Resource(name="empDaoImp")
	private EmpDao empDao;

	@Override
//	propagation���õ��Ǵ�����Ϊ�������ǲ���ͬһ��������Ϊ���ظ�����
	@Transactional(propagation=Propagation.REQUIRED)
	public void transfer(String from, String to, int money) {
		// TODO Auto-generated method stub
		//����Ǯ
		empDao.outMoney(from, money);
		
		//int i = 0/0;
		//����Ǯ
		empDao.inMoney(to, money);
	}

}
