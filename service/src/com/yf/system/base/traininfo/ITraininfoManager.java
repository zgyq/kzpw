/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.traininfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITraininfoManager{ 
	
  
 	/**
	 * 创建 车次信息
	 * @param id
	 * @return deleted count 
	 */
	public Traininfo createTraininfo(Traininfo traininfo) throws SQLException;
	
	/**
	 * 删除 车次信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTraininfo(long id);
	
	
	/**
	 * 修改 车次信息
	 * @param id
	 * @return updated count 
	 */
	public int updateTraininfo(Traininfo traininfo);

		
	/**
	 * 修改 车次信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTraininfoIgnoreNull(Traininfo traininfo);
		
	
	/**
	 * 查找 车次信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraininfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 车次信息
	 * @param id
	 * @return
	 */
	public Traininfo findTraininfo(long id);
	
	
	/** 
	 * 查找 车次信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTraininfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找车次信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTraininfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 车次信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTraininfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTraininfoBySql(String sql);
	
}

