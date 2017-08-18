package com.fj.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.fj.domian.User;

public class UserDaoImp implements UserDao {

//	使用spring的hibernate模板
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		//现在这里创建对象
		User user = new User();
		user.setId(2);
		user.setName("付杰");
		user.setPassword("123145354");
		
		//加入对象
		hibernateTemplate.save(user);
	}

}
