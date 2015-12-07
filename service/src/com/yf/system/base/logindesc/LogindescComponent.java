/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.logindesc;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class LogindescComponent   implements ILogindescComponent{ 
	
	
	private ILogindescManager logindescManager;
   
   
 	public ILogindescManager getLogindescManager() {
		return logindescManager;
	}

	public void setLogindescManager(ILogindescManager logindescManager) {
		this.logindescManager = logindescManager;
	}
  
 	/**
	 * 创建 登录信息
	 * @param id
	 * @return deleted count 
	 */
	public Logindesc createLogindesc(Logindesc logindesc) throws SQLException{
	
		return logindescManager.createLogindesc(logindesc);
	}
	/**
	 * 删除 登录信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLogindesc(long id){
	
		return logindescManager.deleteLogindesc(id);
	}
	
	
	/**
	 * 修改 登录信息
	 * @param id
	 * @return updated count 
	 */
	public int updateLogindesc(Logindesc logindesc){
		return logindescManager.updateLogindesc(logindesc);
	
	}

		
	/**
	 * 修改 登录信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLogindescIgnoreNull(Logindesc logindesc){
			return logindescManager.updateLogindescIgnoreNull(logindesc);
	
	}
	
	/**
	 * 查找 登录信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLogindesc(String where, String orderby,int limit,int offset){
		return logindescManager.findAllLogindesc(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 登录信息
	 * @param id
	 * @return
	 */
	public Logindesc findLogindesc(long id){
		return logindescManager.findLogindesc(id);
	}
	
	/** 
	 * 查找 登录信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLogindesc(String where, String orderby,PageInfo pageinfo){
		return logindescManager.findAllLogindesc(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找登录信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLogindesc(String sql,int limit,int offset){
		return logindescManager.findAllLogindesc(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 登录信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLogindescBySql(String sql){
		return logindescManager.excuteLogindescBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLogindescBySql(String sql){
		return logindescManager.countLogindescBySql(sql);
	}
}

