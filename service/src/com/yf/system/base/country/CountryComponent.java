/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.country;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CountryComponent   implements ICountryComponent{ 
	
	
	private ICountryManager countryManager;
   
   
 	public ICountryManager getCountryManager() {
		return countryManager;
	}

	public void setCountryManager(ICountryManager countryManager) {
		this.countryManager = countryManager;
	}
  
 	/**
	 * 创建 国家表
	 * @param id
	 * @return deleted count 
	 */
	public Country createCountry(Country country) throws SQLException{
	
		return countryManager.createCountry(country);
	}
	/**
	 * 删除 国家表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCountry(long id){
	
		return countryManager.deleteCountry(id);
	}
	
	
	/**
	 * 修改 国家表
	 * @param id
	 * @return updated count 
	 */
	public int updateCountry(Country country){
		return countryManager.updateCountry(country);
	
	}

		
	/**
	 * 修改 国家表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCountryIgnoreNull(Country country){
			return countryManager.updateCountryIgnoreNull(country);
	
	}
	
	/**
	 * 查找 国家表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCountry(String where, String orderby,int limit,int offset){
		return countryManager.findAllCountry(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 国家表
	 * @param id
	 * @return
	 */
	public Country findCountry(long id){
		return countryManager.findCountry(id);
	}
	
	/** 
	 * 查找 国家表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCountry(String where, String orderby,PageInfo pageinfo){
		return countryManager.findAllCountry(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找国家表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCountry(String sql,int limit,int offset){
		return countryManager.findAllCountry(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 国家表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCountryBySql(String sql){
		return countryManager.excuteCountryBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCountryBySql(String sql){
		return countryManager.countCountryBySql(sql);
	}
}

