package com.fj.mapper;

import java.util.List;

import com.fj.po.Orders;
import com.fj.po.OrdersAndOrdersDetail;
import com.fj.po.OrdersCustom;
import com.fj.po.User;

public interface OrdersCustomMapper {
	//��ѯ�������û�����Ϣ(һ��һ   ʹ��resultMap)
	public List<Orders> findOrdersListMap();
}
