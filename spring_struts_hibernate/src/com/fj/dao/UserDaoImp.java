package com.fj.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.fj.domian.User;

public class UserDaoImp implements UserDao {

//	ʹ��spring��hibernateģ��
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		//�������ﴴ������
		User user = new User();
		user.setId(2);
		user.setName("����");
		user.setPassword("123145354");
		
		//�������
		hibernateTemplate.save(user);
	}

}
