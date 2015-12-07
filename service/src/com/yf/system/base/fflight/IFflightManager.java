/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.fflight;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IFflightManager{ 
	
  
 	/**
	 * 创建 国际机票行程
	 * @param id
	 * @return deleted count 
	 */
	public Fflight createFflight(Fflight fflight) throws SQLException;
	
	/**
	 * 删除 国际机票行程
	 * @param id
	 * @return deleted count 
	 */
	public int deleteFflight(long id);
	
	
	/**
	 * 修改 国际机票行程
	 * @param id
	 * @return updated count 
	 */
	public int updateFflight(Fflight fflight);

		
	/**
	 * 修改 国际机票行程但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateFflightIgnoreNull(Fflight fflight);
		
	
	/**
	 * 查找 国际机票行程
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFflight(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 国际机票行程
	 * @param id
	 * @return
	 */
	public Fflight findFflight(long id);
	
	
	/** 
	 * 查找 国际机票行程
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllFflight(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找国际机票行程
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllFflight(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 国际机票行程
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteFflightBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countFflightBySql(String sql);
	
}

