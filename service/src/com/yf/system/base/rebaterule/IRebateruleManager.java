/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rebaterule;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IRebateruleManager{ 
	
  
 	/**
	 * 创建 返佣规则
	 * @param id
	 * @return deleted count 
	 */
	public Rebaterule createRebaterule(Rebaterule rebaterule) throws SQLException;
	
	/**
	 * 删除 返佣规则
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRebaterule(long id);
	
	
	/**
	 * 修改 返佣规则
	 * @param id
	 * @return updated count 
	 */
	public int updateRebaterule(Rebaterule rebaterule);

		
	/**
	 * 修改 返佣规则但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRebateruleIgnoreNull(Rebaterule rebaterule);
		
	
	/**
	 * 查找 返佣规则
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterule(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 返佣规则
	 * @param id
	 * @return
	 */
	public Rebaterule findRebaterule(long id);
	
	
	/** 
	 * 查找 返佣规则
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRebaterule(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找返佣规则
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterule(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 返佣规则
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRebateruleBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRebateruleBySql(String sql);
	
}

