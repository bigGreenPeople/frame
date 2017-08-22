package com.fj.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fj.domain.User;

public class UserDaoImp extends HibernateDaoSupport implements UserDao {

	@Override
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		@SuppressWarnings("all")
		List<User> list = (List<User>) this.getHibernateTemplate().find
				("from User where username=? and password=?", user.getUsername(),user.getPassword());
		//�ж�list����û��ֵ
		if(list!=null && list.size()!=0){
			//�������ǵĵ�¼�û�
			return list.get(0);
		}
		return null;
	}

}