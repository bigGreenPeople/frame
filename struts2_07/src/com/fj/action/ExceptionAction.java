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
		//如果没有传参的话这里 应该会有一个空指针异常   但是我们在struts.xml配置了异常出错的界面所以会跳转到error.jsp
		System.out.println(getNum);
		if(getNum==0){
			//这里同上
			int i = 3/0;
		}
		
		return "ok";
	}
}
