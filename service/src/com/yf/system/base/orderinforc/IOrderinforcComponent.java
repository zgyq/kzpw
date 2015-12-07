/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.orderinforc;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IOrderinforcComponent{ 
	
  
 	/**
	 * 创建 订单处理记录
	 * @param id
	 * @return deleted count 
	 */
	public Orderinforc createOrderinforc(Orderinforc orderinforc) throws SQLException;
	
	/**
	 * 删除 订单处理记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteOrderinforc(long id);
	
	
	/**
	 * 修改 订单处理记录
	 * @param id
	 * @return updated count 
	 */
	public int updateOrderinforc(Orderinforc orderinforc);

		
	/**
	 * 修改 订单处理记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateOrderinforcIgnoreNull(Orderinforc orderinforc);
		
	
	/**
	 * 查找 订单处理记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOrderinforc(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 订单处理记录
	 * @param id
	 * @return
	 */
	public Orderinforc findOrderinforc(long id);
	
	/**
	 * 查找 订单处理记录 by language
	 * @param id
	 * @return
	 */
	public Orderinforc findOrderinforcbylanguage(long id,Integer language);
	
	/** 
	 * 查找 订单处理记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllOrderinforc(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找订单处理记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllOrderinforc(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 订单处理记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteOrderinforcBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countOrderinforcBySql(String sql);
	
}

