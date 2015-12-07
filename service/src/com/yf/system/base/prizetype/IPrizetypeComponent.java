/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.prizetype;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IPrizetypeComponent{ 
	
  
 	/**
	 * 创建 积分礼品类型
	 * @param id
	 * @return deleted count 
	 */
	public Prizetype createPrizetype(Prizetype prizetype) throws SQLException;
	
	/**
	 * 删除 积分礼品类型
	 * @param id
	 * @return deleted count 
	 */
	public int deletePrizetype(long id);
	
	
	/**
	 * 修改 积分礼品类型
	 * @param id
	 * @return updated count 
	 */
	public int updatePrizetype(Prizetype prizetype);

		
	/**
	 * 修改 积分礼品类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePrizetypeIgnoreNull(Prizetype prizetype);
		
	
	/**
	 * 查找 积分礼品类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizetype(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 积分礼品类型
	 * @param id
	 * @return
	 */
	public Prizetype findPrizetype(long id);
	
	
	/** 
	 * 查找 积分礼品类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPrizetype(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找积分礼品类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPrizetype(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 积分礼品类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePrizetypeBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPrizetypeBySql(String sql);
	
}

