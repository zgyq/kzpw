/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainroom;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITrainroomManager{ 
	
  
 	/**
	 * 创建 火车售票点
	 * @param id
	 * @return deleted count 
	 */
	public Trainroom createTrainroom(Trainroom trainroom) throws SQLException;
	
	/**
	 * 删除 火车售票点
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainroom(long id);
	
	
	/**
	 * 修改 火车售票点
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainroom(Trainroom trainroom);

		
	/**
	 * 修改 火车售票点但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainroomIgnoreNull(Trainroom trainroom);
		
	
	/**
	 * 查找 火车售票点
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainroom(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 火车售票点
	 * @param id
	 * @return
	 */
	public Trainroom findTrainroom(long id);
	
	
	/** 
	 * 查找 火车售票点
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainroom(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找火车售票点
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainroom(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 火车售票点
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainroomBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainroomBySql(String sql);
	
}

