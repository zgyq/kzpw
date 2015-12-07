package com.yf.b2b2g.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
*
* 开发人：hanmenghui
* 开发日期：2012-02-09
* 功能说明：员工证件信息
*
*/
public class Certificate implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**员工ID */
	private long empid;
	/**姓名 */
	private String certname;
	
	/**证件类型 */
	private int certtype;
	
	/**证件号码*/
	private String certnum;
	
	/**证件有效期 */
	private Timestamp validdate;

	public String getCertname() {
		return certname;
	}
	
	public static Map<Integer,String> certtypename(){
		Map<Integer,String> map=new HashMap<Integer,String>();
		map.put(1, "身份证");
		map.put(2, "驾驶证");
		map.put(3, "护照");
		map.put(4, "港澳通行证");
		map.put(5, "台湾通行证");
		map.put(6, "台胞证");
		map.put(7, "台胞证");
		map.put(8, "回乡证");
		map.put(9, "军官证");
		map.put(0, "其它");
		return map;
	}

	public void setCertname(String certname) {
		this.certname = certname;
	}

	public int getCerttype() {
		return certtype;
	}

	public void setCerttype(int certtype) {
		this.certtype = certtype;
	}

	public String getCertnum() {
		return certnum;
	}

	public void setCertnum(String certnum) {
		this.certnum = certnum;
	}

	public Timestamp getValiddate() {
		return validdate;
	}

	public void setValiddate(Timestamp validdate) {
		this.validdate = validdate;
	}

	public long getEmpid() {
		return empid;
	}

	public void setEmpid(long empid) {
		this.empid = empid;
	}

}
