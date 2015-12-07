package com.yf.b2b2g.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Role  implements Serializable{
	
	/** 角色ID*/
	private long id;
	
	/** 企业ID*/
	private long comid;
	
	private int type;
	
	/** 角色名称*/
	private String name;
	
	/** 角色说明*/
	private String memo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getComid() {
		return comid;
	}

	public void setComid(long comid) {
		this.comid = comid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
