/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.dnsmaintenance;

import java.util.*;
import java.sql.*;
import java.sql.Date;

/**
 * 分销商DNSLOGO维护
 */
public class DnsmaintenanceBean implements java.io.Serializable {

	/**
	 * 分销商DNSLOGO维护 表名
	 */
	public static final String TABLE = "T_DNSMAINTENANCE";

	/**
	 * ID 列名
	 */
	public static final String COL_id = "ID";
	/**
	 * 加盟商 列名
	 */
	public static final String COL_agentid = "C_AGENTID";

	/**
	 * 登录页id 列名
	 */
	public static final String COL_loginpageid = "C_LOGINPAGEID";

	/**
	 * 公司名称 列名
	 */
	public static final String COL_companynae = "C_COMPANYNAME";
	/**
	 * 公司简称
	 */
	public static final String COL_shortname = "C_SHORTNAME";

	/**
	 * 域名 列名
	 */
	public static final String COL_dnsname = "C_DNSNAME";
	/**
	 * 域名 列名
	 */
	public static final String COL_serviceline = "C_SERVICELINE";

	/**
	 * logo图片 列名
	 */
	public static final String COL_logosrc = "C_LOGOSRC";
	/**
	 * logo图片 列名
	 */
	public static final String COL_logloginosrc = "C_LOGLOGINOSRC";
	
	/**
	 *备案号 列名
	 */
	public static final String COL_icpnum = "C_ICPNUM";
	
	/**
	 *公司地址 列名
	 */
	public static final String COL_dizhi = "C_DIZHI";
	
	/**
	 *备用1 列名
	 */
	public static final String COL_back1 = "C_BACK1";
	/**
	 *备用2 列名
	 */
	public static final String COL_back2 = "C_BACK2";
	

	// ID
	private long id;

	private long agentid;

	// 公司名称
	private String companyname;

	private String shortname;

	private String address;

	private String serviceline;

	// 域名
	private String dnsname;

	// logo图片
	private String logosrc;

	private String logologinsrc;

	private String loginpage;

	private String loginpagename;
	
	private String icpnum;
	
	private String dizhi;
	
	private String back1;
	
	private String back2;

	/**
	 * getID
	 */
	public long getId() {
		return id;
	}

	/**
	 * setID
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * get公司名称
	 */
	public String getCompanyname() {
		return companyname;
	}

	/**
	 * set公司名称
	 */
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	/**
	 * get域名
	 */
	public String getDnsname() {
		return dnsname;
	}

	/**
	 * set域名
	 */
	public void setDnsname(String dnsname) {
		this.dnsname = dnsname;
	}

	/**
	 * getlogo图片
	 */
	public String getLogosrc() {
		return logosrc;
	}

	/**
	 * setlogo图片
	 */
	public void setLogosrc(String logosrc) {
		this.logosrc = logosrc;
	}

	public String toString() {

		return "[" + id + "|"

		+ companyname + "|"
		
		+ logologinsrc + "|"
		
		+ address + "|"
		
		+ serviceline + "|"
		
		+ loginpage + "|"
		
		+ icpnum + "|"
		
		+ dizhi + "|"
		
		+ back1 + "|"
		
		+ back2 + "|"

		+ dnsname + "|"

		+ logosrc + "]";
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getServiceline() {
		return serviceline;
	}

	public void setServiceline(String serviceline) {
		this.serviceline = serviceline;
	}

	public long getAgentid() {
		return agentid;
	}

	public void setAgentid(long agentid) {
		this.agentid = agentid;
	}

	public String getLogologinsrc() {
		return logologinsrc;
	}

	public void setLogologinsrc(String logologinsrc) {
		this.logologinsrc = logologinsrc;
	}

	public String getLoginpage() {
		return loginpage;
	}

	public void setLoginpage(String loginpage) {
		this.loginpage = loginpage;
	}

	public String getLoginpagename() {
		return loginpagename;
	}

	public void setLoginpagename(String loginpagename) {
		this.loginpagename = loginpagename;
	}

	public String getIcpnum() {
		return icpnum;
	}

	public void setIcpnum(String icpnum) {
		this.icpnum = icpnum;
	}

	public String getDizhi() {
		return dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}

	public String getBack1() {
		return back1;
	}

	public void setBack1(String back1) {
		this.back1 = back1;
	}

	public String getBack2() {
		return back2;
	}

	public void setBack2(String back2) {
		this.back2 = back2;
	}

}
