package com.fj.dao;

import java.util.List;

import com.fj.domain.Visit;

public interface VisitDao extends BaseDao<Visit>{
	//������ѯ
	List<Visit> findmultiselectCount(Visit visit);
	
}
