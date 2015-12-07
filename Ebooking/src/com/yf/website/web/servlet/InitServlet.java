package com.yf.website.web.servlet;

import java.io.FileNotFoundException;

import javax.servlet.ServletException;

import org.apache.log4j.PropertyConfigurator;

import com.yf.website.web.server.Server;



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
		System.out.println("EBOOK服务初始化开始...");
		
		Server.getInstance().setUrl(this.getInitParameter("service_url"));
		Server.getInstance().setUrlAtom(this.getInitParameter("atom_service_url")) ;
		Server.getInstance().setInter(this.getInitParameter("inter_service_url"));
		Server.getInstance().setHotelinter(this.getInitParameter("hotel_service_url"));
		PropertyConfigurator.configure( this.getServletContext().getRealPath("WEB-INF")+"/Log4j.properties");
		
		
						
		System.out.println("EBOOK服务初始化结束.");
		
	}   
}