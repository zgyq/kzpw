/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triporderrc;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TriporderrcComponent   implements ITriporderrcComponent{ 
	
	
	private ITriporderrcManager triporderrcManager;
   
   
 	public ITriporderrcManager getTriporderrcManager() {
		return triporderrcManager;
	}

	public void setTriporderrcManager(ITriporderrcManager triporderrcManager) {
		this.triporderrcManager = triporderrcManager;
	}
  
 	/**
	 * 创建 旅行订单记录
	 * @param id
	 * @return deleted count 
	 */
	public Triporderrc createTriporderrc(Triporderrc triporderrc) throws SQLException{
	
		return triporderrcManager.createTriporderrc(triporderrc);
	}
	/**
	 * 删除 旅行订单记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriporderrc(long id){
	
		return triporderrcManager.deleteTriporderrc(id);
	}
	
	
	/**
	 * 修改 旅行订单记录
	 * @param id
	 * @return updated count 
	 */
	public int updateTriporderrc(Triporderrc triporderrc){
		return triporderrcManager.updateTriporderrc(triporderrc);
	
	}

		
	/**
	 * 修改 旅行订单记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriporderrcIgnoreNull(Triporderrc triporderrc){
			return triporderrcManager.updateTriporderrcIgnoreNull(triporderrc);
	
	}
	
	/**
	 * 查找 旅行订单记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporderrc(String where, String orderby,int limit,int offset){
		return triporderrcManager.findAllTriporderrc(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 旅行订单记录
	 * @param id
	 * @return
	 */
	public Triporderrc findTriporderrc(long id){
		return triporderrcManager.findTriporderrc(id);
	}
	/**
	 * 查找 旅行订单记录 by language
	 * @param id
	 * @return
	 */
	public Triporderrc findTriporderrcbylanguage(long id,Integer language){
		return triporderrcManager.findTriporderrcbylanguage(id,language);
	}
	/** 
	 * 查找 旅行订单记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriporderrc(String where, String orderby,PageInfo pageinfo){
		return triporderrcManager.findAllTriporderrc(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找旅行订单记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporderrc(String sql,int limit,int offset){
		return triporderrcManager.findAllTriporderrc(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 旅行订单记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriporderrcBySql(String sql){
		return triporderrcManager.excuteTriporderrcBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriporderrcBySql(String sql){
		return triporderrcManager.countTriporderrcBySql(sql);
	}
}

