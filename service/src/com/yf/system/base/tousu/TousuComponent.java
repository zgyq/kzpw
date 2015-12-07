/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.tousu;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class TousuComponent   implements ITousuComponent{ 
	
	
	private ITousuManager tousuManager;
   
   
 	public ITousuManager getTousuManager() {
		return tousuManager;
	}

	public void setTousuManager(ITousuManager tousuManager) {
		this.tousuManager = tousuManager;
	}
  
 	/**
	 * 创建 投诉建议表
	 * @param id
	 * @return deleted count 
	 */
	public Tousu createTousu(Tousu tousu) throws SQLException{
	
		return tousuManager.createTousu(tousu);
	}
	/**
	 * 删除 投诉建议表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTousu(long id){
	
		return tousuManager.deleteTousu(id);
	}
	
	
	/**
	 * 修改 投诉建议表
	 * @param id
	 * @return updated count 
	 */
	public int updateTousu(Tousu tousu){
		return tousuManager.updateTousu(tousu);
	
	}

		
	/**
	 * 修改 投诉建议表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTousuIgnoreNull(Tousu tousu){
			return tousuManager.updateTousuIgnoreNull(tousu);
	
	}
	
	/**
	 * 查找 投诉建议表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTousu(String where, String orderby,int limit,int offset){
		return tousuManager.findAllTousu(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 投诉建议表
	 * @param id
	 * @return
	 */
	public Tousu findTousu(long id){
		return tousuManager.findTousu(id);
	}
	
	/** 
	 * 查找 投诉建议表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTousu(String where, String orderby,PageInfo pageinfo){
		return tousuManager.findAllTousu(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找投诉建议表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTousu(String sql,int limit,int offset){
		return tousuManager.findAllTousu(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 投诉建议表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTousuBySql(String sql){
		return tousuManager.excuteTousuBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTousuBySql(String sql){
		return tousuManager.countTousuBySql(sql);
	}
}

