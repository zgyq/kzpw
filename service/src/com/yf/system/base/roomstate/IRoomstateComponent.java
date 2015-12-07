/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.roomstate;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IRoomstateComponent{ 
	
  
 	/**
	 * 创建 酒店房态
	 * @param id
	 * @return deleted count 
	 */
	public Roomstate createRoomstate(Roomstate roomstate) throws SQLException;
	
	/**
	 * 删除 酒店房态
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomstate(long id);
	
	
	/**
	 * 修改 酒店房态
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomstate(Roomstate roomstate);

		
	/**
	 * 修改 酒店房态但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomstateIgnoreNull(Roomstate roomstate);
		
	
	/**
	 * 查找 酒店房态
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstate(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店房态
	 * @param id
	 * @return
	 */
	public Roomstate findRoomstate(long id);
	
	/**
	 * 查找 酒店房态 by language
	 * @param id
	 * @return
	 */
	public Roomstate findRoomstatebylanguage(long id,Integer language);
	
	/** 
	 * 查找 酒店房态
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomstate(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店房态
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstate(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店房态
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomstateBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomstateBySql(String sql);
	
}

