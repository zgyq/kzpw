/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.airbaseprice;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class AirbasepriceComponent   implements IAirbasepriceComponent{ 
	
	
	private IAirbasepriceManager airbasepriceManager;
   
   
 	public IAirbasepriceManager getAirbasepriceManager() {
		return airbasepriceManager;
	}

	public void setAirbasepriceManager(IAirbasepriceManager airbasepriceManager) {
		this.airbasepriceManager = airbasepriceManager;
	}
  
 	/**
	 * 创建 机票基础价格表
	 * @param id
	 * @return deleted count 
	 */
	public Airbaseprice createAirbaseprice(Airbaseprice airbaseprice) throws SQLException{
	
		return airbasepriceManager.createAirbaseprice(airbaseprice);
	}
	/**
	 * 删除 机票基础价格表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAirbaseprice(long id){
	
		return airbasepriceManager.deleteAirbaseprice(id);
	}
	
	
	/**
	 * 修改 机票基础价格表
	 * @param id
	 * @return updated count 
	 */
	public int updateAirbaseprice(Airbaseprice airbaseprice){
		return airbasepriceManager.updateAirbaseprice(airbaseprice);
	
	}

		
	/**
	 * 修改 机票基础价格表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAirbasepriceIgnoreNull(Airbaseprice airbaseprice){
			return airbasepriceManager.updateAirbasepriceIgnoreNull(airbaseprice);
	
	}
	
	/**
	 * 查找 机票基础价格表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirbaseprice(String where, String orderby,int limit,int offset){
		return airbasepriceManager.findAllAirbaseprice(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 机票基础价格表
	 * @param id
	 * @return
	 */
	public Airbaseprice findAirbaseprice(long id){
		return airbasepriceManager.findAirbaseprice(id);
	}
	/**
	 * 查找 机票基础价格表 by language
	 * @param id
	 * @return
	 */
	public Airbaseprice findAirbasepricebylanguage(long id,Integer language){
		return airbasepriceManager.findAirbasepricebylanguage(id,language);
	}
	/** 
	 * 查找 机票基础价格表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAirbaseprice(String where, String orderby,PageInfo pageinfo){
		return airbasepriceManager.findAllAirbaseprice(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找机票基础价格表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAirbaseprice(String sql,int limit,int offset){
		return airbasepriceManager.findAllAirbaseprice(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 机票基础价格表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAirbasepriceBySql(String sql){
		return airbasepriceManager.excuteAirbasepriceBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAirbasepriceBySql(String sql){
		return airbasepriceManager.countAirbasepriceBySql(sql);
	}
}

