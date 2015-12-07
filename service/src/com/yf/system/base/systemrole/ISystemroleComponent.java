/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.systemrole;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISystemroleComponent{ 
	
  
 	/**
	 * 创建 系统角色
	 * @param id
	 * @return deleted count 
	 */
	public Systemrole createSystemrole(Systemrole systemrole) throws SQLException;
	
	/**
	 * 删除 系统角色
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemrole(long id);
	
	
	/**
	 * 修改 系统角色
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemrole(Systemrole systemrole);

		
	/**
	 * 修改 系统角色但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemroleIgnoreNull(Systemrole systemrole);
		
	
	/**
	 * 查找 系统角色
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemrole(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 系统角色
	 * @param id
	 * @return
	 */
	public Systemrole findSystemrole(long id);
	
	
	/** 
	 * 查找 系统角色
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemrole(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找系统角色
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemrole(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 系统角色
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemroleBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemroleBySql(String sql);
	
}

