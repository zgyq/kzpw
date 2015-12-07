/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.useraddress;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class UseraddressComponent   implements IUseraddressComponent{ 
	
	
	private IUseraddressManager useraddressManager;
   
   
 	public IUseraddressManager getUseraddressManager() {
		return useraddressManager;
	}

	public void setUseraddressManager(IUseraddressManager useraddressManager) {
		this.useraddressManager = useraddressManager;
	}
  
 	/**
	 * 创建 会员常用配送地址
	 * @param id
	 * @return deleted count 
	 */
	public Useraddress createUseraddress(Useraddress useraddress) throws SQLException{
	
		return useraddressManager.createUseraddress(useraddress);
	}
	/**
	 * 删除 会员常用配送地址
	 * @param id
	 * @return deleted count 
	 */
	public int deleteUseraddress(long id){
	
		return useraddressManager.deleteUseraddress(id);
	}
	
	
	/**
	 * 修改 会员常用配送地址
	 * @param id
	 * @return updated count 
	 */
	public int updateUseraddress(Useraddress useraddress){
		return useraddressManager.updateUseraddress(useraddress);
	
	}

		
	/**
	 * 修改 会员常用配送地址但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateUseraddressIgnoreNull(Useraddress useraddress){
			return useraddressManager.updateUseraddressIgnoreNull(useraddress);
	
	}
	
	/**
	 * 查找 会员常用配送地址
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUseraddress(String where, String orderby,int limit,int offset){
		return useraddressManager.findAllUseraddress(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会员常用配送地址
	 * @param id
	 * @return
	 */
	public Useraddress findUseraddress(long id){
		return useraddressManager.findUseraddress(id);
	}
	
	/** 
	 * 查找 会员常用配送地址
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllUseraddress(String where, String orderby,PageInfo pageinfo){
		return useraddressManager.findAllUseraddress(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会员常用配送地址
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllUseraddress(String sql,int limit,int offset){
		return useraddressManager.findAllUseraddress(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会员常用配送地址
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteUseraddressBySql(String sql){
		return useraddressManager.excuteUseraddressBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countUseraddressBySql(String sql){
		return useraddressManager.countUseraddressBySql(sql);
	}
}

