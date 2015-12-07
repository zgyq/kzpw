/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tousu;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITousuComponent{ 
	
  
 	/**
	 * 创建 投诉建议表
	 * @param id
	 * @return deleted count 
	 */
	public Tousu createTousu(Tousu tousu) throws SQLException;
	
	/**
	 * 删除 投诉建议表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTousu(long id);
	
	
	/**
	 * 修改 投诉建议表
	 * @param id
	 * @return updated count 
	 */
	public int updateTousu(Tousu tousu);

		
	/**
	 * 修改 投诉建议表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTousuIgnoreNull(Tousu tousu);
		
	
	/**
	 * 查找 投诉建议表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTousu(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 投诉建议表
	 * @param id
	 * @return
	 */
	public Tousu findTousu(long id);
	
	
	/** 
	 * 查找 投诉建议表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTousu(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找投诉建议表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTousu(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 投诉建议表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTousuBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTousuBySql(String sql);
	
}

