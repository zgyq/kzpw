/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.charterorder;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICharterorderComponent{ 
	
  
 	/**
	 * 创建 包机订单
	 * @param id
	 * @return deleted count 
	 */
	public Charterorder createCharterorder(Charterorder charterorder) throws SQLException;
	
	/**
	 * 删除 包机订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCharterorder(long id);
	
	
	/**
	 * 修改 包机订单
	 * @param id
	 * @return updated count 
	 */
	public int updateCharterorder(Charterorder charterorder);

		
	/**
	 * 修改 包机订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCharterorderIgnoreNull(Charterorder charterorder);
		
	
	/**
	 * 查找 包机订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCharterorder(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 包机订单
	 * @param id
	 * @return
	 */
	public Charterorder findCharterorder(long id);
	
	
	/** 
	 * 查找 包机订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCharterorder(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找包机订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCharterorder(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 包机订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCharterorderBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCharterorderBySql(String sql);
	
}

