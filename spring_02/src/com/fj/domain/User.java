package com.fj.domain;

public class User {
	private String username;
	private String password;
	private Book book;
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User(String username, String password) {
		System.out.println("调用有参构造方法");
		this.username = username;
		this.password = password;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
		System.out.println("调用无参构造方法");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		System.out.println("调用了set方法 ");
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
