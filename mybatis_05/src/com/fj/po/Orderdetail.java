package com.fj.po;

import java.io.Serializable;

public class Orderdetail implements Serializable{
	private Integer id;
	private Integer orders_id;
	private Integer items_id;
	private Integer items_num;
	//配置与商品表的属性
	private Items items;
	
	
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(Integer orders_id) {
		this.orders_id = orders_id;
	}
	public Integer getItems_id() {
		return items_id;
	}
	public void setItems_id(Integer items_id) {
		this.items_id = items_id;
	}
	public Integer getItems_num() {
		return items_num;
	}
	public void setItems_num(Integer items_num) {
		this.items_num = items_num;
	}
	
	
}
