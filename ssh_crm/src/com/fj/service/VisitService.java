package com.fj.service;

import java.util.List;

import com.fj.domain.Visit;

public interface VisitService {
	//����
	public void addVisit(Visit visit);
	//��ʾ
	public List<Visit> findAll();
}
