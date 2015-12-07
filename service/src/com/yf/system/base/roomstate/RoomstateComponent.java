/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.roomstate;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class RoomstateComponent   implements IRoomstateComponent{ 
	
	
	private IRoomstateManager roomstateManager;
   
   
 	public IRoomstateManager getRoomstateManager() {
		return roomstateManager;
	}

	public void setRoomstateManager(IRoomstateManager roomstateManager) {
		this.roomstateManager = roomstateManager;
	}
  
 	/**
	 * 创建 酒店房态
	 * @param id
	 * @return deleted count 
	 */
	public Roomstate createRoomstate(Roomstate roomstate) throws SQLException{
	
		return roomstateManager.createRoomstate(roomstate);
	}
	/**
	 * 删除 酒店房态
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomstate(long id){
	
		return roomstateManager.deleteRoomstate(id);
	}
	
	
	/**
	 * 修改 酒店房态
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomstate(Roomstate roomstate){
		return roomstateManager.updateRoomstate(roomstate);
	
	}

		
	/**
	 * 修改 酒店房态但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomstateIgnoreNull(Roomstate roomstate){
			return roomstateManager.updateRoomstateIgnoreNull(roomstate);
	
	}
	
	/**
	 * 查找 酒店房态
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstate(String where, String orderby,int limit,int offset){
		return roomstateManager.findAllRoomstate(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店房态
	 * @param id
	 * @return
	 */
	public Roomstate findRoomstate(long id){
		return roomstateManager.findRoomstate(id);
	}
	/**
	 * 查找 酒店房态 by language
	 * @param id
	 * @return
	 */
	public Roomstate findRoomstatebylanguage(long id,Integer language){
		return roomstateManager.findRoomstatebylanguage(id,language);
	}
	/** 
	 * 查找 酒店房态
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomstate(String where, String orderby,PageInfo pageinfo){
		return roomstateManager.findAllRoomstate(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店房态
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstate(String sql,int limit,int offset){
		return roomstateManager.findAllRoomstate(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店房态
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomstateBySql(String sql){
		return roomstateManager.excuteRoomstateBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomstateBySql(String sql){
		return roomstateManager.countRoomstateBySql(sql);
	}
}

