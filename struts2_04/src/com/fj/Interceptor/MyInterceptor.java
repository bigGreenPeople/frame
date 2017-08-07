package com.fj.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor extends MethodFilterInterceptor{

	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//根据运行的结果来看拦截器的destroy 方法是在tomcat关闭的时候被调用了
		System.out.println("自定义拦截器的destroy调用");
		super.destroy();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		//根据运行的结果来看拦截器的init 方法是在tomcat启动的时候就被调用了
		System.out.println("自定义拦截器的init调用");
		super.init();
	}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//执行action之前先进入到doIntercept方法
		System.out.println("自定义拦截器doIntercept调用");
		//放行操作  并且返回action方法里面的返回值
		if(1==2){
			String result = invocation.invoke();
			System.out.println("action 的返回值是"+result);
		}
		//如果执行了invocation.invoke();页面就跳转到action方法返回的界面
		//如果没有执行就返回我们拦截器返回的界面
		return "err";
		
				
	}
	
}
