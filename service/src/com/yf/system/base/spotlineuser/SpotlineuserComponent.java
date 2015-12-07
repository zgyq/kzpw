/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotlineuser;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SpotlineuserComponent   implements ISpotlineuserComponent{ 
	
	
	private ISpotlineuserManager spotlineuserManager;
   
   
 	public ISpotlineuserManager getSpotlineuserManager() {
		return spotlineuserManager;
	}

	public void setSpotlineuserManager(ISpotlineuserManager spotlineuserManager) {
		this.spotlineuserManager = spotlineuserManager;
	}
  
 	/**
	 * 创建 线路游客
	 * @param id
	 * @return deleted count 
	 */
	public Spotlineuser createSpotlineuser(Spotlineuser spotlineuser) throws SQLException{
	
		return spotlineuserManager.createSpotlineuser(spotlineuser);
	}
	/**
	 * 删除 线路游客
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotlineuser(long id){
	
		return spotlineuserManager.deleteSpotlineuser(id);
	}
	
	
	/**
	 * 修改 线路游客
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotlineuser(Spotlineuser spotlineuser){
		return spotlineuserManager.updateSpotlineuser(spotlineuser);
	
	}

		
	/**
	 * 修改 线路游客但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotlineuserIgnoreNull(Spotlineuser spotlineuser){
			return spotlineuserManager.updateSpotlineuserIgnoreNull(spotlineuser);
	
	}
	
	/**
	 * 查找 线路游客
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineuser(String where, String orderby,int limit,int offset){
		return spotlineuserManager.findAllSpotlineuser(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 线路游客
	 * @param id
	 * @return
	 */
	public Spotlineuser findSpotlineuser(long id){
		return spotlineuserManager.findSpotlineuser(id);
	}
	
	/** 
	 * 查找 线路游客
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotlineuser(String where, String orderby,PageInfo pageinfo){
		return spotlineuserManager.findAllSpotlineuser(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找线路游客
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotlineuser(String sql,int limit,int offset){
		return spotlineuserManager.findAllSpotlineuser(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 线路游客
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotlineuserBySql(String sql){
		return spotlineuserManager.excuteSpotlineuserBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotlineuserBySql(String sql){
		return spotlineuserManager.countSpotlineuserBySql(sql);
	}
}

