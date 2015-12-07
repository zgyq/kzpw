/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.trainseat;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ITrainseatComponent{ 
	
  
 	/**
	 * 创建 火车席别
	 * @param id
	 * @return deleted count 
	 */
	public Trainseat createTrainseat(Trainseat trainseat) throws SQLException;
	
	/**
	 * 删除 火车席别
	 * @param id
	 * @return deleted count 
	 */
	public int deleteTrainseat(long id);
	
	
	/**
	 * 修改 火车席别
	 * @param id
	 * @return updated count 
	 */
	public int updateTrainseat(Trainseat trainseat);

		
	/**
	 * 修改 火车席别但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateTrainseatIgnoreNull(Trainseat trainseat);
		
	
	/**
	 * 查找 火车席别
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainseat(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 火车席别
	 * @param id
	 * @return
	 */
	public Trainseat findTrainseat(long id);
	
	
	/** 
	 * 查找 火车席别
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllTrainseat(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找火车席别
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllTrainseat(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 火车席别
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteTrainseatBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countTrainseatBySql(String sql);
	
}

