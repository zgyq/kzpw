package com.yf.system.back.servlet;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class ServiceFilter implements Filter{
	private String ip;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		String aip = arg0.getRemoteAddr();
		
		if(aip!=null && ip.contains(aip)){
			arg2.doFilter(arg0,arg1);
		}else{
			System.out.println(aip);
			arg2.doFilter(arg0,arg1);
			//throw new IOException("wrong ip adrress!:"+aip);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		ip = arg0.getInitParameter("ip");
		
	}

}
