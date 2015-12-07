package com.yf.system.base.service;

import javax.servlet.ServletException;

import org.apache.log4j.PropertyConfigurator;





/**
 * Servlet implementation class for Servlet: InitServlet
 *
 */
 public class InitServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public InitServlet() {
		super();
	}   	 	  	  	  
	
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init() throws ServletException {
		
		super.init();
		System.out.println("商旅中心服务初始化开始...");
	
		PropertyConfigurator.configure( this.getServletContext().getRealPath("WEB-INF")+"/Log4j.properties");
						
		System.out.println("商旅中心服务初始化结束.");
		
	}   
}