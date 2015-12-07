/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.country;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICountryManager{ 
	
  
 	/**
	 * 创建 国家表
	 * @param id
	 * @return deleted count 
	 */
	public Country createCountry(Country country) throws SQLException;
	
	/**
	 * 删除 国家表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCountry(long id);
	
	
	/**
	 * 修改 国家表
	 * @param id
	 * @return updated count 
	 */
	public int updateCountry(Country country);

		
	/**
	 * 修改 国家表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCountryIgnoreNull(Country country);
		
	
	/**
	 * 查找 国家表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCountry(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 国家表
	 * @param id
	 * @return
	 */
	public Country findCountry(long id);
	
	
	/** 
	 * 查找 国家表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCountry(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找国家表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCountry(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 国家表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCountryBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCountryBySql(String sql);
	
}
