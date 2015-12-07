/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fairport;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IFairportComponent{ 
	
  
 	/**
	 * 创建 国际机票机场
	 * @param id
	 * @return deleted count 
	 */
	public Fairport createFairport(Fairport fairport) throws SQLException;
	
	/**
	 * 删除 国际机票机场
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFairport(long id);
	
	
	/**
	 * 修改 国际机票机场
	 * @param id
	 * @return updated count 
	 */
	public int updateFairport(Fairport fairport);

		
	/**
	 * 修改 国际机票机场但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFairportIgnoreNull(Fairport fairport);
		
	
	/**
	 * 查找 国际机票机场
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairport(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 国际机票机场
	 * @param id
	 * @return
	 */
	public Fairport findFairport(long id);
	
	/**
	 * 查找 国际机票机场 by language
	 * @param id
	 * @return
	 */
	public Fairport findFairportbylanguage(long id,Integer language);
	
	/** 
	 * 查找 国际机票机场
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFairport(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找国际机票机场
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFairport(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 国际机票机场
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFairportBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFairportBySql(String sql);
	
}

