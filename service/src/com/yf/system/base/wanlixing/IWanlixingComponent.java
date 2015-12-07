/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.wanlixing;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IWanlixingComponent{ 
	
  
 	/**
	 * 创建 万里行申请表
	 * @param id
	 * @return deleted count 
	 */
	public Wanlixing createWanlixing(Wanlixing wanlixing) throws SQLException;
	
	/**
	 * 删除 万里行申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteWanlixing(long id);
	
	
	/**
	 * 修改 万里行申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateWanlixing(Wanlixing wanlixing);

		
	/**
	 * 修改 万里行申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateWanlixingIgnoreNull(Wanlixing wanlixing);
		
	
	/**
	 * 查找 万里行申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWanlixing(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 万里行申请表
	 * @param id
	 * @return
	 */
	public Wanlixing findWanlixing(long id);
	
	
	/** 
	 * 查找 万里行申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllWanlixing(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找万里行申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWanlixing(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 万里行申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteWanlixingBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countWanlixingBySql(String sql);
	
}

