package com.fj.mapper;

import java.util.List;

import com.fj.po.Orders;
import com.fj.po.OrdersAndOrdersDetail;
import com.fj.po.OrdersCustom;
import com.fj.po.User;

public interface OrdersCustomMapper {
	//��ѯ�������û�����Ϣ(һ��һ)
	public List<OrdersCustom> findOrdersList();
	//��ѯ�������û�����Ϣ(һ��һ   ʹ��resultMap)
	public List<Orders> findOrdersListMap();
	// ��ʾ����������û��Ĺ�ϵҲ���Ƕ��һ
	public List<Orders> findOrdersDetailList();
	// ��ʾ����������û��Ĺ�ϵҲ���Ƕ��һ(ʹ��resultType)
	public List<OrdersAndOrdersDetail> findOrdersDetailListType();
	//��ʾ�û�����Ʒ�ĵĹ�ϵҲ���Ƕ�Զ�
	public List<User> findOrderListResultMap();
}
