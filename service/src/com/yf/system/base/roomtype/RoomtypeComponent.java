/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.roomtype;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class RoomtypeComponent   implements IRoomtypeComponent{ 
	
	
	private IRoomtypeManager roomtypeManager;
   
   
 	public IRoomtypeManager getRoomtypeManager() {
		return roomtypeManager;
	}

	public void setRoomtypeManager(IRoomtypeManager roomtypeManager) {
		this.roomtypeManager = roomtypeManager;
	}
  
 	/**
	 * 创建 酒店房型
	 * @param id
	 * @return deleted count 
	 */
	public Roomtype createRoomtype(Roomtype roomtype) throws SQLException{
	
		return roomtypeManager.createRoomtype(roomtype);
	}
	/**
	 * 删除 酒店房型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomtype(long id){
	
		return roomtypeManager.deleteRoomtype(id);
	}
	
	
	/**
	 * 修改 酒店房型
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomtype(Roomtype roomtype){
		return roomtypeManager.updateRoomtype(roomtype);
	
	}

		
	/**
	 * 修改 酒店房型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomtypeIgnoreNull(Roomtype roomtype){
			return roomtypeManager.updateRoomtypeIgnoreNull(roomtype);
	
	}
	
	/**
	 * 查找 酒店房型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomtype(String where, String orderby,int limit,int offset){
		return roomtypeManager.findAllRoomtype(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店房型
	 * @param id
	 * @return
	 */
	public Roomtype findRoomtype(long id){
		return roomtypeManager.findRoomtype(id);
	}
	/**
	 * 查找 酒店房型 by language
	 * @param id
	 * @return
	 */
	public Roomtype findRoomtypebylanguage(long id,Integer language){
		return roomtypeManager.findRoomtypebylanguage(id,language);
	}
	/** 
	 * 查找 酒店房型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomtype(String where, String orderby,PageInfo pageinfo){
		return roomtypeManager.findAllRoomtype(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店房型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomtype(String sql,int limit,int offset){
		return roomtypeManager.findAllRoomtype(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店房型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomtypeBySql(String sql){
		return roomtypeManager.excuteRoomtypeBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomtypeBySql(String sql){
		return roomtypeManager.countRoomtypeBySql(sql);
	}
}

