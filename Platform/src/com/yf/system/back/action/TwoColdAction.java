package com.yf.system.back.action;

import com.yf.system.back.server.Server;
import com.opensymphony.xwork.ActionSupport;

public class TwoColdAction extends ActionSupport {
	
	public String twocold(){
		String sql= " SELECT * FROM T_PASSENGER";
		Server.getInstance().getSystemService().findMapResultBySql(sql, null);
		System.out.println("*******OK**** VERY GOOD!~~~~~~~***");
		return "";
	}

}
