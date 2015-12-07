/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotcity;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SpotcityComponent   implements ISpotcityComponent{ 
	
	
	private ISpotcityManager spotcityManager;
   
   
 	public ISpotcityManager getSpotcityManager() {
		return spotcityManager;
	}

	public void setSpotcityManager(ISpotcityManager spotcityManager) {
		this.spotcityManager = spotcityManager;
	}
  
 	/**
	 * 创建 景区城市
	 * @param id
	 * @return deleted count 
	 */
	public Spotcity createSpotcity(Spotcity spotcity) throws SQLException{
	
		return spotcityManager.createSpotcity(spotcity);
	}
	/**
	 * 删除 景区城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotcity(long id){
	
		return spotcityManager.deleteSpotcity(id);
	}
	
	
	/**
	 * 修改 景区城市
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotcity(Spotcity spotcity){
		return spotcityManager.updateSpotcity(spotcity);
	
	}

		
	/**
	 * 修改 景区城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotcityIgnoreNull(Spotcity spotcity){
			return spotcityManager.updateSpotcityIgnoreNull(spotcity);
	
	}
	
	/**
	 * 查找 景区城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotcity(String where, String orderby,int limit,int offset){
		return spotcityManager.findAllSpotcity(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景区城市
	 * @param id
	 * @return
	 */
	public Spotcity findSpotcity(long id){
		return spotcityManager.findSpotcity(id);
	}
	
	/** 
	 * 查找 景区城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotcity(String where, String orderby,PageInfo pageinfo){
		return spotcityManager.findAllSpotcity(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找景区城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotcity(String sql,int limit,int offset){
		return spotcityManager.findAllSpotcity(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景区城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotcityBySql(String sql){
		return spotcityManager.excuteSpotcityBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotcityBySql(String sql){
		return spotcityManager.countSpotcityBySql(sql);
	}
}

