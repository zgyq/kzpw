/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.city;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CityComponent   implements ICityComponent{ 
	
	
	private ICityManager cityManager;
   
   
 	public ICityManager getCityManager() {
		return cityManager;
	}

	public void setCityManager(ICityManager cityManager) {
		this.cityManager = cityManager;
	}
  
 	/**
	 * 创建 地级市
	 * @param id
	 * @return deleted count 
	 */
	public City createCity(City city) throws SQLException{
	
		return cityManager.createCity(city);
	}
	/**
	 * 删除 地级市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCity(long id){
	
		return cityManager.deleteCity(id);
	}
	
	
	/**
	 * 修改 地级市
	 * @param id
	 * @return updated count 
	 */
	public int updateCity(City city){
		return cityManager.updateCity(city);
	
	}

		
	/**
	 * 修改 地级市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCityIgnoreNull(City city){
			return cityManager.updateCityIgnoreNull(city);
	
	}
	
	/**
	 * 查找 地级市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCity(String where, String orderby,int limit,int offset){
		return cityManager.findAllCity(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 地级市
	 * @param id
	 * @return
	 */
	public City findCity(long id){
		return cityManager.findCity(id);
	}
	/**
	 * 查找 地级市 by language
	 * @param id
	 * @return
	 */
	public City findCitybylanguage(long id,Integer language){
		return cityManager.findCitybylanguage(id,language);
	}
	/** 
	 * 查找 地级市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCity(String where, String orderby,PageInfo pageinfo){
		return cityManager.findAllCity(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找地级市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCity(String sql,int limit,int offset){
		return cityManager.findAllCity(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 地级市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCityBySql(String sql){
		return cityManager.excuteCityBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCityBySql(String sql){
		return cityManager.countCityBySql(sql);
	}
}

