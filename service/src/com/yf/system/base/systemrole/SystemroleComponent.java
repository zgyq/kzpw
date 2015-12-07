/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.systemrole;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SystemroleComponent   implements ISystemroleComponent{ 
	
	
	private ISystemroleManager systemroleManager;
   
   
 	public ISystemroleManager getSystemroleManager() {
		return systemroleManager;
	}

	public void setSystemroleManager(ISystemroleManager systemroleManager) {
		this.systemroleManager = systemroleManager;
	}
  
 	/**
	 * 创建 系统角色
	 * @param id
	 * @return deleted count 
	 */
	public Systemrole createSystemrole(Systemrole systemrole) throws SQLException{
	
		return systemroleManager.createSystemrole(systemrole);
	}
	/**
	 * 删除 系统角色
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemrole(long id){
	
		return systemroleManager.deleteSystemrole(id);
	}
	
	
	/**
	 * 修改 系统角色
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemrole(Systemrole systemrole){
		return systemroleManager.updateSystemrole(systemrole);
	
	}

		
	/**
	 * 修改 系统角色但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemroleIgnoreNull(Systemrole systemrole){
			return systemroleManager.updateSystemroleIgnoreNull(systemrole);
	
	}
	
	/**
	 * 查找 系统角色
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemrole(String where, String orderby,int limit,int offset){
		return systemroleManager.findAllSystemrole(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 系统角色
	 * @param id
	 * @return
	 */
	public Systemrole findSystemrole(long id){
		return systemroleManager.findSystemrole(id);
	}
	
	/** 
	 * 查找 系统角色
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemrole(String where, String orderby,PageInfo pageinfo){
		return systemroleManager.findAllSystemrole(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找系统角色
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemrole(String sql,int limit,int offset){
		return systemroleManager.findAllSystemrole(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 系统角色
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemroleBySql(String sql){
		return systemroleManager.excuteSystemroleBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemroleBySql(String sql){
		return systemroleManager.countSystemroleBySql(sql);
	}
}

