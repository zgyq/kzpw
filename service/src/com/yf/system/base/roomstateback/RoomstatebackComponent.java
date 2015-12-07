/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.roomstateback;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class RoomstatebackComponent   implements IRoomstatebackComponent{ 
	
	
	private IRoomstatebackManager roomstatebackManager;
   
   
 	public IRoomstatebackManager getRoomstatebackManager() {
		return roomstatebackManager;
	}

	public void setRoomstatebackManager(IRoomstatebackManager roomstatebackManager) {
		this.roomstatebackManager = roomstatebackManager;
	}
  
 	/**
	 * 创建 酒店房态表
	 * @param id
	 * @return deleted count 
	 */
	public Roomstateback createRoomstateback(Roomstateback roomstateback) throws SQLException{
	
		return roomstatebackManager.createRoomstateback(roomstateback);
	}
	/**
	 * 删除 酒店房态表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRoomstateback(long id){
	
		return roomstatebackManager.deleteRoomstateback(id);
	}
	
	
	/**
	 * 修改 酒店房态表
	 * @param id
	 * @return updated count 
	 */
	public int updateRoomstateback(Roomstateback roomstateback){
		return roomstatebackManager.updateRoomstateback(roomstateback);
	
	}

		
	/**
	 * 修改 酒店房态表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRoomstatebackIgnoreNull(Roomstateback roomstateback){
			return roomstatebackManager.updateRoomstatebackIgnoreNull(roomstateback);
	
	}
	
	/**
	 * 查找 酒店房态表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstateback(String where, String orderby,int limit,int offset){
		return roomstatebackManager.findAllRoomstateback(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 酒店房态表
	 * @param id
	 * @return
	 */
	public Roomstateback findRoomstateback(long id){
		return roomstatebackManager.findRoomstateback(id);
	}
	/**
	 * 查找 酒店房态表 by language
	 * @param id
	 * @return
	 */
	public Roomstateback findRoomstatebackbylanguage(long id,Integer language){
		return roomstatebackManager.findRoomstatebackbylanguage(id,language);
	}
	/** 
	 * 查找 酒店房态表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRoomstateback(String where, String orderby,PageInfo pageinfo){
		return roomstatebackManager.findAllRoomstateback(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找酒店房态表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRoomstateback(String sql,int limit,int offset){
		return roomstatebackManager.findAllRoomstateback(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 酒店房态表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRoomstatebackBySql(String sql){
		return roomstatebackManager.excuteRoomstatebackBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRoomstatebackBySql(String sql){
		return roomstatebackManager.countRoomstatebackBySql(sql);
	}
}

