/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tripline;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITriplineComponent{ 
	
  
 	/**
	 * 创建 旅行线路
	 * @param id
	 * @return deleted count 
	 */
	public Tripline createTripline(Tripline tripline) throws SQLException;
	
	/**
	 * 删除 旅行线路
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTripline(long id);
	
	
	/**
	 * 修改 旅行线路
	 * @param id
	 * @return updated count 
	 */
	public int updateTripline(Tripline tripline);

		
	/**
	 * 修改 旅行线路但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriplineIgnoreNull(Tripline tripline);
		
	
	/**
	 * 查找 旅行线路
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripline(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 旅行线路
	 * @param id
	 * @return
	 */
	public Tripline findTripline(long id);
	
	/**
	 * 查找 旅行线路 by language
	 * @param id
	 * @return
	 */
	public Tripline findTriplinebylanguage(long id,Integer language);
	
	/** 
	 * 查找 旅行线路
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTripline(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找旅行线路
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripline(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 旅行线路
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriplineBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriplineBySql(String sql);
	
}

