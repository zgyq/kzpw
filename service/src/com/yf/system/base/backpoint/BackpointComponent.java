/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.backpoint;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class BackpointComponent   implements IBackpointComponent{ 
	
	
	private IBackpointManager backpointManager;
   
   
 	public IBackpointManager getBackpointManager() {
		return backpointManager;
	}

	public void setBackpointManager(IBackpointManager backpointManager) {
		this.backpointManager = backpointManager;
	}
  
 	/**
	 * 创建 隐扣设置
	 * @param id
	 * @return deleted count 
	 */
	public Backpoint createBackpoint(Backpoint backpoint) throws SQLException{
	
		return backpointManager.createBackpoint(backpoint);
	}
	/**
	 * 删除 隐扣设置
	 * @param id
	 * @return deleted count 
	 */
	public int deleteBackpoint(long id){
	
		return backpointManager.deleteBackpoint(id);
	}
	
	
	/**
	 * 修改 隐扣设置
	 * @param id
	 * @return updated count 
	 */
	public int updateBackpoint(Backpoint backpoint){
		return backpointManager.updateBackpoint(backpoint);
	
	}

		
	/**
	 * 修改 隐扣设置但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateBackpointIgnoreNull(Backpoint backpoint){
			return backpointManager.updateBackpointIgnoreNull(backpoint);
	
	}
	
	/**
	 * 查找 隐扣设置
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBackpoint(String where, String orderby,int limit,int offset){
		return backpointManager.findAllBackpoint(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 隐扣设置
	 * @param id
	 * @return
	 */
	public Backpoint findBackpoint(long id){
		return backpointManager.findBackpoint(id);
	}
	
	/** 
	 * 查找 隐扣设置
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllBackpoint(String where, String orderby,PageInfo pageinfo){
		return backpointManager.findAllBackpoint(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找隐扣设置
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllBackpoint(String sql,int limit,int offset){
		return backpointManager.findAllBackpoint(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 隐扣设置
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteBackpointBySql(String sql){
		return backpointManager.excuteBackpointBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countBackpointBySql(String sql){
		return backpointManager.countBackpointBySql(sql);
	}
}

