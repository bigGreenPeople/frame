package com.fj.demo2;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class User {
	@Value(value="付杰")
	private String name;
	//使用我们名称注入
	@Resource(name="book")
	private Book book;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public void sayBook(){
		System.out.println("我是："+name+"   我在看"+book.getBookName());
	}
}
