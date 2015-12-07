﻿/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.region;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class RegionComponent   implements IRegionComponent{ 
	
	
	private IRegionManager regionManager;
   
   
 	public IRegionManager getRegionManager() {
		return regionManager;
	}

	public void setRegionManager(IRegionManager regionManager) {
		this.regionManager = regionManager;
	}
  
 	/**
	 * 创建 区域
	 * @param id
	 * @return deleted count 
	 */
	public Region createRegion(Region region) throws SQLException{
	
		return regionManager.createRegion(region);
	}
	/**
	 * 删除 区域
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRegion(long id){
	
		return regionManager.deleteRegion(id);
	}
	
	
	/**
	 * 修改 区域
	 * @param id
	 * @return updated count 
	 */
	public int updateRegion(Region region){
		return regionManager.updateRegion(region);
	
	}

		
	/**
	 * 修改 区域但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRegionIgnoreNull(Region region){
			return regionManager.updateRegionIgnoreNull(region);
	
	}
	
	/**
	 * 查找 区域
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRegion(String where, String orderby,int limit,int offset){
		return regionManager.findAllRegion(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 区域
	 * @param id
	 * @return
	 */
	public Region findRegion(long id){
		return regionManager.findRegion(id);
	}
	/**
	 * 查找 区域 by language
	 * @param id
	 * @return
	 */
	public Region findRegionbylanguage(long id,Integer language){
		return regionManager.findRegionbylanguage(id,language);
	}
	/** 
	 * 查找 区域
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRegion(String where, String orderby,PageInfo pageinfo){
		return regionManager.findAllRegion(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找区域
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRegion(String sql,int limit,int offset){
		return regionManager.findAllRegion(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 区域
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRegionBySql(String sql){
		return regionManager.excuteRegionBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRegionBySql(String sql){
		return regionManager.countRegionBySql(sql);
	}
}

