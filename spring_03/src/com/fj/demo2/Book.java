package com.fj.demo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//��xml���������Զ�����
public class Book {
	@Value(value="�׽")
	private String bookName;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
}
