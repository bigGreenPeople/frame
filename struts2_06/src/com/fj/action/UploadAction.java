package com.fj.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	//upload������������ǻ�ȡ
	//Ҫ����ϴ��ؼ���name	����ʵ��һ����ʱ�ļ��ϴ����ļ�
	private File fieldName;
	//�ϴ��ļ�������
	private String fieldNameContentType;
	//�ϴ��ļ����ļ��� 	fieldName+FileName(�̶�)
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
		//��ӡ���ϴ���Ϣ
		System.out.println(fieldName);
		System.out.println(fieldNameContentType);
		System.out.println(fieldNameFileName);
		
		//�����ļ������·��
		String path = "/WEB-INF/file";
		//�õ�����·��
		String repath = ServletActionContext.getServletContext().getRealPath(path);
		System.out.println(repath);
		//file���ļ���ȫ·��
		File file = new File(repath,fieldNameFileName);
		//ʹ�����������ļ���д��
		FileUtils.copyFile(fieldName, file);
		
		return NONE;
	}
}
