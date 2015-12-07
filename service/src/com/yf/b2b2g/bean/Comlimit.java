package com.yf.b2b2g.bean;

import java.io.Serializable;

public class Comlimit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long comid;
	
	private long rightid;

	public long getComid() {
		return comid;
	}

	public void setComid(long comid) {
		this.comid = comid;
	}

	public long getRightid() {
		return rightid;
	}

	public void setRightid(long rightid) {
		this.rightid = rightid;
	}

	

}
