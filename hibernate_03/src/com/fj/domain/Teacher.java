package com.fj.domain;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	private Integer id;
	private String name;
	private Set<Student> setStudent = new HashSet<Student>();
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(Integer id, String name, Set<Student> setStudent) {
		super();
		this.id = id;
		this.name = name;
		this.setStudent = setStudent;
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

	public Set<Student> getSetStudent() {
		return setStudent;
	}

	public void setSetStudent(Set<Student> setStudent) {
		this.setStudent = setStudent;
	}
	
	
	
	
}
