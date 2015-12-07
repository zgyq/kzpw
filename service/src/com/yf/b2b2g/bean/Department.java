package com.yf.b2b2g.bean;

import java.io.Serializable;

public class Department implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	/** PARENTID */
	private long parentid;
	
	/** 父字符串 */
	private String parentstr;
	
	/** 部门编号 */
	private String deptid;
	
	/** 部门名称 */
	private String deptname;
	
	/** 部门描述 */
	private String note;
	
	/** 所属企业 */
	private long comid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getParentid() {
		return parentid;
	}

	public void setParentid(long parentid) {
		this.parentid = parentid;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public long getComid() {
		return comid;
	}

	public void setComid(long comid) {
		this.comid = comid;
	}

	public String getParentstr() {
		return parentstr;
	}

	public void setParentstr(String parentstr) {
		this.parentstr = parentstr;
	}


	


}
