package com.fj.action;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FieldAction extends ActionSupport implements ServletRequestAware{
	
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext servletContext;
	//ʹ�ýӿ�ע�뷽ʽ�õ������
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//��������ʵ�ʱ��Ὣrequestע����� 
		this.request = request;
		//�õ���request�Ϳ��Եõ�HttpSession ServletContext
		session = request.getSession();
		servletContext = request.getServletContext();
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("ִ��action");
		//ʹ��ActionContext�õ������    ��ȡ�õ������ȫ����map�����
		//�õ�ActionContext	 ȡ��ֵ
		/*ActionContext actionContext = ActionContext.getContext();
		//�õ��������� ����װ��map��
		// �õ�request������
		Map<String, Object> parameters = actionContext.getParameters();
		//�õ�session 
		Map<String, Object> session = actionContext.getSession();
		//�õ�servletContext 
		Map<String, Object> application = actionContext.getApplication();
		//��ʾ����
		Set<String> set = parameters.keySet();
		for(String key:set){
			Object[] ob = (Object[])(parameters.get(key));
			System.out.println(Arrays.toString(ob));
		}*/
	
		//ʹ��ServletActionContext�õ������      ������ྲ̬��������ֱ�ӻ�������	
		/*HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext servletContext = ServletActionContext.getServletContext();
		HttpSession session = request.getSession();
		ServletContext servletContext2 = request.getServletContext();
		System.out.println(servletContext==servletContext2);  //true
*/		
		System.out.println(request);
		System.out.println(session);
		System.out.println(servletContext);
		return NONE;
	}

	
}
