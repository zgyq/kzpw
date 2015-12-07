/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainfare;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITrainfareComponent{ 
	
  
 	/**
	 * 创建 火车票价
	 * @param id
	 * @return deleted count 
	 */
	public Trainfare createTrainfare(Trainfare trainfare) throws SQLException;
	
	/**
	 * 删除 火车票价
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainfare(long id);
	
	
	/**
	 * 修改 火车票价
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainfare(Trainfare trainfare);

		
	/**
	 * 修改 火车票价但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainfareIgnoreNull(Trainfare trainfare);
		
	
	/**
	 * 查找 火车票价
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainfare(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 火车票价
	 * @param id
	 * @return
	 */
	public Trainfare findTrainfare(long id);
	
	
	/** 
	 * 查找 火车票价
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainfare(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找火车票价
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainfare(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 火车票价
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainfareBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainfareBySql(String sql);
	
}

