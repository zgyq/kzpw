/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.spzrate;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface ISpzrateComponent{ 
	
  
 	/**
	 * 创建 特价政策表
	 * @param id
	 * @return deleted count 
	 */
	public Spzrate createSpzrate(Spzrate spzrate) throws SQLException;
	
	/**
	 * 删除 特价政策表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteSpzrate(long id);
	
	
	/**
	 * 修改 特价政策表
	 * @param id
	 * @return updated count 
	 */
	public int updateSpzrate(Spzrate spzrate);

		
	/**
	 * 修改 特价政策表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateSpzrateIgnoreNull(Spzrate spzrate);
		
	
	/**
	 * 查找 特价政策表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpzrate(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 特价政策表
	 * @param id
	 * @return
	 */
	public Spzrate findSpzrate(long id);
	
	/**
	 * 查找 特价政策表 by language
	 * @param id
	 * @return
	 */
	public Spzrate findSpzratebylanguage(long id,Integer language);
	
	/** 
	 * 查找 特价政策表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllSpzrate(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找特价政策表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllSpzrate(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 特价政策表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteSpzrateBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countSpzrateBySql(String sql);
	
}

