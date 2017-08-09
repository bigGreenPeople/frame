package com.fj.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction2 extends ActionSupport{
	//这个方法对文件名进行一个中文编码
	public String getFileName() throws Exception{
		String fileName = new String("图片.jpg".getBytes("UTF-8"),"ISO8859-1");
		return fileName;
	}
	
	//返回一个输入流用来进行文件的下载
	public InputStream getPic(){
		//在我们的项目的真实路径下查找到要下载的文件 
		InputStream is = ServletActionContext.getServletContext().getResourceAsStream("/WEB-INF/file/psb.jpg");
		return is;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		return "stream";
	}
}
