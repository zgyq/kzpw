/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.forderinfo;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IForderinfoManager{ 
	
  
 	/**
	 * 创建 国际机票订单表
	 * @param id
	 * @return deleted count 
	 */
	public Forderinfo createForderinfo(Forderinfo forderinfo) throws SQLException;
	
	/**
	 * 删除 国际机票订单表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteForderinfo(long id);
	
	
	/**
	 * 修改 国际机票订单表
	 * @param id
	 * @return updated count 
	 */
	public int updateForderinfo(Forderinfo forderinfo);

		
	/**
	 * 修改 国际机票订单表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateForderinfoIgnoreNull(Forderinfo forderinfo);
		
	
	/**
	 * 查找 国际机票订单表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderinfo(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 国际机票订单表
	 * @param id
	 * @return
	 */
	public Forderinfo findForderinfo(long id);
	
	
	/** 
	 * 查找 国际机票订单表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllForderinfo(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找国际机票订单表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllForderinfo(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 国际机票订单表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteForderinfoBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countForderinfoBySql(String sql);
	
}

