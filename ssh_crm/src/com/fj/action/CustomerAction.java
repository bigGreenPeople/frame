package com.fj.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.fj.domain.Customer;
import com.fj.domain.Dict;
import com.fj.domain.PageBean;
import com.fj.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	
	private CustomerService customerService;
	//添加的用户
	private Customer customer = new Customer();
	//设置当前页 ，默认是第一页
	private Integer currentPage = 1;
	
	//到添加页面
	public String toAddPage(){
		//得到我们的字典表
		List<Dict> dictList = customerService.findAllDict();
		if(dictList!=null){
			ServletActionContext.getRequest().setAttribute("dictList", dictList);
		}
		return "toAddPage";
	}
	
	//添加
	public String add() throws Exception {
		// TODO Auto-generated method stub
		customerService.addCustomer(customer);
		//跳转到list界面
		return "addSuccess";
	}
	
	//客户列表
	public String list(){
		List<Customer> list = customerService.listCustomer();
		//判断是否已经取得list
		if(list!=null && list.size()!=0){
			//将list放入到request中
			ServletActionContext.getRequest().setAttribute("list", list);
		}
		
		return "list";
	}
	
	//分页显示列表
	public String listPage(){
		//得到分页后的list
		PageBean listPage = customerService.listCustomerPage(currentPage);
		//如果不为空把它放入到域对象里面去 
		if(listPage!=null){
			ServletActionContext.getRequest().setAttribute("listPage", listPage);
		}
		
		return "listPage";
	}
	
	//跳转到修改页面
	public String toUpdate(){
		//先去查询到要修改的用户
		Customer updCustomer = customerService.getCustomerByID(customer.getCid());
		//得到我们的字典表
		List<Dict> dictList = customerService.findAllDict();
		if(dictList!=null){
			ServletActionContext.getRequest().setAttribute("dictList", dictList);
		}
		//判断修改的用户是否为空
		if(updCustomer!=null){
			//不为空放入到reques中
			ServletActionContext.getRequest().setAttribute("updCustomer", updCustomer);
		}
		
		return "toUpdate";
	}
	
	//修改
	public String update(){
		//这个时候我们的customer就是要修改后的客户
		customerService.updCustomer(customer);
		
		return "update";
	}
	
	//查找用户
	public String find(){
		//查找用户
		System.out.println(customer.getCustName());
		List<Customer> list = customerService.findCustomer(customer.getCustName());
		//放入到域对象
		if(list!=null && list.size()!=0){
			ServletActionContext.getRequest().setAttribute("list", list);
		}
		return "find";
	}
	
	//删除
	public String delete(){
		customerService.delCustomer(customer.getCid());
		return "delete";
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//到条件组合查询页面
	public String toCustQuery(){
		//得到我们的字典表
		List<Dict> dictList = customerService.findAllDict();
		if(dictList!=null){
			ServletActionContext.getRequest().setAttribute("dictList", dictList);
		}
		return "toCustQuery";
	}
	
	//条件组合查询
	public String findMoreCondition(){
		List<Customer> list = customerService.findMoreCondition(customer);
		//放入域对象
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	
	//客户来源统计
	public String findCountSource(){
		
		List<Map> list = customerService.findCountSource();
		
		if(list!=null){
			ServletActionContext.getRequest().setAttribute("list", list);
		}
		
		return "findCountSource";
	}
	
	//客户等级统计
	public String findCountLevel(){
		List<Map> list = customerService.findCountLevel();
		
		if(list!=null){
			ServletActionContext.getRequest().setAttribute("list", list);
		}
		return "findCountLevel";
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
