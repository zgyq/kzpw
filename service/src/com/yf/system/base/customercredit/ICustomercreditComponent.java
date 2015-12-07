/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.customercredit;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICustomercreditComponent{ 
	
  
 	/**
	 * 创建 证件
	 * @param id
	 * @return deleted count 
	 */
	public Customercredit createCustomercredit(Customercredit customercredit) throws SQLException;
	
	/**
	 * 删除 证件
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCustomercredit(long id);
	
	
	/**
	 * 修改 证件
	 * @param id
	 * @return updated count 
	 */
	public int updateCustomercredit(Customercredit customercredit);

		
	/**
	 * 修改 证件但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCustomercreditIgnoreNull(Customercredit customercredit);
		
	
	/**
	 * 查找 证件
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomercredit(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 证件
	 * @param id
	 * @return
	 */
	public Customercredit findCustomercredit(long id);
	
	
	/** 
	 * 查找 证件
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCustomercredit(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找证件
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCustomercredit(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 证件
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCustomercreditBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCustomercreditBySql(String sql);
	
}

