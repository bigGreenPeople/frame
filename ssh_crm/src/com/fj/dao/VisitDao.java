package com.fj.dao;

import java.util.List;

import com.fj.domain.Visit;

public interface VisitDao {

	public List<Visit> findAll();

	public void add(Visit visit);
	
}
