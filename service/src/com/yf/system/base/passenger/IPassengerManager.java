/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.passenger;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IPassengerManager{ 
	
  
 	/**
	 * 创建 乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public Passenger createPassenger(Passenger passenger) throws SQLException;
	
	/**
	 * 删除 乘机人表
	 * @param id
	 * @return deleted count 
	 */
	public int deletePassenger(long id);
	
	
	/**
	 * 修改 乘机人表
	 * @param id
	 * @return updated count 
	 */
	public int updatePassenger(Passenger passenger);

		
	/**
	 * 修改 乘机人表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updatePassengerIgnoreNull(Passenger passenger);
		
	
	/**
	 * 查找 乘机人表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassenger(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 乘机人表
	 * @param id
	 * @return
	 */
	public Passenger findPassenger(long id);
	
	/**
	 * 查找 乘机人表 by language
	 * @param id
	 * @return
	 */
	public Passenger findPassengerbylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 乘机人表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllPassenger(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找乘机人表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllPassenger(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 乘机人表
	 * @param sql 
	 * @return updated count 
	 */
	public int excutePassengerBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countPassengerBySql(String sql);
	
}

