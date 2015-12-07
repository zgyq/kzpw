/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.guest;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IGuestComponent{ 
	
  
 	/**
	 * 创建 客人信息表
	 * @param id
	 * @return deleted count 
	 */
	public Guest createGuest(Guest guest) throws SQLException;
	
	/**
	 * 删除 客人信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGuest(long id);
	
	
	/**
	 * 修改 客人信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateGuest(Guest guest);

		
	/**
	 * 修改 客人信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGuestIgnoreNull(Guest guest);
		
	
	/**
	 * 查找 客人信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGuest(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 客人信息表
	 * @param id
	 * @return
	 */
	public Guest findGuest(long id);
	
	/**
	 * 查找 客人信息表 by language
	 * @param id
	 * @return
	 */
	public Guest findGuestbylanguage(long id,Integer language);
	
	/** 
	 * 查找 客人信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGuest(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找客人信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGuest(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 客人信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGuestBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGuestBySql(String sql);
	
}

