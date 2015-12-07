/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotlineorder;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SpotlineorderComponent   implements ISpotlineorderComponent{ 
	
	
	private ISpotlineorderManager spotlineorderManager;
   
   
 	public ISpotlineorderManager getSpotlineorderManager() {
		return spotlineorderManager;
	}

	public void setSpotlineorderManager(ISpotlineorderManager spotlineorderManager) {
		this.spotlineorderManager = spotlineorderManager;
	}
  
 	/**
	 * 创建 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineorder createSpotlineorder(Spotlineorder spotlineorder) throws SQLException{
	
		return spotlineorderManager.createSpotlineorder(spotlineorder);
	}
	/**
	 * 删除 线路订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineorder(long id){
	
		return spotlineorderManager.deleteSpotlineorder(id);
	}
	
	
	/**
	 * 修改 线路订单
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineorder(Spotlineorder spotlineorder){
		return spotlineorderManager.updateSpotlineorder(spotlineorder);
	
	}

		
	/**
	 * 修改 线路订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineorderIgnoreNull(Spotlineorder spotlineorder){
			return spotlineorderManager.updateSpotlineorderIgnoreNull(spotlineorder);
	
	}
	
	/**
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineorder(String where, String orderby,int limit,int offset){
		return spotlineorderManager.findAllSpotlineorder(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 线路订单
	 * @param id
	 * @return
	 */
	public Spotlineorder findSpotlineorder(long id){
		return spotlineorderManager.findSpotlineorder(id);
	}
	
	/** 
	 * 查找 线路订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineorder(String where, String orderby,PageInfo pageinfo){
		return spotlineorderManager.findAllSpotlineorder(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找线路订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineorder(String sql,int limit,int offset){
		return spotlineorderManager.findAllSpotlineorder(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 线路订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineorderBySql(String sql){
		return spotlineorderManager.excuteSpotlineorderBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineorderBySql(String sql){
		return spotlineorderManager.countSpotlineorderBySql(sql);
	}
}

