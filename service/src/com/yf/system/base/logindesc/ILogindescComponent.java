/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.logindesc;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ILogindescComponent{ 
	
  
 	/**
	 * 创建 登录信息
	 * @param id
	 * @return deleted count 
	 */
	public Logindesc createLogindesc(Logindesc logindesc) throws SQLException;
	
	/**
	 * 删除 登录信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLogindesc(long id);
	
	
	/**
	 * 修改 登录信息
	 * @param id
	 * @return updated count 
	 */
	public int updateLogindesc(Logindesc logindesc);

		
	/**
	 * 修改 登录信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLogindescIgnoreNull(Logindesc logindesc);
		
	
	/**
	 * 查找 登录信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLogindesc(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 登录信息
	 * @param id
	 * @return
	 */
	public Logindesc findLogindesc(long id);
	
	
	/** 
	 * 查找 登录信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLogindesc(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找登录信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLogindesc(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 登录信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLogindescBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLogindescBySql(String sql);
	
}

