/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triprange;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TriprangeComponent   implements ITriprangeComponent{ 
	
	
	private ITriprangeManager triprangeManager;
   
   
 	public ITriprangeManager getTriprangeManager() {
		return triprangeManager;
	}

	public void setTriprangeManager(ITriprangeManager triprangeManager) {
		this.triprangeManager = triprangeManager;
	}
  
 	/**
	 * 创建 行程
	 * @param id
	 * @return deleted count 
	 */
	public Triprange createTriprange(Triprange triprange) throws SQLException{
	
		return triprangeManager.createTriprange(triprange);
	}
	/**
	 * 删除 行程
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriprange(long id){
	
		return triprangeManager.deleteTriprange(id);
	}
	
	
	/**
	 * 修改 行程
	 * @param id
	 * @return updated count 
	 */
	public int updateTriprange(Triprange triprange){
		return triprangeManager.updateTriprange(triprange);
	
	}

		
	/**
	 * 修改 行程但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriprangeIgnoreNull(Triprange triprange){
			return triprangeManager.updateTriprangeIgnoreNull(triprange);
	
	}
	
	/**
	 * 查找 行程
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprange(String where, String orderby,int limit,int offset){
		return triprangeManager.findAllTriprange(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 行程
	 * @param id
	 * @return
	 */
	public Triprange findTriprange(long id){
		return triprangeManager.findTriprange(id);
	}
	/**
	 * 查找 行程 by language
	 * @param id
	 * @return
	 */
	public Triprange findTriprangebylanguage(long id,Integer language){
		return triprangeManager.findTriprangebylanguage(id,language);
	}
	/** 
	 * 查找 行程
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriprange(String where, String orderby,PageInfo pageinfo){
		return triprangeManager.findAllTriprange(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找行程
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprange(String sql,int limit,int offset){
		return triprangeManager.findAllTriprange(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 行程
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriprangeBySql(String sql){
		return triprangeManager.excuteTriprangeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriprangeBySql(String sql){
		return triprangeManager.countTriprangeBySql(sql);
	}
}

