package com.fj.aop;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.ProceedingJoinPoint;

//����һ��������
public class MyAspectXml {
	//ǰ����ǿ
	//JoinPoint����һЩaop����Ϣ
	public void before(JoinPoint joinPoint){
		System.out.println("ǰ��֪ͨ��ִ��");
		/*System.out.println("Ŀ�����Ϊ:"+joinPoint.getTarget());
		System.out.println("Ŀ�귽��Ϊ:"+joinPoint.getSignature().getName());
		System.out.println("Ŀ�귽���Ĳ�����" + Arrays.toString(joinPoint.getArgs()));  */
	}
	
	public void after(JoinPoint joinPoint){
		System.out.println("���÷���ִ��");
	}
//	ProceedingJoinPoint����ִ��Ŀ�귽��
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("����ִ֪ͨ��");
		joinPoint.proceed();
		System.out.println("����ִ֪ͨ��");
	}
}
