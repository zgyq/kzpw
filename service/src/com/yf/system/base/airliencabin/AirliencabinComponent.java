/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airliencabin;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class AirliencabinComponent   implements IAirliencabinComponent{ 
	
	
	private IAirliencabinManager airliencabinManager;
   
   
 	public IAirliencabinManager getAirliencabinManager() {
		return airliencabinManager;
	}

	public void setAirliencabinManager(IAirliencabinManager airliencabinManager) {
		this.airliencabinManager = airliencabinManager;
	}
  
 	/**
	 * 创建 航线仓位信息
	 * @param id
	 * @return deleted count 
	 */
	public Airliencabin createAirliencabin(Airliencabin airliencabin) throws SQLException{
	
		return airliencabinManager.createAirliencabin(airliencabin);
	}
	/**
	 * 删除 航线仓位信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirliencabin(long id){
	
		return airliencabinManager.deleteAirliencabin(id);
	}
	
	
	/**
	 * 修改 航线仓位信息
	 * @param id
	 * @return updated count 
	 */
	public int updateAirliencabin(Airliencabin airliencabin){
		return airliencabinManager.updateAirliencabin(airliencabin);
	
	}

		
	/**
	 * 修改 航线仓位信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirliencabinIgnoreNull(Airliencabin airliencabin){
			return airliencabinManager.updateAirliencabinIgnoreNull(airliencabin);
	
	}
	
	/**
	 * 查找 航线仓位信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirliencabin(String where, String orderby,int limit,int offset){
		return airliencabinManager.findAllAirliencabin(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 航线仓位信息
	 * @param id
	 * @return
	 */
	public Airliencabin findAirliencabin(long id){
		return airliencabinManager.findAirliencabin(id);
	}
	
	/** 
	 * 查找 航线仓位信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirliencabin(String where, String orderby,PageInfo pageinfo){
		return airliencabinManager.findAllAirliencabin(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找航线仓位信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirliencabin(String sql,int limit,int offset){
		return airliencabinManager.findAllAirliencabin(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 航线仓位信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirliencabinBySql(String sql){
		return airliencabinManager.excuteAirliencabinBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirliencabinBySql(String sql){
		return airliencabinManager.countAirliencabinBySql(sql);
	}
}

