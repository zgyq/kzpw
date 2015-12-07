/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ticketapp;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITicketappComponent{ 
	
  
 	/**
	 * 创建 特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public Ticketapp createTicketapp(Ticketapp ticketapp) throws SQLException;
	
	/**
	 * 删除 特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTicketapp(long id);
	
	
	/**
	 * 修改 特价申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateTicketapp(Ticketapp ticketapp);

		
	/**
	 * 修改 特价申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTicketappIgnoreNull(Ticketapp ticketapp);
		
	
	/**
	 * 查找 特价申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketapp(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 特价申请表
	 * @param id
	 * @return
	 */
	public Ticketapp findTicketapp(long id);
	
	
	/** 
	 * 查找 特价申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTicketapp(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找特价申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketapp(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 特价申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTicketappBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTicketappBySql(String sql);
	
}

