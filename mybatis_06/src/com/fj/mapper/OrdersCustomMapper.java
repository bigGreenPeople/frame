package com.fj.mapper;

import java.util.List;

import com.fj.po.Orders;
import com.fj.po.OrdersAndOrdersDetail;
import com.fj.po.OrdersCustom;
import com.fj.po.User;

public interface OrdersCustomMapper {
	//查询订单和用户的信息(一对一   使用resultMap)
	public List<Orders> findOrdersListMap();
}
