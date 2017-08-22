package com.fj.dao;

import java.util.List;

import com.fj.domain.LinkMan;

public interface LinkManDao {
	//执行添加操作
	public void add(LinkMan linkMan);
	//显示所有
	public List<LinkMan> list();
	//查找用户
	public LinkMan findLinkManById(Integer linkid);
	//修改
	public void update(LinkMan linkMan);
	public void delete(Integer linkid);

}
