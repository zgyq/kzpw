/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.messgroup;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IMessgroupComponent{ 
	
  
 	/**
	 * 创建 短信用户组
	 * @param id
	 * @return deleted count 
	 */
	public Messgroup createMessgroup(Messgroup messgroup) throws SQLException;
	
	/**
	 * 删除 短信用户组
	 * @param id
	 * @return deleted count 
	 */
	public int deleteMessgroup(long id);
	
	
	/**
	 * 修改 短信用户组
	 * @param id
	 * @return updated count 
	 */
	public int updateMessgroup(Messgroup messgroup);

		
	/**
	 * 修改 短信用户组但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateMessgroupIgnoreNull(Messgroup messgroup);
		
	
	/**
	 * 查找 短信用户组
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMessgroup(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 短信用户组
	 * @param id
	 * @return
	 */
	public Messgroup findMessgroup(long id);
	
	
	/** 
	 * 查找 短信用户组
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllMessgroup(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找短信用户组
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMessgroup(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 短信用户组
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteMessgroupBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countMessgroupBySql(String sql);
	
}

