package com.fj.aop;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.ProceedingJoinPoint;

//这是一个切面类
public class MyAspectXml {
	//前置增强
	//JoinPoint带回一些aop的信息
	public void before(JoinPoint joinPoint){
		System.out.println("前置通知被执行");
		/*System.out.println("目标对象为:"+joinPoint.getTarget());
		System.out.println("目标方法为:"+joinPoint.getSignature().getName());
		System.out.println("目标方法的参数：" + Arrays.toString(joinPoint.getArgs()));  */
	}
	
	public void after(JoinPoint joinPoint){
		System.out.println("后置方法执行");
	}
//	ProceedingJoinPoint可以执行目标方法
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("环绕通知执行");
		joinPoint.proceed();
		System.out.println("环绕通知执行");
	}
}
