/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.chaininfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IChaininfoManager{ 
	
  
 	/**
	 * 创建 连锁酒店类型
	 * @param id
	 * @return deleted count 
	 */
	public Chaininfo createChaininfo(Chaininfo chaininfo) throws SQLException;
	
	/**
	 * 删除 连锁酒店类型
	 * @param id
	 * @return deleted count 
	 */
	public int deleteChaininfo(long id);
	
	
	/**
	 * 修改 连锁酒店类型
	 * @param id
	 * @return updated count 
	 */
	public int updateChaininfo(Chaininfo chaininfo);

		
	/**
	 * 修改 连锁酒店类型但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateChaininfoIgnoreNull(Chaininfo chaininfo);
		
	
	/**
	 * 查找 连锁酒店类型
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChaininfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 连锁酒店类型
	 * @param id
	 * @return
	 */
	public Chaininfo findChaininfo(long id);
	
	
	/** 
	 * 查找 连锁酒店类型
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllChaininfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找连锁酒店类型
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllChaininfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 连锁酒店类型
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteChaininfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countChaininfoBySql(String sql);
	
}

