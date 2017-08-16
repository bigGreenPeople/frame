package com.fj.aop;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;  
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//这是一个切面类
@Aspect
public class MyAspectXml {
	//前置增强
	//JoinPoint带回一些aop的信息
	@Before("MyAspectXml.pointcut1()")
	public void before(JoinPoint joinPoint){
		System.out.println("前置通知被执行");
		/*System.out.println("目标对象为:"+joinPoint.getTarget());
		System.out.println("目标方法为:"+joinPoint.getSignature().getName());
		System.out.println("目标方法的参数：" + Arrays.toString(joinPoint.getArgs()));  */
	}
	
	//这个相当于切入点	这样这个切入点就业被反复使用了
	@Pointcut("execution(* com.fj.aop.OrderDao.*(..))")
	private void pointcut1(){}

	//我们也可以直接在方法是表明要切入哪个方法
	@After("execution(* com.fj.aop.OrderDao.*(..))")
	public void after(JoinPoint joinPoint){
		System.out.println("后置方法执行");
	}
//	ProceedingJoinPoint可以执行目标方法
	//利用注解配置环绕通知
	@Around(value="execution(* com.fj.aop.OrderDaoImp.save(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("环绕通知执行");
		joinPoint.proceed();
		System.out.println("环绕通知执行");
	}
}
