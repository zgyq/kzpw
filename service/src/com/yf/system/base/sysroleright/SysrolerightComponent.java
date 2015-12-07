/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.sysroleright;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SysrolerightComponent   implements ISysrolerightComponent{ 
	
	
	private ISysrolerightManager sysrolerightManager;
   
   
 	public ISysrolerightManager getSysrolerightManager() {
		return sysrolerightManager;
	}

	public void setSysrolerightManager(ISysrolerightManager sysrolerightManager) {
		this.sysrolerightManager = sysrolerightManager;
	}
  
 	/**
	 * 创建 系统角色权限关联
	 * @param id
	 * @return deleted count 
	 */
	public Sysroleright createSysroleright(Sysroleright sysroleright) throws SQLException{
	
		return sysrolerightManager.createSysroleright(sysroleright);
	}
	/**
	 * 删除 系统角色权限关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysroleright(long id){
	
		return sysrolerightManager.deleteSysroleright(id);
	}
	
	
	/**
	 * 修改 系统角色权限关联
	 * @param id
	 * @return updated count 
	 */
	public int updateSysroleright(Sysroleright sysroleright){
		return sysrolerightManager.updateSysroleright(sysroleright);
	
	}

		
	/**
	 * 修改 系统角色权限关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysrolerightIgnoreNull(Sysroleright sysroleright){
			return sysrolerightManager.updateSysrolerightIgnoreNull(sysroleright);
	
	}
	
	/**
	 * 查找 系统角色权限关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysroleright(String where, String orderby,int limit,int offset){
		return sysrolerightManager.findAllSysroleright(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 系统角色权限关联
	 * @param id
	 * @return
	 */
	public Sysroleright findSysroleright(long id){
		return sysrolerightManager.findSysroleright(id);
	}
	
	/** 
	 * 查找 系统角色权限关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysroleright(String where, String orderby,PageInfo pageinfo){
		return sysrolerightManager.findAllSysroleright(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找系统角色权限关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysroleright(String sql,int limit,int offset){
		return sysrolerightManager.findAllSysroleright(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 系统角色权限关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysrolerightBySql(String sql){
		return sysrolerightManager.excuteSysrolerightBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysrolerightBySql(String sql){
		return sysrolerightManager.countSysrolerightBySql(sql);
	}
}

