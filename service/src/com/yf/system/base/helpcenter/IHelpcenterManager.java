/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.helpcenter;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IHelpcenterManager{ 
	
  
 	/**
	 * 创建 帮助中心
	 * @param id
	 * @return deleted count 
	 */
	public Helpcenter createHelpcenter(Helpcenter helpcenter) throws SQLException;
	
	/**
	 * 删除 帮助中心
	 * @param id
	 * @return deleted count 
	 */
	public int deleteHelpcenter(long id);
	
	
	/**
	 * 修改 帮助中心
	 * @param id
	 * @return updated count 
	 */
	public int updateHelpcenter(Helpcenter helpcenter);

		
	/**
	 * 修改 帮助中心但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateHelpcenterIgnoreNull(Helpcenter helpcenter);
		
	
	/**
	 * 查找 帮助中心
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenter(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 帮助中心
	 * @param id
	 * @return
	 */
	public Helpcenter findHelpcenter(long id);
	
	
	/** 
	 * 查找 帮助中心
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllHelpcenter(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找帮助中心
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllHelpcenter(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 帮助中心
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteHelpcenterBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countHelpcenterBySql(String sql);
	
}

