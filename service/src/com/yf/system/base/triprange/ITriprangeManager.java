/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triprange;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITriprangeManager{ 
	
  
 	/**
	 * 创建 行程
	 * @param id
	 * @return deleted count 
	 */
	public Triprange createTriprange(Triprange triprange) throws SQLException;
	
	/**
	 * 删除 行程
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriprange(long id);
	
	
	/**
	 * 修改 行程
	 * @param id
	 * @return updated count 
	 */
	public int updateTriprange(Triprange triprange);

		
	/**
	 * 修改 行程但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriprangeIgnoreNull(Triprange triprange);
		
	
	/**
	 * 查找 行程
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprange(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 行程
	 * @param id
	 * @return
	 */
	public Triprange findTriprange(long id);
	
	/**
	 * 查找 行程 by language
	 * @param id
	 * @return
	 */
	public Triprange findTriprangebylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 行程
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriprange(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找行程
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprange(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 行程
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriprangeBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriprangeBySql(String sql);
	
}

