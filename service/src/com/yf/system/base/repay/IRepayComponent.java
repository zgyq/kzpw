/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.repay;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IRepayComponent{ 
	
  
 	/**
	 * 创建 大客户还款记录表
	 * @param id
	 * @return deleted count 
	 */
	public Repay createRepay(Repay repay) throws SQLException;
	
	/**
	 * 删除 大客户还款记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRepay(long id);
	
	
	/**
	 * 修改 大客户还款记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateRepay(Repay repay);

		
	/**
	 * 修改 大客户还款记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRepayIgnoreNull(Repay repay);
		
	
	/**
	 * 查找 大客户还款记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRepay(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 大客户还款记录表
	 * @param id
	 * @return
	 */
	public Repay findRepay(long id);
	
	
	/** 
	 * 查找 大客户还款记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRepay(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找大客户还款记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRepay(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 大客户还款记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRepayBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRepayBySql(String sql);
	
}

