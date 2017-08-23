package com.fj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.VisitDao;
import com.fj.domain.Visit;

@Transactional
public class VisitServiceImp implements VisitService {
	private VisitDao visitDao;

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}
	//���
	@Override
	public void addVisit(Visit visit) {
		// TODO Auto-generated method stub
		visitDao.add(visit);
	}
	//��ʾ����
	@Override
	public List<Visit> findAll() {
		// TODO Auto-generated method stub
		return visitDao.findAll();
	}
	
}
