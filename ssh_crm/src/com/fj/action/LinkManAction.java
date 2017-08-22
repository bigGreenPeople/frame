package com.fj.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.fj.domain.Customer;
import com.fj.domain.LinkMan;
import com.fj.service.CustomerService;
import com.fj.service.LinkManService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkManService linkManService;
	private CustomerService customerService;
	private LinkMan linkMan = new LinkMan();
	
	//文件上传的参数
	//file的名字要和表单提交的一样
	private File upload;
	//上传的文件名   ***FileName
	private String uploadFileName;
	
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	//跳转到添加页面
	public String toAddPage(){
		// TODO Auto-generated method stub
		List<Customer> listCustomer = customerService.listCustomer();
		//如果不为null 放入域对象
		if(listCustomer!=null){
			ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		}
		
		return "toAddPage";
	}
	
	//添加操作
	public String add() throws IOException{
		linkManService.addLinkMan(linkMan);
		//文件上传
		//单不等于null的时候就上传
		if(upload!=null){
			//先得到要放入文件的流
			File serverFile = new File("F:/ssm_crm/"+uploadFileName);
			//使用FileUtils复制到新的文件中
			FileUtils.copyFile(upload, serverFile);
		}
		return "add";
	}
	
	//显示所有联系人
	public String list(){
		List<LinkMan> list = linkManService.listLinkMan();
		//如果不为空放入域对象
		if(list!=null){
			ServletActionContext.getRequest().setAttribute("list", list);
		}
		
		return "list";
	}

	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
}
