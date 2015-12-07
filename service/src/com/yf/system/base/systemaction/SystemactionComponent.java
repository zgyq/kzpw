/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.systemaction;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SystemactionComponent   implements ISystemactionComponent{ 
	
	
	private ISystemactionManager systemactionManager;
   
   
 	public ISystemactionManager getSystemactionManager() {
		return systemactionManager;
	}

	public void setSystemactionManager(ISystemactionManager systemactionManager) {
		this.systemactionManager = systemactionManager;
	}
  
 	/**
	 * 创建 系统用户行为
	 * @param id
	 * @return deleted count 
	 */
	public Systemaction createSystemaction(Systemaction systemaction) throws SQLException{
	
		return systemactionManager.createSystemaction(systemaction);
	}
	/**
	 * 删除 系统用户行为
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSystemaction(long id){
	
		return systemactionManager.deleteSystemaction(id);
	}
	
	
	/**
	 * 修改 系统用户行为
	 * @param id
	 * @return updated count 
	 */
	public int updateSystemaction(Systemaction systemaction){
		return systemactionManager.updateSystemaction(systemaction);
	
	}

		
	/**
	 * 修改 系统用户行为但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSystemactionIgnoreNull(Systemaction systemaction){
			return systemactionManager.updateSystemactionIgnoreNull(systemaction);
	
	}
	
	/**
	 * 查找 系统用户行为
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemaction(String where, String orderby,int limit,int offset){
		return systemactionManager.findAllSystemaction(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 系统用户行为
	 * @param id
	 * @return
	 */
	public Systemaction findSystemaction(long id){
		return systemactionManager.findSystemaction(id);
	}
	
	/** 
	 * 查找 系统用户行为
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSystemaction(String where, String orderby,PageInfo pageinfo){
		return systemactionManager.findAllSystemaction(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找系统用户行为
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSystemaction(String sql,int limit,int offset){
		return systemactionManager.findAllSystemaction(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 系统用户行为
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSystemactionBySql(String sql){
		return systemactionManager.excuteSystemactionBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSystemactionBySql(String sql){
		return systemactionManager.countSystemactionBySql(sql);
	}
}

