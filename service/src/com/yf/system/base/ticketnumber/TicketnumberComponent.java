/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.ticketnumber;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TicketnumberComponent   implements ITicketnumberComponent{ 
	
	
	private ITicketnumberManager ticketnumberManager;
   
   
 	public ITicketnumberManager getTicketnumberManager() {
		return ticketnumberManager;
	}

	public void setTicketnumberManager(ITicketnumberManager ticketnumberManager) {
		this.ticketnumberManager = ticketnumberManager;
	}
  
 	/**
	 * 创建 机票票号
	 * @param id
	 * @return deleted count 
	 */
	public Ticketnumber createTicketnumber(Ticketnumber ticketnumber) throws SQLException{
	
		return ticketnumberManager.createTicketnumber(ticketnumber);
	}
	/**
	 * 删除 机票票号
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTicketnumber(long id){
	
		return ticketnumberManager.deleteTicketnumber(id);
	}
	
	
	/**
	 * 修改 机票票号
	 * @param id
	 * @return updated count 
	 */
	public int updateTicketnumber(Ticketnumber ticketnumber){
		return ticketnumberManager.updateTicketnumber(ticketnumber);
	
	}

		
	/**
	 * 修改 机票票号但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTicketnumberIgnoreNull(Ticketnumber ticketnumber){
			return ticketnumberManager.updateTicketnumberIgnoreNull(ticketnumber);
	
	}
	
	/**
	 * 查找 机票票号
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketnumber(String where, String orderby,int limit,int offset){
		return ticketnumberManager.findAllTicketnumber(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机票票号
	 * @param id
	 * @return
	 */
	public Ticketnumber findTicketnumber(long id){
		return ticketnumberManager.findTicketnumber(id);
	}
	
	/** 
	 * 查找 机票票号
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTicketnumber(String where, String orderby,PageInfo pageinfo){
		return ticketnumberManager.findAllTicketnumber(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机票票号
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTicketnumber(String sql,int limit,int offset){
		return ticketnumberManager.findAllTicketnumber(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机票票号
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTicketnumberBySql(String sql){
		return ticketnumberManager.excuteTicketnumberBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTicketnumberBySql(String sql){
		return ticketnumberManager.countTicketnumberBySql(sql);
	}
}

