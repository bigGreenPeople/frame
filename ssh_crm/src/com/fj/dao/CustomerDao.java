package com.fj.dao;

import java.util.List;

import com.fj.domain.Customer;
import com.fj.domain.PageBean;

public interface CustomerDao extends BaseDao<Customer>{
	//添加用户
	//public void add(Customer customer);
	//查询所有客户
	//public List<Customer> findAll();
	//修改客户
	//public void update(Customer customer);
	//删除客户
	//public void delete(int cid);
	//分页列表
	public List<Customer> listCustomerPage(int pageNow,int pageSize);
	//得到记录数
	public int getCount(int currentPage);
	//查询单个用户
	//public Customer findById(int cid);
	//查找用户
	public List<Customer> findCustomer(String custName);
}
