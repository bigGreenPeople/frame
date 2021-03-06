package com.fj.service;

import java.util.List;

import com.fj.domain.LinkMan;

public interface LinkManService {
	//添加联系人
	public void addLinkMan(LinkMan linkMan);
	//显示所有的联系人
	public List<LinkMan> listLinkMan();
	public LinkMan findLinkManById(Integer linkid);
	public void update(LinkMan linkMan);
	public void delLinkMan(Integer linkid);
	//条件查询
	public List<LinkMan> findCondition(LinkMan linkMan);
}
