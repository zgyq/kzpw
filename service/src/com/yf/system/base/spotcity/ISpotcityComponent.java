/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotcity;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISpotcityComponent{ 
	
  
 	/**
	 * 创建 景区城市
	 * @param id
	 * @return deleted count 
	 */
	public Spotcity createSpotcity(Spotcity spotcity) throws SQLException;
	
	/**
	 * 删除 景区城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotcity(long id);
	
	
	/**
	 * 修改 景区城市
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotcity(Spotcity spotcity);

		
	/**
	 * 修改 景区城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotcityIgnoreNull(Spotcity spotcity);
		
	
	/**
	 * 查找 景区城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotcity(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 景区城市
	 * @param id
	 * @return
	 */
	public Spotcity findSpotcity(long id);
	
	
	/** 
	 * 查找 景区城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotcity(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找景区城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotcity(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 景区城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotcityBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotcityBySql(String sql);
	
}

