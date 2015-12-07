/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.gerenguazhanfrec;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IGerenguazhanfrecManager{ 
	
  
 	/**
	 * 创建 个人挂账记录表
	 * @param id
	 * @return deleted count 
	 */
	public Gerenguazhanfrec createGerenguazhanfrec(Gerenguazhanfrec gerenguazhanfrec) throws SQLException;
	
	/**
	 * 删除 个人挂账记录表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteGerenguazhanfrec(long id);
	
	
	/**
	 * 修改 个人挂账记录表
	 * @param id
	 * @return updated count 
	 */
	public int updateGerenguazhanfrec(Gerenguazhanfrec gerenguazhanfrec);

		
	/**
	 * 修改 个人挂账记录表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateGerenguazhanfrecIgnoreNull(Gerenguazhanfrec gerenguazhanfrec);
		
	
	/**
	 * 查找 个人挂账记录表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGerenguazhanfrec(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 个人挂账记录表
	 * @param id
	 * @return
	 */
	public Gerenguazhanfrec findGerenguazhanfrec(long id);
	
	
	/** 
	 * 查找 个人挂账记录表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllGerenguazhanfrec(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找个人挂账记录表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllGerenguazhanfrec(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 个人挂账记录表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteGerenguazhanfrecBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countGerenguazhanfrecBySql(String sql);
	
}

