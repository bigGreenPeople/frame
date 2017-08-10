package com.fj.damain;

import java.util.HashSet;
import java.util.Set;

public class TypeGoods {
	private Integer id;
	private String typeName;
	//这里我们定义一个集合来装它所属的goods
	private Set<Goods> setGoods = new HashSet<Goods>();
	
	public TypeGoods() {
		// TODO Auto-generated constructor stub
	}
	
	

	public TypeGoods(Integer id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}



	public TypeGoods(Integer id, String typeName, Set<Goods> setGoods) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.setGoods = setGoods;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<Goods> getSetGoods() {
		return setGoods;
	}

	public void setSetGoods(Set<Goods> setGoods) {
		this.setGoods = setGoods;
	}
	
	
}
