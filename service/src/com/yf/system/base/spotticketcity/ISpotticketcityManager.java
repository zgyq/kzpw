/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotticketcity;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISpotticketcityManager{ 
	
  
 	/**
	 * 创建 门票城市
	 * @param id
	 * @return deleted count 
	 */
	public Spotticketcity createSpotticketcity(Spotticketcity spotticketcity) throws SQLException;
	
	/**
	 * 删除 门票城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotticketcity(long id);
	
	
	/**
	 * 修改 门票城市
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotticketcity(Spotticketcity spotticketcity);

		
	/**
	 * 修改 门票城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotticketcityIgnoreNull(Spotticketcity spotticketcity);
		
	
	/**
	 * 查找 门票城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticketcity(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 门票城市
	 * @param id
	 * @return
	 */
	public Spotticketcity findSpotticketcity(long id);
	
	
	/** 
	 * 查找 门票城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotticketcity(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找门票城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotticketcity(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 门票城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotticketcityBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotticketcityBySql(String sql);
	
}

