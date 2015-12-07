/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
package com.yf.system.base.customeragent;
import java.util.*;
import java.sql.*;
import java.sql.Date;

import com.yf.system.base.bussiness.Bussiness;

/**
 *加盟商信息表
 *在此类中添加方法和属性，在第一次生成后将不会再做统一更改。
 */
public class Customeragent extends CustomeragentBean{
	private List<Bussiness> bussinesslist;

	public List<Bussiness> getBussinesslist() {
		//System.out.println("******************getBussinesslist**************************");
		return bussinesslist;
	}

	public void setBussinesslist(List<Bussiness> bussinesslist) {
		//System.out.println("****************setBussinesslist***************");
		this.bussinesslist = bussinesslist;
	}
	
	

}
