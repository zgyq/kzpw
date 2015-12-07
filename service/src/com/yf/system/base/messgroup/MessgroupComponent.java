/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.messgroup;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class MessgroupComponent   implements IMessgroupComponent{ 
	
	
	private IMessgroupManager messgroupManager;
   
   
 	public IMessgroupManager getMessgroupManager() {
		return messgroupManager;
	}

	public void setMessgroupManager(IMessgroupManager messgroupManager) {
		this.messgroupManager = messgroupManager;
	}
  
 	/**
	 * 创建 短信用户组
	 * @param id
	 * @return deleted count 
	 */
	public Messgroup createMessgroup(Messgroup messgroup) throws SQLException{
	
		return messgroupManager.createMessgroup(messgroup);
	}
	/**
	 * 删除 短信用户组
	 * @param id
	 * @return deleted count 
	 */
	public int deleteMessgroup(long id){
	
		return messgroupManager.deleteMessgroup(id);
	}
	
	
	/**
	 * 修改 短信用户组
	 * @param id
	 * @return updated count 
	 */
	public int updateMessgroup(Messgroup messgroup){
		return messgroupManager.updateMessgroup(messgroup);
	
	}

		
	/**
	 * 修改 短信用户组但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateMessgroupIgnoreNull(Messgroup messgroup){
			return messgroupManager.updateMessgroupIgnoreNull(messgroup);
	
	}
	
	/**
	 * 查找 短信用户组
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMessgroup(String where, String orderby,int limit,int offset){
		return messgroupManager.findAllMessgroup(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 短信用户组
	 * @param id
	 * @return
	 */
	public Messgroup findMessgroup(long id){
		return messgroupManager.findMessgroup(id);
	}
	
	/** 
	 * 查找 短信用户组
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllMessgroup(String where, String orderby,PageInfo pageinfo){
		return messgroupManager.findAllMessgroup(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找短信用户组
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllMessgroup(String sql,int limit,int offset){
		return messgroupManager.findAllMessgroup(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 短信用户组
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteMessgroupBySql(String sql){
		return messgroupManager.excuteMessgroupBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countMessgroupBySql(String sql){
		return messgroupManager.countMessgroupBySql(sql);
	}
}

