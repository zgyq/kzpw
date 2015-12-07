/**
 * 版权所有, 允风文化
 * Author: B2BJOY 项目开发组
 * copyright: 2009
 *
 *
 *  HISTORY
 *  
 *  2009/08/11 创建
 *
 */
 
package com.yf.website.web.interceptor;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yf.system.base.customeruser.Customeruser;
import com.yf.system.base.dnsmaintenance.Dnsmaintenance;
import com.yf.website.web.action.B2b2cbackAction;
import com.yf.website.web.server.Server;
import com.opensymphony.webwork.ServletActionContext;
import com.opensymphony.xwork.Action;
import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionInvocation;
import com.opensymphony.xwork.interceptor.Interceptor;

public class AuthenInterceptor implements Interceptor {
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void init() {
		// TODO Auto-generated method stub
	}

	public String intercept(ActionInvocation inv) throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String language=request.getParameter("language");
		String contry=request.getParameter("contry");
		if(language==null){
			Object lan=session.getAttribute("language");
			Object con=session.getAttribute("contry");
			if(lan==null){
				con="CN";
				lan="zh";
			}
			language=lan.toString();
			contry=con.toString();
		}
		session.setAttribute("language", language);
		session.setAttribute("contry", contry);
		Locale locale=new Locale(language,contry);
		inv.getInvocationContext().setLocale(locale);

		//陈星更新--B2C网站相关信息

		String servername = request.getServerName();
		servername = getwebname(servername);// 解析
		boolean exist = session.getAttribute("b2cdns") == null ? true
				: ((Dnsmaintenance) session.getAttribute("b2cdns")).getDnsname()
						.equals(servername) ? false : true;// 判断request是否已保存。
		if (exist) {
			String where = "WHERE C_DNSNAME LIKE '%" + servername + "%' AND C_LOGOLOGINSRC='B2C'";
			try{
			List list = Server.getInstance().getSystemService()
					.findAllDnsmaintenance(where, "", -1, 0);
			
			if (list.size() > 0) {
				Dnsmaintenance dns = (Dnsmaintenance) list.get(0);
				session.setAttribute("b2cdns", dns);
			} else {
				where = "WHERE C_DNSNAME = 'default' AND C_LOGOLOGINSRC='B2C'";
				list = Server.getInstance().getSystemService()
						.findAllDnsmaintenance(where, "", -1, 0);
				Dnsmaintenance dns = (Dnsmaintenance) list.get(0);
				session.setAttribute("b2cdns", dns);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		Dnsmaintenance dns = (Dnsmaintenance)session.getAttribute("b2cdns");
		System.out.println("dns:"+dns.toString());
		System.out.println("agentid:"+dns.getAgentid()+",name:"+dns.getAddress()+",tel:"+dns.getServiceline()+",logosrc:"+dns.getLogosrc());
		session.setAttribute("compname", dns.getAddress());//公司名字//旅行
		session.setAttribute("tel", dns.getServiceline());//联系电话//40063-19166
		session.setAttribute("logosrc", dns.getLogosrc());
		session.setAttribute("agentid", dns.getAgentid());
		Map m = inv.getInvocationContext().getParameters();
		Set set =  m.entrySet();
	
		Iterator it = set.iterator();
		while(it.hasNext()){
			
			Object obj = it.next();
			if(((Map.Entry)obj).getValue() instanceof String[]){
				String[] s = (String[])((Map.Entry)obj).getValue();
				for(String ss : s){
					//System.out.println(((Map.Entry)obj).getKey() + " " + ss);
				}
			}
		}
		
		
		
		String method = inv.getProxy().getActionName();
		
		Action action = inv.getAction();
		request.setAttribute("requesturi", request.getContextPath()+"/"+method+".jspx");
		//System.out.println( request.getContextPath()+"/"+method+".jspx");
		Customeruser user = null;
		if(false ){
			B2b2cbackAction	moaction = (B2b2cbackAction)action; 
			if(method.contains("login!logout")
					||method.contains("login!login")
					||method.contains("login!ToHaiTian")
					||method.contains("ticketapp!add")
					||method.contains("airsearch!ToSearchByDB")
					||method.contains("index!toplanserver")
			){
				
			}else{
			
				user = moaction.getLoginUser();
				
				if(user==null){
					
					
					return Action.INPUT;
				}
				if(method!=null && method.indexOf("!")>0 && method.indexOf("!to")<0){
					//writeLog(user,ServletActionContext.getRequest(),method);
				}
			}
		
			try {
				
						return inv.invoke();
				} catch (Exception e) {
					   e.printStackTrace();
					    moaction.addActionMessage(e.getMessage());
					
						return Action.ERROR;
			}
				
		
		}else{
		
					try {
										
								return inv.invoke();
						} catch (Exception e) {
							   e.printStackTrace();
							
								return Action.ERROR;
					}
		}
	}
	public String getwebname(String dnsname) {

		try {
			int start = dnsname.indexOf(".");
			int www=dnsname.indexOf("www");
			int end = dnsname.lastIndexOf(".");
			if (start != -1) {
				if (start == end||www==-1) {
					return dnsname.substring(0, end);
				}
				return dnsname.substring(start + 1, end);
			} else {
				return dnsname;
			}
		} catch (Exception e) {

		}
		return "";
	}
	/**
	 * 写日志信息
	 * @param user
	 * @param request
	 * @param method
	 */
	
	/*private void writeLog(Customeruser user, HttpServletRequest request, String method) {
		try{
			
			Systemaction systemlog = new Systemaction();
			systemlog.setCode(method);
			
			systemlog.setCreatetime(new Timestamp(System.currentTimeMillis()));
			try {
				List<Systemright> list = Server.getInstance().getSystemrightManager().findAllSystemright(" where "+Systemright.COL_code+"='"+method+"'","",-1,0);
				if(!list.isEmpty()){
					systemlog.setActionname(list.get(0).getName());
				}else{
					systemlog.setActionname(method);
				}
			} catch (Exception e) {
				
			}
			try{systemlog.setIp(request.getRemoteAddr());}catch(Exception e){}
			try{systemlog.setUsername(user.getLoginname());}catch(Exception e){}
			Server.getInstance().getSystemactionManager().createSystemaction(systemlog);
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}*/

}
