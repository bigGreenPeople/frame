package com.fj.action;

import com.opensymphony.xwork2.ActionSupport;

public class ExceptionAction extends ActionSupport {
	
	private Integer getNum;
	
	
	public void setGetNum(Integer getNum) {
		this.getNum = getNum;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//���û�д��εĻ����� Ӧ�û���һ����ָ���쳣   ����������struts.xml�������쳣����Ľ������Ի���ת��error.jsp
		System.out.println(getNum);
		if(getNum==0){
			//����ͬ��
			int i = 3/0;
		}
		
		return "ok";
	}
}
