/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.flightstop;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IFlightstopManager{ 
	
  
 	/**
	 * 创建 航班经停信息
	 * @param id
	 * @return deleted count 
	 */
	public Flightstop createFlightstop(Flightstop flightstop) throws SQLException;
	
	/**
	 * 删除 航班经停信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFlightstop(long id);
	
	
	/**
	 * 修改 航班经停信息
	 * @param id
	 * @return updated count 
	 */
	public int updateFlightstop(Flightstop flightstop);

		
	/**
	 * 修改 航班经停信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFlightstopIgnoreNull(Flightstop flightstop);
		
	
	/**
	 * 查找 航班经停信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightstop(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 航班经停信息
	 * @param id
	 * @return
	 */
	public Flightstop findFlightstop(long id);
	
	/**
	 * 查找 航班经停信息 by language
	 * @param id
	 * @return
	 */
	public Flightstop findFlightstopbylanguage(long id,Integer language);
	
	
	/** 
	 * 查找 航班经停信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFlightstop(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找航班经停信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFlightstop(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 航班经停信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFlightstopBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFlightstopBySql(String sql);
	
}

