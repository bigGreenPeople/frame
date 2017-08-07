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
	//使用接口注入方式得到域对象
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//当请求访问的时候会将request注入进来 
		this.request = request;
		//得到了request就可以得到HttpSession ServletContext
		session = request.getSession();
		servletContext = request.getServletContext();
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("执行action");
		//使用ActionContext得到域对象    它取得的域对象全是在map里面的
		//得到ActionContext	 取得值
		/*ActionContext actionContext = ActionContext.getContext();
		//得到表单的数据 并封装到map中
		// 得到request的内容
		Map<String, Object> parameters = actionContext.getParameters();
		//得到session 
		Map<String, Object> session = actionContext.getSession();
		//得到servletContext 
		Map<String, Object> application = actionContext.getApplication();
		//显示出来
		Set<String> set = parameters.keySet();
		for(String key:set){
			Object[] ob = (Object[])(parameters.get(key));
			System.out.println(Arrays.toString(ob));
		}*/
	
		//使用ServletActionContext得到域对象      它有许多静态方法可以直接获得域对象	
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
