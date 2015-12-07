/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carimages;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class CarimagesComponent   implements ICarimagesComponent{ 
	
	
	private ICarimagesManager carimagesManager;
   
   
 	public ICarimagesManager getCarimagesManager() {
		return carimagesManager;
	}

	public void setCarimagesManager(ICarimagesManager carimagesManager) {
		this.carimagesManager = carimagesManager;
	}
  
 	/**
	 * 创建 汽车图片
	 * @param id
	 * @return deleted count 
	 */
	public Carimages createCarimages(Carimages carimages) throws SQLException{
	
		return carimagesManager.createCarimages(carimages);
	}
	/**
	 * 删除 汽车图片
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarimages(long id){
	
		return carimagesManager.deleteCarimages(id);
	}
	
	
	/**
	 * 修改 汽车图片
	 * @param id
	 * @return updated count 
	 */
	public int updateCarimages(Carimages carimages){
		return carimagesManager.updateCarimages(carimages);
	
	}

		
	/**
	 * 修改 汽车图片但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarimagesIgnoreNull(Carimages carimages){
			return carimagesManager.updateCarimagesIgnoreNull(carimages);
	
	}
	
	/**
	 * 查找 汽车图片
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarimages(String where, String orderby,int limit,int offset){
		return carimagesManager.findAllCarimages(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 汽车图片
	 * @param id
	 * @return
	 */
	public Carimages findCarimages(long id){
		return carimagesManager.findCarimages(id);
	}
	
	/** 
	 * 查找 汽车图片
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarimages(String where, String orderby,PageInfo pageinfo){
		return carimagesManager.findAllCarimages(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找汽车图片
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarimages(String sql,int limit,int offset){
		return carimagesManager.findAllCarimages(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 汽车图片
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarimagesBySql(String sql){
		return carimagesManager.excuteCarimagesBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarimagesBySql(String sql){
		return carimagesManager.countCarimagesBySql(sql);
	}
}

