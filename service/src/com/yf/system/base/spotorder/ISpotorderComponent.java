/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotorder;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISpotorderComponent{ 
	
  
 	/**
	 * 创建 门票订单
	 * @param id
	 * @return deleted count 
	 */
	public Spotorder createSpotorder(Spotorder spotorder) throws SQLException;
	
	/**
	 * 删除 门票订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotorder(long id);
	
	
	/**
	 * 修改 门票订单
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotorder(Spotorder spotorder);

		
	/**
	 * 修改 门票订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotorderIgnoreNull(Spotorder spotorder);
		
	
	/**
	 * 查找 门票订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotorder(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 门票订单
	 * @param id
	 * @return
	 */
	public Spotorder findSpotorder(long id);
	
	
	/** 
	 * 查找 门票订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotorder(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找门票订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotorder(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 门票订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotorderBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotorderBySql(String sql);
	
}

