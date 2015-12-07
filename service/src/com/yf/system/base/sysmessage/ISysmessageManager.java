/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.sysmessage;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISysmessageManager{ 
	
  
 	/**
	 * 创建 消息公告
	 * @param id
	 * @return deleted count 
	 */
	public Sysmessage createSysmessage(Sysmessage sysmessage) throws SQLException;
	
	/**
	 * 删除 消息公告
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSysmessage(long id);
	
	
	/**
	 * 修改 消息公告
	 * @param id
	 * @return updated count 
	 */
	public int updateSysmessage(Sysmessage sysmessage);

		
	/**
	 * 修改 消息公告但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSysmessageIgnoreNull(Sysmessage sysmessage);
		
	
	/**
	 * 查找 消息公告
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysmessage(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 消息公告
	 * @param id
	 * @return
	 */
	public Sysmessage findSysmessage(long id);
	
	
	/** 
	 * 查找 消息公告
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSysmessage(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找消息公告
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSysmessage(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 消息公告
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSysmessageBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSysmessageBySql(String sql);
	
}

