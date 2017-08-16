package com.fj.aop;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//����һ��������
@Aspect
public class MyAspectXml {
	//ǰ����ǿ
	//JoinPoint����һЩaop����Ϣ
	@Before("MyAspectXml.pointcut1()")
	public void before(JoinPoint joinPoint){
		System.out.println("ǰ��֪ͨ��ִ��");
		/*System.out.println("Ŀ�����Ϊ:"+joinPoint.getTarget());
		System.out.println("Ŀ�귽��Ϊ:"+joinPoint.getSignature().getName());
		System.out.println("Ŀ�귽���Ĳ�����" + Arrays.toString(joinPoint.getArgs()));  */
	}
	
	//����൱�������	�������������ҵ������ʹ����
	@Pointcut("execution(* com.fj.aop.OrderDao.*(..))")
	private void pointcut1(){}

	//����Ҳ����ֱ���ڷ����Ǳ���Ҫ�����ĸ�����
	@After("execution(* com.fj.aop.OrderDao.*(..))")
	public void after(JoinPoint joinPoint){
		System.out.println("���÷���ִ��");
	}
//	ProceedingJoinPoint����ִ��Ŀ�귽��
	//����ע�����û���֪ͨ
	@Around(value="execution(* com.fj.aop.OrderDaoImp.save(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("����ִ֪ͨ��");
		joinPoint.proceed();
		System.out.println("����ִ֪ͨ��");
	}
}
