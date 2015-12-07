/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.rebaterule;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class RebateruleComponent   implements IRebateruleComponent{ 
	
	
	private IRebateruleManager rebateruleManager;
   
   
 	public IRebateruleManager getRebateruleManager() {
		return rebateruleManager;
	}

	public void setRebateruleManager(IRebateruleManager rebateruleManager) {
		this.rebateruleManager = rebateruleManager;
	}
  
 	/**
	 * 创建 返佣规则
	 * @param id
	 * @return deleted count 
	 */
	public Rebaterule createRebaterule(Rebaterule rebaterule) throws SQLException{
	
		return rebateruleManager.createRebaterule(rebaterule);
	}
	/**
	 * 删除 返佣规则
	 * @param id
	 * @return deleted count 
	 */
	public int deleteRebaterule(long id){
	
		return rebateruleManager.deleteRebaterule(id);
	}
	
	
	/**
	 * 修改 返佣规则
	 * @param id
	 * @return updated count 
	 */
	public int updateRebaterule(Rebaterule rebaterule){
		return rebateruleManager.updateRebaterule(rebaterule);
	
	}

		
	/**
	 * 修改 返佣规则但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateRebateruleIgnoreNull(Rebaterule rebaterule){
			return rebateruleManager.updateRebateruleIgnoreNull(rebaterule);
	
	}
	
	/**
	 * 查找 返佣规则
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterule(String where, String orderby,int limit,int offset){
		return rebateruleManager.findAllRebaterule(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 返佣规则
	 * @param id
	 * @return
	 */
	public Rebaterule findRebaterule(long id){
		return rebateruleManager.findRebaterule(id);
	}
	
	/** 
	 * 查找 返佣规则
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllRebaterule(String where, String orderby,PageInfo pageinfo){
		return rebateruleManager.findAllRebaterule(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找返佣规则
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllRebaterule(String sql,int limit,int offset){
		return rebateruleManager.findAllRebaterule(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 返佣规则
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteRebateruleBySql(String sql){
		return rebateruleManager.excuteRebateruleBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countRebateruleBySql(String sql){
		return rebateruleManager.countRebateruleBySql(sql);
	}
}

