package com.fj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fj.dao.CustomerDao;
import com.fj.domain.Customer;
import com.fj.domain.PageBean;
@Transactional
public class CustomerServiceImp implements CustomerService {

	private CustomerDao customerDao;
	//���ӿͻ�
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.addCustomer(customer);
	}
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	//��ѯ���пͻ�
	@Override
	public List<Customer> listCustomer() {
		// TODO Auto-generated method stub
		return customerDao.listCustomer();
	}
	//�޸Ŀͻ�
	@Override
	public void updCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.updCustomer(customer);
	}
	//ɾ���ͻ�
	@Override
	public void delCustomer(int cid) {
		// TODO Auto-generated method stub
		customerDao.delCustomer(cid);
	}
	//��ҳ�б�
	@Override
	public PageBean listCustomerPage(int currentPage) {
		// TODO Auto-generated method stub
		//����bean
		PageBean pageBean = new PageBean();
		//����pagebean����Ϣ
		pageBean.setCurrentPage(currentPage);
		pageBean.setTotalCount(customerDao.getCount(currentPage));
		pageBean.setPageSize(3);
		
		//�������ҳ��
		int totalPage=pageBean.getTotalCount()%pageBean.getPageSize()==0?
				pageBean.getTotalCount()/pageBean.getPageSize():
					pageBean.getTotalCount()/pageBean.getPageSize()+1;
		
		pageBean.setTotalPage(totalPage);
		//���㿪ʼλ��
		int begin = (pageBean.getCurrentPage()-1)*pageBean.getPageSize();
		pageBean.setBegin(begin);
		//����2��������dao�õ����� 
		pageBean.setList(customerDao.listCustomerPage(pageBean.getBegin(),pageBean.getPageSize()));
		return pageBean;
	}
	
	//��ѯ�����û�
	@Override
	public Customer getCustomerByID(int cid) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerByID(cid);
	}
	
	//�����û�
	@Override
	public List<Customer> findCustomer(String custName) {
		// TODO Auto-generated method stub
		return customerDao.findCustomer(custName);
	}
	
}