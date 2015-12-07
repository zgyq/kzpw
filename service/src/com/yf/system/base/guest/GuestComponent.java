/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.guest;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class GuestComponent   implements IGuestComponent{ 
	
	
	private IGuestManager guestManager;
   
   
 	public IGuestManager getGuestManager() {
		return guestManager;
	}

	public void setGuestManager(IGuestManager guestManager) {
		this.guestManager = guestManager;
	}
  
 	/**
	 * 创建 客人信息表
	 * @param id
	 * @return deleted count 
	 */
	public Guest createGuest(Guest guest) throws SQLException{
	
		return guestManager.createGuest(guest);
	}
	/**
	 * 删除 客人信息表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGuest(long id){
	
		return guestManager.deleteGuest(id);
	}
	
	
	/**
	 * 修改 客人信息表
	 * @param id
	 * @return updated count 
	 */
	public int updateGuest(Guest guest){
		return guestManager.updateGuest(guest);
	
	}

		
	/**
	 * 修改 客人信息表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGuestIgnoreNull(Guest guest){
			return guestManager.updateGuestIgnoreNull(guest);
	
	}
	
	/**
	 * 查找 客人信息表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGuest(String where, String orderby,int limit,int offset){
		return guestManager.findAllGuest(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 客人信息表
	 * @param id
	 * @return
	 */
	public Guest findGuest(long id){
		return guestManager.findGuest(id);
	}
	/**
	 * 查找 客人信息表 by language
	 * @param id
	 * @return
	 */
	public Guest findGuestbylanguage(long id,Integer language){
		return guestManager.findGuestbylanguage(id,language);
	}
	/** 
	 * 查找 客人信息表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGuest(String where, String orderby,PageInfo pageinfo){
		return guestManager.findAllGuest(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找客人信息表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGuest(String sql,int limit,int offset){
		return guestManager.findAllGuest(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 客人信息表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGuestBySql(String sql){
		return guestManager.excuteGuestBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGuestBySql(String sql){
		return guestManager.countGuestBySql(sql);
	}
}

