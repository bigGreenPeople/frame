package com.fj.service;

import java.util.List;

import com.fj.domain.LinkMan;

public interface LinkManService {
	//������ϵ��
	public void addLinkMan(LinkMan linkMan);
	//��ʾ���е���ϵ��
	public List<LinkMan> listLinkMan();

}