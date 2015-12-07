/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.systemaction;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISystemactionComponent{ 
	
  
 	/**
	 * 创建 系统用户行为
	 * @param id
	 * @return deleted count 
	 */
	public Systemaction createSystemaction(Systemaction systemaction) throws SQLException;
	
	/**
	 * 删除 系统用户行为
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemaction(long id);
	
	
	/**
	 * 修改 系统用户行为
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemaction(Systemaction systemaction);

		
	/**
	 * 修改 系统用户行为但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemactionIgnoreNull(Systemaction systemaction);
		
	
	/**
	 * 查找 系统用户行为
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemaction(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 系统用户行为
	 * @param id
	 * @return
	 */
	public Systemaction findSystemaction(long id);
	
	
	/** 
	 * 查找 系统用户行为
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemaction(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找系统用户行为
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemaction(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 系统用户行为
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemactionBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemactionBySql(String sql);
	
}

