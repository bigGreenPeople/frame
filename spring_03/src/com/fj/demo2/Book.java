package com.fj.demo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//在xml中配置了自动生成
public class Book {
	@Value(value="易筋经")
	private String bookName;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
}
