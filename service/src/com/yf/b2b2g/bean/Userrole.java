package com.yf.b2b2g.bean;

import java.io.Serializable;

public class Userrole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long roleid;
	
	private long empid;

	public long getRoleid() {
		return roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public long getEmpid() {
		return empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}


}
