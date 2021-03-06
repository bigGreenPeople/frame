package com.fj.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.fj.domain.LinkMan;
import com.fj.service.LinkManService;

public class LinkManDaoImp extends BaseDaoImp<LinkMan> implements LinkManDao {
	//条件查询
	@SuppressWarnings("all")
	@Override
	public List<LinkMan> findCondition(LinkMan linkMan) {
		// TODO Auto-generated method stub
		//这里只会有两个条件
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		if(linkMan.getCustomer().getCid()!=null && linkMan.getCustomer().getCid()>0){
			criteria.add(Restrictions.eq("customer.cid", linkMan.getCustomer().getCid()));
		}
		if(linkMan.getLkmName()!=null && !"".equals(linkMan.getLkmName())){
			criteria.add(Restrictions.eq("lkmName", linkMan.getLkmName()));
		}
		
		return (List<LinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
	}
}
