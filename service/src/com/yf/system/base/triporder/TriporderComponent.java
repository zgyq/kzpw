/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.triporder;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TriporderComponent   implements ITriporderComponent{ 
	
	
	private ITriporderManager triporderManager;
   
   
 	public ITriporderManager getTriporderManager() {
		return triporderManager;
	}

	public void setTriporderManager(ITriporderManager triporderManager) {
		this.triporderManager = triporderManager;
	}
  
 	/**
	 * 创建 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public Triporder createTriporder(Triporder triporder) throws SQLException{
	
		return triporderManager.createTriporder(triporder);
	}
	/**
	 * 删除 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTriporder(long id){
	
		return triporderManager.deleteTriporder(id);
	}
	
	
	/**
	 * 修改 线路订单
	 * @param id
	 * @return updated count 
	 */
	public int updateTriporder(Triporder triporder){
		return triporderManager.updateTriporder(triporder);
	
	}

		
	/**
	 * 修改 线路订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTriporderIgnoreNull(Triporder triporder){
			return triporderManager.updateTriporderIgnoreNull(triporder);
	
	}
	
	/**
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporder(String where, String orderby,int limit,int offset){
		return triporderManager.findAllTriporder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 线路订单
	 * @param id
	 * @return
	 */
	public Triporder findTriporder(long id){
		return triporderManager.findTriporder(id);
	}
	/**
	 * 查找 线路订单 by language
	 * @param id
	 * @return
	 */
	public Triporder findTriporderbylanguage(long id,Integer language){
		return triporderManager.findTriporderbylanguage(id,language);
	}
	/** 
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTriporder(String where, String orderby,PageInfo pageinfo){
		return triporderManager.findAllTriporder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找线路订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTriporder(String sql,int limit,int offset){
		return triporderManager.findAllTriporder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 线路订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTriporderBySql(String sql){
		return triporderManager.excuteTriporderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTriporderBySql(String sql){
		return triporderManager.countTriporderBySql(sql);
	}
}

