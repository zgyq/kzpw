/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.incity;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IIncityManager{ 
	
  
 	/**
	 * 创建 国际城市表
	 * @param id
	 * @return deleted count 
	 */
	public Incity createIncity(Incity incity) throws SQLException;
	
	/**
	 * 删除 国际城市表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteIncity(long id);
	
	
	/**
	 * 修改 国际城市表
	 * @param id
	 * @return updated count 
	 */
	public int updateIncity(Incity incity);

		
	/**
	 * 修改 国际城市表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateIncityIgnoreNull(Incity incity);
		
	
	/**
	 * 查找 国际城市表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIncity(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 国际城市表
	 * @param id
	 * @return
	 */
	public Incity findIncity(long id);
	
	
	/** 
	 * 查找 国际城市表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllIncity(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找国际城市表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllIncity(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 国际城市表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteIncityBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countIncityBySql(String sql);
	
}

