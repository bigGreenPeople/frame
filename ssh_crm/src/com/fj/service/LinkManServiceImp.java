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
		return linkManDao.list();
	}
}
