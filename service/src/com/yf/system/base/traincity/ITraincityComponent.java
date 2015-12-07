/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.traincity;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITraincityComponent{ 
	
  
 	/**
	 * 创建 火车票城市
	 * @param id
	 * @return deleted count 
	 */
	public Traincity createTraincity(Traincity traincity) throws SQLException;
	
	/**
	 * 删除 火车票城市
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTraincity(long id);
	
	
	/**
	 * 修改 火车票城市
	 * @param id
	 * @return updated count 
	 */
	public int updateTraincity(Traincity traincity);

		
	/**
	 * 修改 火车票城市但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTraincityIgnoreNull(Traincity traincity);
		
	
	/**
	 * 查找 火车票城市
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraincity(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 火车票城市
	 * @param id
	 * @return
	 */
	public Traincity findTraincity(long id);
	
	
	/** 
	 * 查找 火车票城市
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTraincity(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找火车票城市
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraincity(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 火车票城市
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTraincityBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTraincityBySql(String sql);
	
}

