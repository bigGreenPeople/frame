package com.fj.demo2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class User {
	@Value(value="����")
	private String name;
	//ʹ����������ע��
	@Resource(name="book")
	private Book book;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public void sayBook(){
		System.out.println("���ǣ�"+name+"   ���ڿ�"+book.getBookName());
	}
}
