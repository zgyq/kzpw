/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.roomstateback;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IRoomstatebackComponent{ 
	
  
 	/**
	 * 创建 酒店房态表
	 * @param id
	 * @return deleted count 
	 */
	public Roomstateback createRoomstateback(Roomstateback roomstateback) throws SQLException;
	
	/**
	 * 删除 酒店房态表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomstateback(long id);
	
	
	/**
	 * 修改 酒店房态表
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomstateback(Roomstateback roomstateback);

		
	/**
	 * 修改 酒店房态表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomstatebackIgnoreNull(Roomstateback roomstateback);
		
	
	/**
	 * 查找 酒店房态表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstateback(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 酒店房态表
	 * @param id
	 * @return
	 */
	public Roomstateback findRoomstateback(long id);
	
	/**
	 * 查找 酒店房态表 by language
	 * @param id
	 * @return
	 */
	public Roomstateback findRoomstatebackbylanguage(long id,Integer language);
	
	/** 
	 * 查找 酒店房态表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomstateback(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找酒店房态表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstateback(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 酒店房态表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomstatebackBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomstatebackBySql(String sql);
	
}

