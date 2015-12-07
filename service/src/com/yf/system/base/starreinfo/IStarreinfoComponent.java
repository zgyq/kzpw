/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.starreinfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IStarreinfoComponent{ 
	
  
 	/**
	 * 创建 星级返点设置关联
	 * @param id
	 * @return deleted count 
	 */
	public Starreinfo createStarreinfo(Starreinfo starreinfo) throws SQLException;
	
	/**
	 * 删除 星级返点设置关联
	 * @param id
	 * @return deleted count 
	 */
	public int deleteStarreinfo(long id);
	
	
	/**
	 * 修改 星级返点设置关联
	 * @param id
	 * @return updated count 
	 */
	public int updateStarreinfo(Starreinfo starreinfo);

		
	/**
	 * 修改 星级返点设置关联但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateStarreinfoIgnoreNull(Starreinfo starreinfo);
		
	
	/**
	 * 查找 星级返点设置关联
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarreinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 星级返点设置关联
	 * @param id
	 * @return
	 */
	public Starreinfo findStarreinfo(long id);
	
	
	/** 
	 * 查找 星级返点设置关联
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllStarreinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找星级返点设置关联
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarreinfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 星级返点设置关联
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteStarreinfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countStarreinfoBySql(String sql);
	
}

