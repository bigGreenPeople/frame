package com.fj.action;

import com.fj.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	
	private CustomerService customerService;
	
	//�����ҳ��
	public String toAddPage(){
		return "toAddPage";
	}
	
	//���
	public String add() throws Exception {
		// TODO Auto-generated method stub
		
		return super.execute();
	}
	
	//�ͻ��б�
	public String list(){
		return "list";
	}
	
	//�޸�
	public String update(){
		return "update";
	}
	
	//ɾ��
	public String delete(){
		return "delete";
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
}
