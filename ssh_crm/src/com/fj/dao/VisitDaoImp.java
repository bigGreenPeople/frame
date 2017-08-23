package com.fj.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fj.domain.Visit;

public class VisitDaoImp extends HibernateDaoSupport implements VisitDao {
	@Override
	public void add(Visit visit) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(visit);
	}
	
	@Override
	public List<Visit> findAll() {
		// TODO Auto-generated method stub
		return (List<Visit>) this.getHibernateTemplate().find("from Visit");
	}
}
