/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ticketapp;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TicketappComponent   implements ITicketappComponent{ 
	
	
	private ITicketappManager ticketappManager;
   
   
 	public ITicketappManager getTicketappManager() {
		return ticketappManager;
	}

	public void setTicketappManager(ITicketappManager ticketappManager) {
		this.ticketappManager = ticketappManager;
	}
  
 	/**
	 * 创建 特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public Ticketapp createTicketapp(Ticketapp ticketapp) throws SQLException{
	
		return ticketappManager.createTicketapp(ticketapp);
	}
	/**
	 * 删除 特价申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTicketapp(long id){
	
		return ticketappManager.deleteTicketapp(id);
	}
	
	
	/**
	 * 修改 特价申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateTicketapp(Ticketapp ticketapp){
		return ticketappManager.updateTicketapp(ticketapp);
	
	}

		
	/**
	 * 修改 特价申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTicketappIgnoreNull(Ticketapp ticketapp){
			return ticketappManager.updateTicketappIgnoreNull(ticketapp);
	
	}
	
	/**
	 * 查找 特价申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketapp(String where, String orderby,int limit,int offset){
		return ticketappManager.findAllTicketapp(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 特价申请表
	 * @param id
	 * @return
	 */
	public Ticketapp findTicketapp(long id){
		return ticketappManager.findTicketapp(id);
	}
	
	/** 
	 * 查找 特价申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTicketapp(String where, String orderby,PageInfo pageinfo){
		return ticketappManager.findAllTicketapp(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找特价申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketapp(String sql,int limit,int offset){
		return ticketappManager.findAllTicketapp(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 特价申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTicketappBySql(String sql){
		return ticketappManager.excuteTicketappBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTicketappBySql(String sql){
		return ticketappManager.countTicketappBySql(sql);
	}
}

