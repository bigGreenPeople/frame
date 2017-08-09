package com.fj.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	//upload拦截器会帮我们获取
	//要与表单上传控件的name	这其实是一个临时文件上传的文件
	private File fieldName;
	//上传文件的类型
	private String fieldNameContentType;
	//上传文件的文件名 	fieldName+FileName(固定)
	private String fieldNameFileName;
	
	
	
	public void setFieldName(File fieldName) {
		this.fieldName = fieldName;
	}



	public void setFieldNameContentType(String fieldNameContentType) {
		this.fieldNameContentType = fieldNameContentType;
	}



	public void setFieldNameFileName(String fieldNameFileName) {
		this.fieldNameFileName = fieldNameFileName;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//打印出上传信息
		System.out.println(fieldName);
		System.out.println(fieldNameContentType);
		System.out.println(fieldNameFileName);
		
		//设置文件保存的路径
		String path = "/WEB-INF/file";
		//得到绝对路径
		String repath = ServletActionContext.getServletContext().getRealPath(path);
		System.out.println(repath);
		//file是文件的全路径
		File file = new File(repath,fieldNameFileName);
		//使用组件包完成文件的写入
		FileUtils.copyFile(fieldName, file);
		
		return NONE;
	}
}
