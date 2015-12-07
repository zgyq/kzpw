/**
 * 版权所有, 允风文化
 * Author: B2B2C 项目开发组
 * copyright: 2012
 */
 
package com.yf.system.base.xcdorder;

import java.sql.SQLException;
import java.util.*;

import com.yf.system.base.util.PageInfo;

public interface IXcdorderComponent{ 
	
  
 	/**
	 * 创建 行程单订单
	 * @param id
	 * @return deleted count 
	 */
	public Xcdorder createXcdorder(Xcdorder xcdorder) throws SQLException;
	
	/**
	 * 删除 行程单订单
	 * @param id
	 * @return deleted count 
	 */
	public int deleteXcdorder(long id);
	
	
	/**
	 * 修改 行程单订单
	 * @param id
	 * @return updated count 
	 */
	public int updateXcdorder(Xcdorder xcdorder);

		
	/**
	 * 修改 行程单订单但忽略空值 
	 * @param id
	 * @return 
	 */
	public int updateXcdorderIgnoreNull(Xcdorder xcdorder);
		
	
	/**
	 * 查找 行程单订单
	 * @param where
	 * @param orderby
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdorder(String where, String orderby,int limit,int offset);
		
	
	/**
	 * 查找 行程单订单
	 * @param id
	 * @return
	 */
	public Xcdorder findXcdorder(long id);
	
	
	/** 
	 * 查找 行程单订单
	 * @param where
	 * @param orderby
	 * @param pageinfo
	 * @return
	 */
	public List findAllXcdorder(String where, String orderby,PageInfo pageinfo);
		
	/** 
	 * 根据Sql查找行程单订单
	 * @param sql
	 * @param limit
	 * @param offset
	 * @return
	 */
	public List findAllXcdorder(String sql,int limit,int offset);
	
	
	/**
	 * 执行Sql 行程单订单
	 * @param sql 
	 * @return updated count 
	 */
	public int excuteXcdorderBySql(String sql);
	
	/**
	 * 执行Sql 
	 * @param sql 
	 * @return  count 
	 */
	public int countXcdorderBySql(String sql);
	
}

