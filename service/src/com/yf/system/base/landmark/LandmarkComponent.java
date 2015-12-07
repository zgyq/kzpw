/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.landmark;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class LandmarkComponent   implements ILandmarkComponent{ 
	
	
	private ILandmarkManager landmarkManager;
   
   
 	public ILandmarkManager getLandmarkManager() {
		return landmarkManager;
	}

	public void setLandmarkManager(ILandmarkManager landmarkManager) {
		this.landmarkManager = landmarkManager;
	}
  
 	/**
	 * 创建 地标
	 * @param id
	 * @return deleted count 
	 */
	public Landmark createLandmark(Landmark landmark) throws SQLException{
	
		return landmarkManager.createLandmark(landmark);
	}
	/**
	 * 删除 地标
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLandmark(long id){
	
		return landmarkManager.deleteLandmark(id);
	}
	
	
	/**
	 * 修改 地标
	 * @param id
	 * @return updated count 
	 */
	public int updateLandmark(Landmark landmark){
		return landmarkManager.updateLandmark(landmark);
	
	}

		
	/**
	 * 修改 地标但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLandmarkIgnoreNull(Landmark landmark){
			return landmarkManager.updateLandmarkIgnoreNull(landmark);
	
	}
	
	/**
	 * 查找 地标
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLandmark(String where, String orderby,int limit,int offset){
		return landmarkManager.findAllLandmark(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 地标
	 * @param id
	 * @return
	 */
	public Landmark findLandmark(long id){
		return landmarkManager.findLandmark(id);
	}
	/**
	 * 查找 地标 by language
	 * @param id
	 * @return
	 */
	public Landmark findLandmarkbylanguage(long id,Integer language){
		return landmarkManager.findLandmarkbylanguage(id,language);
	}
	/** 
	 * 查找 地标
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLandmark(String where, String orderby,PageInfo pageinfo){
		return landmarkManager.findAllLandmark(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找地标
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLandmark(String sql,int limit,int offset){
		return landmarkManager.findAllLandmark(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 地标
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLandmarkBySql(String sql){
		return landmarkManager.excuteLandmarkBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLandmarkBySql(String sql){
		return landmarkManager.countLandmarkBySql(sql);
	}
}

