/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.scenicspot;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class ScenicspotComponent   implements IScenicspotComponent{ 
	
	
	private IScenicspotManager scenicspotManager;
   
   
 	public IScenicspotManager getScenicspotManager() {
		return scenicspotManager;
	}

	public void setScenicspotManager(IScenicspotManager scenicspotManager) {
		this.scenicspotManager = scenicspotManager;
	}
  
 	/**
	 * 创建 景点
	 * @param id
	 * @return deleted count 
	 */
	public Scenicspot createScenicspot(Scenicspot scenicspot) throws SQLException{
	
		return scenicspotManager.createScenicspot(scenicspot);
	}
	/**
	 * 删除 景点
	 * @param id
	 * @return deleted count 
	 */
	public int deleteScenicspot(long id){
	
		return scenicspotManager.deleteScenicspot(id);
	}
	
	
	/**
	 * 修改 景点
	 * @param id
	 * @return updated count 
	 */
	public int updateScenicspot(Scenicspot scenicspot){
		return scenicspotManager.updateScenicspot(scenicspot);
	
	}

		
	/**
	 * 修改 景点但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateScenicspotIgnoreNull(Scenicspot scenicspot){
			return scenicspotManager.updateScenicspotIgnoreNull(scenicspot);
	
	}
	
	/**
	 * 查找 景点
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScenicspot(String where, String orderby,int limit,int offset){
		return scenicspotManager.findAllScenicspot(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 景点
	 * @param id
	 * @return
	 */
	public Scenicspot findScenicspot(long id){
		return scenicspotManager.findScenicspot(id);
	}
	/**
	 * 查找 景点 by language
	 * @param id
	 * @return
	 */
	public Scenicspot findScenicspotbylanguage(long id,Integer language){
		return scenicspotManager.findScenicspotbylanguage(id,language);
	}
	/** 
	 * 查找 景点
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllScenicspot(String where, String orderby,PageInfo pageinfo){
		return scenicspotManager.findAllScenicspot(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找景点
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScenicspot(String sql,int limit,int offset){
		return scenicspotManager.findAllScenicspot(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 景点
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteScenicspotBySql(String sql){
		return scenicspotManager.excuteScenicspotBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countScenicspotBySql(String sql){
		return scenicspotManager.countScenicspotBySql(sql);
	}
}

