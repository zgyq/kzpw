/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.traderecord;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITraderecordComponent{ 
	
  
 	/**
	 * 创建 交易记录
	 * @param id
	 * @return deleted count 
	 */
	public Traderecord createTraderecord(Traderecord traderecord) throws SQLException;
	
	/**
	 * 删除 交易记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTraderecord(long id);
	
	
	/**
	 * 修改 交易记录
	 * @param id
	 * @return updated count 
	 */
	public int updateTraderecord(Traderecord traderecord);

		
	/**
	 * 修改 交易记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTraderecordIgnoreNull(Traderecord traderecord);
		
	
	/**
	 * 查找 交易记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraderecord(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 交易记录
	 * @param id
	 * @return
	 */
	public Traderecord findTraderecord(long id);
	
	
	/** 
	 * 查找 交易记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTraderecord(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找交易记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraderecord(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 交易记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTraderecordBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTraderecordBySql(String sql);
	
}

