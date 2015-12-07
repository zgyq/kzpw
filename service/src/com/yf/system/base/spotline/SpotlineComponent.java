/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotline;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SpotlineComponent   implements ISpotlineComponent{ 
	
	
	private ISpotlineManager spotlineManager;
   
   
 	public ISpotlineManager getSpotlineManager() {
		return spotlineManager;
	}

	public void setSpotlineManager(ISpotlineManager spotlineManager) {
		this.spotlineManager = spotlineManager;
	}
  
 	/**
	 * 创建 景区线路信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotline createSpotline(Spotline spotline) throws SQLException{
	
		return spotlineManager.createSpotline(spotline);
	}
	/**
	 * 删除 景区线路信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotline(long id){
	
		return spotlineManager.deleteSpotline(id);
	}
	
	
	/**
	 * 修改 景区线路信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotline(Spotline spotline){
		return spotlineManager.updateSpotline(spotline);
	
	}

		
	/**
	 * 修改 景区线路信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineIgnoreNull(Spotline spotline){
			return spotlineManager.updateSpotlineIgnoreNull(spotline);
	
	}
	
	/**
	 * 查找 景区线路信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotline(String where, String orderby,int limit,int offset){
		return spotlineManager.findAllSpotline(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景区线路信息
	 * @param id
	 * @return
	 */
	public Spotline findSpotline(long id){
		return spotlineManager.findSpotline(id);
	}
	
	/** 
	 * 查找 景区线路信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotline(String where, String orderby,PageInfo pageinfo){
		return spotlineManager.findAllSpotline(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找景区线路信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotline(String sql,int limit,int offset){
		return spotlineManager.findAllSpotline(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景区线路信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineBySql(String sql){
		return spotlineManager.excuteSpotlineBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineBySql(String sql){
		return spotlineManager.countSpotlineBySql(sql);
	}
}

