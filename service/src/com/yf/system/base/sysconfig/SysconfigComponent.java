/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.sysconfig;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SysconfigComponent   implements ISysconfigComponent{ 
	
	
	private ISysconfigManager sysconfigManager;
   
   
 	public ISysconfigManager getSysconfigManager() {
		return sysconfigManager;
	}

	public void setSysconfigManager(ISysconfigManager sysconfigManager) {
		this.sysconfigManager = sysconfigManager;
	}
  
 	/**
	 * 创建 系统配置表
	 * @param id
	 * @return deleted count 
	 */
	public Sysconfig createSysconfig(Sysconfig sysconfig) throws SQLException{
	
		return sysconfigManager.createSysconfig(sysconfig);
	}
	/**
	 * 删除 系统配置表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysconfig(long id){
	
		return sysconfigManager.deleteSysconfig(id);
	}
	
	
	/**
	 * 修改 系统配置表
	 * @param id
	 * @return updated count 
	 */
	public int updateSysconfig(Sysconfig sysconfig){
		return sysconfigManager.updateSysconfig(sysconfig);
	
	}

		
	/**
	 * 修改 系统配置表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysconfigIgnoreNull(Sysconfig sysconfig){
			return sysconfigManager.updateSysconfigIgnoreNull(sysconfig);
	
	}
	
	/**
	 * 查找 系统配置表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysconfig(String where, String orderby,int limit,int offset){
		return sysconfigManager.findAllSysconfig(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 系统配置表
	 * @param id
	 * @return
	 */
	public Sysconfig findSysconfig(long id){
		return sysconfigManager.findSysconfig(id);
	}
	
	/** 
	 * 查找 系统配置表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysconfig(String where, String orderby,PageInfo pageinfo){
		return sysconfigManager.findAllSysconfig(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找系统配置表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysconfig(String sql,int limit,int offset){
		return sysconfigManager.findAllSysconfig(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 系统配置表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysconfigBySql(String sql){
		return sysconfigManager.excuteSysconfigBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysconfigBySql(String sql){
		return sysconfigManager.countSysconfigBySql(sql);
	}
}

