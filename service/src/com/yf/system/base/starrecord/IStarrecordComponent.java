/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.starrecord;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IStarrecordComponent{ 
	
  
 	/**
	 * 创建 星级留点记录
	 * @param id
	 * @return deleted count 
	 */
	public Starrecord createStarrecord(Starrecord starrecord) throws SQLException;
	
	/**
	 * 删除 星级留点记录
	 * @param id
	 * @return deleted count 
	 */
	public int deleteStarrecord(long id);
	
	
	/**
	 * 修改 星级留点记录
	 * @param id
	 * @return updated count 
	 */
	public int updateStarrecord(Starrecord starrecord);

		
	/**
	 * 修改 星级留点记录但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateStarrecordIgnoreNull(Starrecord starrecord);
		
	
	/**
	 * 查找 星级留点记录
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarrecord(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 星级留点记录
	 * @param id
	 * @return
	 */
	public Starrecord findStarrecord(long id);
	
	
	/** 
	 * 查找 星级留点记录
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllStarrecord(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找星级留点记录
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarrecord(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 星级留点记录
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteStarrecordBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countStarrecordBySql(String sql);
	
}

