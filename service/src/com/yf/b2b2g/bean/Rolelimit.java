package com.yf.b2b2g.bean;

import java.io.Serializable;

public class Rolelimit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long roleid;
	
	private long limitid;

	public long getRoleid() {
		return roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public long getLimitid() {
		return limitid;
	}

	public void setLimitid(long limitid) {
		this.limitid = limitid;
	}

}
