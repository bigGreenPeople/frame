package com.fj.dao;

import java.util.List;

import com.fj.domain.Customer;
import com.fj.domain.PageBean;

public interface CustomerDao {
	//�����û�
	public void addCustomer(Customer customer);
	//��ѯ���пͻ�
	public List<Customer> listCustomer();
	//�޸Ŀͻ�
	public void updCustomer(Customer customer);
	//ɾ���ͻ�
	public void delCustomer(int cid);
	//��ҳ�б�
	public List<Customer> listCustomerPage(int pageNow,int pageSize);
	//�õ���¼��
	public int getCount(int currentPage);
	//��ѯ�����û�
	public Customer getCustomerByID(int cid);
	//�����û�
	public List<Customer> findCustomer(String custName);
}