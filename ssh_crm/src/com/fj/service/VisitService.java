package com.fj.service;

import java.util.List;

import com.fj.domain.Visit;

public interface VisitService {
	//添加
	public void addVisit(Visit visit);
	//显示
	public List<Visit> findAll();
	//多条件组合查询
	public List<Visit> findmultiselectCount(Visit visit);
}
