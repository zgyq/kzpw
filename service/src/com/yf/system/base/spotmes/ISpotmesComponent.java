/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spotmes;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISpotmesComponent{ 
	
  
 	/**
	 * 创建 景点信息
	 * @param id
	 * @return deleted count 
	 */
	public Spotmes createSpotmes(Spotmes spotmes) throws SQLException;
	
	/**
	 * 删除 景点信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpotmes(long id);
	
	
	/**
	 * 修改 景点信息
	 * @param id
	 * @return updated count 
	 */
	public int updateSpotmes(Spotmes spotmes);

		
	/**
	 * 修改 景点信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpotmesIgnoreNull(Spotmes spotmes);
		
	
	/**
	 * 查找 景点信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotmes(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 景点信息
	 * @param id
	 * @return
	 */
	public Spotmes findSpotmes(long id);
	
	
	/** 
	 * 查找 景点信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpotmes(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找景点信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpotmes(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 景点信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpotmesBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpotmesBySql(String sql);
	
}

