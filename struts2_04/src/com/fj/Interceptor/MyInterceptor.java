package com.fj.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class MyInterceptor extends MethodFilterInterceptor{

	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//�������еĽ��������������destroy ��������tomcat�رյ�ʱ�򱻵�����
		System.out.println("�Զ�����������destroy����");
		super.destroy();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		//�������еĽ��������������init ��������tomcat������ʱ��ͱ�������
		System.out.println("�Զ�����������init����");
		super.init();
	}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//ִ��action֮ǰ�Ƚ��뵽doIntercept����
		System.out.println("�Զ���������doIntercept����");
		//���в���  ���ҷ���action��������ķ���ֵ
		if(1==2){
			String result = invocation.invoke();
			System.out.println("action �ķ���ֵ��"+result);
		}
		//���ִ����invocation.invoke();ҳ�����ת��action�������صĽ���
		//���û��ִ�оͷ����������������صĽ���
		return "err";
		
				
	}
	
}
