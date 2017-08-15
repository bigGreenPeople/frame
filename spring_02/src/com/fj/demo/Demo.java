package com.fj.demo;

import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fj.domain.Book;
import com.fj.domain.Proper;
import com.fj.domain.User;

/**
 * spring��������ע��ķ��� 
 * @author Administrator
 *
 */
public class Demo {
	public static void main(String[] args) {
		//���������ļ�
		//ע����������Ѿ�����set���� �вι��췽��
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		
//		//���췽ʽ�õ�bean
//		User user1 = (User) applicationContext.getBean("user1");
//		System.out.println("user1.username = "+user1.getUsername()+"    user1.password"+user1.getPassword()+"\n");
//		
//		//set��ʽ�õ�bean
//		User user2 = (User) applicationContext.getBean("user2");
//		System.out.println("user2.username = "+user2.getUsername()+"    user2.password"+user2.getPassword()+"\n");
		
		//�������Ե�ע��
//		User user = (User) applicationContext.getBean("user");
//		
//		Book book = user.getBook();
//		System.out.println(book.getBookName());
		
		//p���ƿռ������ע��
		/*Book book = (Book) applicationContext.getBean("book2");
		System.out.println(book.getBookName());*/
		
		//ע�븴������
		Proper p = (Proper) applicationContext.getBean("proper");
		
		//�������
		for(String s:p.getArr()){
			System.out.print(s+"   ");
		}
		System.out.println();
		
		//���list
		for (Object ob: p.getList()) {
			System.out.print(ob.toString()+"   ");
		}
		System.out.println();
		
		//���set
		for (Object ob: p.getSet()) {
			System.out.print(ob.toString()+"   ");
		}
		System.out.println();
		
		Set<String> set = p.getMap().keySet();
		for (String string : set) {
			System.out.print(p.getMap().get(string)+"   ");
		}
		System.out.println();
		
		//���Properties
		Set<Object> set2 = p.getProperties().keySet();
		for (Object string : set2) {
			System.out.print(p.getProperties().get(string)+"   ");
		}
		System.out.println();
	}
}	
