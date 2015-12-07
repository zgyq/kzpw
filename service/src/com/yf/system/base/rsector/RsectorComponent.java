/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rsector;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class RsectorComponent   implements IRsectorComponent{ 
	
	
	private IRsectorManager rsectorManager;
   
   
 	public IRsectorManager getRsectorManager() {
		return rsectorManager;
	}

	public void setRsectorManager(IRsectorManager rsectorManager) {
		this.rsectorManager = rsectorManager;
	}
  
 	/**
	 * 创建 部门绩效表
	 * @param id
	 * @return deleted count 
	 */
	public Rsector createRsector(Rsector rsector) throws SQLException{
	
		return rsectorManager.createRsector(rsector);
	}
	/**
	 * 删除 部门绩效表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRsector(long id){
	
		return rsectorManager.deleteRsector(id);
	}
	
	
	/**
	 * 修改 部门绩效表
	 * @param id
	 * @return updated count 
	 */
	public int updateRsector(Rsector rsector){
		return rsectorManager.updateRsector(rsector);
	
	}

		
	/**
	 * 修改 部门绩效表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRsectorIgnoreNull(Rsector rsector){
			return rsectorManager.updateRsectorIgnoreNull(rsector);
	
	}
	
	/**
	 * 查找 部门绩效表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRsector(String where, String orderby,int limit,int offset){
		return rsectorManager.findAllRsector(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 部门绩效表
	 * @param id
	 * @return
	 */
	public Rsector findRsector(long id){
		return rsectorManager.findRsector(id);
	}
	
	/** 
	 * 查找 部门绩效表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRsector(String where, String orderby,PageInfo pageinfo){
		return rsectorManager.findAllRsector(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找部门绩效表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRsector(String sql,int limit,int offset){
		return rsectorManager.findAllRsector(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 部门绩效表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRsectorBySql(String sql){
		return rsectorManager.excuteRsectorBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRsectorBySql(String sql){
		return rsectorManager.countRsectorBySql(sql);
	}
}

