/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customeragent;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CustomeragentComponent   implements ICustomeragentComponent{ 
	
	
	private ICustomeragentManager customeragentManager;
   
   
 	public ICustomeragentManager getCustomeragentManager() {
		return customeragentManager;
	}

	public void setCustomeragentManager(ICustomeragentManager customeragentManager) {
		this.customeragentManager = customeragentManager;
	}
  
 	/**
	 * 创建 加盟商信息表
	 * @param id
	 * @return deleted count 
	 */
	public Customeragent createCustomeragent(Customeragent customeragent) throws SQLException{
	
		return customeragentManager.createCustomeragent(customeragent);
	}
	/**
	 * 删除 加盟商信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeragent(long id){
	
		return customeragentManager.deleteCustomeragent(id);
	}
	
	
	/**
	 * 修改 加盟商信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeragent(Customeragent customeragent){
		return customeragentManager.updateCustomeragent(customeragent);
	
	}

		
	/**
	 * 修改 加盟商信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeragentIgnoreNull(Customeragent customeragent){
			return customeragentManager.updateCustomeragentIgnoreNull(customeragent);
	
	}
	
	/**
	 * 查找 加盟商信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeragent(String where, String orderby,int limit,int offset){
		return customeragentManager.findAllCustomeragent(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 加盟商信息表
	 * @param id
	 * @return
	 */
	public Customeragent findCustomeragent(long id){
		return customeragentManager.findCustomeragent(id);
	}
	
	/** 
	 * 查找 加盟商信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeragent(String where, String orderby,PageInfo pageinfo){
		return customeragentManager.findAllCustomeragent(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找加盟商信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeragent(String sql,int limit,int offset){
		return customeragentManager.findAllCustomeragent(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 加盟商信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeragentBySql(String sql){
		return customeragentManager.excuteCustomeragentBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeragentBySql(String sql){
		return customeragentManager.countCustomeragentBySql(sql);
	}
}

