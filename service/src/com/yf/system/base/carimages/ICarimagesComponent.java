/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carimages;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICarimagesComponent{ 
	
  
 	/**
	 * 创建 汽车图片
	 * @param id
	 * @return deleted count 
	 */
	public Carimages createCarimages(Carimages carimages) throws SQLException;
	
	/**
	 * 删除 汽车图片
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarimages(long id);
	
	
	/**
	 * 修改 汽车图片
	 * @param id
	 * @return updated count 
	 */
	public int updateCarimages(Carimages carimages);

		
	/**
	 * 修改 汽车图片但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarimagesIgnoreNull(Carimages carimages);
		
	
	/**
	 * 查找 汽车图片
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarimages(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 汽车图片
	 * @param id
	 * @return
	 */
	public Carimages findCarimages(long id);
	
	
	/** 
	 * 查找 汽车图片
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarimages(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找汽车图片
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarimages(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 汽车图片
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarimagesBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarimagesBySql(String sql);
	
}

