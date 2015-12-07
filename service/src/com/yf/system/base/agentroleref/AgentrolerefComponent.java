/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.agentroleref;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class AgentrolerefComponent   implements IAgentrolerefComponent{ 
	
	
	private IAgentrolerefManager agentrolerefManager;
   
   
 	public IAgentrolerefManager getAgentrolerefManager() {
		return agentrolerefManager;
	}

	public void setAgentrolerefManager(IAgentrolerefManager agentrolerefManager) {
		this.agentrolerefManager = agentrolerefManager;
	}
  
 	/**
	 * 创建 会员角色关联
	 * @param id
	 * @return deleted count 
	 */
	public Agentroleref createAgentroleref(Agentroleref agentroleref) throws SQLException{
	
		return agentrolerefManager.createAgentroleref(agentroleref);
	}
	/**
	 * 删除 会员角色关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteAgentroleref(long id){
	
		return agentrolerefManager.deleteAgentroleref(id);
	}
	
	
	/**
	 * 修改 会员角色关联
	 * @param id
	 * @return updated count 
	 */
	public int updateAgentroleref(Agentroleref agentroleref){
		return agentrolerefManager.updateAgentroleref(agentroleref);
	
	}

		
	/**
	 * 修改 会员角色关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateAgentrolerefIgnoreNull(Agentroleref agentroleref){
			return agentrolerefManager.updateAgentrolerefIgnoreNull(agentroleref);
	
	}
	
	/**
	 * 查找 会员角色关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentroleref(String where, String orderby,int limit,int offset){
		return agentrolerefManager.findAllAgentroleref(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 会员角色关联
	 * @param id
	 * @return
	 */
	public Agentroleref findAgentroleref(long id){
		return agentrolerefManager.findAgentroleref(id);
	}
	
	/** 
	 * 查找 会员角色关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllAgentroleref(String where, String orderby,PageInfo pageinfo){
		return agentrolerefManager.findAllAgentroleref(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找会员角色关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllAgentroleref(String sql,int limit,int offset){
		return agentrolerefManager.findAllAgentroleref(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 会员角色关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteAgentrolerefBySql(String sql){
		return agentrolerefManager.excuteAgentrolerefBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countAgentrolerefBySql(String sql){
		return agentrolerefManager.countAgentrolerefBySql(sql);
	}
}

