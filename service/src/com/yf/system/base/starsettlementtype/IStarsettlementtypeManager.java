/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.starsettlementtype;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IStarsettlementtypeManager{ 
	
  
 	/**
	 * 创建 星级结算分类
	 * @param id
	 * @return deleted count 
	 */
	public Starsettlementtype createStarsettlementtype(Starsettlementtype starsettlementtype) throws SQLException;
	
	/**
	 * 删除 星级结算分类
	 * @param id
	 * @return deleted count 
	 */
	public int deleteStarsettlementtype(long id);
	
	
	/**
	 * 修改 星级结算分类
	 * @param id
	 * @return updated count 
	 */
	public int updateStarsettlementtype(Starsettlementtype starsettlementtype);

		
	/**
	 * 修改 星级结算分类但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateStarsettlementtypeIgnoreNull(Starsettlementtype starsettlementtype);
		
	
	/**
	 * 查找 星级结算分类
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarsettlementtype(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 星级结算分类
	 * @param id
	 * @return
	 */
	public Starsettlementtype findStarsettlementtype(long id);
	
	
	/** 
	 * 查找 星级结算分类
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllStarsettlementtype(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找星级结算分类
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllStarsettlementtype(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 星级结算分类
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteStarsettlementtypeBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countStarsettlementtypeBySql(String sql);
	
}

