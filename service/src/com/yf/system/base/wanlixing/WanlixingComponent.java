/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.wanlixing;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class WanlixingComponent   implements IWanlixingComponent{ 
	
	
	private IWanlixingManager wanlixingManager;
   
   
 	public IWanlixingManager getWanlixingManager() {
		return wanlixingManager;
	}

	public void setWanlixingManager(IWanlixingManager wanlixingManager) {
		this.wanlixingManager = wanlixingManager;
	}
  
 	/**
	 * 创建 万里行申请表
	 * @param id
	 * @return deleted count 
	 */
	public Wanlixing createWanlixing(Wanlixing wanlixing) throws SQLException{
	
		return wanlixingManager.createWanlixing(wanlixing);
	}
	/**
	 * 删除 万里行申请表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteWanlixing(long id){
	
		return wanlixingManager.deleteWanlixing(id);
	}
	
	
	/**
	 * 修改 万里行申请表
	 * @param id
	 * @return updated count 
	 */
	public int updateWanlixing(Wanlixing wanlixing){
		return wanlixingManager.updateWanlixing(wanlixing);
	
	}

		
	/**
	 * 修改 万里行申请表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateWanlixingIgnoreNull(Wanlixing wanlixing){
			return wanlixingManager.updateWanlixingIgnoreNull(wanlixing);
	
	}
	
	/**
	 * 查找 万里行申请表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWanlixing(String where, String orderby,int limit,int offset){
		return wanlixingManager.findAllWanlixing(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 万里行申请表
	 * @param id
	 * @return
	 */
	public Wanlixing findWanlixing(long id){
		return wanlixingManager.findWanlixing(id);
	}
	
	/** 
	 * 查找 万里行申请表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllWanlixing(String where, String orderby,PageInfo pageinfo){
		return wanlixingManager.findAllWanlixing(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找万里行申请表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllWanlixing(String sql,int limit,int offset){
		return wanlixingManager.findAllWanlixing(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 万里行申请表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteWanlixingBySql(String sql){
		return wanlixingManager.excuteWanlixingBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countWanlixingBySql(String sql){
		return wanlixingManager.countWanlixingBySql(sql);
	}
}

