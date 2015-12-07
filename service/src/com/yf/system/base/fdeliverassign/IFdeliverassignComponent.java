/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fdeliverassign;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IFdeliverassignComponent{ 
	
  
 	/**
	 * 创建 国际机票配送信息
	 * @param id
	 * @return deleted count 
	 */
	public Fdeliverassign createFdeliverassign(Fdeliverassign fdeliverassign) throws SQLException;
	
	/**
	 * 删除 国际机票配送信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFdeliverassign(long id);
	
	
	/**
	 * 修改 国际机票配送信息
	 * @param id
	 * @return updated count 
	 */
	public int updateFdeliverassign(Fdeliverassign fdeliverassign);

		
	/**
	 * 修改 国际机票配送信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFdeliverassignIgnoreNull(Fdeliverassign fdeliverassign);
		
	
	/**
	 * 查找 国际机票配送信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFdeliverassign(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 国际机票配送信息
	 * @param id
	 * @return
	 */
	public Fdeliverassign findFdeliverassign(long id);
	
	
	/** 
	 * 查找 国际机票配送信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFdeliverassign(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找国际机票配送信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFdeliverassign(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 国际机票配送信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFdeliverassignBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFdeliverassignBySql(String sql);
	
}

