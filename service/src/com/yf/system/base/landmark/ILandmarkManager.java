/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.landmark;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ILandmarkManager{ 
	
  
 	/**
	 * 创建 地标
	 * @param id
	 * @return deleted count 
	 */
	public Landmark createLandmark(Landmark landmark) throws SQLException;
	
	/**
	 * 删除 地标
	 * @param id
	 * @return deleted count 
	 */
	public int deleteLandmark(long id);
	
	
	/**
	 * 修改 地标
	 * @param id
	 * @return updated count 
	 */
	public int updateLandmark(Landmark landmark);

		
	/**
	 * 修改 地标但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateLandmarkIgnoreNull(Landmark landmark);
		
	
	/**
	 * 查找 地标
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLandmark(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 地标
	 * @param id
	 * @return
	 */
	public Landmark findLandmark(long id);
	
	/**
	 * 查找 地标 by language
	 * @param id
	 * @return
	 */
	public Landmark findLandmarkbylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 地标
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllLandmark(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找地标
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllLandmark(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 地标
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteLandmarkBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countLandmarkBySql(String sql);
	
}

