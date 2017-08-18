package com.fj.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
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

	@Override
	public void delUser() {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(2);
		user.setName("付杰");
		user.setPassword("123145354");
		hibernateTemplate.delete(user);
	}

	@Override
	public void updUser() {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(1);
		user.setName("付大杰");
		user.setPassword("1243596620");
		hibernateTemplate.update(user);
	}

	@Override
	public void query() {
		// TODO Auto-generated method stub
		//User user = hibernateTemplate.get(User.class, 1);
		User user = hibernateTemplate.load(User.class, 1);
		System.out.println(user);
	}

	@Override
	public void queryList() {
		// TODO Auto-generated method stub
		//HQL
//		List<User> list = (List<User>) hibernateTemplate.find("from User");
//		

		//QBC
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		//分页查询
		List<User> list = (List<User>) hibernateTemplate.findByCriteria(criteria, 0, 2);
		//查看结果
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	

}
