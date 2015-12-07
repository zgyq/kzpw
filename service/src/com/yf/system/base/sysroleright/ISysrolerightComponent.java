/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.sysroleright;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISysrolerightComponent{ 
	
  
 	/**
	 * 创建 系统角色权限关联
	 * @param id
	 * @return deleted count 
	 */
	public Sysroleright createSysroleright(Sysroleright sysroleright) throws SQLException;
	
	/**
	 * 删除 系统角色权限关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysroleright(long id);
	
	
	/**
	 * 修改 系统角色权限关联
	 * @param id
	 * @return updated count 
	 */
	public int updateSysroleright(Sysroleright sysroleright);

		
	/**
	 * 修改 系统角色权限关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysrolerightIgnoreNull(Sysroleright sysroleright);
		
	
	/**
	 * 查找 系统角色权限关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysroleright(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 系统角色权限关联
	 * @param id
	 * @return
	 */
	public Sysroleright findSysroleright(long id);
	
	
	/** 
	 * 查找 系统角色权限关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysroleright(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找系统角色权限关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysroleright(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 系统角色权限关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysrolerightBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysrolerightBySql(String sql);
	
}

