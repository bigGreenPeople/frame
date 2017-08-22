package com.fj.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fj.domain.LinkMan;
import com.fj.service.LinkManService;

public class LinkManDaoImp extends HibernateDaoSupport implements LinkManDao {
	@Override
	//添加
	public void add(LinkMan linkMan) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(linkMan);
	}
	//显示所有
	@Override
	public List<LinkMan> list() {
		// TODO Auto-generated method stub
		//查找所有的联系人
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
		
		return list;
	}
}
