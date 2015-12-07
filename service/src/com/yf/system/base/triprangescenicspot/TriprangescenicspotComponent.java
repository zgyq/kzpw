/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triprangescenicspot;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TriprangescenicspotComponent   implements ITriprangescenicspotComponent{ 
	
	
	private ITriprangescenicspotManager triprangescenicspotManager;
   
   
 	public ITriprangescenicspotManager getTriprangescenicspotManager() {
		return triprangescenicspotManager;
	}

	public void setTriprangescenicspotManager(ITriprangescenicspotManager triprangescenicspotManager) {
		this.triprangescenicspotManager = triprangescenicspotManager;
	}
  
 	/**
	 * 创建 行程景点关联
	 * @param id
	 * @return deleted count 
	 */
	public Triprangescenicspot createTriprangescenicspot(Triprangescenicspot triprangescenicspot) throws SQLException{
	
		return triprangescenicspotManager.createTriprangescenicspot(triprangescenicspot);
	}
	/**
	 * 删除 行程景点关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriprangescenicspot(long id){
	
		return triprangescenicspotManager.deleteTriprangescenicspot(id);
	}
	
	
	/**
	 * 修改 行程景点关联
	 * @param id
	 * @return updated count 
	 */
	public int updateTriprangescenicspot(Triprangescenicspot triprangescenicspot){
		return triprangescenicspotManager.updateTriprangescenicspot(triprangescenicspot);
	
	}

		
	/**
	 * 修改 行程景点关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriprangescenicspotIgnoreNull(Triprangescenicspot triprangescenicspot){
			return triprangescenicspotManager.updateTriprangescenicspotIgnoreNull(triprangescenicspot);
	
	}
	
	/**
	 * 查找 行程景点关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprangescenicspot(String where, String orderby,int limit,int offset){
		return triprangescenicspotManager.findAllTriprangescenicspot(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 行程景点关联
	 * @param id
	 * @return
	 */
	public Triprangescenicspot findTriprangescenicspot(long id){
		return triprangescenicspotManager.findTriprangescenicspot(id);
	}
	/**
	 * 查找 行程景点关联 by language
	 * @param id
	 * @return
	 */
	public Triprangescenicspot findTriprangescenicspotbylanguage(long id,Integer language){
		return triprangescenicspotManager.findTriprangescenicspotbylanguage(id,language);
	}
	/** 
	 * 查找 行程景点关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriprangescenicspot(String where, String orderby,PageInfo pageinfo){
		return triprangescenicspotManager.findAllTriprangescenicspot(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找行程景点关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriprangescenicspot(String sql,int limit,int offset){
		return triprangescenicspotManager.findAllTriprangescenicspot(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 行程景点关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriprangescenicspotBySql(String sql){
		return triprangescenicspotManager.excuteTriprangescenicspotBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriprangescenicspotBySql(String sql){
		return triprangescenicspotManager.countTriprangescenicspotBySql(sql);
	}
}

