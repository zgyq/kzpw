/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotline;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISpotlineComponent{ 
	
  
 	/**
	 * 创建 景区线路信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotline createSpotline(Spotline spotline) throws SQLException;
	
	/**
	 * 删除 景区线路信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotline(long id);
	
	
	/**
	 * 修改 景区线路信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotline(Spotline spotline);

		
	/**
	 * 修改 景区线路信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineIgnoreNull(Spotline spotline);
		
	
	/**
	 * 查找 景区线路信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotline(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 景区线路信息
	 * @param id
	 * @return
	 */
	public Spotline findSpotline(long id);
	
	
	/** 
	 * 查找 景区线路信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotline(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找景区线路信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotline(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 景区线路信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineBySql(String sql);
	
}

