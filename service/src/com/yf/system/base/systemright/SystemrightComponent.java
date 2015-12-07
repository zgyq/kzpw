/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.systemright;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SystemrightComponent   implements ISystemrightComponent{ 
	
	
	private ISystemrightManager systemrightManager;
   
   
 	public ISystemrightManager getSystemrightManager() {
		return systemrightManager;
	}

	public void setSystemrightManager(ISystemrightManager systemrightManager) {
		this.systemrightManager = systemrightManager;
	}
  
 	/**
	 * 创建 系统权限
	 * @param id
	 * @return deleted count 
	 */
	public Systemright createSystemright(Systemright systemright) throws SQLException{
	
		return systemrightManager.createSystemright(systemright);
	}
	/**
	 * 删除 系统权限
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemright(long id){
	
		return systemrightManager.deleteSystemright(id);
	}
	
	
	/**
	 * 修改 系统权限
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemright(Systemright systemright){
		return systemrightManager.updateSystemright(systemright);
	
	}

		
	/**
	 * 修改 系统权限但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemrightIgnoreNull(Systemright systemright){
			return systemrightManager.updateSystemrightIgnoreNull(systemright);
	
	}
	
	/**
	 * 查找 系统权限
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemright(String where, String orderby,int limit,int offset){
		return systemrightManager.findAllSystemright(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 系统权限
	 * @param id
	 * @return
	 */
	public Systemright findSystemright(long id){
		return systemrightManager.findSystemright(id);
	}
	
	/** 
	 * 查找 系统权限
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemright(String where, String orderby,PageInfo pageinfo){
		return systemrightManager.findAllSystemright(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找系统权限
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemright(String sql,int limit,int offset){
		return systemrightManager.findAllSystemright(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 系统权限
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemrightBySql(String sql){
		return systemrightManager.excuteSystemrightBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemrightBySql(String sql){
		return systemrightManager.countSystemrightBySql(sql);
	}
}

