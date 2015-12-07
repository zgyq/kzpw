/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.helpcenter;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class HelpcenterComponent   implements IHelpcenterComponent{ 
	
	
	private IHelpcenterManager helpcenterManager;
   
   
 	public IHelpcenterManager getHelpcenterManager() {
		return helpcenterManager;
	}

	public void setHelpcenterManager(IHelpcenterManager helpcenterManager) {
		this.helpcenterManager = helpcenterManager;
	}
  
 	/**
	 * 创建 帮助中心
	 * @param id
	 * @return deleted count 
	 */
	public Helpcenter createHelpcenter(Helpcenter helpcenter) throws SQLException{
	
		return helpcenterManager.createHelpcenter(helpcenter);
	}
	/**
	 * 删除 帮助中心
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHelpcenter(long id){
	
		return helpcenterManager.deleteHelpcenter(id);
	}
	
	
	/**
	 * 修改 帮助中心
	 * @param id
	 * @return updated count 
	 */
	public int updateHelpcenter(Helpcenter helpcenter){
		return helpcenterManager.updateHelpcenter(helpcenter);
	
	}

		
	/**
	 * 修改 帮助中心但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHelpcenterIgnoreNull(Helpcenter helpcenter){
			return helpcenterManager.updateHelpcenterIgnoreNull(helpcenter);
	
	}
	
	/**
	 * 查找 帮助中心
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenter(String where, String orderby,int limit,int offset){
		return helpcenterManager.findAllHelpcenter(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 帮助中心
	 * @param id
	 * @return
	 */
	public Helpcenter findHelpcenter(long id){
		return helpcenterManager.findHelpcenter(id);
	}
	
	/** 
	 * 查找 帮助中心
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHelpcenter(String where, String orderby,PageInfo pageinfo){
		return helpcenterManager.findAllHelpcenter(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找帮助中心
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenter(String sql,int limit,int offset){
		return helpcenterManager.findAllHelpcenter(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 帮助中心
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHelpcenterBySql(String sql){
		return helpcenterManager.excuteHelpcenterBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHelpcenterBySql(String sql){
		return helpcenterManager.countHelpcenterBySql(sql);
	}
}

