/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.customeruser;
import java.util.*;
import java.sql.*;
import java.sql.Date;

import com.yf.system.base.customeragent.Customeragent;
import com.yf.system.base.systemrole.Systemrole;

/**
 *会员
 *在此类中添加方法和属性，在第一次生成后将不会再做统一更改。
 */
public class Customeruser extends CustomeruserBean{
	
	/**
	 * 关联企业
	 */
	private Customeragent customeragent;
	
	/**
	 * 关联角色
	 */
	private List<Systemrole> systemroles;

	public Customeragent getCustomeragent() {
		return customeragent;
	}

	public void setCustomeragent(Customeragent customeragent) {
		this.customeragent = customeragent;
	}

	public List<Systemrole> getSystemroles() {
		return systemroles;
	}

	public void setSystemroles(List<Systemrole> systemroles) {
		this.systemroles = systemroles;
	}

	

}
