/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.changpass;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IChangpassComponent{ 
	
  
 	/**
	 * 创建 变更记录
	 * @param id
	 * @return deleted count 
	 */
	public Changpass createChangpass(Changpass changpass) throws SQLException;
	
	/**
	 * 删除 变更记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteChangpass(long id);
	
	
	/**
	 * 修改 变更记录
	 * @param id
	 * @return updated count 
	 */
	public int updateChangpass(Changpass changpass);

		
	/**
	 * 修改 变更记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateChangpassIgnoreNull(Changpass changpass);
		
	
	/**
	 * 查找 变更记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChangpass(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 变更记录
	 * @param id
	 * @return
	 */
	public Changpass findChangpass(long id);
	
	
	/** 
	 * 查找 变更记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllChangpass(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找变更记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChangpass(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 变更记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteChangpassBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countChangpassBySql(String sql);
	
}

