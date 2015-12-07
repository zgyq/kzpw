/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customeragent;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICustomeragentManager{ 
	
  
 	/**
	 * 创建 加盟商信息表
	 * @param id
	 * @return deleted count 
	 */
	public Customeragent createCustomeragent(Customeragent customeragent) throws SQLException;
	
	/**
	 * 删除 加盟商信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomeragent(long id);
	
	
	/**
	 * 修改 加盟商信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomeragent(Customeragent customeragent);

		
	/**
	 * 修改 加盟商信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomeragentIgnoreNull(Customeragent customeragent);
		
	
	/**
	 * 查找 加盟商信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeragent(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 加盟商信息表
	 * @param id
	 * @return
	 */
	public Customeragent findCustomeragent(long id);
	
	
	/** 
	 * 查找 加盟商信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomeragent(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找加盟商信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomeragent(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 加盟商信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomeragentBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomeragentBySql(String sql);
	
}

