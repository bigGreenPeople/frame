package com.fj.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction2 extends ActionSupport{
	//����������ļ�������һ�����ı���
	public String getFileName() throws Exception{
		String fileName = new String("ͼƬ.jpg".getBytes("UTF-8"),"ISO8859-1");
		return fileName;
	}
	
	//����һ�����������������ļ�������
	public InputStream getPic(){
		//�����ǵ���Ŀ����ʵ·���²��ҵ�Ҫ���ص��ļ� 
		InputStream is = ServletActionContext.getServletContext().getResourceAsStream("/WEB-INF/file/psb.jpg");
		return is;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		return "stream";
	}
}
