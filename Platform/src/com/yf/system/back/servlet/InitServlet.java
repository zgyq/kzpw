package com.yf.system.back.servlet;

import javax.servlet.ServletException;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import com.yf.system.back.action.B2b2cbackAction;
import com.yf.system.back.action.CustomeragentAction;
import com.yf.system.back.server.Server;



/**
 * Servlet implementation class for Servlet: InitServlet
 *
 */
 public class InitServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	 
 private  Scheduler scheduler ;
	public InitServlet() {
		super();
	}   	 	  	  	  
	
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init() throws ServletException {
		
		super.init();
		
		System.out.println("商旅中心CRM服务初始化开始...");
		Server.getInstance().setUrl(this.getInitParameter("service_url"));
		Server.getInstance().setUrlAtom(this.getInitParameter("atom_service_url")) ;
		Server.getInstance().setInter(this.getInitParameter("inter_service_url")) ;
		Server.getInstance().setHotelinter(this.getInitParameter("hotel_service_url"));
		//PropertyConfigurator.configure( this.getServletContext().getRealPath("WEB-INF")+"/Log4j.properties");
		System.out.println("商旅中心CRM服务初始化结束.");
		String vmoneyservice=this.getInitParameter("vmoneyservice");
		if(vmoneyservice.equals("1")){//系统添加虚拟账户服务
		this.getServletContext().setAttribute("vmoneyservice", "1");
			CustomeragentAction.vmenable = true;
		}
		
		//以下为定时任务
		String isopen=this.getInitParameter("isopen");//1开启 0关闭
		String xepnrtime=this.getInitParameter("xepnrtime");//1开启 0关闭
		System.out.println("isopen:"+isopen);
		System.out.println("xepnrtime:"+xepnrtime);
		try {
			if(isopen.equals("1")){
				//XEPNR
				try {
					scheduler = StdSchedulerFactory.getDefaultScheduler();
					JobDetail xepnr = new JobDetail("xepnr","XEPNRG",JobXEPNR.class);
					scheduler.scheduleJob(xepnr, new CronTrigger("xepnr","xe",xepnrtime));
				} catch (SchedulerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					scheduler.start();
				} catch (SchedulerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			}
			
		}catch (Exception e) {
			
			// TODO: handle exception
		}
		
		
	}
	
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Start  stop...");
		 try {
			scheduler.shutdown();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}