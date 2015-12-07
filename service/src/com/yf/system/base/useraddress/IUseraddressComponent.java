/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.useraddress;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IUseraddressComponent{ 
	
  
 	/**
	 * 创建 会员常用配送地址
	 * @param id
	 * @return deleted count 
	 */
	public Useraddress createUseraddress(Useraddress useraddress) throws SQLException;
	
	/**
	 * 删除 会员常用配送地址
	 * @param id
	 * @return deleted count 
	 */
	public int deleteUseraddress(long id);
	
	
	/**
	 * 修改 会员常用配送地址
	 * @param id
	 * @return updated count 
	 */
	public int updateUseraddress(Useraddress useraddress);

		
	/**
	 * 修改 会员常用配送地址但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateUseraddressIgnoreNull(Useraddress useraddress);
		
	
	/**
	 * 查找 会员常用配送地址
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUseraddress(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 会员常用配送地址
	 * @param id
	 * @return
	 */
	public Useraddress findUseraddress(long id);
	
	
	/** 
	 * 查找 会员常用配送地址
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllUseraddress(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找会员常用配送地址
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUseraddress(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 会员常用配送地址
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteUseraddressBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countUseraddressBySql(String sql);
	
}

