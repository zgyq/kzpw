/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.city;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICityManager{ 
	
  
 	/**
	 * 创建 地级市
	 * @param id
	 * @return deleted count 
	 */
	public City createCity(City city) throws SQLException;
	
	/**
	 * 删除 地级市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCity(long id);
	
	
	/**
	 * 修改 地级市
	 * @param id
	 * @return updated count 
	 */
	public int updateCity(City city);

		
	/**
	 * 修改 地级市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCityIgnoreNull(City city);
		
	
	/**
	 * 查找 地级市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCity(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 地级市
	 * @param id
	 * @return
	 */
	public City findCity(long id);
	
	/**
	 * 查找 地级市 by language
	 * @param id
	 * @return
	 */
	public City findCitybylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 地级市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCity(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找地级市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCity(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 地级市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCityBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCityBySql(String sql);
	
}

