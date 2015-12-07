/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.helpcenterinfo;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class HelpcenterinfoComponent   implements IHelpcenterinfoComponent{ 
	
	
	private IHelpcenterinfoManager helpcenterinfoManager;
   
   
 	public IHelpcenterinfoManager getHelpcenterinfoManager() {
		return helpcenterinfoManager;
	}

	public void setHelpcenterinfoManager(IHelpcenterinfoManager helpcenterinfoManager) {
		this.helpcenterinfoManager = helpcenterinfoManager;
	}
  
 	/**
	 * 创建 帮助中心信息
	 * @param id
	 * @return deleted count 
	 */
	public Helpcenterinfo createHelpcenterinfo(Helpcenterinfo helpcenterinfo) throws SQLException{
	
		return helpcenterinfoManager.createHelpcenterinfo(helpcenterinfo);
	}
	/**
	 * 删除 帮助中心信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHelpcenterinfo(long id){
	
		return helpcenterinfoManager.deleteHelpcenterinfo(id);
	}
	
	
	/**
	 * 修改 帮助中心信息
	 * @param id
	 * @return updated count 
	 */
	public int updateHelpcenterinfo(Helpcenterinfo helpcenterinfo){
		return helpcenterinfoManager.updateHelpcenterinfo(helpcenterinfo);
	
	}

		
	/**
	 * 修改 帮助中心信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHelpcenterinfoIgnoreNull(Helpcenterinfo helpcenterinfo){
			return helpcenterinfoManager.updateHelpcenterinfoIgnoreNull(helpcenterinfo);
	
	}
	
	/**
	 * 查找 帮助中心信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenterinfo(String where, String orderby,int limit,int offset){
		return helpcenterinfoManager.findAllHelpcenterinfo(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 帮助中心信息
	 * @param id
	 * @return
	 */
	public Helpcenterinfo findHelpcenterinfo(long id){
		return helpcenterinfoManager.findHelpcenterinfo(id);
	}
	
	/** 
	 * 查找 帮助中心信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHelpcenterinfo(String where, String orderby,PageInfo pageinfo){
		return helpcenterinfoManager.findAllHelpcenterinfo(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找帮助中心信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenterinfo(String sql,int limit,int offset){
		return helpcenterinfoManager.findAllHelpcenterinfo(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 帮助中心信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHelpcenterinfoBySql(String sql){
		return helpcenterinfoManager.excuteHelpcenterinfoBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHelpcenterinfoBySql(String sql){
		return helpcenterinfoManager.countHelpcenterinfoBySql(sql);
	}
}

