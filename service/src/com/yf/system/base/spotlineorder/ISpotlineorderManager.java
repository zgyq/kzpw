/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotlineorder;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISpotlineorderManager{ 
	
  
 	/**
	 * 创建 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineorder createSpotlineorder(Spotlineorder spotlineorder) throws SQLException;
	
	/**
	 * 删除 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineorder(long id);
	
	
	/**
	 * 修改 线路订单
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineorder(Spotlineorder spotlineorder);

		
	/**
	 * 修改 线路订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineorderIgnoreNull(Spotlineorder spotlineorder);
		
	
	/**
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineorder(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 线路订单
	 * @param id
	 * @return
	 */
	public Spotlineorder findSpotlineorder(long id);
	
	
	/** 
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineorder(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找线路订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineorder(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 线路订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineorderBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineorderBySql(String sql);
	
}

