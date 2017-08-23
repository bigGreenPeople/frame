package com.fj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.CustomerDao;
import com.fj.domain.Customer;
import com.fj.domain.PageBean;
@Transactional
public class CustomerServiceImp implements CustomerService {

	private CustomerDao customerDao;
	//添加客户
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.add(customer);
	}
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	//查询所有客户
	@Override
	public List<Customer> listCustomer() {
		// TODO Auto-generated method stub
		return customerDao.findAll();
	}
	//修改客户
	@Override
	public void updCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.update(customer);
	}
	//删除客户
	@Override
	public void delCustomer(int cid) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setCid(cid);
		customerDao.delete(customer);
	}
	//分页列表
	@Override
	public PageBean listCustomerPage(int currentPage) {
		// TODO Auto-generated method stub
		//创建bean
		PageBean pageBean = new PageBean();
		//设置pagebean的信息
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalCount(customerDao.getCount(currentPage));
		pageBean.setPageSize(3);
		
		//计算出总页数
		int totalPage=pageBean.getTotalCount()%pageBean.getPageSize()==0?
				pageBean.getTotalCount()/pageBean.getPageSize():
					pageBean.getTotalCount()/pageBean.getPageSize()+1;
		
		pageBean.setTotalPage(totalPage);
		//计算开始位置
		int begin = (pageBean.getCurrentPage()-1)*pageBean.getPageSize();
		pageBean.setBegin(begin);
		//传递2个参数给dao得到数据 
		pageBean.setList(customerDao.listCustomerPage(pageBean.getBegin(),pageBean.getPageSize()));
		return pageBean;
	}
	
	//查询单个用户
	@Override
	public Customer getCustomerByID(int cid) {
		// TODO Auto-generated method stub
		return customerDao.findById(cid);
	}
	
	//查找用户
	@Override
	public List<Customer> findCustomer(String custName) {
		// TODO Auto-generated method stub
		return customerDao.findCustomer(custName);
	}
	
	//多条件组合查询
	@Override
	public List<Customer> findMoreCondition(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.findMoreCondition(customer);
	}
	
}
