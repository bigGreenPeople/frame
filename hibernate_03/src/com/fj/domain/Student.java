package com.fj.domain;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private Integer id;
	private String name;
	private Set<Teacher> setTeacher = new HashSet<Teacher>();
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(Integer id, String name, Set<Teacher> setTeacher) {
		super();
		this.id = id;
		this.name = name;
		this.setTeacher = setTeacher;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Teacher> getSetTeacher() {
		return setTeacher;
	}

	public void setSetTeacher(Set<Teacher> setTeacher) {
		this.setTeacher = setTeacher;
	}
	
	
}
