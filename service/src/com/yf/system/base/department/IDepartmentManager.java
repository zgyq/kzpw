/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.department;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IDepartmentManager{ 
	
  
 	/**
	 * 创建 部门
	 * @param id
	 * @return deleted count 
	 */
	public Department createDepartment(Department department) throws SQLException;
	
	/**
	 * 删除 部门
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDepartment(long id);
	
	
	/**
	 * 修改 部门
	 * @param id
	 * @return updated count 
	 */
	public int updateDepartment(Department department);

		
	/**
	 * 修改 部门但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDepartmentIgnoreNull(Department department);
		
	
	/**
	 * 查找 部门
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDepartment(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 部门
	 * @param id
	 * @return
	 */
	public Department findDepartment(long id);
	
	
	/** 
	 * 查找 部门
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDepartment(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找部门
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDepartment(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 部门
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDepartmentBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDepartmentBySql(String sql);
	
}

