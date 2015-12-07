/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.optrecord;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IOptrecordManager{ 
	
  
 	/**
	 * 创建 操作记录表
	 * @param id
	 * @return deleted count 
	 */
	public Optrecord createOptrecord(Optrecord optrecord) throws SQLException;
	
	/**
	 * 删除 操作记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteOptrecord(long id);
	
	
	/**
	 * 修改 操作记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateOptrecord(Optrecord optrecord);

		
	/**
	 * 修改 操作记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateOptrecordIgnoreNull(Optrecord optrecord);
		
	
	/**
	 * 查找 操作记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOptrecord(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 操作记录表
	 * @param id
	 * @return
	 */
	public Optrecord findOptrecord(long id);
	
	
	/** 
	 * 查找 操作记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllOptrecord(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找操作记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOptrecord(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 操作记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteOptrecordBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countOptrecordBySql(String sql);
	
}

