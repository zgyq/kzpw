/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainstation;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITrainstationManager{ 
	
  
 	/**
	 * 创建 火车站信息
	 * @param id
	 * @return deleted count 
	 */
	public Trainstation createTrainstation(Trainstation trainstation) throws SQLException;
	
	/**
	 * 删除 火车站信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainstation(long id);
	
	
	/**
	 * 修改 火车站信息
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainstation(Trainstation trainstation);

		
	/**
	 * 修改 火车站信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainstationIgnoreNull(Trainstation trainstation);
		
	
	/**
	 * 查找 火车站信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainstation(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 火车站信息
	 * @param id
	 * @return
	 */
	public Trainstation findTrainstation(long id);
	
	
	/** 
	 * 查找 火车站信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainstation(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找火车站信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainstation(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 火车站信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainstationBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainstationBySql(String sql);
	
}

