package com.fj.demo;

import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fj.domain.Book;
import com.fj.domain.Proper;
import com.fj.domain.User;

/**
 * spring两种属性注入的方法 
 * @author Administrator
 *
 */
public class Demo {
	public static void main(String[] args) {
		//加载配置文件
		//注意在这里就已经调用set方法 有参构造方法
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		//构造方式得到bean
//		User user1 = (User) applicationContext.getBean("user1");
//		System.out.println("user1.username = "+user1.getUsername()+"    user1.password"+user1.getPassword()+"\n");
//		
//		//set方式得到bean
//		User user2 = (User) applicationContext.getBean("user2");
//		System.out.println("user2.username = "+user2.getUsername()+"    user2.password"+user2.getPassword()+"\n");
		
		//对象属性的注入
//		User user = (User) applicationContext.getBean("user");
//		
//		Book book = user.getBook();
//		System.out.println(book.getBookName());
		
		//p名称空间的属性注入
		/*Book book = (Book) applicationContext.getBean("book2");
		System.out.println(book.getBookName());*/
		
		//注入复杂属性
		Proper p = (Proper) applicationContext.getBean("proper");
		
		//输出数组
		for(String s:p.getArr()){
			System.out.print(s+"   ");
		}
		System.out.println();
		
		//输出list
		for (Object ob: p.getList()) {
			System.out.print(ob.toString()+"   ");
		}
		System.out.println();
		
		//输出set
		for (Object ob: p.getSet()) {
			System.out.print(ob.toString()+"   ");
		}
		System.out.println();
		
		Set<String> set = p.getMap().keySet();
		for (String string : set) {
			System.out.print(p.getMap().get(string)+"   ");
		}
		System.out.println();
		
		//输出Properties
		Set<Object> set2 = p.getProperties().keySet();
		for (Object string : set2) {
			System.out.print(p.getProperties().get(string)+"   ");
		}
		System.out.println();
	}
}	
