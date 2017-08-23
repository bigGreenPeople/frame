package com.fj.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Customer;
import com.fj.domain.User;
import com.fj.domain.Visit;
import com.fj.service.CustomerService;
import com.fj.service.UserService;
import com.fj.service.VisitService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
	private VisitService visitService;
	private CustomerService customerService;
	private UserService userService;
	//�ݷ�����
	private Visit visit = new Visit();
	
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	
	//�����û��ݷ�
	public String addVisit(){
		visitService.addVisit(visit);
		
		return "addVisit";
	}
	
	//�����Ӱݷý���
	public String toAddPage(){
		List<User> listUser = userService.findAll();
		List<Customer> listCustomer = customerService.listCustomer();
		//���������
		ServletActionContext.getRequest().setAttribute("listUser", listUser);
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		
		return "toAddPage";
	}
	//��ʾ���аݷ�
	public String listVisit(){
		List<Visit> visitList = visitService.findAll();
		if(visitList!=null){
			ServletActionContext.getRequest().setAttribute("visitList", visitList);
		}
		
		return "listVisit";
	}
	
	@Override
	public Visit getModel() {
		// TODO Auto-generated method stub
		return visit;
	}
}