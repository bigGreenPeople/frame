package com.fj.po;

import java.util.List;

public class QueryVo {
	private OrdersCustom userCustom;
	List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public OrdersCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(OrdersCustom userCustom) {
		this.userCustom = userCustom;
	}
	
}
