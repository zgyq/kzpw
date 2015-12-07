/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rdepartment;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IRdepartmentManager{ 
	
  
 	/**
	 * 创建 部门销售汇总表
	 * @param id
	 * @return deleted count 
	 */
	public Rdepartment createRdepartment(Rdepartment rdepartment) throws SQLException;
	
	/**
	 * 删除 部门销售汇总表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRdepartment(long id);
	
	
	/**
	 * 修改 部门销售汇总表
	 * @param id
	 * @return updated count 
	 */
	public int updateRdepartment(Rdepartment rdepartment);

		
	/**
	 * 修改 部门销售汇总表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRdepartmentIgnoreNull(Rdepartment rdepartment);
		
	
	/**
	 * 查找 部门销售汇总表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRdepartment(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 部门销售汇总表
	 * @param id
	 * @return
	 */
	public Rdepartment findRdepartment(long id);
	
	
	/** 
	 * 查找 部门销售汇总表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRdepartment(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找部门销售汇总表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRdepartment(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 部门销售汇总表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRdepartmentBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRdepartmentBySql(String sql);
	
}

