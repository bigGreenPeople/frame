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
	
	//�ļ��ϴ��Ĳ���
	//file������Ҫ�ͱ����ύ��һ��
	private File upload;
	//�ϴ����ļ���   ***FileName
	private String uploadFileName;
	
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	//��ת������ҳ��
	public String toAddPage(){
		// TODO Auto-generated method stub
		List<Customer> listCustomer = customerService.listCustomer();
		//�����Ϊnull ���������
		if(listCustomer!=null){
			ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		}
		
		return "toAddPage";
	}
	
	//���Ӳ���
	public String add() throws IOException{
		linkManService.addLinkMan(linkMan);
		//�ļ��ϴ�
		//��������null��ʱ����ϴ�
		if(upload!=null){
			//�ȵõ�Ҫ�����ļ�����
			File serverFile = new File("F:/ssm_crm/"+uploadFileName);
			//ʹ��FileUtils���Ƶ��µ��ļ���
			FileUtils.copyFile(upload, serverFile);
		}
		return "add";
	}
	
	//��ʾ������ϵ��
	public String list(){
		List<LinkMan> list = linkManService.listLinkMan();
		//�����Ϊ�շ��������
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