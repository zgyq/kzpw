/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotlineprice;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISpotlinepriceManager{ 
	
  
 	/**
	 * 创建 景区线路价格信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineprice createSpotlineprice(Spotlineprice spotlineprice) throws SQLException;
	
	/**
	 * 删除 景区线路价格信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineprice(long id);
	
	
	/**
	 * 修改 景区线路价格信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineprice(Spotlineprice spotlineprice);

		
	/**
	 * 修改 景区线路价格信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlinepriceIgnoreNull(Spotlineprice spotlineprice);
		
	
	/**
	 * 查找 景区线路价格信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineprice(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 景区线路价格信息
	 * @param id
	 * @return
	 */
	public Spotlineprice findSpotlineprice(long id);
	
	
	/** 
	 * 查找 景区线路价格信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineprice(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找景区线路价格信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineprice(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 景区线路价格信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlinepriceBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlinepriceBySql(String sql);
	
}

