/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.department;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class DepartmentComponent   implements IDepartmentComponent{ 
	
	
	private IDepartmentManager departmentManager;
   
   
 	public IDepartmentManager getDepartmentManager() {
		return departmentManager;
	}

	public void setDepartmentManager(IDepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
	}
  
 	/**
	 * 创建 部门
	 * @param id
	 * @return deleted count 
	 */
	public Department createDepartment(Department department) throws SQLException{
	
		return departmentManager.createDepartment(department);
	}
	/**
	 * 删除 部门
	 * @param id
	 * @return deleted count 
	 */
	public int deleteDepartment(long id){
	
		return departmentManager.deleteDepartment(id);
	}
	
	
	/**
	 * 修改 部门
	 * @param id
	 * @return updated count 
	 */
	public int updateDepartment(Department department){
		return departmentManager.updateDepartment(department);
	
	}

		
	/**
	 * 修改 部门但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateDepartmentIgnoreNull(Department department){
			return departmentManager.updateDepartmentIgnoreNull(department);
	
	}
	
	/**
	 * 查找 部门
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDepartment(String where, String orderby,int limit,int offset){
		return departmentManager.findAllDepartment(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 部门
	 * @param id
	 * @return
	 */
	public Department findDepartment(long id){
		return departmentManager.findDepartment(id);
	}
	
	/** 
	 * 查找 部门
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllDepartment(String where, String orderby,PageInfo pageinfo){
		return departmentManager.findAllDepartment(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找部门
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllDepartment(String sql,int limit,int offset){
		return departmentManager.findAllDepartment(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 部门
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteDepartmentBySql(String sql){
		return departmentManager.excuteDepartmentBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countDepartmentBySql(String sql){
		return departmentManager.countDepartmentBySql(sql);
	}
}

