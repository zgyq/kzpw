/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.carorder;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ICarorderComponent{ 
	
  
 	/**
	 * 创建 租车订单
	 * @param id
	 * @return deleted count 
	 */
	public Carorder createCarorder(Carorder carorder) throws SQLException;
	
	/**
	 * 删除 租车订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteCarorder(long id);
	
	
	/**
	 * 修改 租车订单
	 * @param id
	 * @return updated count 
	 */
	public int updateCarorder(Carorder carorder);

		
	/**
	 * 修改 租车订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateCarorderIgnoreNull(Carorder carorder);
		
	
	/**
	 * 查找 租车订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarorder(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 租车订单
	 * @param id
	 * @return
	 */
	public Carorder findCarorder(long id);
	
	
	/** 
	 * 查找 租车订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllCarorder(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找租车订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllCarorder(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 租车订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteCarorderBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countCarorderBySql(String sql);
	
}

