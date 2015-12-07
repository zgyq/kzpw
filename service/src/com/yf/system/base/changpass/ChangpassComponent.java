/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.changpass;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class ChangpassComponent   implements IChangpassComponent{ 
	
	
	private IChangpassManager changpassManager;
   
   
 	public IChangpassManager getChangpassManager() {
		return changpassManager;
	}

	public void setChangpassManager(IChangpassManager changpassManager) {
		this.changpassManager = changpassManager;
	}
  
 	/**
	 * 创建 变更记录
	 * @param id
	 * @return deleted count 
	 */
	public Changpass createChangpass(Changpass changpass) throws SQLException{
	
		return changpassManager.createChangpass(changpass);
	}
	/**
	 * 删除 变更记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteChangpass(long id){
	
		return changpassManager.deleteChangpass(id);
	}
	
	
	/**
	 * 修改 变更记录
	 * @param id
	 * @return updated count 
	 */
	public int updateChangpass(Changpass changpass){
		return changpassManager.updateChangpass(changpass);
	
	}

		
	/**
	 * 修改 变更记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateChangpassIgnoreNull(Changpass changpass){
			return changpassManager.updateChangpassIgnoreNull(changpass);
	
	}
	
	/**
	 * 查找 变更记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChangpass(String where, String orderby,int limit,int offset){
		return changpassManager.findAllChangpass(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 变更记录
	 * @param id
	 * @return
	 */
	public Changpass findChangpass(long id){
		return changpassManager.findChangpass(id);
	}
	
	/** 
	 * 查找 变更记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllChangpass(String where, String orderby,PageInfo pageinfo){
		return changpassManager.findAllChangpass(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找变更记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChangpass(String sql,int limit,int offset){
		return changpassManager.findAllChangpass(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 变更记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteChangpassBySql(String sql){
		return changpassManager.excuteChangpassBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countChangpassBySql(String sql){
		return changpassManager.countChangpassBySql(sql);
	}
}

