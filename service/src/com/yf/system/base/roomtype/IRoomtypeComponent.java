/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.roomtype;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IRoomtypeComponent{ 
	
  
 	/**
	 * 创建 酒店房型
	 * @param id
	 * @return deleted count 
	 */
	public Roomtype createRoomtype(Roomtype roomtype) throws SQLException;
	
	/**
	 * 删除 酒店房型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomtype(long id);
	
	
	/**
	 * 修改 酒店房型
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomtype(Roomtype roomtype);

		
	/**
	 * 修改 酒店房型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomtypeIgnoreNull(Roomtype roomtype);
		
	
	/**
	 * 查找 酒店房型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomtype(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店房型
	 * @param id
	 * @return
	 */
	public Roomtype findRoomtype(long id);
	
	/**
	 * 查找 酒店房型 by language
	 * @param id
	 * @return
	 */
	public Roomtype findRoomtypebylanguage(long id,Integer language);
	
	/** 
	 * 查找 酒店房型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomtype(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店房型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomtype(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店房型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomtypeBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomtypeBySql(String sql);
	
}

