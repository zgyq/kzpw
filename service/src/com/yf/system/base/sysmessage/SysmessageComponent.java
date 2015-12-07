/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.sysmessage;

import java.sql.SQLException;
import java.util.*;


import com.yf.system.base.util.PageInfo;

public class SysmessageComponent   implements ISysmessageComponent{ 
	
	
	private ISysmessageManager sysmessageManager;
   
   
 	public ISysmessageManager getSysmessageManager() {
		return sysmessageManager;
	}

	public void setSysmessageManager(ISysmessageManager sysmessageManager) {
		this.sysmessageManager = sysmessageManager;
	}
  
 	/**
	 * 创建 消息公告
	 * @param id
	 * @return deleted count 
	 */
	public Sysmessage createSysmessage(Sysmessage sysmessage) throws SQLException{
	
		return sysmessageManager.createSysmessage(sysmessage);
	}
	/**
	 * 删除 消息公告
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysmessage(long id){
	
		return sysmessageManager.deleteSysmessage(id);
	}
	
	
	/**
	 * 修改 消息公告
	 * @param id
	 * @return updated count 
	 */
	public int updateSysmessage(Sysmessage sysmessage){
		return sysmessageManager.updateSysmessage(sysmessage);
	
	}

		
	/**
	 * 修改 消息公告但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysmessageIgnoreNull(Sysmessage sysmessage){
			return sysmessageManager.updateSysmessageIgnoreNull(sysmessage);
	
	}
	
	/**
	 * 查找 消息公告
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysmessage(String where, String orderby,int limit,int offset){
		return sysmessageManager.findAllSysmessage(where, orderby,limit,offset);
	}
		
	
	/**
	 * 查找 消息公告
	 * @param id
	 * @return
	 */
	public Sysmessage findSysmessage(long id){
		return sysmessageManager.findSysmessage(id);
	}
	
	/** 
	 * 查找 消息公告
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysmessage(String where, String orderby,PageInfo pageinfo){
		return sysmessageManager.findAllSysmessage(where, orderby,pageinfo);
	}
		
	/** 
	 * 根据Sql查找消息公告
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysmessage(String sql,int limit,int offset){
		return sysmessageManager.findAllSysmessage(sql,limit,offset);
	}
	
	
	/**
	 * 执行Sql 消息公告
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysmessageBySql(String sql){
		return sysmessageManager.excuteSysmessageBySql(sql);
	}
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysmessageBySql(String sql){
		return sysmessageManager.countSysmessageBySql(sql);
	}
}

