/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rdepartment;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class RdepartmentComponent   implements IRdepartmentComponent{ 
	
	
	private IRdepartmentManager rdepartmentManager;
   
   
 	public IRdepartmentManager getRdepartmentManager() {
		return rdepartmentManager;
	}

	public void setRdepartmentManager(IRdepartmentManager rdepartmentManager) {
		this.rdepartmentManager = rdepartmentManager;
	}
  
 	/**
	 * 创建 部门销售汇总表
	 * @param id
	 * @return deleted count 
	 */
	public Rdepartment createRdepartment(Rdepartment rdepartment) throws SQLException{
	
		return rdepartmentManager.createRdepartment(rdepartment);
	}
	/**
	 * 删除 部门销售汇总表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRdepartment(long id){
	
		return rdepartmentManager.deleteRdepartment(id);
	}
	
	
	/**
	 * 修改 部门销售汇总表
	 * @param id
	 * @return updated count 
	 */
	public int updateRdepartment(Rdepartment rdepartment){
		return rdepartmentManager.updateRdepartment(rdepartment);
	
	}

		
	/**
	 * 修改 部门销售汇总表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRdepartmentIgnoreNull(Rdepartment rdepartment){
			return rdepartmentManager.updateRdepartmentIgnoreNull(rdepartment);
	
	}
	
	/**
	 * 查找 部门销售汇总表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRdepartment(String where, String orderby,int limit,int offset){
		return rdepartmentManager.findAllRdepartment(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 部门销售汇总表
	 * @param id
	 * @return
	 */
	public Rdepartment findRdepartment(long id){
		return rdepartmentManager.findRdepartment(id);
	}
	
	/** 
	 * 查找 部门销售汇总表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRdepartment(String where, String orderby,PageInfo pageinfo){
		return rdepartmentManager.findAllRdepartment(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找部门销售汇总表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRdepartment(String sql,int limit,int offset){
		return rdepartmentManager.findAllRdepartment(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 部门销售汇总表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRdepartmentBySql(String sql){
		return rdepartmentManager.excuteRdepartmentBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRdepartmentBySql(String sql){
		return rdepartmentManager.countRdepartmentBySql(sql);
	}
}

