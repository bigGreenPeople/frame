package com.fj.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fj.domain.Customer;

public class CustomerDaoImp extends HibernateDaoSupport implements CustomerDao {

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(customer);
	}

}
