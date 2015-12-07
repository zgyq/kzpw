/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainsch;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITrainschManager{ 
	
  
 	/**
	 * 创建 列车时刻
	 * @param id
	 * @return deleted count 
	 */
	public Trainsch createTrainsch(Trainsch trainsch) throws SQLException;
	
	/**
	 * 删除 列车时刻
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainsch(long id);
	
	
	/**
	 * 修改 列车时刻
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainsch(Trainsch trainsch);

		
	/**
	 * 修改 列车时刻但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainschIgnoreNull(Trainsch trainsch);
		
	
	/**
	 * 查找 列车时刻
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainsch(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 列车时刻
	 * @param id
	 * @return
	 */
	public Trainsch findTrainsch(long id);
	
	
	/** 
	 * 查找 列车时刻
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainsch(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找列车时刻
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainsch(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 列车时刻
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainschBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainschBySql(String sql);
	
}

