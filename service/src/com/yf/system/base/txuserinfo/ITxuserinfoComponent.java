/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.txuserinfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITxuserinfoComponent{ 
	
  
 	/**
	 * 创建 用户信息
	 * @param id
	 * @return deleted count 
	 */
	public Txuserinfo createTxuserinfo(Txuserinfo txuserinfo) throws SQLException;
	
	/**
	 * 删除 用户信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTxuserinfo(long id);
	
	
	/**
	 * 修改 用户信息
	 * @param id
	 * @return updated count 
	 */
	public int updateTxuserinfo(Txuserinfo txuserinfo);

		
	/**
	 * 修改 用户信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTxuserinfoIgnoreNull(Txuserinfo txuserinfo);
		
	
	/**
	 * 查找 用户信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTxuserinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 用户信息
	 * @param id
	 * @return
	 */
	public Txuserinfo findTxuserinfo(long id);
	
	
	/** 
	 * 查找 用户信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTxuserinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找用户信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTxuserinfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 用户信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTxuserinfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTxuserinfoBySql(String sql);
	
}

