package com.fj.createBean1;

/**
 * 使用静态工程创建类
 * @author bigGreenPeople
 *
 */
public class UserFactory {
	//得到User类
	public static User getUser(){
		return new User();
	}
}
