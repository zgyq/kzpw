/**
 * 版权所有, 允风文化
 * Author: 允风文化 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.scang;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IScangManager{ 
	
  
 	/**
	 * 创建 订单升舱表
	 * @param id
	 * @return deleted count 
	 */
	public Scang createScang(Scang scang) throws SQLException;
	
	/**
	 * 删除 订单升舱表
	 * @param id
	 * @return deleted count 
	 */
	public int deleteScang(long id);
	
	
	/**
	 * 修改 订单升舱表
	 * @param id
	 * @return updated count 
	 */
	public int updateScang(Scang scang);

		
	/**
	 * 修改 订单升舱表但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateScangIgnoreNull(Scang scang);
		
	
	/**
	 * 查找 订单升舱表
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScang(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 订单升舱表
	 * @param id
	 * @return
	 */
	public Scang findScang(long id);
	
	
	/** 
	 * 查找 订单升舱表
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllScang(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找订单升舱表
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllScang(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 订单升舱表
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteScangBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countScangBySql(String sql);
	
}

