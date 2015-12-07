/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.helpcenterinfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHelpcenterinfoComponent{ 
	
  
 	/**
	 * 创建 帮助中心信息
	 * @param id
	 * @return deleted count 
	 */
	public Helpcenterinfo createHelpcenterinfo(Helpcenterinfo helpcenterinfo) throws SQLException;
	
	/**
	 * 删除 帮助中心信息
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHelpcenterinfo(long id);
	
	
	/**
	 * 修改 帮助中心信息
	 * @param id
	 * @return updated count 
	 */
	public int updateHelpcenterinfo(Helpcenterinfo helpcenterinfo);

		
	/**
	 * 修改 帮助中心信息但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHelpcenterinfoIgnoreNull(Helpcenterinfo helpcenterinfo);
		
	
	/**
	 * 查找 帮助中心信息
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenterinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 帮助中心信息
	 * @param id
	 * @return
	 */
	public Helpcenterinfo findHelpcenterinfo(long id);
	
	
	/** 
	 * 查找 帮助中心信息
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHelpcenterinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找帮助中心信息
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenterinfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 帮助中心信息
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHelpcenterinfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHelpcenterinfoBySql(String sql);
	
}

