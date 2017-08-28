package com.fj.mapper;

import java.util.List;

import com.fj.po.Orders;
import com.fj.po.OrdersAndOrdersDetail;
import com.fj.po.OrdersCustom;
import com.fj.po.User;

public interface OrdersCustomMapper {
	//查询订单和用户的信息(一对一)
	public List<OrdersCustom> findOrdersList();
	//查询订单和用户的信息(一对一   使用resultMap)
	public List<Orders> findOrdersListMap();
	// 显示订单详情和用户的关系也就是多对一
	public List<Orders> findOrdersDetailList();
	// 显示订单详情和用户的关系也就是多对一(使用resultType)
	public List<OrdersAndOrdersDetail> findOrdersDetailListType();
	//显示用户与商品的的关系也就是多对多
	public List<User> findOrderListResultMap();
}
