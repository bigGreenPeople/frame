package com.fj.mapper;

import java.util.List;

import com.fj.po.Orders;
import com.fj.po.OrdersCustom;

public interface OrdersCustomMapper {
	//��ѯ�������û�����Ϣ(һ��һ)
	public List<OrdersCustom> findOrdersList();
	//��ѯ�������û�����Ϣ(һ��һ   ʹ��resultMap)
	public List<Orders> findOrdersListMap();
	// ��ʾ����������û��Ĺ�ϵҲ���Ƕ��һ
	public List<Orders> findOrdersDetailList();
}
