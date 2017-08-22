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

	//���
	@Override
	public void addLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		linkManDao.add(linkMan);
	}
	
	//����������ϵ��
	@Override
	public List<LinkMan> listLinkMan() {
		// TODO Auto-generated method stub
		return linkManDao.list();
	}
}
