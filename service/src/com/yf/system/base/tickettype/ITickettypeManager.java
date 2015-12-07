/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tickettype;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITickettypeManager{ 
	
  
 	/**
	 * 创建 机票类型
	 * @param id
	 * @return deleted count 
	 */
	public Tickettype createTickettype(Tickettype tickettype) throws SQLException;
	
	/**
	 * 删除 机票类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTickettype(long id);
	
	
	/**
	 * 修改 机票类型
	 * @param id
	 * @return updated count 
	 */
	public int updateTickettype(Tickettype tickettype);

		
	/**
	 * 修改 机票类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTickettypeIgnoreNull(Tickettype tickettype);
		
	
	/**
	 * 查找 机票类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickettype(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 机票类型
	 * @param id
	 * @return
	 */
	public Tickettype findTickettype(long id);
	
	
	/** 
	 * 查找 机票类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTickettype(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找机票类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTickettype(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 机票类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTickettypeBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTickettypeBySql(String sql);
	
}

