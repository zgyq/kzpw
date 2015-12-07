/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.cityairport;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CityairportComponent   implements ICityairportComponent{ 
	
	
	private ICityairportManager cityairportManager;
   
   
 	public ICityairportManager getCityairportManager() {
		return cityairportManager;
	}

	public void setCityairportManager(ICityairportManager cityairportManager) {
		this.cityairportManager = cityairportManager;
	}
  
 	/**
	 * 创建 机场城市
	 * @param id
	 * @return deleted count 
	 */
	public Cityairport createCityairport(Cityairport cityairport) throws SQLException{
	
		return cityairportManager.createCityairport(cityairport);
	}
	/**
	 * 删除 机场城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCityairport(long id){
	
		return cityairportManager.deleteCityairport(id);
	}
	
	
	/**
	 * 修改 机场城市
	 * @param id
	 * @return updated count 
	 */
	public int updateCityairport(Cityairport cityairport){
		return cityairportManager.updateCityairport(cityairport);
	
	}

		
	/**
	 * 修改 机场城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCityairportIgnoreNull(Cityairport cityairport){
			return cityairportManager.updateCityairportIgnoreNull(cityairport);
	
	}
	
	/**
	 * 查找 机场城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCityairport(String where, String orderby,int limit,int offset){
		return cityairportManager.findAllCityairport(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机场城市
	 * @param id
	 * @return
	 */
	public Cityairport findCityairport(long id){
		return cityairportManager.findCityairport(id);
	}
	/**
	 * 查找 机场城市 by language
	 * @param id
	 * @return
	 */
	public Cityairport findCityairportbylanguage(long id,Integer language){
		return cityairportManager.findCityairportbylanguage(id,language);
	}
	/** 
	 * 查找 机场城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCityairport(String where, String orderby,PageInfo pageinfo){
		return cityairportManager.findAllCityairport(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机场城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCityairport(String sql,int limit,int offset){
		return cityairportManager.findAllCityairport(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机场城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCityairportBySql(String sql){
		return cityairportManager.excuteCityairportBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCityairportBySql(String sql){
		return cityairportManager.countCityairportBySql(sql);
	}
}

