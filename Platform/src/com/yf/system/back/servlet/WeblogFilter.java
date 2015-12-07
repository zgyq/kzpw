package com.yf.system.back.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeblogFilter implements Filter {
	private static String filterfile =""; 
	
	private String[] keywords = new String[]{
			"EXCEPT",
			"EXEC",
			"ALTER",
			"EXECUTE",
			"FETCH",
			"BACKUP",
			"RESTORE",
			"GRANT",
			"REVOKE",
			"IDENTITY_INSERT",
			"COLUMN",
			"INSERT",
			"SETUSER",
			"SHUTDOWN",
			"CREATE",
			"SYSTEM_USER",
			"KILL",
			"DELETE",
			"UPDATE",
			"DROP",
			"DUMP",
			
	}; 
	
	private static boolean log = true ;
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		 boolean flag = false;
			HttpServletRequest req = (HttpServletRequest)arg0;
			req.setCharacterEncoding("UTF-8");
		try {
		
		
		  if(log){	
		
			 
		
			if(!(req.getRequestURI().contains("wrong.jsp"))){
				
			
			
			HttpServletResponse resp = (HttpServletResponse)arg1;
			String str = "";
		
			Map map = req.getParameterMap();
			Set set  = map.entrySet();
			
			Iterator it = set.iterator();
			while(it.hasNext()){
				Object o = it.next();
				Object obj = ((Map.Entry)o).getValue();
				if(obj instanceof String[]){
					String[] s = (String[])obj;
					for(String ss : s){
						str+=ss;
					}
				}else{
					str+=(String)obj;
				}
				
			}
			
			// System.out.println("debug:"+str);
			if(str!=null && (!str.equals("null"))&& str.length()>0){
				for(String key : keywords){
					
					if( str.toUpperCase().contains(key) ){
						flag=true;
						System.out.println("error:"+str);
						resp.sendRedirect(req.getContextPath()+"/wrong.jsp");
						
						break;
					}
					
				}
			}
			}
		  }

		} catch (Exception e) {
			// TODO: handle exception
		}
		if(!flag)
		arg2.doFilter(arg0,arg1);
		
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
