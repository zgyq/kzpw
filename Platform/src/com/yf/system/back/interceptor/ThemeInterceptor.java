package com.yf.system.back.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;

/**
 * 此拦截器用于控制界面主题
 * @author xiaohan
 *
 */
public class ThemeInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1543199131388154127L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Object themeobj = session.getAttribute("themename");
		String themename = "black";//默认主题
		if (themeobj != null) {
			String theme=themeobj.toString();
			String name = request.getParameter("themename");
			if (name != null && name.trim()!= "") {
				themename = name;
			}else{
				themename=theme;
			}
		}
		session.setAttribute("themename", themename);

		return invocation.invoke();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
