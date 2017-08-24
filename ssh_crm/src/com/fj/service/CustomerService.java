package com.fj.service;

import java.util.List;
import java.util.Map;

import com.fj.domain.Customer;
import com.fj.domain.Dict;
import com.fj.domain.PageBean;

public interface CustomerService {
	//添加客户
	public void addCustomer(Customer customer);
	//查询所有客户
	public List<Customer> listCustomer();
	//修改客户
	public void updCustomer(Customer customer);
	//删除客户
	public void delCustomer(int cid);
	//分页列表
	public PageBean listCustomerPage(int currentPage);
	//查询单个用户
	public Customer getCustomerByID(int cid);
	//查找用户
	public List<Customer> findCustomer(String custName);
	//多条件组合查询
	public List<Customer> findMoreCondition(Customer customer);
	//查找所有字典表
	public List<Dict> findAllDict();
	public List<Map> findCountSource();
	public List<Map> findCountLevel();
}
