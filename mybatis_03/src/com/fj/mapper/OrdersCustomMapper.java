package com.fj.mapper;

import java.util.List;

import com.fj.po.OrdersCustom;

public interface OrdersCustomMapper {
	//查询订单和用户的信息(一对一)
	public List<OrdersCustom> findOrdersList();
}
