package com.fj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.LinkManDao;
import com.fj.domain.LinkMan;
@Transactional
public class LinkManServiceImp implements LinkManService {
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	//添加
	@Override
	public void addLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		linkManDao.add(linkMan);
	}
	
	//查找所有联系人
	@Override
	public List<LinkMan> listLinkMan() {
		// TODO Auto-generated method stub
		return linkManDao.findAll();
	}
	
	//查找联系人
	@Override
	public LinkMan findLinkManById(Integer linkid) {
		// TODO Auto-generated method stub
		return linkManDao.findById(linkid);
	}
	
	//修改联系人
	@Override
	public void update(LinkMan linkMan) {
		// TODO Auto-generated method stub
		linkManDao.update(linkMan);
	}
	
	//删除
	@Override
	public void delLinkMan(Integer linkid) {
		// TODO Auto-generated method stub
		//封装数据
		LinkMan linkMan = new LinkMan();
		linkMan.setLinkid(linkid);
		
		linkManDao.delete(linkMan);
	}
	
	//条件查询联系人
	@Override
	public List<LinkMan> findCondition(LinkMan linkMan) {
		// TODO Auto-generated method stub
		return linkManDao.findCondition(linkMan);
	}
}
