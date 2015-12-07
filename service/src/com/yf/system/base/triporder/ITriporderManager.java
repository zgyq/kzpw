/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triporder;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITriporderManager{ 
	
  
 	/**
	 * 创建 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public Triporder createTriporder(Triporder triporder) throws SQLException;
	
	/**
	 * 删除 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriporder(long id);
	
	
	/**
	 * 修改 线路订单
	 * @param id
	 * @return updated count 
	 */
	public int updateTriporder(Triporder triporder);

		
	/**
	 * 修改 线路订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriporderIgnoreNull(Triporder triporder);
		
	
	/**
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporder(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 线路订单
	 * @param id
	 * @return
	 */
	public Triporder findTriporder(long id);
	
	/**
	 * 查找 线路订单 by language
	 * @param id
	 * @return
	 */
	public Triporder findTriporderbylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriporder(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找线路订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporder(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 线路订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriporderBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriporderBySql(String sql);
	
}

