package com.fj.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Customer;
import com.fj.domain.PageBean;
import com.fj.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	
	private CustomerService customerService;
	//���ӵ��û�
	private Customer customer = new Customer();
	//���õ�ǰҳ ��Ĭ���ǵ�һҳ
	private Integer currentPage = 1;
	
	//������ҳ��
	public String toAddPage(){
		return "toAddPage";
	}
	
	//����
	public String add() throws Exception {
		// TODO Auto-generated method stub
		customerService.addCustomer(customer);
		return "addSuccess";
	}
	
	//�ͻ��б�
	public String list(){
		List<Customer> list = customerService.listCustomer();
		//�ж��Ƿ��Ѿ�ȡ��list
		if(list!=null && list.size()!=0){
			//��list���뵽request��
			ServletActionContext.getRequest().setAttribute("list", list);
		}
		
		return "list";
	}
	
	//��ҳ��ʾ�б�
	public String listPage(){
		//�õ���ҳ���list
		PageBean listPage = customerService.listCustomerPage(currentPage);
		//�����Ϊ�հ������뵽���������ȥ 
		if(listPage!=null){
			ServletActionContext.getRequest().setAttribute("listPage", listPage);
		}
		
		return "listPage";
	}
	
	//��ת���޸�ҳ��
	public String toUpdate(){
		//��ȥ��ѯ��Ҫ�޸ĵ��û�
		Customer updCustomer = customerService.getCustomerByID(customer.getCid());
		//�ж��޸ĵ��û��Ƿ�Ϊ��
		if(updCustomer!=null){
			//��Ϊ�շ��뵽reques��
			ServletActionContext.getRequest().setAttribute("updCustomer", updCustomer);
		}
		
		return "toUpdate";
	}
	
	//�޸�
	public String update(){
		//���ʱ�����ǵ�customer����Ҫ�޸ĺ�Ŀͻ�
		customerService.updCustomer(customer);
		
		return "update";
	}
	
	//�����û�
	public String find(){
		//�����û�
		System.out.println(customer.getCustName());
		List<Customer> list = customerService.findCustomer(customer.getCustName());
		//���뵽�����
		if(list!=null && list.size()!=0){
			ServletActionContext.getRequest().setAttribute("list", list);
		}
		return "find";
	}
	
	//ɾ��
	public String delete(){
		customerService.delCustomer(customer.getCid());
		return "delete";
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	
}