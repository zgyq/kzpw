/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tripline;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TriplineComponent   implements ITriplineComponent{ 
	
	
	private ITriplineManager triplineManager;
   
   
 	public ITriplineManager getTriplineManager() {
		return triplineManager;
	}

	public void setTriplineManager(ITriplineManager triplineManager) {
		this.triplineManager = triplineManager;
	}
  
 	/**
	 * 创建 旅行线路
	 * @param id
	 * @return deleted count 
	 */
	public Tripline createTripline(Tripline tripline) throws SQLException{
	
		return triplineManager.createTripline(tripline);
	}
	/**
	 * 删除 旅行线路
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTripline(long id){
	
		return triplineManager.deleteTripline(id);
	}
	
	
	/**
	 * 修改 旅行线路
	 * @param id
	 * @return updated count 
	 */
	public int updateTripline(Tripline tripline){
		return triplineManager.updateTripline(tripline);
	
	}

		
	/**
	 * 修改 旅行线路但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriplineIgnoreNull(Tripline tripline){
			return triplineManager.updateTriplineIgnoreNull(tripline);
	
	}
	
	/**
	 * 查找 旅行线路
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripline(String where, String orderby,int limit,int offset){
		return triplineManager.findAllTripline(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 旅行线路
	 * @param id
	 * @return
	 */
	public Tripline findTripline(long id){
		return triplineManager.findTripline(id);
	}
	/**
	 * 查找 旅行线路 by language
	 * @param id
	 * @return
	 */
	public Tripline findTriplinebylanguage(long id,Integer language){
		return triplineManager.findTriplinebylanguage(id,language);
	}
	/** 
	 * 查找 旅行线路
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTripline(String where, String orderby,PageInfo pageinfo){
		return triplineManager.findAllTripline(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找旅行线路
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTripline(String sql,int limit,int offset){
		return triplineManager.findAllTripline(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 旅行线路
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriplineBySql(String sql){
		return triplineManager.excuteTriplineBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriplineBySql(String sql){
		return triplineManager.countTriplineBySql(sql);
	}
}

